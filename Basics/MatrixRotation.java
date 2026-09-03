   import java.util.Arrays;
   public class MatrixRotation {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose 
        for (int i = 0; i < n; i++) {
            // j = i + 1 से शुरू होता है ताकि डायगोनल के नीचे के एलिमेंट्स दोबारा स्वैप न हों
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Step 2: Reverse Rows 
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                
                left++;
                right--;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3}, {4, 5, 6},{7, 8, 9}};
        System.out.println("---(Original Matrix) ---");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("\n--- 90(Rotated Matrix) ---");
        printMatrix(matrix);
    }
}
