package library.model;

public class Library {

        private final int maxBooks  = 1000;
        private Book [] books = new Book[maxBooks];
        private int booksNumber;


    public void addBooks(Book book) {
        if (booksNumber<maxBooks){
        books[booksNumber]= book;
        booksNumber++;
        }else {
            System.out.println("Maksymalna ilość książek została osiąnięta.");
        }
    }


    public void printBooks() {
        if (booksNumber==0){
            System.out.println("Brak książek w bibliotece");
        }
        for (int i = 0; i < booksNumber; i++) {
            System.out.println(books[i].toString());
        }
    }
}
