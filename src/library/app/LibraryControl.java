package library.app;

import library.exception.NoSuchOptionException;
import library.io.ConsolePrinter;
import library.io.DataReader;
import library.model.Book;
import library.model.Library;
import library.model.Magazine;

import java.util.InputMismatchException;

public class LibraryControl {
    // zmienne do kontrolowania programu
//    private static final int EXIT = 0;
//    private static final int ADD_BOOK = 1;
//    private static final int ADD_MAGAZINE = 2;
//
//    private static final int PRINTS_BOOKS = 3;
//    private static final int PRINTS_MAGZINE = 4;

    // zmienna do komunikacji z użytkownikiem
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    // "biblioteka" przechowująca dane
    private Library library = new Library();

    /*
     * Główna metoda programu, która pozwala na wybór opcji i interakcję
     */

    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Nie ma tekiej opcji");
            }
        } while (option != Option.EXIT);


    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                try {
                    option = Option.createFromInt(dataReader.getInt());
                    optionOk = true;
                } catch (NoSuchOptionException e) {
                    printer.printLine(e.getMessage() + " ,podaj ponownie:");

                } catch (InputMismatchException ignore) {
                    printer.printLine("Wprowadzono warość, która nie jes liczbą, posaj ponownie:");
                }
            } finally {

            }
        }
        return option;
    }


    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBooks(book);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        for (Option value : Option.values()) {
            System.out.println(value);
        }
    }


    private void exit() {
        System.out.println("Koniec programu, papa!");
        // zamykamy strumień wejścia
        dataReader.close();
    }
}
