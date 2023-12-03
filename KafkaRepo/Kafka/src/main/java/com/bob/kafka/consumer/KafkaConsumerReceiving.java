package com.bob.kafka.consumer;


import com.bob.kafka.payloadSending.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumerReceiving {
    // from @kafkaListener getting message AND group id
//    @KafkaListener(topics = "topicNameBob",groupId = "myGroup")
    public void consumeMessage(String msg){
        log.info(format("Consuming the message from topicNameBob Topic:: %s", msg));
    }

    @KafkaListener(topics = "topicNameBob", groupId = "myGroup")
    public void consumeJsonMsg(Student student) {
        log.info(format("Consuming the message from topicNameBob Topic:: %s", student.toString()));
    }
}
