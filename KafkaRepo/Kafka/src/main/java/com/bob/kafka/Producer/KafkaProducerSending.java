package com.bob.kafka.Producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service  // bean
@RequiredArgsConstructor // injection
@Slf4j // for log
public class KafkaProducerSending {
    // key-serializer,Value-serializer
    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String msg){
        log.info(format("Sending message to topicNameBob Topic:: %s", msg));
        kafkaTemplate.send("topicNameBob",msg);
    }

}
