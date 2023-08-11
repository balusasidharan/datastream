echo 'export PATH="/opt/homebrew/opt/kafka/bin:$PATH"' >> ~/.zshrc




/opt/homebrew/opt/kafka/bin/zookeeper-server-start /opt/homebrew/etc/kafka/zookeeper.properties
/opt/homebrew/opt/kafka/bin/kafka-server-start /opt/homebrew/etc/kafka/server.properties

Create Topics 

/opt/homebrew/opt/kafka/bin/kafka-topics --create \
  --replication-factor 1 --partitions 1 \
  --bootstrap-server <<provide kafka server address> usually localhost:9092 \
  --topic flink_output

  /opt/homebrew/opt/kafka/bin/kafaka-topics --list --bootstrap-server localhost:9092

  /opt/homebrew/opt/kafka/bin/kafka-topics --create \
  --replication-factor 1 --partitions 1 \
  --bootstrap-server localhost:9092 \
  --topic flink.input

  # List the topics 
  /opt/homebrew/opt/kafka/bin/kafka-topics --list --bootstrap-server localhost:9092
flink.input
flink.output

#Create a Java project 
mvn archetype:generate 
	-DgroupId=balu.learning.datastream
	-DartifactId=kafka-flink
	-DarchetypeArtifactId= maven-archetype-quickstart
	-DinteractiveMode=false