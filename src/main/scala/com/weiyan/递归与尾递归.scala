package com.weiyan

import scala.annotation.tailrec

object 递归与尾递归 {

  def factorial(n: Int): Int = {
    if (n == 0)
      1
    else
      n * factorial(n - 1)
  }

  def factorial2(n: Int): Int = {

    @tailrec
    def loop(acc: Int, n: Int): Int ={
      if (n == 0) acc else loop(n * acc, n - 1)
    }
    loop(1,n)
  }


  def main(args: Array[String]): Unit = {
    val count =  100000
//    factorial(count)
    factorial2(count)
  }
}
