package system;

import java.util.*;

public class MusicRecommendationSystem {
    private Map<String, List<String>> userPreferences; // Map to store user preferences
    private Map<String, List<String>> userFeedback; // Map to store user feedback
    private MusicCatalog musicCatalog; // Music catalog reference

    static Scanner sc = new Scanner(System.in);
    
    public MusicRecommendationSystem() {
        this.userPreferences = new HashMap<>();
        this.userFeedback = new HashMap<>();
        this.musicCatalog = new MusicCatalog();
    }

    // Method to add user preferences
    public void addUserPreferences(String username, List<String> preferences) {
        userPreferences.put(username, preferences);
    }

    // Method to recommend songs based on user preferences
    public List<String> recommendSongs(String username, MusicCatalog catalog) {
        List<String> userPreferences = this.userPreferences.get(username);
        if (userPreferences == null || userPreferences.isEmpty()) {
            System.out.println("User has no preferences.");
            return new ArrayList<>();
        }

        Map<String, Integer> songScores = new HashMap<>();

        // Calculate similarity between users based on preferences
        Map<String, Double> userSimilarities = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : this.userPreferences.entrySet()) {
            String otherUsername = entry.getKey();
            if (!otherUsername.equals(username)) {
                List<String> otherUserPreferences = entry.getValue();
                double similarity = calculateSimilarity(userPreferences, otherUserPreferences);
                userSimilarities.put(otherUsername, similarity);
            } 
        }

        // Use preferences of similar users for collaborative filtering
        for (Map.Entry<String, Double> similarityEntry : userSimilarities.entrySet()) {
            String otherUsername = similarityEntry.getKey();
            double similarity = similarityEntry.getValue();
            List<String> similarUserPreferences = this.userPreferences.get(otherUsername);
            for (String preference : similarUserPreferences) {
                for (Song song : catalog.getSongs()) {
                    if (song.getGenres().contains(preference)) {
                        // Use similarity to weight song scores
                        int score = (int) (similarity * songScores.getOrDefault(song.getTitle(), 0));
                        songScores.put(song.getTitle(), score);
                    }
                }
            }
        }

     // Sort songs by score in descending order
        List<Map.Entry<String, Integer>> sortedSongs = new ArrayList<>(songScores.entrySet());
        sortedSongs.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Extract song names from sorted entries and limit to 5 recommendations
        List<String> recommendedSongs = new ArrayList<>();
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedSongs) {
            recommendedSongs.add(entry.getKey());
            count++;
            if (count == 5) {
                break;
            }
        }

        return recommendedSongs;
    }


    // Method to calculate similarity between two users based on preferences
    private double calculateSimilarity(List<String> preferences1, List<String> preferences2) {
        Set<String> intersection = new HashSet<>(preferences1);
        intersection.retainAll(preferences2);
        int commonPreferences = intersection.size();
        int totalPreferences = preferences1.size() + preferences2.size() - commonPreferences;
        return (double) commonPreferences / totalPreferences;
    }

    // Method to register a new user
    public void registerUser(String username, String password) {
        UserLoginSystem.registerUser(username, password);
    }

    // Method to authenticate a user
    public boolean authenticateUser(String username, String password) {
        return UserLoginSystem.validateLogin(username, password);
    }

    // Method to provide feedback on recommended songs
    public void provideFeedback(String username, String song, String feedback) {
        userFeedback.computeIfAbsent(username, k -> new ArrayList<>()).add(song + ": " + feedback);
    }

    // Method to get feedback for a user
    public List<String> getFeedback(String username) {
        return userFeedback.getOrDefault(username, Collections.emptyList());
    }
    
    public void registerUser() {
        System.out.println("Enter a username:");
        String username = sc.nextLine();
        System.out.println("Enter a password:");
        String password = sc.nextLine();

        List<String> preferences = new ArrayList<>();
        System.out.println("Enter your genre preferences (comma-separated):");
        String genreInput = sc.nextLine();
        List<String> genres = Arrays.asList(genreInput.split(","));
        for (String genre : genres) {
            preferences.add(genre.trim());
        }
        addUserPreferences(username, preferences);
        registerUser(username, password);       
        System.out.println("User registered successfully!");
    }

    public static void main(String[] args) {
        MusicRecommendationSystem recommendationSystem = new MusicRecommendationSystem();

        // Register users
        recommendationSystem.registerUser("User1", "password1");
        recommendationSystem.registerUser("User2", "password2");
        recommendationSystem.registerUser("User3", "password3");
        // Sample user preferences
        recommendationSystem.addUserPreferences("User1", Arrays.asList("Rock", "Pop"));
        recommendationSystem.addUserPreferences("User2", Arrays.asList("Pop", "Hip Hop"));
        recommendationSystem.addUserPreferences("User3", Arrays.asList("Jazz", "Blues"));
        
        // Sample music catalog (song, genres)
        MusicCatalog catalog = new MusicCatalog();
        catalog.addSong(new Song("Believer", "Imagine Dragons", Arrays.asList("Rock", "Alternative")));
        catalog.addSong(new Song("Havana", "Camila Cabello", Arrays.asList("Pop", "Latin")));
        catalog.addSong(new Song("So What", "P!nk", Arrays.asList("Pop", "Rock")));
        catalog.addSong(new Song("God's Plan", "Drake", Arrays.asList("Hip Hop", "Rap")));
        catalog.addSong(new Song("Old Town Road", "Lil Nas X", Arrays.asList("Hip Hop", "Country")));
        catalog.addSong(new Song("Bad Guy", "Billie Eilish", Arrays.asList("Pop", "Electropop")));
        catalog.addSong(new Song("Vaaste", "Dhvani Bhanushali", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Duniyaa", "Akhil & Dhvani Bhanushali", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Bekhayali", "Sachet Tandon", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Blinding Lights", "The Weeknd", Arrays.asList("Pop", "Synth-pop")));
        catalog.addSong(new Song("Dance Monkey", "Tones and I", Arrays.asList("Pop", "Indie pop")));
        catalog.addSong(new Song("Watermelon Sugar", "Harry Styles", Arrays.asList("Pop", "Funk-pop")));
        catalog.addSong(new Song("Filhall", "B Praak", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Tum Hi Aana", "Jubin Nautiyal", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Bheegi Bheegi", "Neha Kakkar & Tony Kakkar", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Levitating", "Dua Lipa", Arrays.asList("Pop", "Disco")));
        catalog.addSong(new Song("Montero (Call Me by Your Name)", "Lil Nas X", Arrays.asList("Hip Hop", "Pop")));
        catalog.addSong(new Song("Bachpan Ka Pyar", "Badshah", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Savage Love", "Jawsh 685 & Jason Derulo", Arrays.asList("Pop", "Dance-pop")));
        catalog.addSong(new Song("Levitating", "Dua Lipa", Arrays.asList("Pop", "Disco")));
        catalog.addSong(new Song("O Saki Saki", "Neha Kakkar", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Dilbar", "Neha Kakkar & Dhvani Bhanushali", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Tera Ban Jaunga", "Akhil Sachdeva & Tulsi Kumar", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Tera Ghata", "Gajendra Verma", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Bekhayali", "Sachet Tandon", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Senorita", "Shawn Mendes & Camila Cabello", Arrays.asList("Pop", "Latin")));
        catalog.addSong(new Song("Genda Phool", "Badshah", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Aankh Marey", "Neha Kakkar & Mika Singh", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Laung Laachi", "Mannat Noor", Arrays.asList("Pop", "Bollywood")));
        catalog.addSong(new Song("Duniyaa", "Akhil & Dhvani Bhanushali", Arrays.asList("Pop", "Bollywood")));

        recommendationSystem.registerUser();
        
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        // Authenticate users and recommend songs
        if (recommendationSystem.authenticateUser(username, password)) {
            List<String> recommendedSongs = recommendationSystem.recommendSongs(username, catalog);
            System.out.println("Recommended songs for " + username + ": " + recommendedSongs);

        } else {
            System.out.println("Authentication failed for " + username);
        }

        // Close scanner
        sc.close();
    }
}
