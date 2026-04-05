package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Slf4j
@Service
public class kafkaConsumer {
    @KafkaListener(topics = "patient", groupId = "analytics-service")
    public void Consume(byte[] event) {
        try {
            PatientEvent patientEvent = PatientEvent.parseFrom(event);
            log.info("successfully parsed the message received and consumed it {}" , patientEvent.getPatientId());
            // perform any business logic
        } catch (InvalidProtocolBufferException e) {
            log.error("Error deserialization of event {}",e.getMessage());
        }
    }
}
