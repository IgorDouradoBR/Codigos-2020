package Codigos;

public abstract class CarroFerroviario {
    private int identificador;
    private Composicao composicaoRef;
    private Boolean livre= false;

    CarroFerroviario(int identificador) {
        this.identificador = identificador;
        this.composicaoRef = null;
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public boolean estaLivre() {
        return composicaoRef == null;
    }
    

    public String toString() {
        return this.getClass().getName();
    }

    public Boolean getLivre() {
        return livre;
    }

    public void setComposicaoRef(Boolean livreoun) {
        this.livre = livreoun;
    }
}