import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final Scanner s = new Scanner(System.in);

    public static double solicitaValor(String demanda){
        System.out.println(demanda);
        double valor = s.nextFloat();
        if (valor < 0){
            System.out.println("Valor invalido!");
            return -1.0;
        }else{
            return valor;
        }
    }

    public static void deposito(ContaCorrente cc){
        double valor = solicitaValor("Entre o valor a depositar: ");
        if (valor == -1){
            return;
        }
        cc.deposito(valor);
    }

    public static void retirada(ContaCorrente cc){
        double valor = solicitaValor("Entre o valor que deseja retirar: ");
        if (valor == -1){
            return;
        }
        cc.retirada(valor);
    }

    public static void quitaJuros(ContaCorrente cc){
        if (cc instanceof ContaComLimite){
            ContaComLimite ccl = (ContaComLimite)cc;
            if (ccl.getJurosDivida() == 0){
                System.out.println("Voce não deve nada");
            }else{
               if (ccl.getSaldo() >= ccl.getJurosDivida()){
                   ccl.quitaJuros();
                   System.out.println("Divida quitada");
               }else{
                   System.out.println("Voce nao tem saldo suficiente");
               }
            }
        }else{
            System.out.println("Esse tipo de conta não tem juros");
        }
    }

    public static void menu(CadastroAgencia cad){
        while(true){
            System.out.println("Digite o numero da conta: ");
            int numeroCC = s.nextInt();
            ContaCorrente cc = cad.getConta(numeroCC);
            if (cc != null){
                // ACRESCENTAR OPÇÃO PARA QUITAR OS JUROS !!
                System.out.println("Digite sua opcao: <1> Deposito, <2> Retirada <3> Fim <4> Quita juros <5> mostra taxa conta");
                int opcao = s.nextInt();
                switch(opcao){
                    case 1:
                        deposito(cc);
                        break;
                    case 2:
                        retirada(cc);
                        break;
                    case 3:
                        return;
                    case 4:
                        quitaJuros(cc);
                        break;
                    case 5:
                        System.out.println(cc.custoTaxa());
                        break;
                    default:
                        System.out.println("Operacao invalida");
                        break;
                }    
                System.out.println(cad.toString());
            }else{
                System.out.println("Conta invalida!!\n");
            }
        }
    }

    public static void main(String args[]){
        /*
        // Não é possível instanciar classes abstratas
        //ContaCorrente cc = new ContaCorrente(10,"Ze",1000);

        ArrayList<ContaCorrente> contas = new ArrayList<>();

        contas.add(new ContaRemunerada(2020,"Ze",5000.0));
        contas.add(new ContaComLimite(2021,"Primo do Ze",1000.0,5000.0));

        contas.get(0).deposito(3000.0);
        contas.get(1).retirada(2000.0);

        for(ContaCorrente c:contas){
            System.out.println(c);
        }
        */
        CadastroAgencia cadAg = new CadastroAgencia();
        menu(cadAg);
        System.out.println("Fim");
    }

}