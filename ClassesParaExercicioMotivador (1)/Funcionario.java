public class Funcionario{
    public static final double LIM_ISENCAO_IR = 2000;
    private String matricula;
    private String nome;
    private double salarioBruto;
    private int categoria;
    
    public Funcionario(String matricula, String nome, double salarioBruto, int categoria){
        this.matricula = matricula;
        this.nome = nome;
        this. salarioBruto = salarioBruto;
        this.categoria= categoria;
    }

	public String getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getSalarioBruto() {
		return salarioBruto;
	}
    
    public double getINSS(){
        return salarioBruto*0.1;
    }

    public double getImpRenda(){
        double adicional = (salarioBruto - getINSS())*0.25;
        double novoSB = salarioBruto + adicional;
        if (novoSB <= LIM_ISENCAO_IR){
            return 0.0;
        }else{
            double aux = novoSB - LIM_ISENCAO_IR;
            double ir = aux * 0.2;
            return ir;
        }
    }

    public int getCat(){
        return categoria;
    }

    public double getCategoria(){
        if(categoria==1){
            return getINSS() * 0.25;
        }
        else{
            return 0;
        }
    }

    public double getSalarioLiquido(){
        return salarioBruto - getINSS()+ getCategoria() - getImpRenda();
    }

    

    public String toString() {
        

        
        String aux = "";
        aux += "Categoria: "+this.getClass().getName()+"\n";
        aux += "Matricula: "+this.getMatricula()+"\n";
        aux += "Nome: "+this.getNome()+"\n";
        aux += "Salario bruto: "+this.getSalarioBruto()+"\n";
        aux += "(-) INSS: "+this.getINSS()+"\n";
        aux += "(+) Funcionário de area de risco"+ this.getCategoria()+"\n";
        aux += "(-) IR: "+this.getImpRenda()+"\n";
        aux += "Salario liquido: "+this.getSalarioLiquido()+"\n";
        aux += "----------";
        return aux;    
    }
}