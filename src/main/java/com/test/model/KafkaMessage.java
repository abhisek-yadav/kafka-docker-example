package com.test.model;

public class KafkaMessage {

  private String key;
  private String value;

  public KafkaMessage(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

}
