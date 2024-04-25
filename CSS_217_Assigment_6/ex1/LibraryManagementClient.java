package ex6;

public class LibraryManagementClient {
    public static void main(String[] args) {

        boolean success = LibraryFacade.borrowBook("User 1", "Book 2");
        System.out.println(success); // Output: true


        success = LibraryFacade.returnBook("User 1", "Book 1");
        System.out.println(success); // Output: true


        boolean available = LibraryFacade.checkAvailability("Book 4");
        System.out.println(available); // Output: false
    }
}
