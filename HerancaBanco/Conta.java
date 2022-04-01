public class Conta{
    private int nroConta=0;
    private String nomeConta="";
    private double saldo=0;
    private boolean deposito= false;
    private boolean retirada= false;
    private int LIMITE= 5000;
    public Conta(int nroConta, String nomeConta,double saldo){
        this.nomeConta=nomeConta;
        this.nroConta= nroConta;
        this.saldo= saldo;
    }

    public int getNroConta() {
        return nroConta;
    }

    public void setNroConta(int nroConta) {
        this.nroConta = nroConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getDeposito() {
        return deposito;
    }

    public boolean deposito(double valor) {
        if(getSaldo()+valor<=LIMITE){ 
            double deposita = getSaldo()+valor;
            setSaldo(deposita);          
            return true;
        }
        else{
            return false;
        }
    }

    public boolean retirada(double valor) {
        if(getSaldo()- valor>= 0){
            double retira= getSaldo()- valor;
            setSaldo(retira);
            return true;
        }
        else{
            return false;
        }
    }

    public void setRetirada(boolean retirada) {
        this.retirada = retirada;
    }

    @Override
    public String toString() {
        String aux= "";
        aux+= "\nNome da conta=" + nomeConta;
        aux+= "\nNúmero da conta=" + nroConta; 
        aux+= "\nSaldo=" + saldo;
        return aux;
    }
    
}