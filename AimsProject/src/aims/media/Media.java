package aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = MediaComparator.COMPARE_BY_TITLE_COST;
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = MediaComparator.COMPARE_BY_COST_TITLE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isMatch(String title) {
        return getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Kiểm tra nếu 2 tham chiếu trỏ cùng một đối tượng
        if (!(o instanceof Media)) return false; // Kiểm tra kiểu đối tượng
        Media media = (Media) o; // Ép kiểu đối tượng
        return this.title != null && this.title.equals(media.title); // So sánh tiêu đề
    }

}
