package balu.learning.datastream;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import org.apache.flink.streaming.connectors.kafka.KafkaDeserializationSchema;

import java.util.Properties;

public class FlinkConsumer
{


    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

// Kafka properties
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");

// Create KafkaSource
        KafkaSource<String> source = KafkaSource.<String>builder()
                .setTopics("topic1")
                .setGroupId("my-group")
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .setProperties(props)
                .build();

// Read from source
        DataStream<String> stream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka Source");

// Print stream
        stream.print();

// Execute
        env.execute();





    }

}
