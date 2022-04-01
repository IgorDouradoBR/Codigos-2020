public class Esportivo extends Carro {

    private int velocidadeMaxima;
  
   
  
    public Esportivo(String placa, String cpfProprietario, int ano,
  
                     String marca, String modelo,
  
                     int velocidadeMaxima) {
  
        super(placa, cpfProprietario, ano, marca, modelo);
  
        this.velocidadeMaxima = velocidadeMaxima;
  
    }
  
   
  
    @Override
  
    public String toString() {
  
        return super.toString()+
  
               ", velocidadeMaxima=" + velocidadeMaxima;
  
    }
  
  }