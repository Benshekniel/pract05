import scala.io.StdIn.readLine

object InventoryManagement {

  def getProductList: List[String] = {
    def loop(acc: List[String]): List[String] = {
      val input = readLine("Enter product name (or type 'done' to finish): ")
      if (input.toLowerCase == "done") acc
      else loop(acc :+ input)
    }
    loop(List())
  }

  def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach {
      case (product, index) => println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  def main(args: Array[String]): Unit = {
    val productList = getProductList
    println("Product List:")
    printProductList(productList)
    println(s"Total number of products: ${getTotalProducts(productList)}")
  }
}