package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toPatientResponseDTO(Patient patient){
        PatientResponseDTO response = new PatientResponseDTO();
        response.setId(patient.getId().toString());
        response.setName(patient.getName());
        response.setEmail(patient.getEmail());
        response.setAddress(patient.getAddress());
        response.setDateOfBirth(patient.getDateOfBirth().toString());
        return response;
    }

    public static Patient toPatient(PatientRequestDTO patient){
        Patient newPatient = new Patient();
        newPatient.setName(patient.getName());
        newPatient.setEmail(patient.getEmail());
        newPatient.setAddress(patient.getAddress());
        newPatient.setDateOfBirth(LocalDate.parse(patient.getDateOfBirth()));
        newPatient.setRegistrationDate(LocalDate.parse(patient.getRegistrationDate()));
        return newPatient;
    }

}
