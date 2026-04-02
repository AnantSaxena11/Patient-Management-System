package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.patientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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


    public PatientResponseDTO registerPatient(PatientRequestDTO patient){
        if(patientRepository.existsByEmail(patient.getEmail())){
            throw new EmailAlreadyExistsException("Patient with " + patient.getEmail() + " already exists in database.");
        }
        Patient newPatient = PatientMapper.toPatient(patient);
        patientRepository.save(newPatient);
        return PatientMapper.toPatientResponseDTO(newPatient);
    }


    public PatientResponseDTO updatePatient(UUID Id,PatientRequestDTO patient) {
        Patient tobeUpdated = patientRepository.findById(Id).orElseThrow(() -> new PatientNotFoundException("Patient with id " + Id + " not found."));

        if(patientRepository.existsByEmailAndIdNot(patient.getEmail(),Id)){
            throw new EmailAlreadyExistsException("A patient with this email already exists in the system " + patient.getEmail());
        }
        tobeUpdated.setName(patient.getName());
        tobeUpdated.setEmail(patient.getEmail());
        tobeUpdated.setAddress(patient.getAddress());
        tobeUpdated.setDateOfBirth(LocalDate.parse(patient.getDateOfBirth()));
        patientRepository.save(tobeUpdated);
        PatientResponseDTO response = PatientMapper.toPatientResponseDTO(tobeUpdated);
        return response;
    }
}
