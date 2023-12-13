package TestePermuta;
import java.util.Scanner;

public class Permutacao{
    private boolean isPermuta(int a, int b){ //Converter para string para facilitar ou usar divisão inteira e resto
        String A =  Integer.toString(a);
        String A =  Integer.toString(b);

        



    }


    public static void main(String[] us){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.close();

        if(isPermuta(a,b)){
            System.out.println("è permutação");
        }
        else{
            System.out.println("não é permutação")
        }

    }

}
