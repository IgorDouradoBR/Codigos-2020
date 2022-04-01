public class Veiculo implements Comparable<Veiculo>{
    int ano = 0;
    String marca = "";
    String cor = "";
    public Veiculo(int ano, String marca, String cor){
        this.ano= ano;
        this.marca = marca;
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

     
     // teste

     @Override public int compareTo(Veiculo outroAno) { 
        if (this.ano > outroAno.getAno()) { 
          return -1; 
          } if (this.ano < outroAno.getAno()) { 
          return 1; 
          } 
          return 0; 
         }




}