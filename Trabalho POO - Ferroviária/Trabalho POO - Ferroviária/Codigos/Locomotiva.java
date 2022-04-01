package Codigos;

public class Locomotiva extends CarroFerroviario {
    private double pesoMaximoCarregado;
    private int numeroMaxDeVagoes;
    

    Locomotiva(int identificador, double pesoMaximoCarregado, int numeroMaxDeVagoes) {
        super(identificador);
        this.pesoMaximoCarregado = pesoMaximoCarregado;
        this.numeroMaxDeVagoes = numeroMaxDeVagoes;
    }

    @Override
    public String toString() {
        return   "Código da locomotiva: " + super.getIdentificador() + " Peso Máximo: " + this.pesoMaximoCarregado
                + " Numero de Vagoes suportados: " + this.numeroMaxDeVagoes;
    }

    public double getPesoMaximoCarregado() {
        return pesoMaximoCarregado;
    }

    public void setPesoMaximoCarregado(double pesoMaximoCarregado) {
        this.pesoMaximoCarregado = pesoMaximoCarregado;
    }

    public int getNumeroMaxDeVagoes() {
        return numeroMaxDeVagoes;
    }

    public void setNumeroMaxDeVagoes(int numeroMaxDeVagoes) {
        this.numeroMaxDeVagoes = numeroMaxDeVagoes;
    }
}