public class Carro extends Veiculo {

    private String marca;
  
    private String modelo;
  
   
  
    public Carro(String placa, String cpfProprietario, int ano,
  
                 String marca, String modelo) {
  
        super(placa, cpfProprietario, ano);
  
        this.marca = marca;
  
        this.modelo = modelo;
  
    }
  
   
  
    @Override
  
    public String toString() {
  
        return super.toString()+", marca=" + marca +
  
                                ", modelo=" + modelo;
  
    }
  
  }