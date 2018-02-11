package com.weiyan

object 函数式编程与指令编程 {
  // 1 到 100 100个数相加的和

  val sum = (1 to 100).fold(0)(_ + _)

  def sum3(n: Int): Int = {
    if (n == 1) n else n + sum3(n - 1)
  }
  //=======================================
  def sum2 = {
    var  sum = 0
    var i = 0
    do {
      sum += i
      i += 1
    } while (i <= 100)
    sum
  }
  //=======================================

  def main(args: Array[String]): Unit = {
    println("函数式" + sum)
    println("指令式" + sum2)
    println("递归式" + sum3(100))
  }

}
