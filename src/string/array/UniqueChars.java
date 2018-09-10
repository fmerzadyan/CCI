package string.array;

import java.util.HashMap;

public class UniqueChars {
    // Uses HashMap
    private static boolean isUniqueUsingHashMap(String chars) {
        HashMap<Character, Boolean> charsPresent = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            // Assuming the chars are ASCII characters.
            char currentChar = chars.charAt(i);
            if (charsPresent.containsKey(currentChar)) {
                return false;
            } else {
                charsPresent.put(currentChar, true);
            }
        }
        return true;
    }
    
    private static boolean isUniqueUsingBooleanArray(String chars) {
        int len = chars.length();
        // ASCII provides 128 characters (7-bit memory for every char).
        // If the length of the chars is longer than 128 characters then there MUST be a repeat character.
        if (len > 128) return false;
        
        boolean[] charset = new boolean[128];
        for (int i = 0; i < len; i++) {
            char currentChar = chars.charAt(i);
            if (charset[currentChar]) {
                return false;
            }
            charset[currentChar] = true;
        }
        
        return true;
    }
    
    private static boolean isUniqueUsingBitManipulation(String chars) {
        int checker = 0;
        for (int i = 0; i < chars.length(); i++) {
            
            // int charAt = chars.charAt(i);
            // int a = 'a';
            int currentChar = chars.charAt(i) - 'a';
            // int bitShift = (1 << currentChar);
            // int bitwiseAnd = checker & bitShift;
            if ((checker & (1 << currentChar)) > 0) {
                return false;
            }
            // int bitwiseOr = checker | (1 << currentChar);
            checker |= (1 << currentChar);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String chars = "abbcdefg";
        System.out.println(isUniqueUsingHashMap(chars));
        System.out.println(isUniqueUsingBooleanArray(chars));
        System.out.println(isUniqueUsingBitManipulation(chars));
    }
}
