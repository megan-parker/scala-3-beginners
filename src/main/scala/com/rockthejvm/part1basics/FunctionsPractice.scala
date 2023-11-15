package com.rockthejvm.part1basics

object FunctionsPractice {

  def aFunction(a: String, b: Int): String = a + " " + b

  val aFunctionInvocation: String = aFunction("Scala", 999999)

  // No difference here, just two styles
  def aNoArgFunction(): Int = 45
  def aParameterLessFunction: Int = 45

  // functions can be recursive
  // when you need loops, use recursion
  def stringConcatenation(str: String, n: Int): String =
    if (n==0) ""
    else if (n == 1) str
    else str + stringConcatenation(str, n - 1)

  val scalax3: String = stringConcatenation("scala", 3)

  // "void functions"
  def aVoidFunction(aString: String): Unit =
    println(aString)

  def computeDoubleStringWithSideEffect(aString: String): String = {
    aVoidFunction(aString) //Unit
    aString + aString // meaningful value
  } // discouraging side effects => hard to read in large applications

  // wrapper functions
  def aBigFunction(n: Int): Int = {
    // small, auxiliary functions inside
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n + 1)
  }

  /**
   * Exercises
   * 1. A greeting funcion (name, age) => "Hi my name is $name and I am $age years old."
   * 2. Factorial function n => 1 * 2 * 3 * .. * n (negative arg returns zero)
   * 3. Fibonacci function
   *  fib(1) = 1
   *  fib(2) = 1
   *  fib(3) = 1 + 1
   *  fib(n) = fib(n-1) + fib(n-2)
   * 4. Tests if a number is prime
   */

  def aGreetingFunction(name: String, age: Int): Unit = println(s"Hi my name is $name and I am $age years old")

  def aFactorialFunction(n: Int): Int = if (n == 1) 1 else if (n <= 0) 0 else n * aFactorialFunction(n-1)

  def aFibonacciFunction(n: Int): Int = if (n <= 2) 1 else aFibonacciFunction(n-1) + aFibonacciFunction(n-2)

  def isPrime(n: Int): Boolean = {
    //if (n % [n,n-1, n-2... 0] == 0) true else false
    def expression(x: Int): Boolean ={
      println(s"N: $n, X: $x, X-1: ${x-1}")
      if (x == 2) true
      else if ((n % (x-1)) == 0) false
      else expression(x-1)
    }
    expression(n)
  }

  def isPrimeSln(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <=1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2) // only need to check half the numbers
  }

  def main(args: Array[String]): Unit = {
    //    println(scalax3)
    //    println(aFactorialFunction(4))
    //    println(aFibonacciFunction(13))
    println(isPrime(11))

  }

}
