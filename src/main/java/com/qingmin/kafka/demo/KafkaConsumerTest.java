package com.qingmin.kafka.demo;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.google.gson.Gson;

public class KafkaConsumerTest {

	public static void main(String[] args){
		Gson gson = new Gson();
		
		Properties props = new Properties();
	     props.put("bootstrap.servers", "hdpvrtvw9010:6667");
	     props.put("group.id", "qingminTestGroup");
	     //props.put("enable.auto.commit", "true");
	     //props.put("auto.commit.interval.ms", "1000");
	     //props.put("session.timeout.ms", "30000");
	     props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
	     consumer.subscribe(Arrays.asList("test.appdynamic.alert.qingmin"));
	     try{
		     while (true) {
		         ConsumerRecords<String, String> records = consumer.poll(1000000);
		         for (ConsumerRecord<String, String> record : records)
		             System.out.printf("offset = %d, key = %s, value = %s,timestamp = %s, partition=%s, topic=%s ", record.offset(), record.key(), record.value(),record.timestamp(),record.partition(),record.topic());
		     } 
	     }finally {
	         consumer.close();
	     }
	}
}
