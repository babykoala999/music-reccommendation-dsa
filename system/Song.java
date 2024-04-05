package system;
import java.util.List;

public class Song {
    private String title;
    private String artist;
    private List<String> genres;

    public Song(String title, String artist, List<String> genres) {
        this.title = title;
        this.artist = artist;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genres=" + genres +
                '}';
    }
}
