import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class App{
    public static void main(String[] args){
        Catalogo cat = new Catalogo();
        List<Veiculo> aux = cat.getVeiculos();
        System.out.println("Veiculos não ordenados: ");
       for(int i=0;i<aux.size(); i++){
           System.out.println("Veiculo: "+ (i+1) + " / Ano: " + aux.get(i).getAno() + " / Marca: " + aux.get(i).getMarca() + " / Cor: " +aux.get(i).getCor());
       }
       Collections.sort(aux);
       System.out.println("\n Veiculos ordenados por ano:(Decrescente) ");
       for(int i=0;i<aux.size(); i++){
        System.out.println("Veiculo: "+ (i+1) + " / Ano: " + aux.get(i).getAno() + " / Marca: " + aux.get(i).getMarca() + " / Cor: " +aux.get(i).getCor());
    }

    }
}