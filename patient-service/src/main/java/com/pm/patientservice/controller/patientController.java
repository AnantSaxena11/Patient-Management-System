package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validators.CreatePatientValidationGroups;
import com.pm.patientservice.service.patientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Patient" , description = "This is an API for Managing the Patients")
public class patientController {

    @Autowired
    private patientService patientService;

    @GetMapping("/patients")
    @Operation(summary = "GET PATIENTS")
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping("/registerPatient")
    @Operation(summary = "REGISTER PATIENTS")
    public ResponseEntity<PatientResponseDTO> registerPatient(@Validated({Default.class, CreatePatientValidationGroups.class}) @RequestBody PatientRequestDTO patient) {
        PatientResponseDTO Patient = patientService.registerPatient(patient);
        return ResponseEntity.ok().body(Patient);
    }

    @PutMapping("/updatePatient/{Id}")
    @Operation(summary = "UPDATE PATIENTS")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID Id,@Validated({Default.class}) @RequestBody PatientRequestDTO patient){
        PatientResponseDTO Patient = patientService.updatePatient(Id,patient);
        return ResponseEntity.ok().body(Patient);
    }

    @DeleteMapping("/delete/{Id}")
    @Operation(summary = "DELETE PATIENTS")
    public ResponseEntity<Void> deletePatient(@PathVariable("Id") UUID Id){
        patientService.deletePatient(Id);
        return ResponseEntity.noContent().build();
    }
}
