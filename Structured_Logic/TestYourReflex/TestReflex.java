package TestYourReflex;

import java.lang.Math;
import java.util.Scanner;


public class TestReflex{
    public static void main(String[] a){
        Scanner scan = new Scanner(System.in);
        int time = (int)(Math.random()*61);
        int numero = (int)(Math.random()*10001);

        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Agora! " + numero);

        long start = System.nanoTime();
        while (true){
            int k = scan.nextInt();
            if(k == numero){
                break;
            }
            
        }

        long end = System.nanoTime();
        scan.close();
        long demora = (end - start)/1000000000;

        System.out.println("Voce demorou " + demora + "segundos");

    }
}
