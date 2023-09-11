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
            System.out.println("7. return a book ");
            System.out.println("8. list all reservation ");
            System.out.println("9. statistics ");
            System.out.println("10. Exit");
            System.out.println("---------------------------------------------");

            System.out.print("Choose a number :");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("---------------------------------------------");

            switch (choice) {
                case 1:
                    int isbn = 0;
                    String title = "";
                    int quantity = 0;
                    String author = "";

                    boolean isValidIsbn = false;
                    while (!isValidIsbn) {
                        System.out.println("Enter the book ISBN:");
                        isbn = scanner.nextInt();
                        scanner.nextLine();

                        if (isbn <= 0) {
                            System.out.println("Invalid ISBN. ISBN must be a positive integer.");
                        } else {
                            isValidIsbn = true;
                        }
                    }

                    boolean isValidTitle = false;
                    while (!isValidTitle) {
                        System.out.println("Enter the book title:");
                        title = scanner.nextLine();

                        if (title.isEmpty()) {
                            System.out.println("Invalid title. Title must not be empty.");
                        } else {
                            isValidTitle = true;
                        }
                    }

                    boolean isValidQuantity = false;
                    while (!isValidQuantity) {
                        System.out.println("Enter the book quantity:");
                        quantity = scanner.nextInt();
                        scanner.nextLine();

                        if (quantity < 0) {
                            System.out.println("Invalid quantity. Quantity must be a non-negative integer.");
                        } else {
                            isValidQuantity = true;
                        }
                    }

                    boolean isValidAuthor = false;
                    while (!isValidAuthor) {
                        System.out.println("Enter the author name:");
                        author = scanner.nextLine();

                        if (author.isEmpty()) {
                            System.out.println("Invalid author name. Author name must not be empty.");
                        } else {
                            isValidAuthor = true;
                        }
                    }

                    bookController.addBook(isbn, title, quantity, author);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("Enter the book ISBN to update:");
                    int updateIsbn = scanner.nextInt();
                    scanner.nextLine();


                    boolean isValidNewTitle = false;
                    String newTitle = "";
                    while (!isValidNewTitle) {
                        System.out.println("Enter the new book title:");
                        newTitle = scanner.nextLine();

                        if (newTitle.isEmpty()) {
                            System.out.println("Invalid title. Title must not be empty.");
                        } else {
                            isValidNewTitle = true;
                        }
                    }


                    boolean isValidNewQuantity = false;
                    int newQuantity = 0;
                    while (!isValidNewQuantity) {
                        System.out.println("Enter the new book quantity:");
                        newQuantity = scanner.nextInt();
                        scanner.nextLine();

                        if (newQuantity < 0) {
                            System.out.println("Invalid quantity. Quantity must be a non-negative integer.");
                        } else {
                            isValidNewQuantity = true;
                        }
                    }

                    boolean isValidNewAuthor = false;
                    String newAuthor = "";
                    while (!isValidNewAuthor) {
                        System.out.println("Enter the new author name:");
                        newAuthor = scanner.nextLine();

                        if (newAuthor.isEmpty()) {
                            System.out.println("Invalid author name. Author name must not be empty.");
                        } else {
                            isValidNewAuthor = true;
                        }
                    }

                    boolean isUpdated = bookController.updateBook(updateIsbn, newTitle, newQuantity, newAuthor);
                    if (isUpdated) {
                        System.out.println("Book updated successfully!");
                    } else {
                        System.out.println("Failed to update the book. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("Enter the book ISBN to delete:");
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
                                    book.getIsbn(), book.getTitle(), book.getQuantity(), book.getAuthor());
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
                                    book.getIsbn(), book.getTitle(), book.getQuantity(), book.getAuthor());
                        }
                    }
                    break;

                case 6 :
                    System.out.println("Enter the book ISBN:");
                    int reserIsbn = scanner.nextInt();
                    scanner.nextLine();


                    if (!reservationController.bookExists(reserIsbn)) {
                        System.out.println("Book with ISBN " + reserIsbn + " does not exist.");
                        break;
                    }

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

                    client.setCin(cin);
                    client.setMemberNumber(memberNumber);
                    client.setClientName(clientName);

                    reservationController.addReservation(reserIsbn, Status.BORROWED, client, dateOfBorrowing, dateOfReturn);

                    System.out.println("Reservation added successfully!");
                    break;

                case 7:
                    System.out.println("Enter the book ISBN:");
                    int returnIsbn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the client member number :");
                    int returnMemberNumber = scanner.nextInt();
                    scanner.nextLine();

                    reservationController.returnBook(returnIsbn, returnMemberNumber);

                    System.out.println("Book returned successfully!");
                    break;

                case 8:

                    List<Reservation> reservations = reservationController.getAllReservations();
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found.");
                    } else {
                        System.out.println("List of reservations:");
                        System.out.printf("%-15s %-20s %-10s %-20s %-20s%n", "book_ISBN", "client_name", "status", "cin" , "member number");

                        for (Reservation reservation : reservations) {
                            System.out.printf("%-15d %-20s %-10s %-20s %-20d%n",
                                    reservation.getIsbn(), reservation.getClient().getClientName(), reservation.getStatus().name(), reservation.getClient().getCin() ,reservation.getClient().getMemberNumber() );
                        }
                    }

                    break;


                case 9:
                    System.out.println("Book Statistics:");
                    bookController.getBookCountByStatus(Status.LOST);
                   bookController.getBookCountByStatus(Status.BORROWED);
                 bookController.getBookCountByStatus(Status.AVAILABLE);

                    break;

                case 10:
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

