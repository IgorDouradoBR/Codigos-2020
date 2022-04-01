package Codigos;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.PrintWriter;

public class Menu {
    public void menu(){

        Scanner teclado = new Scanner(System.in);
        Garagem garagem = new Garagem();
        garagem.loadLocomotivas();
        garagem.loadVagoes();
        EditorDeComposicao edit = new EditorDeComposicao();
        while(true){
            
            System.out.println("Digite a opção que você deseja? \n[1] Criar uma nova composição(trem)\n[2] Editar uma composição\n[3] Ver todas composições editadas\n[4] Desfazer uma composição\n[0] Fim do programa gerando arquivos texto da situação das classes");
            int opcao= teclado.nextInt();

            switch(opcao) {
                case 1:
                    System.out.println("Digite o codigo identificador que receberá essa composição: ");
                    int identificador= teclado.nextInt();
                    System.out.println(garagem.listarLocomotivas());
                    System.out.println("Digite o código de qual das locomotivas você deseja para encabeçar a composição");
                    Locomotiva l= (Locomotiva) garagem.getCarro(teclado.nextInt());
                    Composicao c = new Composicao(identificador, l);
                    edit.composicoes.add(c);
                    break;
                case 2: 
                    System.out.println(edit.listarComposicoes());
                    System.out.println("Digite o código de qual composição voce deseja editar");
                    int codigoComp = teclado.nextInt();
                    
                    if(edit.verificaCodigo(codigoComp)== true){
                
                        while(true){
                            System.out.println("Composição a ser editada: "+ edit.getComp(codigoComp).toString());
                            System.out.println("Digite a operação que você deseja realizar nessa composicão: \n[1] Listar locomotivas livres \n[2] Listar vagões livres \n[3] Inserir uma locomotiva (informar identificador) respeitando restrições \n[4] Inserir um vagão (informar identificador) respeitando restrições \n[5] Remover o último elemento da composição \n[0] Encerrar a edição da composição");
                            int opc = teclado.nextInt();
                            switch(opc){
                                case 1:
                                    System.out.println("Locomotivas ainda disponíveis: "+ garagem.listarLocomotivas());
                                    break;
                                case 2:
                                    System.out.println("Vagões ainda disponíveis: "+ garagem.listarVagoes());
                                    break;

                                case 3:
                                    System.out.println("*OBS: se já tiver adicionado um vagão na composição, não é possível adicionar uma nova locomotiva, apenas se excluir todos os vagões contidos na composição \nDigite o código da locomotiva que você deseja adicionar a composição: ");
                                    int codigoLoc= teclado.nextInt();
                                    if(garagem.temEmLocom(codigoLoc)==true){
                                        edit.getComp(codigoComp).addCarro(garagem.getCarro(codigoLoc));
                                    }
                                    break;
                                case 4:
                                    System.out.println("*OBS: Após adicionar um vagão não será mais possível adicionar uma nova locomotiva, apenas se excluir todos os vagões contidos na composição \nDigite o código do vagão que você deseja adicionar a composição: ");
                                    int codigoVagao= teclado.nextInt();
                                    if(garagem.temEmVagoes(codigoVagao)==true){
                                        edit.getComp(codigoComp).addCarro(garagem.getCarro(codigoVagao));
                                    }
                                    break;
                                case 5:
                                    if(edit.getComp(codigoComp).getSize()==1){
                                        System.out.println("Não é possível remover a primeira locomotiva da composição, para isso, realize a operação de excluir a composição");
                                    }
                                    else if(edit.getComp(codigoComp).getSize()!=1){
                                        garagem.addCarro(edit.getComp(codigoComp).ultimoCarro());
                                        edit.getComp(codigoComp).remover();
                                    }
                                    break;
                                case 0:
                                    if(!(edit.composicoesEditadas.contains(edit.getComp(codigoComp)))){
                                        edit.composicoesEditadas.add(edit.getComp(codigoComp));
                                    }
                                    System.out.println("Fim da ediçao da composição");
                                    break;

                                default:
                                    System.out.println("opção inválida");
                                    break;
                            }
                            if(opc==0 ){
                                break;
                            }
                            
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite [1] se quiser ver todas as composicoes ou [2] se quiser ver somente as composições editadas por ordem de edição");
                    int opcaoDeComp = teclado.nextInt();
                    if(opcaoDeComp==1){
                        System.out.println("Todas as composições criadas: ");
                        for(Composicao compos: edit.composicoes){
                            System.out.println(compos.toString());
                        }                        
                    }
                    if(opcaoDeComp==2){
                        System.out.println("Composições que já foram editadas: ");
                        for(Composicao compos: edit.composicoesEditadas){
                            System.out.println(compos.toString());
                        } 
                    }
                    break;
                case 4:
                    System.out.println(edit.listarComposicoes());
                    System.out.println("Digite a codigo da composição que deseja excluir: ");
                    int codigoDeRemocao = teclado.nextInt();
                    for(int i=0; i<edit.getComp(codigoDeRemocao).getSize(); i++){
                        garagem.addCarro(edit.getComp(codigoDeRemocao).carroPorIndex(i));
                    }
                    edit.removerPorCodigo(codigoDeRemocao);
                    edit.removerPorCodigoEditadas(codigoDeRemocao);
                                      
                    break;
                case 0:
                
                    String currDir = Paths.get("").toAbsolutePath().toString();
                    String nameComplete = currDir+"\\"+"VagoesLivresFinal.txt";
                    Path path = Paths.get(nameComplete);
                    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
                      
                            String linha = garagem.listarVagoes();
                                           
                            writer.println(linha);
                        
                    }catch (IOException x){
                      System.err.format("Erro de E/S: %s%n", x);
                  }
                    String currDi = Paths.get("").toAbsolutePath().toString();
                    String nameComplet = currDi+"\\"+"LocomotivasLivresFinal.txt";
                    Path pat = Paths.get(nameComplet);
                    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(pat, StandardCharsets.UTF_8))){
                      
                            String linha = garagem.listarLocomotivas();
                                           
                            writer.println(linha);
                        
                    }catch (IOException x){
                      System.err.format("Erro de E/S: %s%n", x);
                  }
                    String currD = Paths.get("").toAbsolutePath().toString();
                    String nameComple = currD+"\\"+"ComposicoesFeitaseMantidasNoFinal.txt";
                    Path pa = Paths.get(nameComple);
                    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(pa, StandardCharsets.UTF_8))){
                      
                            String linha = edit.listarComposicoes();
                                           
                            writer.println(linha);
                        
                    }catch (IOException x){
                      System.err.format("Erro de E/S: %s%n", x);
                  }
                
                    System.out.println("Fim de programa");
                    break;
                default:
                    System.out.println("opção inválida");
                break;
            }
            if(opcao==0){
                break;
            }
        }

    }
}