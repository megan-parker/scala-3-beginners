package com.rockthejvm.part2oop

object OOBasicsPractice {

  class Person(val name: String = "Jane Doe", age: Int = 0) { // constructor signature can support default args
    // fields
    val allCaps = name.toUpperCase()

    // methods
    // attached to every single Person instance
    def greet(name: String): Unit =
      println(s"${this.name} says: Hi, $name") // this keyword refers to the current instance (Person class), regular name is from greet function

    // signature differs - OVERLOADING
    def greet(): String =
      s"Hi, everyone, my name is $name"

    // aux constructor
    def this(name: String) =
      this(name, 0)

    def this() =
      this("Jane Doe")
  }

  val aPerson: Person = new Person("John", 26)
  val john: String = aPerson.name // doesn't work - name constructor arg isn't a field, add val in-front of name to compile
  val johnYelling: String = aPerson.allCaps
  val johnSayHiToDaniel = aPerson.greet("Daniel")
  val johnSaysHi = aPerson.greet()


  def main(args: Array[String]): Unit = {
    println(johnSayHiToDaniel)
  }
}
