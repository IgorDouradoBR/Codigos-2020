
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LinkedList<Palavra> lista = new LinkedList<>();

        String aux[];

        Path path1 = Paths.get("nomes.csv");

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                aux = line.split(";");
                Palavra p = new Palavra(aux[0], aux[1]);
                lista.add(p);
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }

        WordTree nova = new WordTree();
        for (int i = 0; i < lista.size(); i++) {
            nova.addPalav(lista.get(i).getPalavra(), lista.get(i).getSignificado());
        }

        while (true) {
            Scanner teclado = new Scanner(System.in);
            Scanner teclado2 = new Scanner(System.in);
            System.out.println("\nDigite 1 para iniciar ou continuar a busca ou 0 para sair do programa");
            int opcao = teclado.nextInt();
            if (opcao == 0) {
                break;
            } else {
                System.out.println(
                        "Digite um conjunto de caracteres (é contabilizado a partir de 2 caracteres) para saber quais nomes começam por eles: ");
                String caract = teclado2.nextLine();
                while(caract.length()<2){
                    System.out.println("Digite uma sequência que possua no minímo 2 caracteres: ");
                    caract = teclado2.nextLine();
                }
                caract = caract.substring(0, 1).toUpperCase().concat(caract.substring(1));
                List<String> auxil = nova.buscaGeral(caract);
                if(auxil==null){
                    System.out.println("\n ----não foi encontrado nenhum nome que começe com esses caracteres---- ");
                }
                else if (auxil.size() != 0) {
                    for (int i = 0; i < auxil.size(); i++) {
                        System.out.println("Nome " + (i + 1) + ": " + auxil.get(i));
                    }
                    System.out.println("Digite qual o NÚMERO do nome que você deseja saber o signifado");
                    int numeroNome = teclado.nextInt();

                    while (numeroNome <= 0 || numeroNome > auxil.size()) {
                        System.out.println("Digite um NÚMERO que esteja entre as opções:");
                        numeroNome = teclado.nextInt();
                    }
                    System.out.println("Significado do nome " + auxil.get(numeroNome - 1) + " -> "
                            + nova.getSignificado(auxil.get(numeroNome - 1)));

                } 
            }

        }

    }

}
