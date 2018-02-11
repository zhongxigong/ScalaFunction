package com.weiyan.curr

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class Sum(begin: Int, end: Int) {

  def cal(): Int = {
    (begin to end).foldLeft(0)(_ + _)
  }
}


class Result(sum: Int) {
  def consolePrintln: Unit = {
    println(sum)
  }
}

class HelloWorld extends Actor {
  override def receive = {
    case (sum: Sum, result: ActorRef) => {
      val rr = sum.cal()
      result ! new Result(rr)
    }
  }
}


class ResultActor extends Actor {

  override def receive = {
    case result: Result => {
      result.consolePrintln
    }
  }
}


object Demo {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("hello")
    val hello = system.actorOf(Props[HelloWorld], name = "hello")
    val result = system.actorOf(Props[ResultActor], name = "result")
    hello ! (new Sum(1, 100), result)

    Thread.sleep(1000)
    hello ! (new Sum(100, 500000), result)
  }
}
