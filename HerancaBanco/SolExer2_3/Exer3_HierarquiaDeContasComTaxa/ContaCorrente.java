public abstract class ContaCorrente{
    private Integer nroConta;
    private String nomeCorrentista;
    private double saldo;
    private int contaOpDep;
    private int contaOpRet;

    public ContaCorrente(int nroConta, String nomeCorrentista, double saldo) {
        this.nroConta = nroConta;
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = saldo;
        this.contaOpDep = 0;
        this.contaOpRet = 0;
    }

    public abstract double custoTaxa();

    public int getNroConta() {
        return nroConta;
    }

    public int getContaOpDep(){
        return contaOpDep;
    }

    public void zeraContadores(){
        contaOpDep = 0;
        contaOpRet = 0;
    }

    public int getContaOpRet(){
        return contaOpRet;
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
            contaOpDep++;
            saldo += valor;
            return true;
        }
    }
    
    public boolean retirada(double valor){
        if (valor <= 0){
            return false;
        }else{
            contaOpRet++;
            saldo -= valor;
            return true;
        }
    }

    @Override
    public String toString() {
        return getClass().getName()+", nomeCorrentista=" + nomeCorrentista + 
                                    ", nroConta=" + nroConta + 
                                    ", saldo=" + saldo+"custo";
    }
}