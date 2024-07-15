import scala.io.StdIn.readLine

case class Book(title: String, author: String, isbn: String)

object LibraryManagement {

  var library: Set[Book] = Set(
    Book("a Mockingbird", "Harper Lee", "9780061120084"),
    Book("1984", "George Orwell", "9780451524935"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565")
  )

  def addBook(book: Book): Unit = {
    library += book
    println(s"Book '${book.title}' added to the library.")
  }

  def removeBook(isbn: String): Unit = {
    library.find(_.isbn == isbn) match {
      case Some(book) =>
        library -= book
        println(s"Book '${book.title}' removed from the library.")
      case None =>
        println("Book not found.")
    }
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    if (library.isEmpty) {
      println("The library is empty.")
    } else {
      println("Current library collection:")
      library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    }
  }

  def searchBookByTitle(title: String): Unit = {
    library.find(_.title.toLowerCase == title.toLowerCase) match {
      case Some(book) =>
        println(s"Book found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println("Book not found.")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.toLowerCase == author.toLowerCase)
    if (booksByAuthor.isEmpty) {
      println("No books found by this author.")
    } else {
      println(s"Books by ${author}:")
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    }
  }

  def main(args: Array[String]): Unit = {
    var continue = true
    while (continue) {
      println("\nLibrary Management System")
      println("1. Display Library")
      println("2. Add Book")
      println("3. Remove Book")
      println("4. Check Book by ISBN")
      println("5. Search Book by Title")
      println("6. Display Books by Author")
      println("7. Exit")
      print("Enter your choice: ")

      readLine().toInt match {
        case 1 =>
          displayLibrary()
        case 2 =>
          println("Enter title:")
          val title = readLine()
          println("Enter author:")
          val author = readLine()
          println("Enter ISBN:")
          val isbn = readLine()
          addBook(Book(title, author, isbn))
        case 3 =>
          println("Enter ISBN of the book to remove:")
          val isbn = readLine()
          removeBook(isbn)
        case 4 =>
          println("Enter ISBN to check:")
          val isbn = readLine()
          if (isBookInLibrary(isbn)) {
            println("Book is in the library.")
          } else {
            println("Book is not in the library.")
          }
        case 5 =>
          println("Enter title to search:")
          val title = readLine()
          searchBookByTitle(title)
        case 6 =>
          println("Enter author to search:")
          val author = readLine()
          displayBooksByAuthor(author)
        case 7 =>
          continue = false
        case _ =>
          println("Invalid choice. Please try again.")
      }
    }
  }
}

