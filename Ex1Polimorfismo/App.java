import java.util.ArrayList;
public class App {
    public static void imprime(ArrayList<Produto> prod){
        for (int i=0; i<prod.size(); i++){
            System.out.println("Código do produto: " +prod.get(i).getCodigo());
            System.out.println("Descrição do produto: " +prod.get(i).getDescricao());
            System.out.println("Imposto sobre o produto: " +prod.get(i).getImposto());
            System.out.println("Margem de lucro sobre o produto: " +prod.get(i).getMargemLucro());
            System.out.println("Preço do produto a pagar pelo consumidor: " +prod.get(i).calculaPrecoConsumidor());
            System.out.println("\n");
        }
    }

    public static void main(String[] args){
        ArrayList<Produto> prod = new ArrayList<>();
        Eletrodomestico ed1= new Eletrodomestico(1923, "Fogão ", 145, 220);
        prod.add(ed1);
        Telefonia tel1= new Telefonia(1920, "Xiaomizinho", 432, true);
        prod.add(tel1);
        Telefonia tel2= new Telefonia(1921,"Blé iphone", 5000, false);
        prod.add(tel2);
        Eletrodomestico ed2= new Eletrodomestico(1922, "Geladeira ", 1442, 110);
        prod.add(ed2);
        Eletropesado ep1= new Eletropesado(1924, "Maquina de lavar", 550);
        prod.add(ep1);
        Eletropesado ep2= new Eletropesado(1925, "Maquina de passar", 1650);
        prod.add(ep2);
        imprime(prod);



    }
}