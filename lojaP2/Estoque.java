import java.util.ArrayList;

public class Estoque {
	public final int MAXIMONOEST = 200;
	private ArrayList<ItemDeEstoque> itens;

	public Estoque(){
		itens = new ArrayList<>(MAXIMONOEST);
	}

	public boolean cadastrar(Produto prod, int estoqueInicial){
		if(itens.size()<MAXIMONOEST){
			ItemDeEstoque item= new ItemDeEstoque(prod, estoqueInicial);
			itens.add(item);
			return true;
		}
		else{
			return false;
		}
	}

	private Produto produto;

	private ItemDeEstoque[] itemDeEstoque;

	public ItemDeEstoque getItem(int codigoProd) {
		return null;
	}

}
