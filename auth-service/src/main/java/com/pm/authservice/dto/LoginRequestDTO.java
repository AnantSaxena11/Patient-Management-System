package com.pm.authservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Login Request DTO" , description = "This DTO defines what does the user sends to initiate login")
public class LoginRequestDTO {
    @Email(message = "email should be a valid email address")
    @NotBlank(message = "email should not be blank")
    @Schema(name = "Email" , description = "This field represents email" , example = "mailer@mail.com")
    private String email;

    @NotBlank(message = "password cannot be blank")
    @Size(min = 8,max = 16,message = "password should be least 8 character and of maximum 16 characters")
    @Schema(name = "Password" , description = "This field represents a password" , example = "@#H8F36t")
    private String password;

}
