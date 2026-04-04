package com.pm.patientservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "This is a Patient Response DTO")
public class PatientResponseDTO {
    @Schema(name = "ID" , description = "Patient ID" , example = "123e4567-e89b-12d3-a456-426614174000")
    private String Id;
    @Schema(name = "Name", description = "Patient Name" ,  example = "John Doe")
    private String Name;
    @Schema(name = "email" , description = "Patient Email" , example = "example@mail.com")
    private String email;
    @Schema(name = "address" , description = "Patient Address" , example = "Street X City Y")
    private String address;
    @Schema(name = "Date of Birth" , description = "Patients DOB" , example = "2003-10-11")
    private String dateOfBirth;
}
