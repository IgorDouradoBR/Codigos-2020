public class ValorInteiro extends ElementoDeExpressao{
    private Integer valor;
    private String rep;

    public ValorInteiro(int valor){
        this.valor = valor;
        this.rep = this.valor.toString();
    }

    @Override
    public Integer valor() {
        return valor;
    }

    @Override
    public String toString() {
        return rep;
    }

    
}