package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validators.CreatePatientValidationGroups;
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
@Schema(name = "PatientRequestDTO" , description="PatientRequestDTO Class")
public class PatientRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(max = 100 , message = "Name cannot exceed 100 characters")
    @Schema(name = "Name", description = "Patient Name" ,  example = "John Doe")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Schema(name = "email" , description = "Patient Email" , example = "example@mail.com")
    private String email;

    @NotBlank(message = "Address is required")
    @Schema(name = "address" , description = "Patient Address" , example = "Street X City Y")
    private String address;

    @NotBlank(message = "Date of Birth is required")
    @Schema(name = "Date of Birth" , description = "Patients DOB" , example = "2003-10-11")
    private String dateOfBirth;

    @NotBlank(groups = CreatePatientValidationGroups.class, message = "Registration date is required")
    @Schema(name = "Date of Registration" , description = "Patients registration date" , example = "2026-10-11")
    private String registrationDate;

}
