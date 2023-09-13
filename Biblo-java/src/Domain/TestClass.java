package Domain;

import Controller.BookController;
import Controller.ReservationController;
import Domain.Enum.Status;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


public class TestClass {
    public static boolean isInteger(double number) {
        return number == (int) number;
    }
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
                        if (scanner.hasNextInt()) {
                            isbn = scanner.nextInt();
                            scanner.nextLine();

                            if (isbn <= 0) {
                                System.out.println("Invalid ISBN. ISBN must be a positive integer.");
                            } else {
                                isValidIsbn = true;
                            }
                        } else {
                            System.out.println("Invalid input. ISBN must be an integer.");
                            scanner.nextLine();
                        }
                    }

                    boolean isValidTitle = false;
                    while (!isValidTitle) {
                        System.out.println("Enter the book title:");
                        if (scanner.hasNextLine()) {
                            title = scanner.nextLine();
                            if (title.isEmpty()) {
                                System.out.println("Invalid title. Title must not be empty.");
                            } else {
                                isValidTitle = true;
                            }
                        } else {
                            System.out.println("Invalid input. please enter a String value .");
                            scanner.nextLine();
                        }
                    }

                    boolean isValidQuantity = false;
                    while (!isValidQuantity) {
                        System.out.println("Enter the book quantity:");
                        if (scanner.hasNextInt()) {
                            quantity = scanner.nextInt();
                            scanner.nextLine();

                            if (quantity < 0) {
                                System.out.println("Invalid quantity. Quantity must be a non-negative integer.");
                            } else {
                                isValidQuantity = true;
                            }
                        } else {
                            System.out.println("Invalid input. Quantity must be an integer.");
                            scanner.nextLine();
                        }
                    }

                    boolean isValidAuthor = false;
                    while (!isValidAuthor) {
                        System.out.println("Enter the author name:");
                        if (scanner.hasNextLine()) {
                            author = scanner.nextLine();

                            if (author.isEmpty()) {
                                System.out.println("Invalid author name. Author name must not be empty.");
                            } else {
                                isValidAuthor = true;
                            }
                        } else {
                            System.out.println("Invalid input. author must be String .");
                            scanner.nextLine();
                        }
                    }

                    bookController.addBook(isbn, title, quantity, author);
                    System.out.println("Book added successfully!");
                    break;

                case 2:



                    boolean isValidNewISBN = false;
                    int updateIsbn = 0;
                    while (!isValidNewISBN) {
                        System.out.println("Enter the book ISBN to update:");
                        if (scanner.hasNextInt()) {
                            updateIsbn = scanner.nextInt();
                            scanner.nextLine();
                            if (!reservationController.bookExists(updateIsbn)) {
                                System.out.println("Book with ISBN " + updateIsbn + " does not exist.");
                            } else {
                                isValidNewISBN = true;
                            }
                        } else {
                            System.out.println("Invalid ISBN. the isbn must be integer .");
                            scanner.nextLine();
                        }

                    }


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
                    boolean invalidDeleteBook = false;
                    while (!invalidDeleteBook) {
                        System.out.println("Enter the book ISBN to delete:");
                        if (scanner.hasNextInt()) {
                            int deleteId = scanner.nextInt();
                            if (!reservationController.bookExists(deleteId)) {
                                System.out.println("Book with ISBN " + deleteId + " does not exist.");
                            } else {
                                bookController.deleteBook(deleteId);
                                System.out.println("Book deleted successfully!");
                                invalidDeleteBook = true;
                            }

                        } else {
                            System.out.println("Invalid Isbn. ISBN3 must be integer .");
                            scanner.nextLine();
                        }
                    }


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
                case 6:
                    int reserIsbn = 0;

                    boolean isValidreservIsbn = false;
                    while (!isValidreservIsbn) {
                        System.out.println("Enter the book ISBN:");
                        if (scanner.hasNextInt()) {
                            reserIsbn = scanner.nextInt();
                            scanner.nextLine();
                            if (!reservationController.bookExists(reserIsbn)) {
                                System.out.println("Book with ISBN " + reserIsbn + " does not exist.");

                            } else {
                                isValidreservIsbn = true;
                            }

                        } else {
                            System.out.println("Invalid ISBN. please enter a integer value .");
                            scanner.nextLine();
                        }
                    }

                    boolean isValidreservCIN = false;
                    int cin = 0;
                    while (!isValidreservCIN) {
                        System.out.println("Enter the client CIN:");
                        if (scanner.hasNextInt()) {
                            cin = scanner.nextInt();
                            scanner.nextLine();
                            isValidreservCIN = true;
                        } else {
                            System.out.println("Invalid CIN. please enter a integer value .");
                            scanner.nextLine();
                        }
                    }

                    boolean isValidresClientNumber = false;
                    int memberNumber = 0;
                    while (!isValidresClientNumber) {
                        System.out.println("Enter the client member number:");
                        if (scanner.hasNextInt()) {
                            memberNumber = scanner.nextInt();
                            scanner.nextLine();
                            isValidresClientNumber = true;
                        } else {
                            System.out.println("Invalid number mumber . please enter an integer value .");
                            scanner.nextLine();
                        }
                    }

                    System.out.println("Enter the client name:");
                    String clientName = scanner.nextLine();
                    scanner.nextLine();

                    System.out.println("Enter the date of return (YYYY-MM-DD):");
                    String returnDateStr = scanner.nextLine();
                    Date dateOfReturn = Date.valueOf(returnDateStr);

                    client.setCin(cin);
                    client.setMemberNumber(memberNumber);
                    client.setClientName(clientName);

                    Calendar calendar = Calendar.getInstance();
                    java.util.Date dateOfBorrowing = calendar.getTime();
                    java.sql.Date sqlDateOfBorrowing = new java.sql.Date(dateOfBorrowing.getTime());

                    reservationController.addReservation(reserIsbn, Status.BORROWED, client, sqlDateOfBorrowing, dateOfReturn);

                    System.out.println("Reservation added successfully!");

                    break;

                case 7:
                    int returnIsbn = 0;
                    int returnMemberNumber = 0;

                    boolean isValidReturnSbn = false;
                    while (!isValidReturnSbn) {
                        System.out.println("Enter the book ISBN:");
                        if (scanner.hasNextInt()) {
                            returnIsbn = scanner.nextInt();
                            if (!reservationController.bookExists(returnIsbn)) {
                                System.out.println("Book with ISBN " + returnIsbn + " does not exist.");
                            } else {
                                isValidReturnSbn = true;
                            }

                        } else {
                            System.out.println("Invalid ISBN. please enter a integer value .");
                            scanner.nextLine();
                        }
                    }

                    boolean isValidReturnMn = false;
                    while (!isValidReturnMn) {
                        System.out.println("Enter the client member number :");
                        if (scanner.hasNextInt()) {
                            returnMemberNumber = scanner.nextInt();
                            scanner.nextLine();
                            isValidReturnMn = true;
                        } else {
                            System.out.println("Invalid member number. please enter a integer value .");
                            scanner.nextLine();
                        }
                    }
                    reservationController.returnBook(returnIsbn, returnMemberNumber);

                    System.out.println("Book returned successfully!");
                    break;

                case 8:

                    List<Reservation> reservations = reservationController.getAllReservations();
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found.");
                    } else {
                        System.out.println("List of reservations:");
                        System.out.printf("%-15s %-20s %-10s %-20s  %-20s %-20s%n", "book_ISBN", "client_name", "status", "cin", "member number", "date_of_return");

                        for (Reservation reservation : reservations) {
                            System.out.printf("%-15d %-20s %-10s %-20s %-20s %-20s%n",
                                    reservation.getIsbn(), reservation.getClient().getClientName(),
                                    reservation.getStatus().name(), reservation.getClient().getCin(),
                                    reservation.getClient().getMemberNumber(), reservation.getDate_of_return().toString());
                        }
                    }

                    break;


                case 9:
                    System.out.println("Book Statistics:");
                    bookController.getBookCountByStatus(Status.LOST);
                    bookController.getBookCountByStatus(Status.BORROWED);
                    bookController.getBookCountByStatus(Status.AVAILABLE);
                    long countAllbooks = bookController.getAllBooks().stream().count();
                    System.out.println("books :9" + countAllbooks);
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

