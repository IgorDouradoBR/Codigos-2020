
public class Executive extends Passagem{
    public Executive(String cpf, String nome, String assento, double custoPassagem){
        super(cpf, nome, assento, custoPassagem);
        
    }

    public double getMilhas(){
        return getCustoPassagem()*0.1;
    }

    @Override
    public double custoBagagem(int quant, int[]pesos){
        if(quant<=2 && quant>=0){
            return 0;
        }
        else{
            double cont=0;
            for(int i=0; i<quant; i++){
                cont+= pesos[i];
            }            
            return cont/2; 
        }
    }
}