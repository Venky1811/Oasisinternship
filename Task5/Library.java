package Task5;

import java.util.*;
import java.time.LocalDate;


class Book {
    private String title;
    private String author;
    private String category;
    private boolean isIssued;
    private LocalDate returnDate;

    // Constructor, getters, and setters
    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isIssued = false;
        this.returnDate = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean getIsIssued() {
        return isIssued;
    }

    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}

// User class
class User {
    private String username;
    private String email;

    // Constructor, getters, and setters
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

// Library class
public class Library {
    private List<Book> books;
    private List<User> users;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Add book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Add user to the library system
    public void addUser(User user) {
        users.add(user);
    }

    // Remove user from the library system
    public void removeUser(User user) {
        users.remove(user);
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        Library library = new Library();

        // Creating some books and users
        Book book1 = new Book("Midnight's Children", "Salman Rushdie", "Fiction");
        Book book2 = new Book("The God of Small Things", "Arundhati Roy", "Fiction");
        User user1 = new User("Venky", "Venky@example.com");

        // Adding books and users to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addUser(user1);

        // Testing the functionality
        System.out.println("Books in the library: ");
        for (Book book : library.books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (Category: " + book.getCategory() + ")");
        }

        System.out.println("\nUsers in the library system: ");
        for (User user : library.users) {
            System.out.println("Username: " + user.getUsername() + ", Email: " + user.getEmail());
        }
    }
}
