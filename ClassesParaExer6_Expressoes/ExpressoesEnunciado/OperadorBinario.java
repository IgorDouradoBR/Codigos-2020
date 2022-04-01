public abstract class OperadorBinario extends ElementoDeExpressao{
    private ElementoDeExpressao opEsq;
    private ElementoDeExpressao opDir;

    public OperadorBinario(ElementoDeExpressao opEsq,ElementoDeExpressao opDir){
        this.opEsq = opEsq;
        this.opDir = opDir;
    }

    public ElementoDeExpressao getOpEsq(){
        return opEsq;
    }

    public ElementoDeExpressao getOpDir(){
        return opDir;
    }
}