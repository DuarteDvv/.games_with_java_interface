import java.util.Scanner;
package Fibonacci;

public class FiboRecursivo{

    private int Fibonacci(int k){
        if(k == 0){
            return 1; 
        }
        if(k == 1){
            return 1;
        }

        return Fibonacci(k-1) + Fibonacci(k-2);
    }

    public static void main(String[] arg){
        FiboRecursivo F = new FiboRecursivo();
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int result = FiboRecursivo.Fibonacci(a);
        System.out.println(result);

    }
}