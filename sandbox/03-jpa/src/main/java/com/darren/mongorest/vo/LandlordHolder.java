package com.darren.mongorest.vo;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data @SuperBuilder
public class LandlordHolder {
    String username;
    String email;
    String companyNickName;
    //String landlordLogoURL;
}
