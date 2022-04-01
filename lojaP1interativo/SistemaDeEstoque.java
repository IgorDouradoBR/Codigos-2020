public class SistemaDeEstoque{
    private Geladeira geladeira;
    private Fogao fogao;
    private Ventilador ventilador;
    private Ferro ferro;
    private boolean bool= false;
    public SistemaDeEstoque(Geladeira geladeira, Ferro ferro, Fogao fogao, Ventilador ventilador){
        this.geladeira= geladeira;
        this.ferro= ferro;
        this.fogao= fogao;
        this.ventilador= ventilador;
    }

    public int getGeladeira(){
        return geladeira.getGeladeiraEst();
    }

    public int getFogao(){
        return fogao.getFogaoEst();
    }

    public int getVentilador(){
        return ventilador.getVentiladorEst();
    }

    public int getFerro(){
        return ferro.getFerroEst();
    }

    public void setGeladeiraMais(int quant){
        geladeira.setGeladeiraEstMais(quant);
    }

    public void setFerroMais(int quant){
        ferro.setFerroEstMais(quant);
    }

    public void setFogaoMais(int quant){
        fogao.setFogaoEstMais(quant);
    }

    public void setVentiladorMais(int quant){
        ventilador.setVentiladorEstMais(quant);
    }

    public void setGeladeiraMenos(int quant){
        geladeira.setGeladeiraEstMenos(quant);
    }

    public void setFerroMenos(int quant){
        ferro.setFerroEstMenos(quant);
    }

    public void setFogaoMenos(int quant){
        fogao.setFogaoEstMenos(quant);
    }

    public void setVentiladorMenos(int quant){
        ventilador.setVentiladorEstMenos(quant);
    }

    public void imprimeGeladeira(int quantidade){

        System.out.println("   01                 "+ geladeira.getGeladeiraCod()+ "     "+ geladeira.getGeladeiraNome()+ "     "+ geladeira.getGeladeiraPreco()+ "     "+ quantidade+ "     "+ geladeira.getGeladeiraPreco()*quantidade);
    }
    public void imprimeFerro(int quantidade){

        System.out.println("   02                 "+ ferro.getFerroCod()+ "     "+ ferro.getFerroNome()+ "     "+ ferro.getFerroPreco()+ "     "+ quantidade+ "     "+ ferro.getFerroPreco()*quantidade);
    }
    public void imprimeFogao(int quantidade){

        System.out.println("   03                 "+ fogao.getFogaoCod()+ "     "+ fogao.getFogaoNome()+ "     "+ fogao.getFogaoPreco()+ "     "+ quantidade+ "     "+ fogao.getFogaoPreco()*quantidade);
    }
    public void imprimeVentilador(int quantidade){

        System.out.println("   04                 "+ ventilador.getVentiladorCod()+ "     "+ ventilador.getVentiladorNome()+ "     "+ ventilador.getVentiladorPreco()+ "     "+ quantidade+ "     "+ ventilador.getVentiladorPreco()*quantidade);
    }
    
    

    
}