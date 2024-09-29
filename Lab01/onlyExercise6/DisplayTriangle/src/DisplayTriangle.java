import java.util.Scanner;

public class DisplayTriangle {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int n;
        do {
            System.out.print("Input n: ");
            n = keyboard.nextInt();
        }while(n <= 0);
        for ( int i = n - 1; i >= 0; i--){
            for ( int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for ( int j = 0; j < 2 * (n - i) - 1; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
