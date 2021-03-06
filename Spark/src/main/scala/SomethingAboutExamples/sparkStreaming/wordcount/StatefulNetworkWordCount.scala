package SomethingAboutExamples.sparkStreaming.wordcount

import org.apache.spark.{HashPartitioner, SparkConf}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by hushiwei on 2017/6/11.
  *
  * nc -lk 9999
  */
object StatefulNetworkWordCount {
  def main(args: Array[String]): Unit = {

    //    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)

    val updateFunc = (values: Seq[Int], state: Option[Int]) => {
      val currentCount = values.sum

      val previousCount = state.getOrElse(0)

      Some(currentCount + previousCount)
    }

    val newUpdateFunc = (iterator: Iterator[(String, Seq[Int], Option[Int])]) => {
      iterator.flatMap(t => updateFunc(t._2, t._3).map(s => (t._1, s)))
    }

    val sparkConf = new SparkConf().setAppName("StatefulNetworkWordCount").setMaster("local[4]")
    val ssc = new StreamingContext(sparkConf, Seconds(3))
    ssc.checkpoint(".")

    // Initial Rdd input to updateStateByKey

    val initialRDD = ssc.sparkContext.parallelize(List(("hello", 1), ("word", 1)))

    // Create a ReceiverInputDStream on target ip:port and count the
    // words in input stream of \n delimited test (eg. generated by 'nc')

    val lines = ssc.socketTextStream("localhost", 9999)
    val words = lines.flatMap(_.split(" "))
    val wordDstream = words.map(x => (x, 1))
    wordDstream.print()

    // Update the cumulative count using updateStateByKey
    // This will give a Dstream made of state (which is the cumulative count of the words)
    val stateDstream = wordDstream.updateStateByKey[Int](newUpdateFunc, new HashPartitioner(ssc.sparkContext.defaultParallelism), true, initialRDD)
    stateDstream.print()
    ssc.start()
    ssc.awaitTermination()

  }

}
