package com.rockthejvm.part2oop

object OOBasicsExamplesPractice {

  /**
   * Exercise: imagine we're creating a backend for a book publishing house.
   * Create a Novel and a Writer class
   *
   * Writer: first name, surname, year
   *  - method fullname
   *
   * Novel: name, year of release, author
   *  - authorAge
   *  - isWrittenBy(author)
   *  - copy (new year of release) = new instance of novel
   */

  class Writer(firstName: String, surName: String, val yearOfBirth: Int){
    def fullname: String = s"$firstName $surName"
  }

  class Novel(name: String, yearOfRelease: Int, author: Writer) {
    def authorAge: Int = {
      // Determine age of author at time of publishing of Novel subtract YOB writer from year of release of novel
      this.yearOfRelease - author.yearOfBirth
    }
    def isWrittenBy(author: Writer): Boolean = {
      // returns Boolean if written by author instance passed
      author == this.author
    }

    def copy(newYearOfRelease: Int): Novel= {
      // return new instance of novel data structure
      new Novel(this.name, newYearOfRelease, this.author)
    }
  }

  /**
   * Exercise 2: an immutable counter closs
   * - constructed with an initial count
   * - increment/decrement => NEW instances of counter
   * - increment(n)/decrement(n) => NEW instance of counter
   * - print() print current count of counter instance
   *
   * Benefits of immutable data:
   * 1. works well in distributed environments
   * 2. Easier to read and understand code
   */

  class Counter(count: Int = 0){
    def increment: Counter = new Counter(count + 1)
    def decrement: Counter =
      if (count == 0) this
      else
        new Counter(count - 1)

    def increment(n: Int): Counter = //new Counter(count + n) //option 1: increment counter that jumps over n points OR
      if (n <= 0) this
      else
        increment.increment(n - 1) // vulnerable to stack overflow errors at large numbers

    def decrement(n: Int): Counter = // new Counter(count - n)
    if (n <= 0) this
    else decrement.decrement(n - 1) // vulnerable to stack overflow errors at large numbers but is better if logging is done in inc/dec methods

    def print(): Unit = println(s"Current count $count") // Use () for action methods, not for getter methods
  }

  def main(args: Array[String]): Unit = {
    val counter = new Counter()
    counter.increment.increment.increment.decrement.print()

    val charlesDickens = new Writer("Charles", "Dickens", 1812)
    println(charlesDickens.fullname)

    val novel = new Novel("Great Expectations", 1861, charlesDickens)
    println(novel.authorAge)
    val charlesDickensImpostor = new Writer("Charles", "Impostor", 1912)
    println(novel.isWrittenBy(charlesDickensImpostor))
    println(novel.isWrittenBy(charlesDickens))

    val fakeNovel = new Novel("Great Expectations Fake", 1940, charlesDickensImpostor)
    println(fakeNovel.isWrittenBy(charlesDickensImpostor))
    println(fakeNovel.isWrittenBy(charlesDickens))

    val novelCopy = novel.copy(1870)
    println(novel.isWrittenBy(charlesDickensImpostor))
    println(novel.isWrittenBy(charlesDickens))
  }
}
