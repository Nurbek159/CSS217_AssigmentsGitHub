package ex6;

import java.util.*;


class BookInventory {
    private static final Map<String, Integer> books = new HashMap<>();
    static {
        books.put("Book 1", 5);
        books.put("Book 2", 3);
        books.put("Book 3", 2);
        books.put("Book 4", 0);
        books.put("Book 5", 7);
    }

    public static boolean checkAvailability(String title) {
        if (books.containsKey(title) && books.get(title) > 0) {
            return true;
        }
        return false;
    }

    public static boolean borrowBook(String title) {
        if (checkAvailability(title)) {
            books.put(title, books.get(title) - 1);
            return true;
        }
        return false;
    }

    public static boolean returnBook(String title) {
        if (books.containsKey(title)) {
            books.put(title, books.get(title) + 1);
            return true;
        }
        return false;
    }
}


class UserManagement {
    private static final Map<String, List<String>> users = new HashMap<>();
    static {
        users.put("User 1", new ArrayList<>(Arrays.asList("Book 1", "Book 3")));
        users.put("User 2", new ArrayList<>(Arrays.asList("Book 2")));
        users.put("User 3", new ArrayList<>());
    }

    public static boolean borrowBook(String user, String title) {
        if (users.containsKey(user)) {
            users.get(user).add(title);
            return true;
        }
        return false;
    }

    public static boolean returnBook(String user, String title) {
        if (users.containsKey(user) && users.get(user).contains(title)) {
            users.get(user).remove(title);
            return true;
        }
        return false;
    }
}


class LibraryFacade {
    public static boolean borrowBook(String user, String title) {
        if (BookInventory.borrowBook(title)) {
            if (UserManagement.borrowBook(user, title)) {
                return true;
            } else {
                BookInventory.returnBook(title);
            }
        }
        return false;
    }

    public static boolean returnBook(String user, String title) {
        if (UserManagement.returnBook(user, title)) {
            BookInventory.returnBook(title);
            return true;
        }
        return false;
    }

    public static boolean checkAvailability(String title) {
        return BookInventory.checkAvailability(title);
    }


    public static void searchBooks(String title, String author) {

    }
}
