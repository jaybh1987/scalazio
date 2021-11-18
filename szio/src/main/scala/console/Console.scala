package console

import com.sun.xml.internal.fastinfoset.tools.PrintTable


sealed trait Console[+A]
final case class Return[A](value: () => A) extends Console[A]
final case class PrintLine[A](line: String, rest: Console[A]) extends Console[A]
final case class ReadLine[A](rest: String => Console[A]) extends Console[A]


class ConsoleSyntax[+A](self: Console[A]) {

}

//object Test {
//
//  val example1: Console[Unit] = PrintLine(
//    "Hello, what is your name?",
//    ReadLine( name =>
//      PrintLine(s"my name is $name",
//        Return(() => ())
//      ))
//  )
//
//  def succeed[A](a: => A): Console[A] = Return(() => a)
//
//  def printLine(line: String): Console[Unit] = PrintLine(line, succeed())
//
//  def readLine: Console[String] = ReadLine(line => succeed(line))
//
//  def interpret[A](program: Console[A]): A = program match {
//    case Return(value) => value()
//    case PrintLine(line, next) =>
//      println(line)
//      interpret(next)
//    case ReadLine(next) => interpret(next(scala.io.StdIn.readLine()))
//  }
//}
//
//
