package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validators.CreatePatientValidationGroups;
import com.pm.patientservice.service.patientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import jdk.jfr.ContentType;
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
    @Operation(summary = "Get the data of all the pateints",
    description = "Retrieve a list of all the patients in the system")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Patients retrieved successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = PatientResponseDTO.class)
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "No patient found"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error"
                    )
            }
    )
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping("/registerPatient")
    @Operation(summary = "To Register New Patient",
    description = "This api is used to register a new patient")

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "New Patient Created Successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    public ResponseEntity<PatientResponseDTO> registerPatient(@Validated({Default.class, CreatePatientValidationGroups.class}) @RequestBody PatientRequestDTO patient) {
        PatientResponseDTO Patient = patientService.registerPatient(patient);
        return ResponseEntity.ok().body(Patient);
    }

    @PutMapping("/updatePatient/{Id}")
    @Operation(summary = "Update Patients",
    description = "This api is used to update the patients data ID must be provided beforehand")

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Patient updated successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error"
            )
    })

    public ResponseEntity<PatientResponseDTO> updatePatient(@Parameter(description = "Patient ID" , example = "123e4567-e89b-12d3-a456-426614174000") @PathVariable UUID Id, @Validated({Default.class}) @RequestBody PatientRequestDTO patient){
        PatientResponseDTO Patient = patientService.updatePatient(Id,patient);
        return ResponseEntity.ok().body(Patient);
    }

    @DeleteMapping("/delete/{Id}")
    @Operation(summary = "To Delete Patient" ,  description = "This api is used to delete the patients data by the ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The patient got deleted successfully"
            ),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error")
    }
    )
    public ResponseEntity<Void> deletePatient(@Parameter(description = "Patient ID" , example = "123e4567-e89b-12d3-a456-426614174000") @PathVariable("Id") UUID Id){
        patientService.deletePatient(Id);
        return ResponseEntity.noContent().build();
    }
}
