import java.util.LinkedList;
import java.util.List;

public class Catalogo{
    List<Veiculo> veiculos = new LinkedList<Veiculo>();
    public Catalogo(){
       addcatalogo();
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    public void addcatalogo(){
        Veiculo c1 = new Veiculo(2001, "Toyota", "verde");
        Veiculo c2 = new Veiculo(2010, "Chevrolet", "amarelo");
        Veiculo c3 = new Veiculo(2020, "Fiat", "preto");
        Veiculo c4 = new Veiculo(2019, "Volkswagen", "vermelho");
        Veiculo c5 = new Veiculo(2002, "Ford", "branco");
        Veiculo c6 = new Veiculo(2001, "Honda", "verde");
        Veiculo c7 = new Veiculo(2002, "Hyundai", "vermelho");
        Veiculo c8 = new Veiculo(2008, "Toyota", "azul");
        Veiculo c9 = new Veiculo(1998, "Ford", "amarelo");
        Veiculo c0 = new Veiculo(1990, "Chevrolet", "laranja");
        veiculos.add(c1);
        veiculos.add(c2);
        veiculos.add(c3);
        veiculos.add(c4);
        veiculos.add(c5);
        veiculos.add(c6);
        veiculos.add(c7);
        veiculos.add(c8);
        veiculos.add(c9);
        veiculos.add(c0);
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}