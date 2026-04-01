package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.patientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class patientService {
    @Autowired
    private patientRepository patientRepository;

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patientList = patientRepository.findAll();
        List<PatientResponseDTO> allPatients = new ArrayList<>();
        for(Patient patient : patientList){
            PatientResponseDTO patientResponse = PatientMapper.toPatientResponseDTO(patient);
            allPatients.add(patientResponse);
        }
        return allPatients;
    }

}
