import java.util.Arrays;

class ZeroMatrix {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // 1. Check if the first row/column contain any zeros
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
            }
        }

        // 2. Use the first row and first column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. Zero out cells based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. Restore first row and first column if they originally contained zero
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        ZeroMatrix zeroMatrix = new ZeroMatrix();

        System.out.println("Original matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        zeroMatrix.setZeroes(matrix);

        System.out.println("\nUpdated matrix (set matrix zeroes):");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}