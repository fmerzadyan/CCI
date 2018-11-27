package string;

import java.util.Arrays;

public class Permutation {
    private static boolean isPermutationUsingSorting(String A, String B) {
        // Permutation means a different arrangement of characters but the same length.
        if (A.length() != B.length()) return false;
        
        // Sort both strings which should equal each other if the same sorting algorithm is used
        // and if they are permutations of each other.
        A = sort(A);
        B = sort(B);
        
        return A.equals(B);
    }
    
    private static String sort(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
    
    private static boolean isPermutationUsingCharFrequency(String A, String B) {
        if (A.length() != B.length()) return false;
        
        // ASCII offers 128 characters (7 bit for every character).
        int[] chars = new int[128];
        for (int i = 0; i < A.length(); i++) {
            chars[A.charAt(i)]++;
        }
    
        for (int i = 0; i < B.length(); i++) {
            chars[B.charAt(i)]--;
            if (chars[B.charAt(i)] < 0) return false;
        }
        
        // Chars has no negative values and therefore no positive values either.
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isPermutationUsingSorting("race", "care"));
        System.out.println(isPermutationUsingCharFrequency("race", "care"));
    }
}
