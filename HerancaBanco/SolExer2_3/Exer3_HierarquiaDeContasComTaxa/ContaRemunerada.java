
public class ContaRemunerada extends ContaCorrente{
    public static final double REMUNERACAO = 1.02;

    public ContaRemunerada(int nroConta, String nomeCorrentista, double saldo) {
        super(nroConta, nomeCorrentista, saldo);
    }

    @Override
    public boolean deposito(double valor) {
        double valorRemunerado = valor*REMUNERACAO;
        return(super.deposito(valorRemunerado));
    }

    @Override
    public boolean retirada(double valor) {
        if ((getSaldo() - valor) < 0.0){
            return false;
        }else{
            return super.retirada(valor);
        }
    }

    @Override
    public double custoTaxa() {
        double custo = 0.01 * (getContaOpDep()+getContaOpRet());
        zeraContadores();
        return custo;
    }
}