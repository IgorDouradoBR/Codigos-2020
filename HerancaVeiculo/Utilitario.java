public class Utilitario extends Veiculo {

    private int capacidadeCarga;
  
   
  
    public Utilitario(String placa, String cpfProprietario,
  
                      int ano, int capacidadeCarga) {
  
        super(placa, cpfProprietario, ano);
  
        this.capacidadeCarga = capacidadeCarga;
  
    }
  
   
  
    @Override
  
    public String toString() {
  
        return super.toString()+
  
               ", capacidadeCarga=" + capacidadeCarga;
  
    }  
  
  }