package string.array.manipulation;

public class Matrix {
    private static String[][] transposeMatrix(String[][] matrix) {
        // Assuming NxN matrix where m=n.
        String[][] result = new String[matrix.length][matrix.length];
        
        // Each row becomes a column in transposed matrix.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        
        return result;
    }
    
    private static String[][] rotateMatrix(String[][] matrix) {
        // Ensure NxN matrix where N cannot be zero.
        if (matrix.length == 0 || matrix.length != matrix[0].length) return null;
        
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = 1 - first;
                // Save the top.
                String top = matrix[first][i];
                // Left -> top.
                matrix[first][i] = matrix[last - offset][first];
                // Bottom -> left.
                matrix[last - offset][first] = matrix[last][last - offset];
                // Right -> bottom.
                matrix[last][last - offset] = matrix[i][last];
                // Top -> right.
                matrix[i][last] = top;
            }
        }
        
        return matrix;
    }
    
    private static void print(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
        }
        System.out.print("\n\n");
    }
    
    public static void main(String[] args) {
        String[][] matrix = new String[3][3];
        
        matrix[0][0] = "a";
        matrix[0][1] = "b";
        matrix[0][2] = "c";
        matrix[1][0] = "d";
        matrix[1][1] = "e";
        matrix[1][2] = "f";
        matrix[2][0] = "g";
        matrix[2][1] = "h";
        matrix[2][2] = "i";
        
        String[][] result = transposeMatrix(matrix);
        print(result);
        
        String[][] result2 = rotateMatrix(matrix);
        print(result2);
    }
}
