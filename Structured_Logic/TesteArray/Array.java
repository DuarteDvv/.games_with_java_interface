package TesteArray;
import java.util.*;

public class Array{

    

    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int maximo = scan.nextInt();
        MyArray a = new MyArray(maximo);
    }
}

public class MyArray{
    int curent = 0;
    int max;
    int[] a;

    MyArray(int k){
        max = k;
        a = new int[k]
    }

    public boolean Add(int k){
        if(curent = max){
            return false;
        }
        else{
            a[curent] = k;
            curent++;
        }

    }

    public double media(){
        int soma = 0;
        int nElem;
        for(int n : a){
            nElem++;
            soma += n;
        }

        return soma/nElem;
    }
}