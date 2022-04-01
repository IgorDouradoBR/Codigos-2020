package cofrinhoExtra;
import java.util.Scanner;


public class App{

    public static void imprime(int[] vetor){ 
        for(int i=0; i<vetor.length; i++) {// dá o tamanho do vetor
            if(vetor[i] != 0){
                System.out.println((i+1)+ "º      ||    "+ vetor[i]);
            }
        }
    }

    
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        Cofrinho c = new Cofrinho();
        int limite =0;
        int excluidas= 0;
        boolean seguir = false;
        while(seguir == false ){
                            
                            System.out.println("digite 0 para parar, 1 para continuar a adicionar moedas no cofrinho ou 2 para retirar uma moeda: "); 
                            int opc= teclado.nextInt();
                            if(opc == 0){
                                seguir = true;
                            }
                            if(opc ==1){
                            boolean teste = false;
                            while(teste == false){
                                System.out.println("digite o valor da "+ (limite+1) +"ª moeda do cofrinho");
                                int v = teclado.nextInt();
                                switch(v){
                                    case 100: 
                                    c.setValor(100);                                                   
                                    c.setQuantCada(100);
                                    teste = true; 
                                    limite += 1;
                                    break;
                                    case 50: 
                                    c.setValor(50);                                                 
                                    c.setQuantCada(50);
                                    teste = true; 
                                    limite += 1;
                                    break;
                                    case 25: 
                                    c.setValor(25);                                                        
                                    c.setQuantCada(25);
                                    teste = true; 
                                    limite += 1;
                                    break;
                                    case 10: 
                                    c.setValor(10);                                                         
                                    c.setQuantCada(10);
                                    teste = true; 
                                    limite += 1;
                                    break;
                                    case 5: 
                                    c.setValor(5);                                                       
                                    c.setQuantCada(5);
                                    teste = true; 
                                    limite += 1;
                                    break;
                                    case 1: 
                                    c.setValor(1);                                                         
                                    c.setQuantCada(1);
                                    teste = true; 
                                    limite += 1;
                                    break;
                                }        
                        }
                    int valorT = c.getValorTotal(c.getValor());
                    double valorDouble = (double) valorT;
                    System.out.println("\n quantidade de moedas no cofrinho: "+ c.getQuantTotal(c.getValor())+ " Moedas" + "\n quantidade de moedas que ja foram informadas contados as excluídas: "+ (c.getQuantTotal(c.getValor())+excluidas)+ " Moedas"+ "\n valor total no cofrinho em reais: " + (valorDouble/100) + " R$");

                    }   
                        if(opc==2){
                            imprime(c.getValor());
                            System.out.println("Dada a sequênca cronologica das moedas adicionadas, digite o número da posicao correspodente à moeda que voce deseja retirar do cofrinho\n(Por exemplo: para retirar a 3ª moeda digite 3)");
                            int posicao = teclado.nextInt();
                            c.setRemover((posicao-1));
                            limite-= 1;
                            excluidas += 1;
                            int valorT = c.getValorTotal(c.getValor());
                            double valorDouble = (double) valorT;
                            System.out.println("\n quantidade de moedas no cofrinho: "+ c.getQuantTotal(c.getValor())+ " Moedas" + "\n quantidade de moedas que ja foram informadas contados as excluídas: "+ (c.getQuantTotal(c.getValor())+excluidas)+ " Moedas"+ "\n valor total no cofrinho em reais: " + (valorDouble/100) + " R$");

                        }                                                  
                        }//referente ao while
                    
                     
                    
                
                    
                    int valorT = c.getValorTotal(c.getValor());
                    double valorDouble = (double) valorT;
                
                    System.out.println("\n quantidade de moedas no cofrinho: "+ c.getQuantTotal(c.getValor())+ " Moedas" + "\n quantidade de moedas que ja foram informadas contados as excluídas: "+ (c.getQuantTotal(c.getValor())+excluidas)+ " Moedas"+ "\n valor total no cofrinho em reais: " + (valorDouble/100) + " R$\n fim de programa.");
                    

                        
                        
            } 
                       
        
        
    }


        









