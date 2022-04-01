public class ClasseRecorde implements Comparable<ClasseRecorde>{
    String nome;
    int pontuacao;
    public ClasseRecorde(String nome,int pontuacao){
        this.nome = nome;
        this.pontuacao = pontuacao;
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
    public int compareTo(ClasseRecorde outroRecorde) { 
        if (this.pontuacao > outroRecorde.getPontuacao()) { 
          return -1; 
          } 
          if (this.pontuacao < outroRecorde.getPontuacao()) { 
          return 1; 
          } 
          return 0; 
         }
}