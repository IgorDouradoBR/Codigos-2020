
public class ContaRemunarada extends Conta {
    public ContaRemunarada(int nroConta, String nomeConta,double saldo){
        super(nroConta, nomeConta, saldo);
    }
    
    public void remunera(double valor){
        if(deposito(valor)==true){
            double deposita = getSaldo()+valor;
            double adicional = valor * 0.13;
            System.out.println("Adicional: "+ adicional);
            double defin = deposita + adicional;
            setSaldo(defin);            
        }
    }
}