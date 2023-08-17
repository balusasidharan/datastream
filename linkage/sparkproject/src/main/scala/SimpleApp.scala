/* SimpleApp.scala */
import org.apache.spark.sql.SparkSession;

object SimpleApp {
  def main(args: Array[String]) {
   // val logFile = "YOUR_SPARK_HOME/README.md" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val logData = spark.read.textFile("files")
    println("Hello this is my application as a scala  jar file "+ logData.count())

    spark.stop()
  }
}