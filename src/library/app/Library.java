package library.app;

import library.model.Book;

public class Library {

    public static void main(String[] args) {

        final String appName = "Biblioteka v0.5";

        String title = "W pustyni i w puszczy";
        String author = "Henryk Sienkiewicz";
        int yearOfPublishmen = 1_955;
        int numberOfPages = 256;
        String publishingHouse = "Helios";
        String isbnNumber = "65464567414";

        Book book = new Book(title, author, yearOfPublishmen, numberOfPages, publishingHouse);
        Book book1 = new Book(title, author, yearOfPublishmen, numberOfPages, publishingHouse,
                isbnNumber);

        System.out.println(appName);
        System.out.println(book.toString());
        System.out.println(book1.toString());

    }
}
