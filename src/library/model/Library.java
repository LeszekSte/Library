package library.model;

import java.util.Arrays;

public class Library {

    private static final int MAX_PUBLICATION = 2000;
    private Publication[] publications = new Publication[MAX_PUBLICATION];
    private int publicationsNumber;

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        for (int i = 0; i < publicationsNumber; i++) {
            result[i] = publications[i];
        }
        return publications;
    }

    public void addBooks(Book book) {
        addPublcation(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublcation(magazine);
    }

    private void addPublcation(Publication publication) {
        if (publicationsNumber >= MAX_PUBLICATION) {
            throw new ArrayIndexOutOfBoundsException("Max publication exceeded " + MAX_PUBLICATION);
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }

}
