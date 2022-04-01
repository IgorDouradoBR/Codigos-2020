import java.util.ArrayList;

public class CadastroFuncionarios{
    private ArrayList<Funcionario> funcionarios;

    private void carregaFuncionarios(){
        funcionarios.add(new Funcionario("A3212","Huguinho Pato",1890.0, 0));
        funcionarios.add(new Funcionario("A3312","Zezinho Pato",3720.0, 0));
        funcionarios.add(new Funcionario("A3412","Luizinho Pato",8940.0, 1));
        funcionarios.add(new Funcionario("B9931","Lala Pata",4220.0, 1));
        funcionarios.add(new Funcionario("B9932","Lele Pata",1283.0, 1));
        funcionarios.add(new Funcionario("B9933","Lili Pata",12438.0, 1));
        funcionarios.add(new Funcionario("B9934","Lili Pata",12438.0, 0));
        funcionarios.add(new Funcionario("B9935","Lili Pata",12438.0, 1));
    }

    public CadastroFuncionarios(){
        funcionarios = new ArrayList<>();
        carregaFuncionarios();
    }

    public void cadastraFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public boolean garantir(){
        int cont=0;
        for(Funcionario func:funcionarios){
            if (func.getCat()==1){
                cont+=1;
            }
        }
        if(cont>=3){
        return true;
        }
        else{
            return false;
        }
    }

    public Funcionario recuperaPorMatricula(String matricula){
        for(Funcionario func:funcionarios){
            if (func.getMatricula().equals(matricula)){
                return func;
            }
        }
        return null;
    }
}