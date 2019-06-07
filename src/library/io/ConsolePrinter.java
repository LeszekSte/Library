package library.io;

import library.model.Book;
import library.model.LibraryUser;
import library.model.Magazine;
import library.model.Publication;

import java.util.Collection;

public class ConsolePrinter {

    public void printBooks(Collection<Publication>  publications) {
        int couter = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.toString());
                couter++;
            }
        }
        if (couter == 0)
            printLine("Brak książek w bibliotece");
    }

    public void printMagazines(Collection<Publication> publications) {
        int couter = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                printLine(publication.toString());
                couter++;
            }
        }
        if (couter == 0)
            printLine("Brak magazynów w bibliotece");
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printUsers(Collection<LibraryUser>  users) {
        for (LibraryUser user : users) {
            printLine(user.toString());
        }

    }
}
