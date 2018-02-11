package com.weiyan

object 函数 {


  var tmp = 0


  var ++ = () => tmp +=1 // 非纯函数，对全局变量tmp做了修改。有副作用  tmp = tmp + 1 这种表达式在数学中是永远不会成立的。这是芬诺依曼机器指令的操作行为。

  var add = (first: Int, second: Int) => first + second



  def main(args: Array[String]): Unit = {
    (1 to 100).foreach(item => {
//      println(item)
      ++()
    })
    println(tmp)

    val sum = add(2,3) // 纯函数
    println(sum)
  }

}
