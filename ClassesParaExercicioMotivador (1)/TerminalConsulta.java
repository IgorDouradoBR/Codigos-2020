import java.util.Scanner;

public class TerminalConsulta {
    private CadastroFuncionarios cadastro;

    public TerminalConsulta() {
        cadastro = new CadastroFuncionarios();
    }

    public void menu() {
        Scanner s = new Scanner(System.in);
        if (cadastro.garantir()==true){    
            while (true) {
                System.out.println("Entre a matricula do funcionario (0=fim): ");
                String matricula = s.nextLine();
                if (matricula.equals("0")){
                    break; // Quebra o while
                }
                Funcionario func = cadastro.recuperaPorMatricula(matricula);
                System.out.println("----------");
                if (func == null) {
                    System.out.println("Funcionario nao encontrado !!");
                }else{
                    System.out.println(func.toString());
                }
                System.out.println("Digite qualquer tecla para continuar.\n");
                s.nextLine();
            }
            }
            else{System.out.println("Você nao cadastrou funcionarios o suficiente da categoria 'área de risco', deve cadastrar 3 ou mais ");}
            s.close();
    }
}