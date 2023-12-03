package com.bob.kafka.restController;

import com.bob.kafka.Producer.KafkaJsonProducer;
import com.bob.kafka.Producer.KafkaProducerSending;
import com.bob.kafka.payloadSending.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    // inject
    private final KafkaProducerSending kafkaProducerSending;

    // inject for JSon
    private final KafkaJsonProducer kafkaJsonProducer;


    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        kafkaProducerSending.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully created");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student message) {
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully as JSON");
    }
}
