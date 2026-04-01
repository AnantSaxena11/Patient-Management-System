package com.pm.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDTO {
    private String Id;
    private String Name;
    private String email;
    private String address;
    private String dateOfBirth;
}
