package library.model;

public class Library {

    private static final int MAX_LIBRARY = 2000;
    private Publication[] publications = new Publication[MAX_LIBRARY];
    private int publicationsNumber;

    public void addBooks(Book book) {
        if (publicationsNumber < MAX_LIBRARY) {
            publications[publicationsNumber] = book;
            publicationsNumber++;
        } else {
            System.out.println("Maksymalna ilość książek została osiąnięta.");
        }
    }

    public void addMagazine(Magazine magazine) {
        if (publicationsNumber < MAX_LIBRARY) {
            publications[publicationsNumber] = magazine;
            publicationsNumber++;
        } else {
            System.out.println("Maksymalna ilość magazynów została osiąnięta.");
        }
    }

    public void printBooks() {
        int countBooks = 0;
        if (publicationsNumber == 0) {
            System.out.println("Brak książek w bibliotece");
        }
        for (int i = 0; i < publicationsNumber; i++) {
            if (publications[i] instanceof Book)
                System.out.println(publications[i].toString());
                countBooks++;
        }
    }

    public void printMagazines() {
        int countMagazine = 0;
        if (publicationsNumber == 0) {
            System.out.println("Brak magazynów w bibliotece");
        }
        for (int i = 0; i < publicationsNumber; i++) {

            if (publications[i] instanceof Magazine) {
                System.out.println(publications[i].toString());
                countMagazine++;
            };
        }
    }

}
