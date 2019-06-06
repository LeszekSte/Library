package library.model;

import library.exception.PublicationAlreadyExistsException;
import library.exception.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {

    // private static final int INITIAL_CAPACITY = 1;
   //  private int publicationsNumber;
   //  private Publication[] publications = new Publication[INITIAL_CAPACITY];

    private Map<String, Publication> publications = new HashMap<>();
    private Map<String, LibraryUser> users = new HashMap<String, LibraryUser>();



    public Map<String, Publication> getPublications() {
        return publications;
    }

    public Map<String, LibraryUser> getUser() {
        return users;
    }




    //    public Publication[] getPublications() {
//        Publication[] result = new Publication[publicationsNumber];
//        for (int i = 0; i < publicationsNumber; i++) {
//            result[i] = publications[i];
//        }
//        return result;
//    }

    public void addUser(LibraryUser user) {
        if(users.containsKey(user.getPesel()))
            try {
                throw new UserAlreadyExistsException(
                        "Użytkownik ze wskazanym peselem już istnieje " + user.getPesel()
                );
            } catch (UserAlreadyExistsException e) {
                e.printStackTrace();
            }
        users.put(user.getPesel(), user);
    }
//
//    public void addPublication(Publication publication) {
//        if (publications.containsKey(publication.getTitle())) {
//            publications = Arrays.copyOf(publications, publications.length * 2);
//        }
//        publications[publicationsNumber] = publication;
//        publicationsNumber++;
//    }

    public void addPublication(Publication publication) {
        if(publications.containsKey(publication.getTitle()))
            try {
                throw new PublicationAlreadyExistsException(
                        "Publikacja o takim tytule już istnieje " + publication.getTitle()
                );
            } catch (PublicationAlreadyExistsException e) {
                e.printStackTrace();
            }
        publications.put(publication.getTitle(), publication);
    }

    public boolean removePublication(Publication publication) {
        if(publications.containsValue(publication)) {
            publications.remove(publication.getTitle());
            return true;
        } else {
            return false;
        }
    }
//    public boolean removePublication(Publication pub) {
//        final int NOT_FOUND = -1;
//        int found = NOT_FOUND;
//        int i = 0;
//        while (i < publications.length && found == NOT_FOUND) {
//            if (pub.equals(publications[i])) {
//                found = i;
//            } else {
//                i++;
//            }
//        }
//        if (found != NOT_FOUND) {
//            System.arraycopy(publications, found + 1, publications, found, publications.length - found - 1);
//            publicationsNumber--;
//        }
//        return found != NOT_FOUND;
//    }
}