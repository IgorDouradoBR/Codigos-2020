public class ContaComLimite extends Conta {
    double juros= 0;
    private final int LIMITESALDO= 600;
    public ContaComLimite(int nroConta, String nomeConta,double saldo){
        super(nroConta, nomeConta, saldo);
        System.out.println("\n Você pode sacar até 600 reais(auxilio corona pai)\n Se o valor de saque for maior que o saldo disponível na conta, terá uma taxa de juros de 25 reais"); 
    }
    @Override
    public boolean retirada(double valor){
        if(valor<=LIMITESALDO && getSaldo()-valor>=0){
            double retira= getSaldo()- valor;
            setSaldo(retira);
            return true;
        }
        else if(valor>getSaldo() && valor<=LIMITESALDO){
            setSaldo(getSaldo()-valor);
            juros+= 25;
            return true;
        }
        else{
            System.out.println("Valor acima de 600");
            return false;
        }
    }

    public double getJuros() {
        return juros;        
    }

    public void quitaJuros() {
        if(getSaldo()>0){
            juros = 0;
        }
        else{
            System.out.println("Sua conta ainda não possui saldo para ter os juros quitados");
        }
    }

    @Override
    public String toString() {
        String aux = super.toString();
        aux+= "\nJuros:" + getJuros();
        return aux;
    }

    
}