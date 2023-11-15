package com.rockthejvm.part1basics

object ExpressionsPractice {

  // expressions are structures that can be evaluated to a value
  val meaningOfLife: Int = 40 + 2

  // mathematical expressions: +, -, *, /, bitwise |, &, <<, >>, >>>
  val mathExpression: Int = 2 + 3 * 4

  // comparison operations: <, <=, >, >=, ==, !=
  val equalityTest: Boolean = 1 == 2

  // boolean expressions: !, ||, &&
  val nonEqualityTest: Boolean = !equalityTest

  // instructions vs expressions
  // expressions are evaluated (functional programming), instructions are executed (imperative programming)
  // in scala we think in terms of expressions

  // ifs are expressions in scala
  val aCondition = true
  val anIfExpression: Int = if (aCondition) 45 else 99 // if expressions collapse to a value

  // code blocks
  val aCodeBlock: Int = {
    // local values
    val localValue = 78
    localValue + 54 // value of expression is last value in the code block
  }

  // everything in scala is an expression
  // function implementations are also expressions

  /**
   * Exercise
   * Without running the code, what do you think these values will print out?
   */
  val someValue: Boolean = {
    2 < 3 // Boolean(true)
  }

  val someOtherValue: Int = {
    if (someValue) 239 else 986
    42 // 42
  }

  val yetAnotherValue: Unit = println("Scala") // Scala ()
  val theUnit: Unit = () // same as void in other languages


  def main(args: Array[String]): Unit = {

    println(theUnit)

  }

}
