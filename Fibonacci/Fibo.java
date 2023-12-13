package Fibonacci;
import java.util.Scanner;


public class Fibo{


    private int fibonacci(int k){

        int first = 0, second = 1, result = 0;

        if (k == 0) {
            result = first;
        } 
        else if (k == 1) {
            result = second;
        } 
        else{
            for (int i = 2; i <= k; i++) {
                result = first + second;
                first = second;
                second = result;
            }
        }

        return result;


    }
    public static void main(String[] arg){
        Fibo F = new Fibo();
        try(Scanner scan = new Scanner(System.in)){
            int a = scan.nextInt();
            int result = F.fibonacci(a);
            System.out.println(result);
        }


        



       
    }
}

