import java.util.ArrayList;
import java.util.List;

public class App {

    public void imprimeVetor(ArrayList<String> vetor)
    {   //imprime um vetor de inteiros
        System.out.print("\n");
        for(int i = 0; i<vetor.size();i++)
        {
            System.out.print("|"+vetor.get(i));
        }
        System.out.print("|\n");

    }
    public static void main(String[] args) {
        Renumberr ren = new Renumberr();
       
        ren.lerPrograma("Prog1.bas");
        System.out.println(ren.toString());
        ArrayList<List<String>> novo = new ArrayList<>();
        ren.renumera(10);
        System.out.println(ren.toString());

        
    }
}