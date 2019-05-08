package library.app;

import library.io.DataReader;
import library.model.Book;

public class LibraryApp {

    public static void main(String[] args) {
        final String appName = "Biblioteka v0.9";
        System.out.println(appName);
//        books[0] = new Book("W pustyni i w puszczy", "Heniek", 1870, 300, "Agora", "1654636");
//        books[1] = new Book("W pustyni", "Wojtek", 1900, 500, "Helios", "16546654636");
//        books[2] = new Book("W Ameryce", "Marek", 2055, 301, "TomCat", "5461654636");

        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();

    }
}

