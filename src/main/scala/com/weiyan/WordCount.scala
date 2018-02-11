package com.weiyan

import scala.io.Source

object WordCount {

  // 读取文件的每一行，字符串切割，然后组装成

  def main(args: Array[String]): Unit = {
    val start = System.currentTimeMillis()
    // wordCount
    Source
      .fromFile("/Users/yaoyuan/Downloads/《红楼梦》完整版.txt")
      .getLines()//
      .toStream
      .par
      .flatMap(_.split(""))
      .map(item => {
        //            println(item,Thread.currentThread().getName) // 多线程
        (item, 1)
      })
      .groupBy(_._1)
      .map {
        case (which, counts) => (which, counts.foldLeft(0)(_ + _._2))
      }
      .toStream
      .sortBy(_._2)
      .reverse
      .take(50)
      .foreach(item => {
        println(item)
      })
    println("共耗时" + (System.currentTimeMillis() - start))
  }

}
