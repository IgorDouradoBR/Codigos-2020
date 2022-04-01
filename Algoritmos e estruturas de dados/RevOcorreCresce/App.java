
import java.util.Random;



public class App {

    public static void imprimir(int[] vetor)
    {
        for(int i=0; i<vetor.length; i++) {// dá o tamanho do vetor
            System.out.print(vetor[i]+ " ");
        }
    }
    public static void main(String[] args) {
        ListArrayOfInteger lista = new ListArrayOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        lista.add(8);
        
        

        lista.reverse();
       
        System.out.println("Elemento armazenado na "
                + "segunda posicao da lista: " +lista.get(1));

        Integer a[] = lista.subList(3,6);
        for(Integer i : a)
            System.out.println(i);
    }
}
