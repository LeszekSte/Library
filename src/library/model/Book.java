package library.model;

public class Book {
    private String title;
    private String author;
    private int yearOfPublishmen;
    private int numberOfPages;
    private String publishingHouse;
    private String isbnNumber;


    public Book(String title, String author, int yearOfPublishmen, int numberOfPages, String publishingHouse, String isbnNumber) {
        this(title,author,yearOfPublishmen,numberOfPages,publishingHouse);
        this.isbnNumber = isbnNumber;
    }

    public Book(String title, String author, int yearOfPublishmen, int numberOfPages, String publishingHouse) {
        this.title = title;
        this.author = author;
        this.yearOfPublishmen = yearOfPublishmen;
        this.numberOfPages = numberOfPages;
        this.publishingHouse = publishingHouse;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublishmen() {
        return yearOfPublishmen;
    }

    public void setYearOfPublishmen(int yearOfPublishmen) {
        this.yearOfPublishmen = yearOfPublishmen;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }


    @Override
    public String toString() {

        String info;
        if (isbnNumber==null){
            isbnNumber= "";
        }

        info="Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublishmen=" + yearOfPublishmen +
                ", numberOfPages=" + numberOfPages +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", isbnNumber='" + isbnNumber + '\'' +
                '}';



        return  info;


   }
}
