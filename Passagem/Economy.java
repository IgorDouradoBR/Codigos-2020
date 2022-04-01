
public class Economy extends Passagem{
    public Economy(String cpf, String nome, String assento, double custoPassagem){
        super(cpf, nome, assento, custoPassagem);
        
    }

    @Override
    public double custoBagagem(int quant, int[] pesos){
        double cont=0;
        for(int i=0; i<quant; i++){
            cont+= pesos[i];
        }
        double contDepois= cont/2;
        double adicional = quant * 10;
        return contDepois+adicional;       
    }    

}