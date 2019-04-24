public class Main {

    public static void main(String[] args) {
        final String appName = "Biblioteka v0.1";



        String title = "W pustyni i w puszczy";
        String author = "Henryk Sienkiewicz";
        int yearOfPublishmen = 1955;
        int numberOfPages = 256;
        String publishingHouse = "Helios";
        String isbnNumber = "65464567414";
        Book book = new Book(title,author,yearOfPublishmen,numberOfPages,publishingHouse,
                isbnNumber);
        System.out.println(appName);
        System.out.println("Książki dostępne w Bibliotece");
        System.out.println("Tutuł - " + book.getTitle());
        System.out.println("Autor - " + book.getAuthor());
        System.out.println("Rok wydania - " + book.getPublishingHouse());
        System.out.println("Ilość stron -  " + book.getNumberOfPages());
        System.out.println("ISBN numer  - " + book.getIsbnNumber());

        System.out.println(book.toString());

    }
}
