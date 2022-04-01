
public class App {
    public static void main(String[] args){
        Conta c1 = new Conta(19204, "Igor Pereira Dourado", 3000);
        ContaRemunarada c2= new ContaRemunarada(786, "Melissa", 3453);
        ContaComLimite c3= new ContaComLimite(4563, "Fabiano ", 3467);
        c3.retirada(325);
        c3.deposito(500);
        c3.retirada(500);
        c3.deposito(890);
        c1.deposito(453);
        c1.retirada(53);
        c2.deposito(543);
        c2.remunera(100);
        c2.remunera(234);
        System.out.println(c1.toString()+ "\n" + c2.toString()+ "\n"+ c3.toString());
    }

}