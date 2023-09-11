package Domain;
import Controller.BookController;
import Controller.ReservationController;
import Domain.Enum.Status;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        BookController bookController = new BookController();
        ReservationController reservationController = new ReservationController();
        BookCopy bookCopy = new BookCopy();
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);



        boolean exit = false;
        while (!exit) {
            System.out.println("---------------------------------------------");
            System.out.println("Welcome to the Book Management System!");
            System.out.println("Please select an action:");
            System.out.println("1. Add a book");
            System.out.println("2. Update a book");
            System.out.println("3. Delete a book");
            System.out.println("4. Search by authore or book");
            System.out.println("5. List all books");
            System.out.println("6. Add a reservation ");
            System.out.println("7. Exit");
            System.out.println("---------------------------------------------");

            System.out.print("Choose a number :");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("---------------------------------------------");

            switch (choice) {
                case 1:
                    System.out.println("Enter the book isbn:");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the book title:");
                    String title = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Enter the book countity:");
                    int countity = scanner.nextInt();
                    scanner.nextLine();
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
                    System.out.println("Enter a keyword for book or author search:");
                    String keyword = scanner.nextLine();

                    List<Book> searchResults = bookController.searchBooks(keyword);
                    System.out.println("Search Results:");

                    if (searchResults.isEmpty()) {
                        System.out.println("No books found matching the search criteria.");
                    } else {
                        System.out.println("List of filtered books:");
                        System.out.printf("%-15s %-20s %-10s %-20s%n", "ISBN", "Title", "Quantity", "Author");

                        for (Book book : searchResults) {
                            System.out.printf("%-15d %-20s %-10d %-20s%n",
                                    book.getIsbn(), book.getTitle(), book.getCountity(), book.getAuthor());
                        }
                    }
                    break;

                case 5:
                    List<Book> books = bookController.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        System.out.println("List of books:");
                        System.out.printf("%-15s %-20s %-10s %-20s%n", "ISBN", "Title", "Quantity", "Author");

                        for (Book book : books) {
                            System.out.printf("%-15d %-20s %-10d %-20s%n",
                                    book.getIsbn(), book.getTitle(), book.getCountity(), book.getAuthor());
                        }
                    }
                    break;

                case 6 :
                    System.out.println("Enter the reservation ID:");
                    int reservationId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the book ISBN:");
                    int reserIsbn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the client CIN:");
                    int cin = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the client member number:");
                    int memberNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the client name:");
                    String clientName = scanner.nextLine();
                    System.out.println("Enter the date of borrowing (YYYY-MM-DD):");
                    String borrowingDateStr = scanner.nextLine();
                    Date dateOfBorrowing = Date.valueOf(borrowingDateStr);
                    System.out.println("Enter the date of return (YYYY-MM-DD):");
                    String returnDateStr = scanner.nextLine();
                    Date dateOfReturn = Date.valueOf(returnDateStr);

                    // Create a new bookcopy object
                    bookCopy.setBookIsbn(reserIsbn);
                    bookCopy.setStatus(Status.BORROWED);
                    bookCopy.setId(reservationId);
                    // Create a new client object

                    client.setCin(cin);
                    client.setMember_number(memberNumber);
                    client.setClient_name(clientName);


                    // Call the addReservation method in the reservationController
                    reservationController.addReservation( reserIsbn, bookCopy, client, dateOfBorrowing, dateOfReturn);

                    System.out.println("Reservation added successfully!");
                    break;


                case 7:
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

