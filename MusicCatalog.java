import java.util.ArrayList;
import java.util.List;

class MusicCatalog {
    private List<Song> songs;

    public MusicCatalog() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> searchByTitle(String title) {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                result.add(song);
            }
        }
        return result;
    }

    public List<Song> searchByArtist(String artist) {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getArtist().equalsIgnoreCase(artist)) {
                result.add(song);
            }
        }
        return result;
    }

    public List<Song> searchByGenre(String genre) {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getGenre().equalsIgnoreCase(genre)) {
                result.add(song);
            }
        }
        return result;
    }
    public static void main(String args[]) {
    	MusicCatalog catalog=new MusicCatalog();
    	catalog.addSong(new Song("Believer", "Imagine Dragons", "Rock")); // Released in 2018 (English)
        catalog.addSong(new Song("Havana", "Camila Cabello", "Pop")); // Released in 2018 (English)
        catalog.addSong(new Song("So What", "P!nk", "Pop")); // Released in 2018 (English)
        catalog.addSong(new Song("God's Plan", "Drake", "Hip Hop")); // Released in 2018 (English)
        catalog.addSong(new Song("Old Town Road", "Lil Nas X", "Hip Hop")); // Released in 2019 (English)
        catalog.addSong(new Song("Bad Guy", "Billie Eilish", "Pop")); // Released in 2019 (English)
        catalog.addSong(new Song("Vaaste", "Dhvani Bhanushali", "Pop")); // Released in 2019 (Hindi)
        catalog.addSong(new Song("Duniyaa", "Akhil & Dhvani Bhanushali", "Pop")); // Released in 2019 (Hindi)
        catalog.addSong(new Song("Bekhayali", "Sachet Tandon", "Pop")); // Released in 2019 (Hindi)
        catalog.addSong(new Song("Blinding Lights", "The Weeknd", "Electronic")); // Released in 2020 (English)
        catalog.addSong(new Song("Dance Monkey", "Tones and I", "Pop")); // Released in 2020 (English)
        catalog.addSong(new Song("Watermelon Sugar", "Harry Styles", "Pop")); // Released in 2020 (English)
        catalog.addSong(new Song("Filhall", "B Praak", "Pop")); // Released in 2020 (Hindi)
        catalog.addSong(new Song("Tum Hi Aana", "Jubin Nautiyal", "Pop")); // Released in 2020 (Hindi)
        catalog.addSong(new Song("Bheegi Bheegi", "Neha Kakkar & Tony Kakkar", "Pop")); // Released in 2020 (Hindi)
        catalog.addSong(new Song("Levitating", "Dua Lipa", "Pop")); // Released in 2020 (English)
        catalog.addSong(new Song("Montero (Call Me by Your Name)", "Lil Nas X", "Hip Hop")); // Released in 2021 (English)
        catalog.addSong(new Song("Bachpan Ka Pyar", "Badshah", "Pop")); // Released in 2021 (Hindi)
        catalog.addSong(new Song("Savage Love", "Jawsh 685 & Jason Derulo", "Pop")); // Released in 2020 (English)
        catalog.addSong(new Song("Levitating", "Dua Lipa", "Pop")); // Released in 2021 (English)
        catalog.addSong(new Song("O Saki Saki", "Neha Kakkar", "Pop")); // Released in 2019 (Hindi)
        catalog.addSong(new Song("Dilbar", "Neha Kakkar & Dhvani Bhanushali", "Pop")); // Released in 2018 (Hindi)
        catalog.addSong(new Song("Tera Ban Jaunga", "Akhil Sachdeva & Tulsi Kumar", "Pop")); // Released in 2019 (Hindi)
        catalog.addSong(new Song("Tera Ghata", "Gajendra Verma", "Pop")); // Released in 2018 (Hindi)
        catalog.addSong(new Song("Bekhayali", "Sachet Tandon", "Pop")); // Released in 2019 (Hindi)
        catalog.addSong(new Song("Senorita", "Shawn Mendes & Camila Cabello", "Pop")); // Released in 2019 (English)
        catalog.addSong(new Song("Genda Phool", "Badshah", "Pop")); // Released in 2020 (Hindi)
        catalog.addSong(new Song("Aankh Marey", "Neha Kakkar & Mika Singh", "Pop")); // Released in 2018 (Hindi)
        catalog.addSong(new Song("Laung Laachi", "Mannat Noor", "Pop")); // Released in 2018 (Hindi)
        catalog.addSong(new Song("Duniyaa", "Akhil & Dhvani Bhanushali", "Pop")); // Released in 2019 (Hindi)
        //System.out.println("added sucesfully");
    }
}
