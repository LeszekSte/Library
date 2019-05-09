package library.app;

import library.io.DataReader;
import library.model.Book;
import library.model.Library;
import library.model.Magazine;

public class LibraryControl {
    // zmienne do kontrolowania programu
    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int ADD_MAGAZINE = 2;

    private static final int PRINTS_BOOKS = 3;
    private static final int PRINTS_MAGZINE = 4;

    // zmienna do komunikacji z użytkownikiem
    private DataReader dataReader = new DataReader();

    // "biblioteka" przechowująca dane
    private Library library = new Library();

    /*
     * Główna metoda programu, która pozwala na wybór opcji i interakcję
     */

    public void controlLoop() {
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINTS_BOOKS:
                    printBooks();
                    break;

                case PRINTS_MAGZINE:
                    printMagazines();
                    break;

                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Nie ma tekiej opcji");
            }
        } while (option != EXIT);


    }



    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void printBooks()
    {
        library.printBooks();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBooks(book);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        System.out.println(EXIT + " - wyjście z programu");
        System.out.println(ADD_BOOK + " - dodanie nowej książki");
        System.out.println(ADD_MAGAZINE + " - dodanie nowego magazynu");
        System.out.println(PRINTS_BOOKS + " - wyświetl dostępne książki");
        System.out.println(PRINTS_MAGZINE + " - wyświetl dostępne magazyny");
    }


    private void exit() {
        System.out.println("Koniec programu, papa!");
        // zamykamy strumień wejścia
        dataReader.close();
    }
}
