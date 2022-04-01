package Codigos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Garagem {

    List<CarroFerroviario> carros = new ArrayList<>();

    public void addCarro(CarroFerroviario carro) {
        carros.add(carro);
    }

    public String listarLocomotivas() {
        String aux = "";
        for (CarroFerroviario carro : carros) {
            if (carro instanceof Locomotiva) {
                aux += carro.toString() + "\n";
            }
        }
        return aux;
    }

    public CarroFerroviario getCarro(int identificador) {
        for (CarroFerroviario carro : carros) {
            if (carro.getIdentificador() == identificador) {
                carros.remove(carro);
                return carro;
            }
        }

        return null;
    }

    public String listarVagoes() {
        String aux = "";
        for (CarroFerroviario carro : carros) {
            if (carro instanceof Vagao) {
                aux += carro.toString() + "\n";
            }
        }
        return aux;
    }

    public Boolean temEmVagoes(int codig) {
        for (CarroFerroviario carro : carros) {
            if (carro instanceof Vagao) {
                Vagao v = (Vagao) carro;
                if(v.getIdentificador()==codig){
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean temEmLocom(int codig) {
        for (CarroFerroviario carro : carros) {
            if (carro instanceof Locomotiva) {
                Locomotiva l = (Locomotiva) carro;
                if(l.getIdentificador()==codig){
                    return true;
                }
            }
        }
        return false;
    }

    public void loadLocomotivas() {
        // ler arquivo
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+"ArquivoLocom.txt";
        Path path = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
           while (sc.hasNext()){
               String linha = sc.nextLine();
               String dados[] = linha.split(";");
               int ident = Integer.parseInt(dados[0]);
               double pesoMax = Double.parseDouble(dados[1]);
               int vagoesMax = Integer.parseInt(dados[2]);
               Locomotiva l = new Locomotiva(ident,pesoMax,vagoesMax);
               carros.add(l);
           }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }


    public void loadVagoes() {
        // ler arquivo
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+"ArquivoVag.txt";
        Path path = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
           while (sc.hasNext()){
               String linha = sc.nextLine();
               String dados[] = linha.split(";");
               int ident = Integer.parseInt(dados[0]);
               int pesoMax = Integer.parseInt(dados[1]);
               Vagao v= new Vagao(ident,pesoMax);
               carros.add(v);
           }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    
}