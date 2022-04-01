
public class Caixa extends Modelo{
    private double volume=0;
    public Caixa(String codigo, double custo){
        super(codigo, custo);
        
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double l1, double l2, double alt) {
        volume= (l1*l2)*alt;
    }

    @Override
    public String toString() {
        String aux= super.toString();
        aux+= "\nvolume= " + getVolume();
        return aux;
    }
    
    
}