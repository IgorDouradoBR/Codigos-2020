public class Veiculo {

  private String placa;

  private String cpfProprietario;

  private int ano;

 

  public Veiculo(String placa, String cpfProprietario, int ano) {

      this.placa = placa;

      this.cpfProprietario = cpfProprietario;

      this.ano = ano;

  }

 

  @Override

  public String toString() {

      return "ano=" + ano + ", cpfProprietario=" + cpfProprietario +

             ", placa=" + placa;

  }

}