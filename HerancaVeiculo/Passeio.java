public class Passeio extends Carro {

    private int nroPassageiros;
  
   
  
    public Passeio(String placa, String cpfProprietario, int ano,    
  
                   String marca, String modelo, int nroPassageiros) {
  
        super(placa, cpfProprietario, ano, marca, modelo);
  
        this.nroPassageiros = nroPassageiros;
  
    }
  
   
  
    @Override
  
    public String toString() {
  
        return super.toString()+", nroPassageiros=" + nroPassageiros;
  
    }
  
  }