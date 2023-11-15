package com.rockthejvm.part1basics

object CBNvsCBVPractice {


  // CBV - standard way of invoking a function with arguments
  // call by value: arguments are evaluated before function invocation
  def aFunction(arg: Int): Int = arg + 1 // passes 90 => 90+1
  val aComputation: Int = aFunction(23 + 67)

  // CBN = call by name
  // arguments are passed LITERALLY as an expression
  def aByNameFunction(arg: => Int): Int = arg + 1 // passes 23 + 67 => 23+67+1
  val anotherComputation = aByNameFunction(23 + 67)

  def printTwiceByValue(x: Long): Unit = {
    println("By value " + x)
    println("By value " + x)
    // Same value
  }

  def printTwiceByName(x: => Long): Unit = {
    println("By name " + x)
    println("By name " + x)
    // Different value
    // Delayed evaluation of the argument
    // Argument is evaluated every time it's used
  }

  def infinite(): Int = 1 + infinite() // infinite loop

  def printFirst(x: Int, y: => Int) = println(x)

  def main(args: Array[String]): Unit = {
//    println(aComputation)
//    println(anotherComputation)

    printTwiceByName(System.nanoTime())
//    printFirst(infinite(), 42) // crashes
    printFirst(42, infinite()) // doesn't crash
    // outcome: we can delay dangerous operations until they are needed
  }
}
