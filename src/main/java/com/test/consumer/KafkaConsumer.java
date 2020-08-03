package com.test.consumer;

import com.test.model.KafkaMessage;
import com.test.util.Constants;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

  public List<KafkaMessage> consumeMessage() {

    List<KafkaMessage> messages = new ArrayList<>();
    boolean flag = true;

    Properties props = new Properties();
    props.put("bootstrap.servers", Constants.KAFKA_HOST + ":" + Constants.KAFKA_PORT);
    props.put("group.id", "test");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    try (org.apache.kafka.clients.consumer.KafkaConsumer<String, String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(
        props)) {
      consumer.subscribe(Collections.singleton(Constants.TOPIC_NAME));
      while (flag) {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

        records.forEach(record -> {
          KafkaMessage message = new KafkaMessage(record.key(), record.value());
          messages.add(message);
        });
        flag = false;
      }
    }

    return messages;
  }
}
