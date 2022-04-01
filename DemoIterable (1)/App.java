import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class App {
    public static void main(String args[]){
        
        Agenda a = new Agenda();

        a.add(new ItemAgenda("Zezinho","94763221"));
        a.add(new ItemAgenda("Fulano","94763221"));
        a.add(new ItemAgenda("Sicrano","94763221"));

        for(ItemAgenda i:a){
            System.out.println(i);
        }
        
    /*
        List<String> nomes = new LinkedList<>();
        //List<String> nomes = new ArrayList<>();

        nomes.add("A");
        nomes.add("B");
        nomes.add("C");
        nomes.add("D");

        ListIterator<String> it = nomes.listIterator();
        while(it.hasNext()){
            String aux = it.next();
            System.out.println(aux);
            if (aux.equals("B")){
                it.remove();
            }
            if (aux.equals("C")){
                it.set("c");
                it.add("X");
            }
        }
        System.out.println("");

        for(String nome:nomes){
            System.out.println(nome);
        }
        */
    }

}