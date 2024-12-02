package aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructor with all fields
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(); // Call the superclass constructor
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
        this.length = length;
        this.director = director;
    }

    // Getter for length
    public int getLength() {
        return length;
    }

    // Getter for director
    public String getDirector() {
        return director;
    }
}
