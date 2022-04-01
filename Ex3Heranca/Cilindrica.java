
public class Cilindrica extends Modelo{
    double volume=0;
    public Cilindrica(String codigo, double custo){
        super(codigo, custo);
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double raio, double alt) {
        volume= (Math.PI*(raio*raio))*alt;
    }

    @Override
    public String toString() {
        String aux= super.toString();
        aux+= "\nvolume= " + getVolume();
        return aux;
    }
    
    
}