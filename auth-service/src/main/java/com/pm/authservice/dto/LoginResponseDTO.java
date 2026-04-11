package com.pm.authservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
@Schema(name = "LoginResponseDTO")
public class LoginResponseDTO {
    @Schema(name = "JWT Token" , description = "This is the JWT Token" , example = "hsgfdiaydgIAGYQG71FAHSDBFBASFBHSABFHBSAHBuqdvabv")
    private final String token;

    public LoginResponseDTO(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
