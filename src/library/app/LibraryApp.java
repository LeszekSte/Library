package library.app;

public class LibraryApp {

    private final static   String APP_NAME = "Biblioteka v 1.8.2";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libControl = new LibraryControl();
        libControl.controlLoop();
    }
}

//    Klasa może zawierać pola i metody statyczne.
//   *     Pola statyczne najczęściej będą połączone ze słowem final i będziemy je wtedy nazywali stałymi.
//   *    Stałe nazywamy WIELKIMI_LITERAMI.

//   *     Pola statyczne istnieją tylko w jednym egzemplarzu w ramach całej aplikacji
//        i powiązane są z klasą, niezależnie od tego ile obiektów danej klasy utworzysz.
//   *     Metody statyczne mogą się odwoływać tylko do innych składowych statycznych

//       ********* super
//      - Nawet jeśli tego nie zapiszesz, to pierwszą instrukcją w konstruktorze zawsze jest super().
//      - Korzystając z instrukcji super() możemy z konstruktora naszej klasy wywołać konstruktor z klasy nadrzędnej.
//      - Jeżeli w klasie nadrzędnej będzie kilka konstruktorów, to wywołany będzie ten,
//        który odpowiada przekazanym do super() argumentom.
//      - Używając notacji super.nazwaMetody() możesz wywołać dowolną metodę z klasy nadrzędnej,
//        co jest przydatne szczególnie wtedy, kiedy nadpisałeś metodę z klasy nadrzędnej w swojej klasie,
//        a nadal potrzebujesz do niej dostępu.