public  class Modelo{
    String codigo= "";
    double custo=0;
    double volume = 0;
    String nome = "";
    public Modelo(String codigo, double custo){
        this.codigo=codigo;
        this.custo= custo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        String aux= "\n";
        aux+=  "codigo=" + getCodigo() ;
        aux+=  "\ncusto=" + custo ;
        aux+= "\nembalagem= "+ this.getClass().getName();
        return aux;
    }


    public void setVolume(double volume){
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}