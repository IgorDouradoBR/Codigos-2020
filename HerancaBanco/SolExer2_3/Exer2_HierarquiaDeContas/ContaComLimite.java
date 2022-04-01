public class ContaComLimite extends ContaCorrente {
    public static final double taxaJuros = 0.05;
    private double limite;
    private double jurosDivida;

    public ContaComLimite(int nroConta, String nomeCorrentista, double saldo, double limite) {
        super(nroConta, nomeCorrentista, saldo);
        this.limite = limite;
        this.jurosDivida = 0.0;
    }

    public double getLimite() {
        return limite;
    }

    public double getJurosDivida() {
        return jurosDivida;
    }

    @Override
    public boolean retirada(double valor) {
        double limNeg = -1.0 * limite;
        double novoSaldo = getSaldo() - valor;

        if (novoSaldo < limNeg) {
            return false;
        } else if (novoSaldo > 0.0) {
            return(super.retirada(valor));
        } else {
            double juros = Math.abs(novoSaldo * taxaJuros);
            jurosDivida += juros;
            return(super.retirada(valor));
        }
    }

    public boolean quitaJuros(){
        if (getSaldo() >= jurosDivida){
            super.retirada(jurosDivida);
            jurosDivida = 0;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return super.toString()+
               ", limite="+limite+
               ", jurosDivida:"+jurosDivida;
    }
}