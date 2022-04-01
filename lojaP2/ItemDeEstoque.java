public class ItemDeEstoque {

	private Produto produto;
	private int quantidade;

	public ItemDeEstoque(Produto produto, int quantidade){
		this.produto= produto;
		this.quantidade= quantidade;
	}

	public Produto getProduto(){
		return produto;
	}

	public int getQuantidade(){
		return quantidade;
	}

	public boolean baixaEstoque(int quantidade){
		if(this.quantidade>= quantidade){
			this.quantidade=quantidade;
			return true;
		}
		else{
			return false;
		}
	}

	public int getQuantidadeEstoqueProduto(int codigo){
		for(int i=0, i<itens)
	}
}
