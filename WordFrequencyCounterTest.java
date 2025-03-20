import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;

public class WordFrequencyCounterTest {
    
    @Test
    public void testBasicFunctionality() {
        // Test case 1: Normal case with repeated words
        String input1 = "hello world hello java world";
        Map<String, Integer> result1 = WordFrequencyCounter.countWordFrequencies(input1);
        
        assertEquals(3, result1.size());
        assertEquals(Integer.valueOf(2), result1.get("hello"));
        assertEquals(Integer.valueOf(2), result1.get("world"));
        assertEquals(Integer.valueOf(1), result1.get("java"));
        
        // Test case 2: Normal case with different capitalization
        String input2 = "Hello WORLD hello Java world";
        Map<String, Integer> result2 = WordFrequencyCounter.countWordFrequencies(input2);
        
        assertEquals(3, result2.size());
        assertEquals(Integer.valueOf(2), result2.get("hello"));
        assertEquals(Integer.valueOf(2), result2.get("world"));
        assertEquals(Integer.valueOf(1), result2.get("java"));
        
        // Test case 3: Normal case with punctuation
        String input3 = "Hello, world! Hello. Java; world?";
        Map<String, Integer> result3 = WordFrequencyCounter.countWordFrequencies(input3);
        
        assertEquals(3, result3.size());
        assertEquals(Integer.valueOf(2), result3.get("hello"));
        assertEquals(Integer.valueOf(2), result3.get("world"));
        assertEquals(Integer.valueOf(1), result3.get("java"));
    }
    
    @Test
    public void testEdgeCases() {
        // Test case 4: Edge case - empty string
        String input4 = "";
        Map<String, Integer> result4 = WordFrequencyCounter.countWordFrequencies(input4);
        
        assertEquals(0, result4.size());
        
        // Test case 5: Edge case - single word
        String input5 = "hello";
        Map<String, Integer> result5 = WordFrequencyCounter.countWordFrequencies(input5);
        
        assertEquals(1, result5.size());
        assertEquals(Integer.valueOf(1), result5.get("hello"));
        
        // Test case 6: Edge case - multiple spaces
        String input6 = "hello   world  hello";
        Map<String, Integer> result6 = WordFrequencyCounter.countWordFrequencies(input6);
        
        assertEquals(2, result6.size());
        assertEquals(Integer.valueOf(2), result6.get("hello"));
        assertEquals(Integer.valueOf(1), result6.get("world"));
    }
}