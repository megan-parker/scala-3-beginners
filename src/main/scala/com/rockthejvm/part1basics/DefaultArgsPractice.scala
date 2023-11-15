package com.rockthejvm.part1basics

import scala.annotation.tailrec

object DefaultArgsPractice {

  //accumulator has a default value
  @tailrec
  def sumUntilTailrec(x: Int, accumulator: Int = 0): Int =
    if (x <= 0) accumulator
    else sumUntilTailrec(x - 1, accumulator + x)

  val sumUntil100: Int = sumUntilTailrec(100)

  // when function often uses the same args, use a default value
  def savePicture(dirPath: String, name: String, format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit =
    println(s"Saving picture in format $format in path $dirPath")

  def main(args: Array[String]): Unit = {
    savePicture("/users/photos", "myphoto")
    savePicture("/users/photos", "myphoto", "png")
    savePicture("/users/photos", "myphoto", width=800, height=600)
  }
}
