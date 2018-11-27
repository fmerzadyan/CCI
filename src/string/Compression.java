package string;

public class Compression {
    private static String compress(String originalString) {
        char currentLetter;
        int counter = 0;
        StringBuilder compressedString = new StringBuilder();
        
        for (int i = 0; i < originalString.length(); i++) {
            currentLetter = originalString.charAt(i);
            
            if (i == originalString.length() - 1) {
                counter += 1;
                compressedString.append(String.valueOf(currentLetter) + counter);
                break;
            }
            
            char nextLetter = originalString.charAt(i + 1);
            if (currentLetter == nextLetter) {
                counter += 1;
            } else {
                counter += 1;
                compressedString.append(String.valueOf(currentLetter) + counter);
                counter = 0;
            }
        }
        
        return compressedString.length() > originalString.length() ? originalString : compressedString.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaar"));
    }
}
