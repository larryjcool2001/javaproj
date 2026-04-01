import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Simple Library Management System that adds, borrow, and return books.
 */

public class LibrarySystem {

    // Book class to store title, author, and quantity
    static class Book {
        String title;
        String author;
        int quantity;

        Book(String title, String author, int quantity) {
            this.title = title;
            this.author = author;
            this.quantity = quantity;
        }
    }

    // Stores book title as key and Book object as value
    private static Map<String, Book> library = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBooks(scanner);
                    break;
                case 2:
                    borrowBooks(scanner);
                    break;
                case 3:
                    returnBooks(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }
        scanner.close();
    }

    private static void addBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter authors name: ");
        String authorString = scanner.nextLine();

        System.out.print("Enter quantity: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Quantity must be a number.");
            scanner.next();
            return;
        }

        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (library.containsKey(title)) {
            // Update existing book's quantity
            library.get(title).quantity += quantity;
        } else {
            // Add new book with author information
            library.put(title, new Book(title, authorString, quantity));
        }
        System.out.println("Book added/updated successfully.");
        System.out.println("Title: " + title + " | Author: " + authorString + " | Quantity: " + quantity);
    }

    private static void borrowBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        if (!library.containsKey(title)) {
            System.out.println("Book not found in library.");
            return;
        }

        System.out.print("Enter number of books to borrow: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid number.");
            scanner.next();
            return;
        }

        int borrowQty = scanner.nextInt();
        scanner.nextLine();

        Book book = library.get(title);
        int available = book.quantity;

        if (borrowQty <= available && borrowQty > 0) {
            book.quantity -= borrowQty;
            System.out.println("Book borrowed successfully.");
            System.out.println("Title: " + book.title + " | Author: " + book.author);
        } else {
            System.out.println("Insufficient copies available.");
        }
    }

    private static void returnBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        if (!library.containsKey(title)) {
            System.out.println("This book does not belong to the library.");
            return;
        }

        System.out.print("Enter number of books to return: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid number.");
            scanner.next();
            return;
        }

        int returnQty = scanner.nextInt();
        scanner.nextLine();

        if (returnQty > 0) {
            Book book = library.get(title);
            book.quantity += returnQty;
            System.out.println("Book returned successfully.");
            System.out.println("Title: " + book.title + " | Author: " + book.author);
        } else {
            System.out.println("Return quantity must be greater than zero.");
        }
    }
}


