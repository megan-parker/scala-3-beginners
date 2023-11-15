package com.rockthejvm.part1basics

object StringOpsPractice {

  val aString: String = "Hello, I am learning Scala"

  // string functions
  val secondCharacter: Char = aString.charAt(1)
  val firstWord: String = aString.substring(0,5)
  val words: Array[String] = aString.split(" ")
  val startsWithHello: Boolean = aString.startsWith("Hello") // true
  val allDashes: String = aString.replace(' ', '-')
  val allUpper: String = aString.toUpperCase()
  val allLower: String = aString.toLowerCase()
  val nChars: Int = aString.length // accessor for number of characters

  // other functions
  val reversed: String = aString.reverse
  val aBunchOfChars: String = aString.take(10)

  // parse a string into a numeric type
  val numberAsString: String = "2"
  val number: Int = numberAsString.toInt

  // interpolation
  // injection of variables inside of a string
  val name = "Alice"
  val age = 12
  val greeting = s"Hi my name is $name and I am $age years old"
  val greetingv1 = s"Hi my name is $name and I will be turning ${age+1} years old"

  // f-interpolation - control numeric formatting
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"

  //raw interpolation can ignore escape sequences
  val escapes = "This is a \n newline"
  val noEscapes = raw"This is a \n newline"

  // You can also create your own interpolation features

  def main(args: Array[String]): Unit = {
    println(firstWord)
    println(words.mkString("Array(", ", ", ")"))
    println(allDashes)
    println(aBunchOfChars)
    println(myth)
    println(escapes)
    println(noEscapes)
  }
}
