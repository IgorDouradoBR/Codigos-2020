
public class Premium extends Executive{
    public Premium(String cpf, String nome, String assento, double custoPassagem){
        super(cpf, nome, assento, custoPassagem);        
    }
    @Override
    public double defineAssento(String numAssento){
        return 0;
    }

    @Override
    public double custoBagagem(int quant, int[] pesos){
        if(quant<=2 && quant>=0){
            return 0;
        }
        else{
            double cont=0;
            for(int i=0; i<quant; i++){
                cont+= pesos[i];
            }            
            return (cont/2)*0.5; 
        }
    }

    @Override
    public double getMilhas(){
        return getCustoPassagem()*0.2;
    }

    /*@Override
    public String toString() {
        String aux = "";
        aux += "Nome: "+ getNome()+"\n";
        aux += "CPF: "+getCpf()+"\n";
        aux += "Codigo do assento: "+getAssento()+"\n";
        aux += "Custo da passagem: "+getCustoPassagem()+"\n";
        aux += "Milhas adquiridas:  +"+getMilhas()+"\n";
        aux += "(+) Funcionário de area de risco"+ custoBagagem()+"\n";
        aux += "(-) IR: "+this.getImpRenda()+"\n";
        aux += "Salario liquido: "+this.getSalarioLiquido()+"\n";
        aux += "----------";
        return aux;  
    }
    */
    
}