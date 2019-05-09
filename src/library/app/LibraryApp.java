package library.app;

import library.io.DataReader;
import library.model.Book;

public class LibraryApp {

    private final static   String APP_NAME = "Biblioteka v11";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libControl = new LibraryControl();
        libControl.controlLoop();
    }
}

//    Klasa może zawierać pola i metody statyczne.
//        Pola statyczne najczęściej będą połączone ze słowem final i będziemy je wtedy nazywali stałymi.
//        Stałe nazywamy WIELKIMI_LITERAMI.

//        Pola statyczne istnieją tylko w jednym egzemplarzu w ramach całej aplikacji
//        i powiązane są z klasą, niezależnie od tego ile obiektów danej klasy utworzysz.

//        Metody statyczne mogą się odwoływać tylko do innych składowych statycznych