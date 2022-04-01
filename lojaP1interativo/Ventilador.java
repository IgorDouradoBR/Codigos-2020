public class Ventilador{
    private int ventiladorEst = 0;
    private final int ventiladorCod= 1233;
    private final String ventiladorNome = "Ventilador Top";
    private final double ventiladorPreco = 174;
    public Ventilador(int ventiladorEst){
        this.ventiladorEst = ventiladorEst;

    }

    public String getVentiladorNome(){
        return ventiladorNome;

    }

    public double getVentiladorPreco(){
        return ventiladorPreco;
    }

    public int getVentiladorCod(){
        return ventiladorCod;

    }

    public int getVentiladorEst(){
        return ventiladorEst;
    }

    public void setVentiladorEstMenos(int quant){
        ventiladorEst -= quant;
    }
    public void setVentiladorEstMais(int quant){
        ventiladorEst += quant;
    }
}