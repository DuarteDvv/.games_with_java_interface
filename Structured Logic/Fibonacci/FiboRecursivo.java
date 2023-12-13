package Fibonacci;
import java.util.Scanner;


public class FiboRecursivo{

    private int Fibonacci(int k){
        if(k == 0){
            return 0; 
        }
        if(k == 1){
            return 1;
        }

        return Fibonacci(k-1) + Fibonacci(k-2);
    }

    public static void main(String[] k){
        FiboRecursivo F = new FiboRecursivo();
        try(Scanner scan = new Scanner(System.in)){
            int a = scan.nextInt();
            int result = F.Fibonacci(a);
            System.out.println(result);
        }

    }
}