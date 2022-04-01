public class Fogao{
    private int fogaoEst = 0;
    private final int fogaoCod= 6765;
    private final String fogaoNome = "Fogao Top";
    private final double fogaoPreco = 879;
    public Fogao(int fogaoEst){
        this.fogaoEst = fogaoEst;

    }

    public String getFogaoNome(){
        return fogaoNome;

    }

    public double getFogaoPreco(){
        return fogaoPreco;
    }

    public int getFogaoCod(){
        return fogaoCod;

    }

    public int getFogaoEst(){
        return fogaoEst;
    }

    public void setFogaoEstMenos(int quant){
        fogaoEst -= quant;
    }

    public void setFogaoEstMais(int quant){
        fogaoEst += quant;
    }
}