import java.util.*;
public class Song {
	    private String title;
	    private String artist;
	    private String genre;
	    // Add more attributes as needed

	    public Song(String title, String artist, String genre) {
	        this.title = title;
	        this.artist = artist;
	        this.genre = genre;
	    }
	    public String toString() {
	        return "Title: " + title + ", Artist: " + artist + ", Genre: " + genre;
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

	    public String getGenre() {
	        return genre;
	    }

	    public void setGenre(String genre) {
	        this.genre = genre;
	    }
}
