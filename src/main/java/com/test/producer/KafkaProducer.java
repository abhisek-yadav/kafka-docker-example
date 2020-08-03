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

    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

//    Properties properties = new Properties();
//    properties.put("bootstrap.servers", Constants.KAFKA_HOST + ":" + Constants.KAFKA_PORT);
//    properties.put("connections.max.idle.ms", 10000);
//    properties.put("request.timeout.ms", 5000);
//
//    try (AdminClient client = AdminClient.create(properties)) {
//      NewTopic topic = new NewTopic(Constants.TOPIC_NAME, 1, (short) 1);
//      client.createTopics(Collections.singleton(topic));
//    }



    try (Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(
        props)) {
      producer.send(new ProducerRecord<>(Constants.TOPIC_NAME, message.getKey(), message.getValue()),
          (rm, ex) -> {
            if (ex != null) {
              throw new RuntimeException(ex);
            }
          });
    }

  }

}
