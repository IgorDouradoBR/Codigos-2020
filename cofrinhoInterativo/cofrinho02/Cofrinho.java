package cofrinho02;
import java.util.Arrays;



public class Cofrinho{
    private int valor = 0;
    private int valorT = 0;
    private int quant = 0;
    private int [] quantCada= new int [6];
    private int [] vetor = new int[10];

    public Cofrinho( ){
        
        
    }


    public void setQuantCada(int valor){
        switch(valor){
            case 100: quantCada[5] += 1;
            break;
            case 50: quantCada[4] += 1;
            break;
            case 25: quantCada[3] += 1;
            break;
            case 10: quantCada[2] += 1;
            break;
            case 5: quantCada[1] += 1;
            break;
            case 1: quantCada[0] += 1;
            break;
        };

    }

    public int getRemover(int vetor[]){
        int ultiPos = 0;
        int nomeM = 0;
        for (int i=0; i<vetor.length; i++){           
            if(vetor[i]!=0){
                ultiPos = i;
            }
        }
        nomeM = vetor[ultiPos];
        if(nomeM==1){
            quantCada[0] -= 1;
        }
        if(nomeM==5){
            quantCada[1] -= 1;
        }
        if(nomeM==10){
            quantCada[2] -= 1;
        }
        if(nomeM==25){
            quantCada[3] -= 1;
        }
        if(nomeM==50){
            quantCada[4] -= 1;
        }
        if(nomeM==100){
            quantCada[5] -= 1;
        }
        vetor[ultiPos] = 0;
        if(ultiPos<=0){
            return -1;
        }
        else{return nomeM;}
        }

    

    public void setValor(int valor){
        for (int i=0; i<vetor.length; i++){
            if(vetor[i]==0){
            vetor[i] = valor;
            break;
            }
        }
    }


    public int getQuant(){
        return quant;
    }

    public int[] getValor(){
        return vetor;
    }
    public int getValorT(){
        return valorT;
    }

    public static void imprimir(int[] vetor)
    {
        for(int i=0; i<vetor.length; i++) {// dá o tamanho do vetor
            System.out.println(vetor[i]);
        }
    }

    public String getQuantCada(int indiv){
        int quantidade[] = new int[1];
        switch(indiv){
            case 100: quantidade[0] = quantCada[5];
            break;
            case 50: quantidade[0] = quantCada[4];
            break;
            case 25: quantidade[0] = quantCada[3];
            break;
            case 10: quantidade[0] = quantCada[2];
            break;
            case 5: quantidade[0] = quantCada[1];
            break;
            case 1: quantidade[0] = quantCada[0];
            break;

        }
        return Arrays.toString(quantidade);
    }

    

    public int getValorTotal(int[] vetor){
        
        int somaTotal = 0;
    
        for(int i=0; i<vetor.length; i++){
            somaTotal += vetor[i];
    
        }
        return somaTotal;
        }

        public int getQuantTotal(int[] vetor){        
            int quantT = 0;
            for(int i=0; i<vetor.length; i++){
                if(vetor[i] != 0){
                    quantT += 1;
                }
        
            }
            return quantT;
            }

        

    }
