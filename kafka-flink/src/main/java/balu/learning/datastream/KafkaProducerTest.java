package balu.learning.datastream;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class KafkaProducerTest {

    // Import Kafka producer packages


    // Create producer properties
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

// Send data
        producer.send(new ProducerRecord<>("topic1", "key1", "My first Kafka Program"));

// Close producer
        producer.close();

    }



}
