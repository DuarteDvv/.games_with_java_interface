package TesteArray;
import java.util.*;

public class Array {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maximo = scan.nextInt();
        MyArray a = new MyArray(maximo);

        for (int i = 0; i < maximo; i++) {
            a.Add(scan.nextInt());
        }

        System.out.println(a.media());
        scan.close();
    }
}

class MyArray {
    int curent = 0;
    int max;
    int[] a;

    public MyArray(int k) {
        max = k;
        a = new int[k];
    }

    public boolean Add(int k) {
        if (curent == max) {
            return false;
        } else {
            a[curent] = k;
            curent++;
            return true;
        }
    }

    public double media() {
        int soma = 0;
        int nElem = 0;
        for (int n : a) {
            nElem++;
            soma += n;
        }

        if (nElem == 0) {
            return 0; // Evitar divisão por zero se o array estiver vazio
        }

        return (double) soma / nElem;
    }
}
