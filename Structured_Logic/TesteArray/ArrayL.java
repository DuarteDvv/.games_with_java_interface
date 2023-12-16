package TesteArray;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayL {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maximo = scan.nextInt();
        MyArrayList a = new MyArrayList();

        for (int i = 0; i < maximo; i++) {
            a.add(scan.nextInt());
        }

        System.out.println(a.media());
        scan.close();
    }
}

class MyArrayList {
    private ArrayList<Integer> list = new ArrayList<>();

    public void add(int element) {
        list.add(element);
    }

    public double media() {
        if (list.isEmpty()) {
            return 0; // Evitar divisão por zero se a lista estiver vazia
        }

        int soma = 0;
        for (int n : list) {
            soma += n;
        }

        return (double) soma / list.size();
    }
}
