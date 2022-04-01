package Codigos;

import java.util.ArrayList;

public class Composicao {

    private ArrayList<CarroFerroviario> carros;
    private int identificador;
    private double limiteVagao=0;
    private double limiteCorrentePeso=0;
    private double limitePesoSuportado=0;
    private double quantidadeVagao=0;



    Composicao(int identificador, Locomotiva locomotiva) {
        if (locomotiva == null) {
            throw new IllegalArgumentException("Locomotiva invalida");
        }
        carros = new ArrayList<>();
        this.identificador = identificador;
        carros.add( locomotiva);
        limiteVagao += locomotiva.getNumeroMaxDeVagoes();
        limitePesoSuportado+= locomotiva.getPesoMaximoCarregado();
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public int getSize() {
        return carros.size();
    }

    public boolean addCarro(CarroFerroviario carro) {
        if (carros.get(carros.size() - 1) instanceof Vagao && !(carro instanceof Vagao)) {
            return false;
        }
        else {
            if(carro instanceof Locomotiva){
                Locomotiva l = (Locomotiva) carro;
                limiteVagao += l.getNumeroMaxDeVagoes();
                limitePesoSuportado+= l.getPesoMaximoCarregado();
                this.carros.add(carro);
                return true;
            }
            else{
                Vagao v =(Vagao) carro;
                limiteCorrentePeso += v.getPesoMaximoSuportado();
                if(( quantidadeVagao +1)>(limiteVagao* 0.9) || limiteCorrentePeso>limitePesoSuportado){
                    return false;
                }
                this.carros.add(carro);
                quantidadeVagao +=1;
                return true;
            }
        }
    }

    public CarroFerroviario getCarro(int identificador) {
        if (carros != null) {
            for (CarroFerroviario carro : carros) {
                if (carro.getIdentificador() == identificador) {
                    return carro;
                }
            }
        }
        return null;
    }

    public boolean remover() {
        if(carros.size()==1){
            System.out.println("Não é possível remover a primeira locomotiva, para isso, deve excluir a composição toda");
            return false;
        }

        else if (carros != null && carros.size()!= 1){
            if(carros.get(carros.size()-1) instanceof Vagao){
                Vagao v= (Vagao)carros.get(carros.size()-1);
                quantidadeVagao-= 1;
                limiteCorrentePeso-= v.getPesoMaximoSuportado();
            }
            if(carros.get(carros.size()-1) instanceof Locomotiva){
                Locomotiva l= (Locomotiva)carros.get(carros.size()-1);
                limiteVagao -= l.getNumeroMaxDeVagoes();
                limitePesoSuportado -= l.getPesoMaximoCarregado();
            }
            this.carros.get(carros.size() - 1).setComposicaoRef(true);
            this.carros.remove(carros.size() - 1);
            
        }
        return true;
    }

    public CarroFerroviario primeiroCarro() {
        if (carros != null)
            return this.carros.get(0);
        return null;
    }

    public CarroFerroviario ultimoCarro() {
        if (carros != null)
            return this.carros.get(carros.size() - 1);
        return null;
    }

    public CarroFerroviario carroPorIndex(int index) {
        if (carros != null)
            return this.carros.get(index);
        return null;
    }

    public String toString() {
        String aux = "\nCódigo da composição: " + this.identificador ;
        for (CarroFerroviario carro : carros) {
            if(carro instanceof Locomotiva){
                Locomotiva l= (Locomotiva) carro;
                aux += "\nLocomotiva Codigo: "+ l.getIdentificador() + " ";
                aux += " Peso maximo levado: "+ l.getPesoMaximoCarregado();
                aux+= "  Numero de vagoes max: " + l.getNumeroMaxDeVagoes();
            }
            if(carro instanceof Vagao){
                Vagao v= (Vagao) carro;

                aux += "\nVagão Codigo: "+ v.getIdentificador() + " ";
                aux += " Peso maximo: "+ v.getPesoMaximoSuportado();
            }
            
        }
        return aux;
    }

   

    
}