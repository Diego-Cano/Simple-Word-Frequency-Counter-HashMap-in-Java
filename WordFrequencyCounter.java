import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a block of text (or type 'exit' to quit):");
        String input = scanner.nextLine();
        
        // Process the input and count word frequencies
        Map<String, Integer> wordFrequencies = countWordFrequencies(input);
        
        // Sort the results alphabetically
        Map<String, Integer> sortedFrequencies = new TreeMap<>(wordFrequencies);
        
        // Display the results
        System.out.println("\nWord Frequencies:");
        for (Map.Entry<String, Integer> entry : sortedFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        scanner.close();
    }
    
    /**
     * Counts the frequency of each word in the given text.
     * 
     * @param text The input text to process
     * @return A map containing words as keys and their frequencies as values
     */
    public static Map<String, Integer> countWordFrequencies(String text) {
        Map<String, Integer> frequencies = new HashMap<>();
        
        // Split the text into words by spaces
        String[] words = text.split("\\s+");
        
        // Process each word
        for (String word : words) {
            // Convert to lowercase and remove common punctuation
            word = word.toLowerCase().replaceAll("[.,!?;:'\"]", "");
            
            // Skip empty strings
            if (word.isEmpty()) {
                continue;
            }
            
            // Update the frequency count
            if (frequencies.containsKey(word)) {
                // Word already exists, increment its count
                frequencies.put(word, frequencies.get(word) + 1);
            } else {
                // New word, add it with count 1
                frequencies.put(word, 1);
            }
        }
        
        return frequencies;
    }
}