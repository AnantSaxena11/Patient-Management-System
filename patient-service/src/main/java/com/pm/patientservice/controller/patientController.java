package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validators.CreatePatientValidationGroups;
import com.pm.patientservice.service.patientService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api")
public class patientController {

    @Autowired
    private patientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping("/registerPatient")
    public ResponseEntity<PatientResponseDTO> registerPatient(@Validated({Default.class, CreatePatientValidationGroups.class}) @RequestBody PatientRequestDTO patient) {
        PatientResponseDTO Patient = patientService.registerPatient(patient);
        return ResponseEntity.ok().body(Patient);
    }

    @PutMapping("/updatePatient/{Id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID Id,@Validated({Default.class}) @RequestBody PatientRequestDTO patient){
        PatientResponseDTO Patient = patientService.updatePatient(Id,patient);
        return ResponseEntity.ok().body(Patient);
    }
}
