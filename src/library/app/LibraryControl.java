package library.app;

import library.exception.DataExportException;
import library.exception.DataImportException;
import library.exception.NoSuchOptionException;
import library.io.ConsolePrinter;
import library.io.DataReader;
import library.io.file.FileManager;
import library.io.file.FileManagerBuilder;
import library.model.Book;
import library.model.Library;
import library.model.Magazine;
import library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private FileManager fileManager;

    private Library library;

    LibraryControl() {
        fileManager = new FileManagerBuilder(printer, dataReader).build();
        try {
            library = fileManager.importData();
            printer.printLine("Zaimportowane dane z pliku");
        } catch (DataImportException e) {
            printer.printLine(e.getMessage());
            printer.printLine("Zainicjowano nową bazę.");
            library = new Library();
        }
    }


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
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + " ,podaj ponownie:");
            } catch (InputMismatchException ignore) {
                printer.printLine("Wprowadzono warość, która nie jest liczbą, podaj ponownie:");
            }
        }
        return option;
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        for (Option value : Option.values()) {
            System.out.println(value);
        }
    }

    private void addBook() {
       try{
           Book book = dataReader.readAndCreateBook();
           library.addBooks(book);
       }catch (InputMismatchException e){
           printer.printLine("Nie udało się stworzyć książki, niepoprawne dane.");
       }catch (ArrayIndexOutOfBoundsException e){
           printer.printLine("Osiągnięto limit pojemności, nie można dodać kolejnej książki");
       }
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        }catch (InputMismatchException e){
            printer.printLine("Nie idało się stworzyć magazynum, niepoprawne dane.");
        }catch (IndexOutOfBoundsException e){
            printer.printLine("Osiągnięto limit pojemności, nie można dodać klejnego magayznu.");
        }

    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazines(publications);
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }


    private void exit() {
        try {
            fileManager.ExportData(library);
            printer.printLine("Export danych do pliku zakończony sukcesem.");
        }catch (DataExportException e){
            printer.printLine(e.getMessage());
        }
        dataReader.close(); // zamykamy strumień wejścia
        printer.printLine("Koniec programu, papa!");
    }


    enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BOOK(1, "Dodanie książki"),
        ADD_MAGAZINE(2, "Dodanie magazynu/gazety"),
        PRINT_BOOKS(3, "Wyświetlenie dostępnych książek"),
        PRINT_MAGAZINES(4, "Wyświetlenie dostępnych magazynów/gazet");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }


        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id " + option);
            }
        }
    }

}
