package com.test.controller;

import com.test.consumer.KafkaConsumer;
import com.test.model.KafkaMessage;
import com.test.producer.KafkaProducer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerConsumerController {

  @Autowired
  private KafkaConsumer kafkaConsumer;

  @Autowired
  private KafkaProducer kafkaProducer;

  @GetMapping(path = "/ping")
  public String ping() {
    return "Hello World!!!";
  }

  @PostMapping(path = "/produces", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> produceMessage(@RequestBody KafkaMessage message) {

    if (message == null) {
      return ResponseEntity.badRequest().body("message can't be empty");
    }

    kafkaProducer.produceMessage(message);

    String response = String
        .format("message produced successfully to kafka with key: %s , value: %s", message.getKey(),
            message.getValue());

    return ResponseEntity.ok(response);

  }

  @GetMapping(path = "/consumes", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> consumeMessages() {

    List<KafkaMessage> messages = kafkaConsumer.consumeMessage();

    return ResponseEntity.ok(messages);
  }

}
