public class Geladeira{
    private int geladeiraEst = 0;
    private final int geladeiraCod= 6765;
    private final String geladeiraNome = "geladeira Top";
    private final double geladeiraPreco = 2500;
    public Geladeira(int geladeiraEst){
        this.geladeiraEst = geladeiraEst;

    }

    public String getGeladeiraNome(){
        return geladeiraNome;

    }

    public double getGeladeiraPreco(){
        return geladeiraPreco;
    }

    public int getGeladeiraCod(){
        return geladeiraCod;

    }

    public int getGeladeiraEst(){
        return geladeiraEst;
    }

    public void setGeladeiraEstMenos(int quant){
        geladeiraEst -= quant;
    }

    public void setGeladeiraEstMais(int quant){
        geladeiraEst += quant;
    }
}