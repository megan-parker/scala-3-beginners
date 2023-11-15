package com.rockthejvm.part1basics

object TypeInference {

  val message = "Hello, world" // compiler infers type from right side
  val message1: String = "Hello, world" // same thing

  // Compiler tries to infer type of everything in an expression

  val x = 2
  val y = s"$x items"

  def func(x: Int): Int = x + 1 // compiler automatically decides Int

  // In functions, compiler can't infer everything
  def factorial(n: Int): Int =
    if (n <= 0) 1 //integer
    else n * factorial(n-1) // can't infer type unless you manually infer it


  def main(args: Array[String]): Unit = {

  }

}
