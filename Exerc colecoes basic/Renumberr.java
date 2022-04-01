import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Renumberr {
    List<String> texto = new LinkedList<String>();


    public void imprimeVetor(String[] vetor)
    {   //imprime um vetor de inteiros
        System.out.print("\n");
        for(int i = 0; i<vetor.length;i++)
        {
            System.out.print("|"+vetor[i]);
        }
        System.out.print("|\n");

    }


    public void lerPrograma(String narq) {
        // ler arquivo
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+ narq;
        Path path = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
           while (sc.hasNext()){
               String linha = sc.nextLine();
               texto.add(linha);

           }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    ArrayList<String> renumera(int passo){
        ArrayList<String> linhaOriginal = new ArrayList<>();
        ArrayList<String> renumeroLinha = new ArrayList<>();
        ArrayList<String> gosub = new ArrayList<>();
        ArrayList<String> goTo = new ArrayList<>();
        ArrayList<String> textoFinal = new ArrayList<>();

        for(int i=0; i<texto.size(); i++){
            String[] splitar= texto.get(i).split(" ");
            linhaOriginal.add(splitar[0]);
            splitar[0] = ""+passo * (i+1);
            renumeroLinha.add(splitar[0]);
            for(int j=0; j<splitar.length; j++){
                char[] letras = null;
                String palavra = splitar[j];
                letras = palavra.toCharArray();
                if(letras[0]=='g' && letras[2]== 's'){
                    gosub.add(splitar[j+1]);
                }
                else if(letras[0]=='g' && letras[3]== 'o'){
                    goTo.add(splitar[j+1]);
                }
            }
        }

        

        for(int i=0; i<texto.size(); i++){
            String[] splitar= texto.get(i).split(" ");
            
            String aux = "";
            
            for(int j=1; j<splitar.length; j++){
                if(goTo.contains(splitar[j])){
                    
                    for(int z=0; z<renumeroLinha.size(); z++){
                        int index=linhaOriginal.indexOf(splitar[j]);
                        int n=index;
                                      
                        splitar[j]= renumeroLinha.get(n);
                        goTo.remove(splitar[j]);
                        break;
                    }
                    
                }
                else if(gosub.contains(splitar[j])){
                    int index=linhaOriginal.indexOf(splitar[j]);
                        int n=index;
                                      
                        splitar[j]= renumeroLinha.get(n);
                        gosub.remove(splitar[j]);
                        break;
                }
                
            }
            splitar[0] = ""+passo * (i+1);
            for(int j=0; j<splitar.length; j++){
                
                aux += splitar[j] + " ";
                
            }
            

            textoFinal.add(aux);
        }
        ArrayList<String> agoravai = new ArrayList<>(); 
        for(int x=0; x<textoFinal.size(); x++){
            agoravai.add(textoFinal.get(x)+ "\n");
        }
        System.out.println(agoravai.toString());
        return agoravai;
    }

    @Override
    public String toString() {
        return "Renumberr [texto=" + texto + "]";
    }
    
}