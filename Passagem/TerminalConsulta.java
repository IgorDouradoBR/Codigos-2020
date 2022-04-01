import java.util.Scanner;
public class TerminalConsulta {
    public TerminalConsulta(){

    }


    public void menu() {
        Scanner teclado = new Scanner(System.in);
        while(true){
            System.out.println();
            System.out.println("digite sua categoria: \n [1] Economica \n [2] Executiva \n [3] Premium \n ou [0] para sair do programa: ");
            int opc = teclado.nextInt();
            if (opc==0){
                break;
            }
            else if (opc == 1){
                
                System.out.println("Digite seu nome: ");
                String nome = teclado.next();                
                System.out.println("Digite seu assento: ");
                String assento = teclado.next();
                System.out.println("Digite o custo da sua passagem: ");
                Double custoPassagem = teclado.nextDouble();  
                System.out.println("Digite seu cpf: ");
                String cpf = teclado.next();              
                Economy econ= new Economy(cpf, nome, assento, custoPassagem);
                System.out.println("Digite quantas bagagens vai levar: ");
                int quant = teclado.nextInt();
                int[] pesos = new int[quant];
                for (int i=0; i<quant; i++){
                    System.out.println("Digite o peso da " + (i+1) + "ª bagagem");
                    pesos[i] = teclado.nextInt();
                }
                System.out.println("Nome: "+ econ.getNome()+"\n" + "Cpf: " + econ.getCpf()+ "\nAssento: " + econ.getAssento()+ "\nCusto passagem: "+ econ.getCustoPassagem()+ "\nCusto da Bagagem: "+ econ.custoBagagem(quant, pesos)+ "\nCusto da alocação do assento: "+ econ.defineAssento(assento));
            }
            else if(opc==2){
                System.out.println("Digite seu nome: ");
                String nome = teclado.next();
                System.out.println("Digite seu cpf: ");
                String cpf = teclado.next();
                System.out.println("Digite seu assento: ");
                String assento = teclado.next();
                System.out.println("Digite o custo da sua passagem: ");
                Double custoPassagem = teclado.nextDouble();                
                Executive Exec= new Executive(cpf, nome, assento, custoPassagem);
                System.out.println("Digite quantas bagagens vai levar: ");
                int quant = teclado.nextInt();
                int[] pesos = new int[quant];
                for (int i=0; i<quant; i++){
                    System.out.println("Digite o peso da " + (i+1) + "ª bagagem");
                    pesos[i] = teclado.nextInt();
                }
                System.out.println("Nome: "+ Exec.getNome()+"\n" + "Cpf: " + Exec.getCpf()+ "\nAssento: " + Exec.getAssento()+ "\nCusto passagem: "+ Exec.getCustoPassagem()+ "\nCusto da Bagagem: "+ Exec.custoBagagem(quant, pesos)+ "\nCusto da alocação do assento: "+ Exec.defineAssento(assento)+ "\n Milhas a mais: +" + Exec.getMilhas());
            }
            else if(opc==3){
                {
                    System.out.println("Digite seu nome: ");
                    String nome = teclado.next();
                    System.out.println("Digite seu cpf: ");
                    String cpf = teclado.next();
                    System.out.println("Digite seu assento: ");
                    String assento = teclado.next();
                    System.out.println("Digite o custo da sua passagem: ");
                    Double custoPassagem = teclado.nextDouble();                
                    Premium Prem= new Premium(cpf, nome, assento, custoPassagem);
                    System.out.println("Digite quantas bagagens vai levar: ");
                    int quant = teclado.nextInt();
                    int[] pesos = new int[quant];
                    for (int i=0; i<quant; i++){
                        System.out.println("Digite o peso da " + (i+1) + "ª bagagem");
                        pesos[i] = teclado.nextInt();
                    }
                    System.out.println("Nome: "+ Prem.getNome()+"\n" + "Cpf: " + Prem.getCpf()+ "\nAssento: " + Prem.getAssento()+ "\nCusto passagem: "+ Prem.getCustoPassagem()+ "\nCusto da Bagagem: "+ Prem.custoBagagem(quant, pesos)+ "\nCusto da alocação do assento: "+ Prem.defineAssento(assento)+ "\n Milhas a mais: +" + Prem.getMilhas());
                }
            
        }

}
}
}