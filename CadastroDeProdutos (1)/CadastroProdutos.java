import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.PrintWriter;

public class CadastroProdutos{
    private static final int MAXPROD = 1000;
    private Produto[] produtos;
    private int contProd;
    private static final String fName = "produtos.txt";

    public CadastroProdutos(){
        produtos = new Produto[MAXPROD];
        contProd = 0;
    }

    public void carregaProdutos(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+fName;
        Path path = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
           while (sc.hasNext()){
               String linha = sc.nextLine();
               String dados[] = linha.split(";");
               int codigo = Integer.parseInt(dados[0]);
               String descricao = dados[1];
               double preco = Double.parseDouble(dados[2]);
               Produto p = new Produto(codigo,descricao,preco);
               produtos[contProd] = p;
               contProd++;
           }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public void gravaProdutos(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+fName;
        Path path = Paths.get(nameComplete);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
          for(int i=0;i<contProd;i++){
                String linha = produtos[i].getCodigo()+";"+
                               produtos[i].getDescricao()+";"+
                               produtos[i].getPrecoUnitario();
                writer.println(linha);
            }
        }catch (IOException x){
          System.err.format("Erro de E/S: %s%n", x);
      }
    }

    public void inflacionaProdutos(){
        for(int i=0;i<contProd;i++){
            double novoValor = produtos[i].getPrecoUnitario() * 1.1;
            produtos[i].setPrecoUnitario(novoValor);
        }
    }

    public String toString(){
        String str = "";
        for(int i=0;i<contProd;i++){
            str = str + produtos[i]+"\n";
        }
        return str;
    }
}
