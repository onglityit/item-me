package com.darren.mongorest.config.security.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.List;

import com.darren.mongorest.service.UserDetailsImpl;
import io.micrometer.common.util.StringUtils;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.*;
import org.jose4j.keys.HmacKey;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;



@Component
public class JwtUtils {
    private final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private final String STR_ISSUER = "Issuer";
    private final String STR_AUDIENCE = "Audience";
    private final Key key1;

    private final String jwtSecret;

    private final int jwtExpirationMs;

    @Autowired
    public JwtUtils(@Value("${com.darren.mongorest.app.jwtSecret}") String jwtSecret,
                    @Value("${com.darren.mongorest.app.jwtExpirationMs}") int jwtExpirationMs) {
        this.jwtSecret = jwtSecret;
        this.jwtExpirationMs = jwtExpirationMs;
        key1 = new HmacKey(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateJwtToken(Authentication authentication) throws JoseException {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        String KEY_ID = "key1";
        JsonWebSignature jws = new JsonWebSignature();

        JwtClaims claims = new JwtClaims();
        claims.setIssuer(STR_ISSUER);
        claims.setAudience(STR_AUDIENCE);
        claims.setExpirationTimeMinutesInTheFuture(jwtExpirationMs/1000);
        claims.setGeneratedJwtId();
        claims.setIssuedAtToNow();
        claims.setNotBeforeMinutesInThePast(2);
        claims.setSubject(userPrincipal.getUsername()); // the subject/principal is whom the token is about
        claims.setClaim("email", userPrincipal.getEmail());
        List<String> groups = Arrays.asList("group-one", "other-group", "group-three");
        claims.setStringListClaim("groups", groups);

        jws.setPayload(claims.toJson());
        jws.setKey(key1);
        jws.setKeyIdHeaderValue(KEY_ID);
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA512);

//        String jwt = jws.getCompactSerialization();
//        System.out.println("JWT: " + jwt);
//        return jwt;

        return jws.getCompactSerialization();

//        return Jwts.builder()
//                .setSubject(userPrincipal.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
//                .signWith( (SignatureAlgorithm.HS512), jwtSecret)
//                .compact();
    }

    public String getUserNameFromJwtToken(String jwt) throws MalformedClaimException {
        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime()
                .setAllowedClockSkewInSeconds(120)
                .setRequireSubject()
                .setExpectedIssuer(STR_ISSUER)
                .setExpectedAudience(STR_AUDIENCE)
                .setVerificationKey(key1)
                .setJwsAlgorithmConstraints(
                        AlgorithmConstraints.ConstraintType.PERMIT,
                        AlgorithmIdentifiers.HMAC_SHA512)
                .build();

        try {
            JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
            //JwtContext jwtContext = jwtConsumer.process(jwt);

            return jwtClaims.getSubject();
        }catch (InvalidJwtException e){
            System.out.println("Invalid JWT! " + e);
            if (e.hasExpired())
            {
                logger.error("JWT expired at " + e.getJwtContext().getJwtClaims().getExpirationTime());
            }
            if (e.hasErrorCode(ErrorCodes.AUDIENCE_INVALID))
            {
                logger.error("JWT had wrong audience: " + e.getJwtContext().getJwtClaims().getAudience());
            }
            if(e.hasErrorCode(ErrorCodes.SIGNATURE_INVALID))
            {
                logger.error("Invalid JWT signature: {}", e.getMessage());
            }

        } catch (MalformedClaimException e) {
            logger.error("MalformedClaimException - JWT token: {}", e.getMessage());
        }catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        //return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return null;
    }

    public boolean validateJwtToken(String authToken) throws MalformedClaimException {
        return !StringUtils.isBlank(getUserNameFromJwtToken(authToken)) ;
    }
}
