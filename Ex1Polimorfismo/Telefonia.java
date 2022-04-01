public class Telefonia extends Produto{
    private boolean importado= false;
    public Telefonia(int codigo, String descricao, double preco, boolean importado){
        super(codigo, descricao, preco);
        this.importado= importado; 
        if(isImportado()==true) {

        }      
    }
    
    @Override
    public double getImposto() { return (getPreco()*0.1)*1.5; }


    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }




}