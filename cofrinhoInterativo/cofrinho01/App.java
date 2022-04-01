package cofrinho01;
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
        int cont = 0;
        Scanner teclado = new Scanner(System.in);
        Cofrinho c = new Cofrinho();
        
        boolean opcao = false;
        while(opcao==false ){
            System.out.println("[0] para sair\n[1] para adicionar moeda\n[2] remove ultima\n[3] quantidade total de moedas\n[4] quantidade de cada uma \n[5] valor que tem no cofrinho em reais \n[6] valor que tem no cofrinho em centavos \n Digite o numero do que voce deseja:  ");
            int opc = teclado.nextInt();
            if(opc==0){
                opcao= true;
            }
            switch(opc){
                
                case 1:
                    
                        System.out.println("digite o numero da quantidade de moedas que quer depositar no cofrinho nesse momento: ");
                        int quant = teclado.nextInt();
                        for(int i=0; i<quant; i++){
                            boolean teste = false;
                            while(teste == false){
                                System.out.println("digite o valor da " + (i+1) + "ª moeda que deseja adicionar: \n  (Por exemplo: 25 centavos = 25 ou 1 real = 100 )");
                                int v = teclado.nextInt();
                                switch(v){
                                    case 100: 
                                    c.setValor(100);                                                   
                                    c.setQuantCada(100);
                                    teste = true;
                                    break;
                                    case 50: 
                                    c.setValor(50);                                                 
                                    c.setQuantCada(50);
                                    teste = true;
                                    break;
                                    case 25: 
                                    c.setValor(25);                                                        
                                    c.setQuantCada(25);
                                    teste = true;
                                    break;
                                    case 10: 
                                    c.setValor(10);                                                         
                                    c.setQuantCada(10);
                                    teste = true;
                                    break;
                                    case 5: 
                                    c.setValor(5);                                                       
                                    c.setQuantCada(5);
                                    teste = true;
                                    break;
                                    case 1: 
                                    c.setValor(1);                                                         
                                    c.setQuantCada(1);
                                    teste = true;
                                    break;
                                }        
                        }
                    
                                                                                  
                        }//referente ao while
                    break;
                case 2: 
                    System.out.println("moeda removida: " + c.getRemover(c.getValor())+ "centavos");
                    break;
                case 5:
                    int valorT = c.getValorTotal(c.getValor());
                    double valorDouble = (double) valorT;
                    System.out.println("valor total no cofrinho em reais: " + (valorDouble/100) + " R$");
                    break;
                case 3:
                    System.out.println("quantidade de moedas no cofrinho: "+ c.getQuantTotal(c.getValor())+ " Moedas");
                    break;
                case 6:                    
                    System.out.println("valor total no cofrinho em centavos: " + c.getValorTotal(c.getValor()) + " centavos");
                    break;
                case 4:
                    System.out.println("quantidade de moedas de cada valor no cofrinho: " );
                    System.out.println("moedas de 1 real: " + c.getQuantCada(100));
                    System.out.println("moedas de 50 centavos : " + c.getQuantCada(50));
                    System.out.println("moedas de 25 centavos : " + c.getQuantCada(25));
                    System.out.println("moedas de 10 centavos : " + c.getQuantCada(10));
                    System.out.println("moedas de 5 centavos : " + c.getQuantCada(5));
                    System.out.println("moedas de 1 centavo : " + c.getQuantCada(1));
                    break;


                        
                        
            } 
        }               
        imprime(c.getValor());
        
        
    }
}

        









