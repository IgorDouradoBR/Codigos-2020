
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;


public class Leitura {

    
    public static void main(String[] args) {
        String linhas[] = new String[250000];
        int numLinhas = 0;
        int numPaginas = 1;
        ListArrayOfString stopw = new ListArrayOfString();//por conta do get O(1)
        ListArrayOfPalavra palavras = new ListArrayOfPalavra();
        ListArrayOfString paginaOcorrencia = new ListArrayOfString();//pagina em que ocorre
        DoubleLinkedListOfString stopcont= new DoubleLinkedListOfString();
        
        Path path1 = Paths.get("fiveweeksinaballoon.txt");// java.txt

        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+ "stopwords.txt";
        Path path = Paths.get(nameComplete);
            try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
            while (sc.hasNext()){
                String linha = sc.nextLine();
                String[] textoStopw = linha.split(" ");
                for(int i=0; i<textoStopw.length;i++){
                    stopw.add(textoStopw[i]);//lê as stopwords
                }

            }
            }catch (IOException x){
                System.err.format("Erro de E/S: %s%n", x);
            }

            

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                linhas[numLinhas] = line;
                paginaOcorrencia.add(numLinhas/40, line+"\n");
                String[] splitar = linhas[numLinhas].split("[ \",._;:?!-=*()]");
                
                for(int i=0; i<splitar.length;i++){
                    String palavraMinuscula = splitar[i].toLowerCase();
                    if(stopw.contains(palavraMinuscula)){
                        if(!stopcont.contains(palavraMinuscula)){
                            stopcont.add(palavraMinuscula);
                        }
                    }
                    else{
                        Palavra aux = new Palavra(palavraMinuscula, numPaginas);
                        if(palavras.containsString(aux)==false ){
                            if(palavraMinuscula.length()>1){
                                palavras.add(aux);
                            }
                        }
                        else{
                            int indexAux = 0;
                            for(int j=0; j<palavras.size();j++){
                                if(aux.getPalavra().equals(palavras.get(j).getPalavra())){
                                    indexAux= j;
                                }
                            }
                            
                            palavras.get(indexAux).adicionaPag(numPaginas);
                                              
                            palavras.get(indexAux).setNumeroOcorrencias();
                            
                        }
                        
                    }
                }

                numLinhas++;
                if (numLinhas % 40 == 0) {
                    numPaginas++;
                }
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);//O teclado 1 nao tava lendo o item 4    
            
            

            
            while(true){
                System.out.println("\n Digite o número da opção que você deseja entre: \n[1] Para exibir o índice remissivo de cada palavra(exceto as stopworlds) do texto\n[2] Para exibir o percentual de stopwords do texto (quanto % do texto é formado por stopwords \n[3] Para exibir qual a palavra que mais aparece durante o texto \n[4] Nessa opção você deve digitar uma palavra, se a palavra estiver presente no texto, o sistema lista os números das páginas em que a palavra ocorre. Após isso, digite o número da página(entre as quais aparecer) que ocorre a palavra e que você quer exibir na tela\n[0] Para sair do programa");
                Integer opcao= teclado.nextInt();
                switch(opcao){
                    case 1:
                        Palavra[] emVetor = new Palavra[palavras.size()];
                        for(int i=0; i<palavras.size(); i++){
                            emVetor[i] = palavras.get(i);
                        }
                        for(int i=0; i<emVetor.length; i++){
                            for(int j=0; j<emVetor.length;j++){
                                if((emVetor[i].getPalavra().compareTo(emVetor[j].getPalavra())<0)){
                                    Palavra auxiliar= emVetor[i];
                                    emVetor[i]= emVetor[j];
                                    emVetor[j]= auxiliar;
                                }
                            }
                        }
                        for(int i = 0; i<emVetor.length;i++)
                        {
                            System.out.print(emVetor[i].getPalavra()+ " "+ emVetor[i].getPaginasOcorre().toString()+ "\n");
                        }
                        break;
                    case 2: 
                        System.out.println("porcetagem de palavras 'stopwords' presentes entre as palavras do texto: " + (stopcont.size()/(palavras.size()+stopcont.size()))*100+"%");
                        break;
                    case 3:
                        int maisOcorrencia=0;
                        String palavMaisComum = "";
                        for(int i=0; i<palavras.size(); i++){
                                int verificaRec = palavras.get(i).getNumeroOcorrencias();
                                if(verificaRec>maisOcorrencia){
                                    maisOcorrencia= verificaRec;
                                    palavMaisComum= palavras.get(i).getPalavra();
                                }
                            }
                        System.out.println("Palavra mais comum no texto: " + palavMaisComum);
                        break;
                    case 4:
                        
                        System.out.println("Digite a palavra que você quer saber: ");
                        String palavra= teclado2.nextLine();
                        for(int i=0; i<palavras.size(); i++){
                            if(palavras.get(i).getPalavra().equals(palavra.toLowerCase())){
                                ListArrayOfInteger exibePaginas = palavras.get(i).getPaginasOcorre();
                                System.out.println("Paginas que contêm a palavra "+ palavra + ": "+ exibePaginas.toString()+ "\n qual o número da página você quer exibir?");
                                Integer qualPagina = teclado.nextInt();
                                if(exibePaginas.contains(qualPagina)){
                                    
                                    System.out.println(paginaOcorrencia.get(qualPagina-1).toString());
                                    break;
                                                                  
                                }
                            }
                            if(i==palavras.size()-1){
                                System.out.println("Palavra não encontrada no texto");
                            }
                        }
                        
                        break;
                        
                    case 0: 
                        break;
                        
                    default:
                    System.out.println("opção inválida, digite uma das 4 opções presentes");
                        break;
                }
                if(opcao==0){
                    break;
                }

            }

        }
    }

