package aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost, List<String> authors) {
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
        for (String author : authors) {
            addAuthor(author);
        }
    }

    public Book(int id, String title, String category, float cost) {
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }

    public void addAuthor(String authorName) {
        if(!authors.contains(authorName))
            authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        if(authors.contains(authorName))
            authors.remove(authorName);
    }


    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + getCost() + "$ - Authors: " + authors;
    }
}
