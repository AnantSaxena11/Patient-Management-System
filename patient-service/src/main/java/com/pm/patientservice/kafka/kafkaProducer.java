package com.pm.patientservice.kafka;

import com.pm.patientservice.model.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Slf4j
@Service
public class kafkaProducer {
    private final KafkaTemplate<Object, byte[]> kafkaTemplate;
    kafkaProducer(KafkaTemplate<Object, byte[]> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Patient patient){
        String topic = "patient";
        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setEventType("Patient_Created")
                .build();

        try{
            kafkaTemplate.send(topic,event.toByteArray());
        }catch (Exception ex){
            log.error("Error sending the patientEvent even: {}",event);
        }
    }

}
