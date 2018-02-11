package com.weiyan

object 集合操作 {


  def sum(xs: List[Int]): Int = if(xs.isEmpty) 0 else xs.head + sum(xs.tail)

  def max(xs: List[Int],a: Int): Int = {
    println(a,xs)
    if (xs.isEmpty)
      throw new java.util.NoSuchElementException
    if(xs.size == 1)
      xs.head
    else
    if (xs.head > max(xs.tail,1)) xs.head else max(xs.tail,2)
  }

  def reverse(xs: String): String = if(xs.length == 1) xs else reverse(xs.tail) + xs.head

/////////////////////////////////////////////////////////////////////////////////////////////////

  def main(args: Array[String]): Unit = {
//        val list = List(1,2,3,4,5,6,7,8,9)
//        list.map(_ * 2).foreach(println)
        println((1 to 100).map(_*2).reduce(_*_))


    //
    //    val votes = Seq(("scala", 1), ("java", 4), ("scala", 10), ("scala", 1), ("python", 10))
    //    val orderedVotes = votes
    //      .groupBy(_._1)
    //      .map { case (which, counts) =>
    //        (which, counts.foldLeft(0)(_ + _._2))
    //      }.toSeq
    //      .sortBy(_._2)
    //      .reverse
    //    orderedVotes.foreach(println)


//    除原来的集合外，还另外产生了三个临时的集合
        List(1,2,3,4).map(_ + 10).filter( _ % 2 == 0).map(_ * 3).foreach(println)


    //    println((1 to 10000).par.map(i => Thread.currentThread.getName).distinct.size)

    //    Array(1,2,3,4).foreach((str :Int) => println(str))
  }
}
