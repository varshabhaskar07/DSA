import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int length = 0;
        boolean centralPalindromeUsed = false;

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (map.getOrDefault(reverse, 0) > 0) {
                // Pair found: word + reverse
                length += 4;
                map.put(reverse, map.get(reverse) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Check if there's a word like "gg" or "cc" that can be used in the center
        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                length += 2;
                break; // Only one such word can be placed in the center
            }
        }

        return length;
    }
}
