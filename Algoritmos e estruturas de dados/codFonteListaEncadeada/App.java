
import java.util.Random;


public class App {

    public static void imprimir(Integer[] vetor)
    {
        for(int i=0; i<vetor.length; i++) {// dá o tamanho do vetor
            System.out.println(vetor[i]);
        }
    }

    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        
        imprimir(lista.sublist(0, 2));
        System.out.println("...\n"+lista.removeByIndex(5));
        System.out.println("...\n" + lista);
 
        
        
    }
}
