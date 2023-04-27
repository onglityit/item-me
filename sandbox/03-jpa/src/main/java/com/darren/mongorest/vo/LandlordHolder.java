package com.darren.mongorest.vo;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LandlordHolder {
    String username;
    String email;
    String companyNickName;
    //String landlordLogoURL;
}
