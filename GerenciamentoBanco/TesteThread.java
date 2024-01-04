import java.lang.*

class GerarPdf implements Runnable{
    public void run() {

    }

}

class Barra implements Runnable{
    public void run(){

    }
}

public class TesteThread {
    public static void main(String[] args){
        Runnable Principal = () -> { // só funciona pq tem apenas um método abstrato definido na interface

        };

        Thread a = new Thread(Principal);
        a.start();

        // melhor forma 

        Runnable Principal2 = new Runnable() { // classe anonima pode implementar uma interface
            public void run(){

            }

        };

        Thread b = new Thread(Principal2);
        b.start();

    }


}
