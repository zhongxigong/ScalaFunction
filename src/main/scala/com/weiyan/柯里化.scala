package com.weiyan

object 柯里化 {



  // 函数只有一个输入对象，一个输出对象，但是大多数情况都会有多个参数。这时候可以通过函数柯里化来解决。
  // 闭包

  // 克里化

  def sum(a :Int,b :Int) = a + b

  def sum2(a :Int) = (b :Int) => a + b

  def sum3 = sum2(2)


  def main(args: Array[String]): Unit = {
    println(sum2(4)(6))
  }


}
