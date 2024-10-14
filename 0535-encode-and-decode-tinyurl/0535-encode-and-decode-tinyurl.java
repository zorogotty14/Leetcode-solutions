import java.util.HashMap;
import java.util.Random;

public class Codec {

    private HashMap<String, String> encodeMap;
    private HashMap<String, String> decodeMap;
    private String baseUrl;
    private String charset;
    private Random random;
    
    // Constructor to initialize the maps and other components
    public Codec() {
        encodeMap = new HashMap<>();
        decodeMap = new HashMap<>();
        baseUrl = "http://tinyurl.com/";
        charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        random = new Random();
    }

    // Method to generate a random string for the short URL
    private String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) { // We use a fixed length of 6 characters
            sb.append(charset.charAt(random.nextInt(charset.length())));
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encodeMap.containsKey(longUrl)) {
            return baseUrl + encodeMap.get(longUrl); // Return existing encoded URL if present
        }
        
        String shortUrl = generateRandomString();
        
        // Ensure that the short URL is unique
        while (decodeMap.containsKey(shortUrl)) {
            shortUrl = generateRandomString(); // Regenerate if collision happens
        }
        
        encodeMap.put(longUrl, shortUrl);
        decodeMap.put(shortUrl, longUrl);
        
        return baseUrl + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(baseUrl, ""); // Extract the random string part
        return decodeMap.getOrDefault(key, ""); // Return original URL if found
    }
}
