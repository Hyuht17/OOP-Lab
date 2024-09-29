import java.util.Scanner;

public class SortandSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input n: ");
        int n = scanner.nextInt();
        int a[] = new int[n], sum = 0;
        for (int i = 0; i < n; i++ ){
            a[i] = scanner.nextInt();
            sum = sum + a[i];
        }

        for (int i = 0; i < n; i++) {
            for ( int j = i + 1; j < n; j++){
                if ( a[i] > a[j] ){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        double average = (double) sum / n;
        System.out.println("Sum = " + sum + " Average = " + average );

        for ( int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        scanner.close();
    }
}
