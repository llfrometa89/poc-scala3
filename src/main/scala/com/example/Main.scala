package com.example

@main def hello: Unit = 
  println("//Hello world!")
  println("Hello world!")
  println(msg)
  println(s"numAsString is ${numAsString(3)}")

  println("//Opaque type")
  import Logarithms.*
  val l2 = Logarithm(2.0)
  val l3 = Logarithm(3.0)
  println((l2 * l3).toDouble) // prints 6.0
  println((l2 + l3).toDouble) // prints 4.999...

  //CONTROL STRUCTURES
  println("//-> if/else")
  val a = 1
  val b = 2
  val x = if a < b then a else b

  println(s"result -> $x")

  println("//-> for loops and expressions")
  val ints = List(1, 2, 3, 4, 5)
  for i <- ints do println(i)

  println("//-> for loops and expressions with Guards")
  for
    i <- ints
    if i > 2
  do
    println(i)

  println("//-> for loops and expressions with Multiple Guards")
  for
    i <- 1 to 3
    j <- 'a' to 'c'
    if i == 2
    if j == 'b'
  do
    println(s"i = $i, j = $j")

  println("//-> for expressions")
  val doubles = for i <- ints yield i * 2 
  println(s"result -> $doubles")

  //FIRST-CLASS FUNCTIONS
  //Scala has most features you’d expect in a functional programming language, including:
  //- Lambdas
  //- Higher-order functions (HOFs)
  //- Immutable collections in the standard library
  //Lambdas, also known as anonymous functions, are a big part of keeping your code concise but readable.
  //The map method of the List class is a typical example of a higher-order function—a function that takes a lambda as parameter.

  //CONTEXTUAL ABSTRACTIONS
  //val addresses: List[Address] = ...
  //addresses.sortBy(address => (address.city, address.street))
  //or
  //addresses.sortBy(address => (address.city, address.street))(using Ordering.Tuple2(Ordering.String, Ordering.String))

  //DOMAIN MODELING
  //The Tools section introduces the tools that are available to you, including classes, traits, enums, and more
  //The OOP Modeling section looks at modeling attributes and behaviors in an object-oriented programming (OOP) style (https://docs.scala-lang.org/scala3/book/domain-modeling-oop.html)
  //The FP Modeling section looks at domain modeling in a functional programming (FP) style


def numAsString(i:Int) = i match
  case 1 | 3 | 5 | 7 | 9 => "odd"
  case 2 | 4 | 6 | 8 | 10 => "even"
  case _ => "too big"

def msg = "I was compiled by Scala 3. :)"

enum Color:
  case Red, Blue, Green

object Logarithms:
// this is the important difference!
  opaque type Logarithm = Double

  object Logarithm:
    def apply(d: Double): Logarithm = math.log(d)

  extension (x: Logarithm)
    def toDouble: Double = math.exp(x)
    def + (y: Logarithm): Logarithm = Logarithm(math.exp(x) + math.exp(y))
    def * (y: Logarithm): Logarithm = x + y