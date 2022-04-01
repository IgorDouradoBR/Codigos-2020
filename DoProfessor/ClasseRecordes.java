public class ClasseRecordes implements Comparable<ClasseRecordes>{
    String nome;
    int pontuacao;
    String modo;
    String adversario;
    public ClasseRecordes(String nome,int pontuacao, String modo,  String adversario){
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.modo = modo;
        this.adversario=adversario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    @Override 
    public int compareTo(ClasseRecordes outroRecorde) { 
        if (this.pontuacao > outroRecorde.getPontuacao()) { 
          return -1; 
          } 
          if (this.pontuacao < outroRecorde.getPontuacao()) { 
          return 1; 
          } 
          return 0; 
         }


	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
    }

    

	public String getAdversario() {
		return adversario;
	}

	public void setAdversario(String adversario) {
		this.adversario = adversario;
    }
}