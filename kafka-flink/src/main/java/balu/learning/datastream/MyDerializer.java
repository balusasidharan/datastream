package balu.learning.datastream;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.flink.util.Collector;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;

public class MyDerializer implements KafkaRecordDeserializationSchema<String> {

    @Override
    public void deserialize(ConsumerRecord consumerRecord, Collector collector) throws IOException {
        //System.out.println("Reading "+ consumerRecord.key());
    }

    @Override
    public TypeInformation getProducedType() {
        return null;
    }
}
