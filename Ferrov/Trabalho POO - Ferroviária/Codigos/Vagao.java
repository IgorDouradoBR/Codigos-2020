package Codigos;

public class Vagao extends CarroFerroviario {
    private int pesoMaximoSuportado;

    Vagao(int identificador, int pesoMaximoSuportado) {
        super(identificador);
        this.pesoMaximoSuportado = pesoMaximoSuportado;
    }

    @Override
    public String toString() {
        return "Código do vagão: " + " " + super.getIdentificador() + " Peso maximo suportado: "
                + this.pesoMaximoSuportado;
    }

    public int getPesoMaximoSuportado() {
        return pesoMaximoSuportado;
    }

    public void setPesoMaximoSuportado(int pesoMaximoSuportado) {
        this.pesoMaximoSuportado = pesoMaximoSuportado;
    }
}