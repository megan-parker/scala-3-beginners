package com.rockthejvm.part1basics

object ValuesAndTypesPractice {

  // values
  val meaningOfLife: Int = 42

  // reassigning is not allowed
  // meaningOfLife = 45 // this is an error

  // type inferrence
  val anInteger = 67 // Typing is optional

  // common types - essential types, primitive types - mapped to regular types on JVM
  val aBoolean: Boolean = true // or false
  val aChar: Char = 'a' // simple quotes with single character
  val anInt: Int = 78 // 4 bytes
  val aShort: Short = 5263 // 2 bytes representation
  val aLong: Long = 234345234 // 8 bytes
  val aFloat: Float = 2.4f // decimals - 4 bytes
  val aDouble: Double = 3.13 // decimals - 8 bytes

  // string
  val aString: String = "a" //double quotes with series of characters

  def main(args: Array[String]): Unit = {

  }

}
