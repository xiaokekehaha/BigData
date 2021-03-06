package SomethingAboutAPI.localexamples

import org.apache.spark.{SparkConf, SparkContext}

object sortByKeyTest {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("sortByKey").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val data1 = Array[(String, Int)](("K1", 1), ("K2", 2),
      ("U1", 3), ("U2", 4),
      ("W1", 5), ("W1", 6)
    )
    val pairs1 = sc.parallelize(data1, 3)

    //val result = pairs.fold(("K0",10))((A, B) => (A._1 + "#" + B._1, A._2 + B._2))

    val result = pairs1.sortByKey()
    result.foreach(println)
    //result.saveAsTextFile("E:\\Spark\\output\\sortByKey")
  }

}