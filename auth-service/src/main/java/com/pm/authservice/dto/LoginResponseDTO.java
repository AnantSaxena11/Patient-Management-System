package com.pm.authservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Schema(name = "LoginResponseDTO")
public class LoginResponseDTO {
    @Schema(name = "JWT Token" , description = "This is the JWT Token" , example = "hsgfdiaydgIAGYQG71FAHSDBFBASFBHSABFHBSAHBuqdvabv")
    private final String token;

    public LoginResponseDTO(String token){
        this.token = token;
    }


}
