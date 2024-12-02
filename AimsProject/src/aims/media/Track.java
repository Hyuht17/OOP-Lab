package aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Kiểm tra nếu 2 tham chiếu trỏ cùng một đối tượng
        if (!(o instanceof Track)) return false; // Kiểm tra kiểu đối tượng
        Track track = (Track) o; // Ép kiểu đối tượng
        return this.title != null && this.title.equals(track.title)
                && this.length == track.length; // So sánh tiêu đề và độ dài
    }

}
