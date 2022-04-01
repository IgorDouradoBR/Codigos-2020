public class Ferro{
    private int ferroEst = 0;
    private final int ferroCod= 3943;
    private final String ferroNome = "Ferro de passar Top";
    private final double ferroPreco = 225;
    public Ferro(int ferroEst){
        this.ferroEst = ferroEst;

    }

    public String getFerroNome(){
        return ferroNome;

    }

    public double getFerroPreco(){
        return ferroPreco;
    }

    public int getFerroCod(){
        return ferroCod;

    }

    public int getFerroEst(){
        return ferroEst;
    }

    public void setFerroEstMenos(int quant){
        ferroEst -= quant;
    }
    public void setFerroEstMais(int quant){
        ferroEst += quant;
    }
}