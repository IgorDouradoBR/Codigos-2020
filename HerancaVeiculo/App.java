import java.util.ArrayList;
public class App {

    public static void main(String args[]) {

        ArrayList<Veiculo> lst = new ArrayList<>();

 

        lst.add(new Carro("ABC1D23","123456789",2015,"GM","ONIX"));

        lst.add(new Esportivo("EFG4H56","123456789",2017,"GM","CORVETTE",220));

        lst.add(new Passeio("IJK7L89","123456789",2020,"HONDA","CIVIC",5));

        lst.add(new Utilitario("MNO1P23","876543210",2012,10000));

 

        for(Veiculo v:lst){

            System.out.println(v);

        }

    }

}