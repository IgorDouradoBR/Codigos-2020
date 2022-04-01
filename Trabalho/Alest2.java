import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Alest2 {
    public static void main(String[] args){

        List<Integer> numeros = new ArrayList<Integer>();

        Path path1 = Paths.get("v1.txt");// java.txt
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+ "v6";
        Path path = Paths.get(nameComplete);
            try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
            while (sc.hasNext()){
                Integer linha = sc.nextInt();
                numeros.add(linha);//lê as stopwords      
            }
            }catch (IOException x){
                System.err.format("Erro de E/S: %s%n", x);
            }
        

        Set<Integer> numRepetidos= new HashSet<Integer>();// numero repetidos
        long tempoInicial = System.currentTimeMillis();
        for(int i=numeros.size() - 1; i>=0; i--){
            int aux = numeros.remove(i);
            if(numeros.contains(aux)){
                numRepetidos.add(aux);
            }
        }

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Numeros repetidos -> "+ numRepetidos.toString());
        System.out.println("Tempo gasto -> "+ (tempoFinal- tempoInicial));

}
}