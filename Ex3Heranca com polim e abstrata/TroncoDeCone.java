
public class TroncoDeCone extends Modelo{
    private double volume=0;
    public TroncoDeCone(String codigo, double custo){
        super(codigo, custo);
    }

    public double getVolume() {
        return volume;
    }

    
    public void setVolume(double raioBase, double raioTopo, double alt) {
        volume= ((1/3) * Math.PI * alt * ((raioBase*raioBase) + (raioBase+raioTopo)+ (raioTopo* raioTopo))) ;
    }    
    
    @Override
    public String toString() {
        String aux= super.toString();
        aux+= "\nvolume= " + getVolume();
        
        return aux;
    }
    
    
}