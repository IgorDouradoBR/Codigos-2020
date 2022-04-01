import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class Agenda implements Iterable<ItemAgenda>{
    List<ItemAgenda> amigos;

    public Agenda() {
        amigos = new ArrayList<>(100);
    }

    public void add(ItemAgenda item) {
        amigos.add(item);
    }

    // TODO:
    public String getTelefone(String nome) {
        /*
        for(ItemAgenda it:amigos){
            if (it.getNome().equals(nome)){
                return it.getTelefone();
            }
        }
        */
        ListIterator<ItemAgenda> it = amigos.listIterator();
        while(it.hasNext()){
            ItemAgenda aux = it.next();
            if (aux.getNome().equals(nome)){
                return aux.getTelefone(); 
            }
        }
        return null;
    }

    @Override
    public Iterator<ItemAgenda> iterator() {
        return amigos.iterator();
    }
}