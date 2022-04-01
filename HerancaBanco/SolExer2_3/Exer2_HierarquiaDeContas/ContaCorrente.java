public abstract class ContaCorrente{
    private Integer nroConta;
    private String nomeCorrentista;
    private double saldo;

    public ContaCorrente(int nroConta, String nomeCorrentista, double saldo) {
        this.nroConta = nroConta;
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = saldo;
    }

    public int getNroConta() {
        return nroConta;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public boolean deposito(double valor){
        if (valor <= 0){
            return false;
        }else{
            saldo += valor;
            return true;
        }
    }
    
    public boolean retirada(double valor){
        if (valor <= 0){
            return false;
        }else{
            saldo -= valor;
            return true;
        }
    }

    @Override
    public String toString() {
        return getClass().getName()+", nomeCorrentista=" + nomeCorrentista + 
                                    ", nroConta=" + nroConta + 
                                    ", saldo=" + saldo;
    }
}