package Domain;
import Controller.BookController;
import java.util.List;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        BookController bookController = new BookController();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("---------------------------------------------");
            System.out.println("Welcome to the Book Management System!");
            System.out.println("Please select an action:");
            System.out.println("1. Add a book");
            System.out.println("2. Update a book");
            System.out.println("3. Delete a book");
            System.out.println("4. List all books");
            System.out.println("5. Exit");
            System.out.println("---------------------------------------------");

            System.out.print("Choose a number :");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.println("---------------------------------------------");

            switch (choice) {
                case 1:
                    System.out.println("Enter the book isbn:");
                    int isbn = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Enter the book title:");
                    String title = scanner.nextLine();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Enter the book countity:");
                    int countity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Enter the author name:");
                    String author = scanner.nextLine();
                    bookController.addBook(isbn, title , countity , author );
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("Enter the book ISBN to update:");
                    int updateIsbn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the new book title:");
                    String newTitle = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Enter the new book countity:");
                    int updateCountity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the new author name:");
                    String updateName = scanner.nextLine();
                    bookController.updateBook(updateIsbn , newTitle , updateCountity ,updateName );
                    System.out.println("Book updated successfully!");
                    break;

                case 3:
                    System.out.println("Enter the book ID to delete:");
                    int deleteId = scanner.nextInt();
                    bookController.deleteBook(deleteId);
                    System.out.println("Book deleted successfully!");
                    break;

                case 4:
                    List<Book> books = bookController.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        System.out.println("List of books:");
                        for (Book book : books) {
                            System.out.println(
                            "ID: " + book.getIsbn() +
                            ", Title: " + book.getTitle() +
                            ", " +"Title: " + book.getTitle()
                            + ", " +"Countity: " + book.getCountity()
                            + ", " +"Author: " + book.getAuthor()
                            );
                        }
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }

}

