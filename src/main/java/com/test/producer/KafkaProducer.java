package com.test.producer;

import com.test.model.KafkaMessage;
import com.test.util.Constants;
import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

  public void produceMessage(KafkaMessage message) {

    Properties props = new Properties();
    props.put("bootstrap.servers", Constants.KAFKA_HOST + ":" + Constants.KAFKA_PORT);
    props.put("acks", "all");
    props.put("retries", 2);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    try (Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(
        props)) {
      producer
          .send(new ProducerRecord<>(Constants.TOPIC_NAME, message.getKey(), message.getValue()),
              (rm, ex) -> {
                if (ex != null) {
                  throw new RuntimeException(ex);
                }
              });
    }
  }

}
