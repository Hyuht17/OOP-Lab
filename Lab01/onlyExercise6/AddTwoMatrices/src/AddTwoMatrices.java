import java.util.Scanner;

public class AddTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrices 1 (m x n): \n"
        + "Input m1: ");
        int m1 = sc.nextInt();

        System.out.println("Enter size of matrices 1 (m x n): \n"
        + "Input n1: ");
        int n1 = sc.nextInt();

        System.out.println("Input matrix 1: ");
        int[][] matrix1 = new int[m1][n1];

        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter size of matrices 2 (m x n): \n"
                + "Input m2: ");
        int m2 = sc.nextInt();

        System.out.println("Enter size of matrices 2 (m x n): \n"
                + "Input n2: ");
        int n2 = sc.nextInt();

        System.out.println("Input matrix 2: ");
        int[][] matrix2 = new int[m2][n2];

        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        if (m1 != m2 || n1 != n2) {
            System.out.println("Error: Matrices must have the same size.");
        }else{
             int[][] resultMatix = new int[m1][n1];

             for ( int i = 0; i < m1; i++) {
                 for ( int j = 0; j < n1; j++) {
                     resultMatix[i][j] = matrix1[i][j] + matrix2[i][j];
                 }
             }

             System.out.println("Result: ");
             for ( int i = 0; i < m1; i++) {
                 for ( int j = 0; j < n1; j++) {
                     System.out.print(resultMatix[i][j] + " ");
                 }
                 System.out.println();
             }
        }
    }
}