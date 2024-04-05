package system;
import java.util.*;
public class UserLoginSystem {
private static Map<String, String> users = new HashMap<>(); // Map to store username-password pairs
    
    // Method to register a new user
    public static void registerUser(String username, String password) {
        users.put(username, password);
    }
    
    // Method to check if a username exists
    public static boolean usernameExists(String username) {
        return users.containsKey(username);
    }
    
    // Method to validate user login
    public static boolean validateLogin(String username, String password) {
        if (users.containsKey(username)) {
            String storedPassword = users.get(username);
            return storedPassword.equals(password);
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Register some users (for demonstration purposes)
        registerUser("user1", "password1");
        registerUser("user2", "password2");
        
        // User login process
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        
        // Validate login
        if (validateLogin(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
        
        scanner.close();
    }
}
