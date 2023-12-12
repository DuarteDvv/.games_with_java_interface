import java.util.Scanner;

package PrimoTeste;
class Primo{
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um numero");
        int a = scan.nextInt();

        if(a = 1){
            System.out.println("Não é primo");
            return 0;
        }
       
        for(int i = 1; i < a; ++i){
            if(a%i = 0){
                System.out.println("Não é primo");
                return 0;
            }
        }

        System.out.println("é primo");
    }
};
