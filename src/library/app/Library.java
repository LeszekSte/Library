package library.app;

import library.io.DataReader;
import library.model.Book;

public class Library {

    public static void main(String[] args) {

        final String appName = "Biblioteka v0.8";
        final int VOLUMIN = 1000;

        Book[] books = new Book[VOLUMIN];
        books[0] = new Book("W pustyni i w puszczy", "Heniek", 1870, 300, "Agora", "1654636");
        books[1] = new Book("W pustyni", "Wojtek", 1900, 500, "Helios", "16546654636");
        books[2] = new Book("W Ameryce", "Marek", 2055, 301, "TomCat", "5461654636");

        DataReader dataReader = new DataReader();
        books[3] = dataReader.readAndCreateBook();

        System.out.println(appName);
            for (int i = 0; i < 4; i++) {
                System.out.println(books[i].toString());
            }

        System.out.printf("W bibliotece można przechowywać %d książek.", books.length);
    }
}
