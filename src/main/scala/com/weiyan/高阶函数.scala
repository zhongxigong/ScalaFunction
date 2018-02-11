package com.weiyan

object 高阶函数 {


  def main(args: Array[String]): Unit = {
    println((1 to 100).reduce(sumInts2))
  }

  def sumInts(a: Int,b: Int): Int = {
    if (a > b) 0 else a + sumInts(a + 1, b)
  }

  def sumCubes(a: Int,b: Int): Int = {
    if(a > b) 0 else cube(a) + sumInts(a + 1, b)
  }

  def sumFactorials(a: Int, b: Int): Int = {
    if (a > b) 0 else fact(a) + sumFactorials(a + 1, b)
  }


  def sum(f: Int => Int, a: Int, b: Int):Int={
    if(a > b) 0
    else f(a) + sum(f,a+1,b)
  }
//==========================================================


  //高阶函数提供一种函数级别上的依赖注入机制，在这里，sum函数的逻辑依赖于注入进来的函数逻辑
  def sumInts2(a: Int,b: Int) = sum(id,a,b)

  def sumCubs2(a: Int, b: Int) = sum(cube,a,b)

  def sumFactorials2(a: Int, b: Int) = sum(fact, a, b)


  val id = (x: Int) => x

  def cube(x: Int) = x * x * x

  def fact(x: Int): Int = if(x == 0) 1 else x * fact(x - 1)




  //////////////////////////////////////////////////////////

  // 高阶函数
  def calcute(f:(Int,Int) => Int,a :Int, b : Int): Unit ={
    val c = f(a,b)
    println(c)
  }


  var add = (a :Int,b :Int) => a + b

  var multiply = (a : Int, b : Int) => a * b



  //    println(add(2,3))
  //    calcute(add,2,3)
  //    calcute(multiply,2,3)

}
