public class Modelo{
    String codigo= "";
    double custo=0;
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
    
    
}