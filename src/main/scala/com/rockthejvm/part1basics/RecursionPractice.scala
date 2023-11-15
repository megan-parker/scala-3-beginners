package com.rockthejvm.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object RecursionPractice {

  // "repetition" == recursion
  def sumUntil(n: Int): Int =
    if (n <= 0) 0
    else n + sumUntil(n - 1)

  def sumUntilV2(n:Int): Int = {
    @tailrec
    def sumUntilTailrec(x: Int, accumulator: Int): Int =
      if (x <= 0) accumulator
      else sumUntilTailrec(x - 1, accumulator + x) // TAIL recursion = recursive call occurs LAST in it's code path
      // no further stack frames necessary = no more risk of Stack Overflow

    sumUntilTailrec(n, 0)
  }

  def sumNumbersBetween(a: Int, b: Int): Int =
    if (a > b) 0
    else a + sumNumbersBetween(a + 1, b)

  def sumNumbersBetweenV2(a: Int, b: Int): Int = {
    @tailrec
    def sumTailRec(currentNumber: Int, accumulator: Int): Int =
      if (currentNumber > b) accumulator
      else sumTailRec(currentNumber + 1, accumulator + currentNumber)

    sumTailRec(a, 0)
  }

  /**
   * Exercises
   * 1. Concatenate a string n times
   * 2. Fibonacci function, tail recursive
   * 3. Is isPrime tail recursive? YES, it's recursion is in the last position
   */

  def stringConcatenation(a: String, n: Int): String = {
    @tailrec
    def stringConcatTR(currentStr: String, accumulator: Int): String = {
      if (accumulator == 1) currentStr
      else stringConcatTR(currentStr + a, accumulator - 1)
    }
    stringConcatTR(a, n)
  }

//  def aFibonacciFunction(n: Int): Int = if (n <= 2) 1 else aFibonacciFunction(n-1) + aFibonacciFunction(n-2)

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTR(y: Int, last: Int, previous: Int): Int = {
      if (y >= n) last
      else fibonacciTR(y + 1, last + previous, last)
    }

    if (n <= 2) 1
    else fibonacciTR(2, 1,1)
  }

  def main(args: Array[String]): Unit = {
    //    println(sumUntilV2(10))
    //    println(sumUntilV2(200000)) // stackoverflow -> too many repetitions for stack
    // question: tail recursion? why do 10 and 20000 work but 200000 returns a negative number

    println(stringConcatenation("scala", 5))
  }

}
