import java.util.ArrayList;

public class CadastroAgencia {
    private ArrayList<ContaCorrente> contas;

    public CadastroAgencia() {
        this.contas = new ArrayList<>();

        contas.add(new ContaRemunerada(10,"Irmão do Ze",1000));
        contas.add(new ContaComLimite(30,"Prima do Ze",5000,8000));
        contas.add(new ContaRemunerada(20,"Tio do Ze",500));
        contas.add(new ContaComLimite(15,"Irmã do Ze",10000,5000));
    }

    public ContaCorrente getConta(int numero){
        for(ContaCorrente c:contas){
            if (c.getNroConta() == numero){
                return c;
            }
        }
        return null;
    }

    public String toString(){
        StringBuilder aux = new StringBuilder("Inventário das contas:\n");
        for(ContaCorrente conta:contas){
            aux.append(conta+"\n");
        }
        return aux.toString();
    }
}