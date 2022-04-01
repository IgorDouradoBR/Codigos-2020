package cofrinho02;
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
        
        int limite = 0;
        while(limite<10 ){
            
                        
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
                    
                                                                                  
                        }//referente ao while
                    
                     
                    
                
                    int valorT = c.getValorTotal(c.getValor());
                    double valorDouble = (double) valorT;
                    
                
                    System.out.println("\n1- quantidade de moedas no cofrinho: "+ c.getQuantTotal(c.getValor())+ " Moedas");
                    
                    System.out.println("\n2- quantidade de moedas de 1 real: " + c.getQuantCada(100));
                     
                    System.out.println("\n3- quantidade de moedas de 50 centavos: " + c.getQuantCada(50));


                    System.out.println("\n4- valor total no cofrinho em centavos: " + c.getValorTotal(c.getValor()) + " centavos");
                    System.out.println("\n5- valor total no cofrinho em reais: " + (valorDouble/100) + " R$");

                
                    
                    
                    c.getRemover(c.getValor());

                    c.getRemover(c.getValor());

                    System.out.println("\n4- valor restante no cofrinho em centavos após a retirada das 2 ultimas moedas depositadas: " + c.getValorTotal(c.getValor()) + " centavos");

                        
                        
            } 
                       
        
        
    }


        









