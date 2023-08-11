import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.connectors.kafka.internals.KafkaCommitCallback;
import org.apache.flink.util.Collector;

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
                .setStartingOffsets(OffsetsInitializer.earliest())
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .setProperties(props)
                .build();

// Read from source
        DataStream<String> stream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka Source");

// Print stream
        KafkaCommitCallback commitCallback = new KafkaCommitCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onException(Throwable throwable) {

            }
        };

        stream.process(new ProcessFunction<String, Object>() {


            @Override
            public void processElement(String s, ProcessFunction<String, Object>.Context context, Collector<Object> collector) throws Exception {
                System.out.println(" this is "+ s);


            }
        });



// Execute
        env.execute();





    }

}
