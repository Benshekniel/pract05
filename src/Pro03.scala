object Fibonacci {

  def fibonacci(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => fibonacci(n - 1) + fibonacci(n - 2)
  }

  def printFibonacciNumbers(n: Int): Unit = {
    def loop(i: Int): Unit = {
      if (i < n) {
        print(s"${fibonacci(i)} ")
        loop(i + 1)
      }
    }
    loop(0)
  }

  def main(args: Array[String]): Unit = {
    println("Enter the number of Fibonacci numbers to print:")
    val n = scala.io.StdIn.readInt()
    printFibonacciNumbers(n)
  }
}

