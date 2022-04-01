public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
	
    public Produto(int codigo, String descricao, double preco) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public double getPreco() { return preco; }

	public void setPreco(double preco) { 
        
        this.preco = preco; 	}

	public int getCodigo() { return codigo; }

	public String getDescricao() { return descricao; }
    
    public double getImposto() { return preco*0.1; }

    

    
    public double getMargemLucro() { return preco*0.4; }
    
    public double calculaPrecoConsumidor() {
    	  return getPreco()+getImposto()+getMargemLucro();
       }
}
