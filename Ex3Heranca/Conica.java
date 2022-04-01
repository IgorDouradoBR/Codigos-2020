
public class Conica extends Modelo{
    double volume=0;
    public Conica(String codigo, double custo){
        super(codigo, custo);
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double raio, double alt) {
        volume= ((Math.PI*(raio*raio))*alt)/3;
    }

    @Override
    public String toString() {
        String aux= super.toString();
        aux+= "\nvolume= " + getVolume();
        return aux;
    }
    
    
}