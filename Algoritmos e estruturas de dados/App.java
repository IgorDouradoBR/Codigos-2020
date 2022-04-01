
import java.util.Random;


public class App {
    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        
        System.out.println(lista);
       
        System.out.println("Elemento armazenado na "
                + "segunda posicao da lista: " +lista.get(1));

        System.out.println("Elemento armazenado na "
                + "ultima posicao da lista: " +lista.get(lista.size()-1)); 
        
        System.out.println("Lista contem 8?"+lista.contains(8));
        System.out.println("Lista contem 44?"+lista.contains(44));
        
        lista.remove(2);
        lista.remove(12);
        lista.remove(8);
        lista.remove(9);
        System.out.println(lista);
 
        LinkedListOfInteger l2 = new LinkedListOfInteger();
        l2.add(0,11);
        l2.add(0,1);
        l2.add(2,22);
        l2.add(0,-11);
        l2.add(1,6);
        l2.add(33);
        l2.add(44);
        System.out.println(l2);
        
        Integer a[] = l2.subList(1, 5);
        
        for(Integer i : a)
            System.out.println(i);        
    }
}
