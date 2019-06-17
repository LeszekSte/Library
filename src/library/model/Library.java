package library.model;

import library.exception.PublicationAlreadyExistsException;
import library.exception.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.*;

public class Library implements Serializable {


    private Map<String, Publication> publications = new HashMap<>();
    private Map<String, LibraryUser> users = new HashMap<>();

    public Map<String, Publication> getPublications() {
        return publications;
    }

      public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public Collection<Publication>getSortetPublication (Comparator<Publication>comparator){
        ArrayList<Publication> list = new ArrayList<>(this.publications.values());
        list.sort(comparator);
        return list;
    }

    public Collection<LibraryUser> getSortetUser (Comparator<LibraryUser>compactor){
        ArrayList<LibraryUser> list = new ArrayList<>(this.users.values());
        list.sort(compactor);
        return list;
    }

      public void addUser(LibraryUser user) {
        if(users.containsKey(user.getPesel()))
            throw new UserAlreadyExistsException(
                    "Użytkownik ze wskazanym peselem już istnieje " + user.getPesel());
        users.put(user.getPesel(), user);
    }

      public void addPublication(Publication publication) {
        if(publications.containsKey(publication.getTitle()))
            throw new PublicationAlreadyExistsException(
                    "Publikacja o takim tytule już istnieje " + publication.getTitle());
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
}