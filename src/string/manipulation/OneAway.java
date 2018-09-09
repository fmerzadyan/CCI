package string.manipulation;

public class OneAway {
    
    private static boolean isOneEditAway(String A, String B) {
        // If the difference in length is greater than one then it can't be one edit away.
        if (Math.abs(A.length() - B.length()) > 1) return false;
        
        // Get shorter and longer strings.
        A = A.length() < B.length() ? A : B;
        B = A.length() < B.length() ? B : A;
        
        int i = 0, j = 0;
        boolean isDifferent = false;
        while (i < A.length() && j < B.length()) {
            if (A.charAt(i) != B.charAt(j)) {
                // Ensure that this is the first difference found.
                if (isDifferent) return false;
                isDifferent = true;
                
                // Replacement: move shorter pointer.
                if (A.length() == B.length()) i++;
            } else {
                // If matching then move shorter pointer.
                i++;
            }
            // Always move pointer for longer string.
            j++;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // Add
        System.out.println(isOneEditAway("fake", "afake"));
        // Remove
        System.out.println(isOneEditAway("fake", "ake"));
        // Replace
        System.out.println(isOneEditAway("fake", "fmke"));
        System.out.println(isOneEditAway("fake", "fakedd"));
    }
}
