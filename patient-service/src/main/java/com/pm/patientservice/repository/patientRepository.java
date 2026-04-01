package com.pm.patientservice.repository;

import com.pm.patientservice.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface patientRepository extends JpaRepository<Patient, UUID> {
    
}
