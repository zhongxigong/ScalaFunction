package com.weiyan.curr

import akka.actor.{ActorSystem, Actor, ActorRef, Props, PoisonPill}
import language.postfixOps
import scala.concurrent.duration._


case object Ping

case object Pong

class Pinger extends Actor {
  var countDown = 2000

  def receive = {
//    case (Pong,str: String) =>
//      if (countDown > 0) {
//        println(s"${self.path} received pong, count down $countDown,Thread is $str")
//        countDown -= 1
//        sender() ! Ping
//      } else {
//        sender() ! PoisonPill
//        self ! PoisonPill
//      }
    case Pong =>
      if (countDown > 0) {
        println(s"${self.path} received pong, count down $countDown")
        countDown -= 1
        sender() ! Ping
      } else {
        sender() ! PoisonPill
        self ! PoisonPill
      }
  }
}

class Ponger(pinger: ActorRef) extends Actor {
  def receive = {
    case Ping =>
      println(s"${self.path} received ping")
      pinger ! Pong
  }
}


object Hello {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("pingpong")

    val pinger = system.actorOf(Props[Pinger], "pinger")

    val ponger = system.actorOf(Props(classOf[Ponger], pinger), "ponger")

//    for(item <- 1 to 200){
//      new Worker(pinger).start()
//    }

    Thread.sleep(10000)
    import system.dispatcher
    system.scheduler.scheduleOnce(500 millis) {
      println("scheduler")
      ponger ! Ping
    }
  }
}

//class Worker(ponger: ActorRef) extends Thread{
//  override def run(): Unit = {
//    for (item <- 1 to 100){
//      ponger ! (Pong,Thread.currentThread().getName)
//    }
//  }
//}


