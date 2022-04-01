import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    public enum Estados {
        ABERTURA, JOGO, PERDEU, GANHOU
    }

    public enum Dificuldade {
        FACIL, MEDIO, DIFICIL
    }

    private ColorPinLine senhaSecreta;
    private ColorPinLine tentativa;
    private BWPinLine pistas;
    private TextField tfNome;

    private List<LinhaJogo> linhasDeJogo;
    private int jogadaAndamento;
    GridPane grid;

    private Scene sceneJogada;
    private Scene sceneAbertura;
    private Scene sceneGanhou;
    private Scene scenePerdeu;
    private Stage primaryStage;

    int nl = 2;
    int qualLinha = 1;


    private int numTentativas = 0;
    private int tentativasCorrente = 0;
    private int nivelDificuldade = 0;
    long tempoInicial;
    long tempoFinal;


    private boolean ganhouBool = false;


    private static final Cor[] CORES = Cor.values();
    private static Random aleatorio = new Random();

    private Scene montaCenaJogada(){
        // Monta a cena da jogada
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Define uma senha para a senha secreta
        senhaSecreta = new ColorPinLine();
        List<Cor> senha = Arrays.asList(getRandomCor(), getRandomCor(), getRandomCor(), getRandomCor(), getRandomCor(),
                getRandomCor());
        for (int i = 0; i < ColorPinLine.QTDADE; i++) {
            senhaSecreta.setCor(senha.get(i), i);
        }
        senhaSecreta.block();
        
        linhasDeJogo = new ArrayList<>();

        LinhaJogo l = LinhaJogo.criaLinhaJogo();
        linhasDeJogo.add(l);
    

        Button but = new Button("Fecha joga");
        but.setOnAction(e -> verificaSenha(e));
        Button btVolta = new Button("Volta tela inicial");
        btVolta.setOnAction(e -> trocaTela(Estados.ABERTURA));
        grid.add(senhaSecreta, 0, 1);

        grid.add(linhasDeJogo.get(0),0,nl);
        
        

        grid.add(but, 0, 14);
        grid.add(btVolta, 1, 14);

        linhasDeJogo.get(0).getTentativa().unblock();
        return new Scene(grid, 600, 200);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        tempoInicial = System.currentTimeMillis();
        sceneJogada = montaCenaJogada();

        // Monta a cena da abertura
        GridPane gridA = new GridPane();
        gridA.setAlignment(Pos.CENTER);
        gridA.setHgap(20);
        gridA.setVgap(10);
        gridA.setPadding(new Insets(50, 50, 50, 50));
        gridA.add(new Label("MINI SENHA JOGO "), 2, 0);
        gridA.add(new Label("Seu nome: "), 1, 2);
        tfNome = new TextField();
        gridA.add(tfNome, 2, 2);
        gridA.add(new Label("Dificuldade do jogo: "), 0, 3);
        Button b = new Button("Prosseguir");
        b.setOnAction(e -> trocaTela(Estados.JOGO));


        gridA.add(b, 4, 9);
        Button easy = new Button("Facil");
        gridA.add(easy, 2, 3);
        easy.setOnAction(e -> dificuldadeJogo(1));
        Button medium = new Button("Medio");
        gridA.add(medium, 3, 3);
        medium.setOnAction(e -> dificuldadeJogo(2));
        Button hard = new Button("Dificil");
        gridA.add(hard, 4, 3);
        hard.setOnAction(e -> dificuldadeJogo(3));
        sceneAbertura = new Scene(gridA);

        GridPane gridG = new GridPane();
        gridG.setAlignment(Pos.CENTER);
        gridG.setHgap(20);
        gridG.setVgap(10);
        gridG.setPadding(new Insets(100, 100, 100, 100));
        gridG.add(new Label("Você ganhou!!! "), 1, 1);
        Button verRecordes = new Button("Ver recordes");
        gridG.add(verRecordes, 4, 3);
        verRecordes.setOnAction(e -> lerRecordes());
        sceneGanhou = new Scene(gridG);

        GridPane gridP = new GridPane();
        gridP.setAlignment(Pos.CENTER);
        gridP.setHgap(20);
        gridP.setVgap(10);
        gridP.setPadding(new Insets(100, 100, 100, 100));
        gridP.add(new Label("Você perdeu, tente novamente "), 1, 1);
        Button verRecordesPerdeu = new Button("Ver recordes");
        gridP.add(verRecordesPerdeu, 4, 3);
        verRecordesPerdeu.setOnAction(e -> lerRecordes());
        scenePerdeu = new Scene(gridP);


        // Exibe a cena da abertura no palco
        primaryStage.setTitle("Inicio do jogo");
        primaryStage.setScene(sceneAbertura);
        primaryStage.show();
    }

    void coletaNome() {
        System.out.println("Nome do jogador: " + tfNome.getText());
    }

    public static Cor getRandomCor() {//escolhe aleatoriamente a cor
        return CORES[aleatorio.nextInt(CORES.length-2)];//-2 pq as ultimas cores sao preto e branco
    }

    

    public void trocaTela(Estados est) {//muda manualmente a tela
        Scene s = null;
        String titulo = "";
        switch (est) {
            case JOGO:
                s = sceneJogada;
                titulo = "Jogo";
                break;
            case ABERTURA:
                s = sceneAbertura;
                titulo = "Tela de abertura";
                break;
            case GANHOU:
                s = sceneGanhou;
                titulo = tfNome.getText() + " ganhou!";
                ganhouBool = false;//teste ao reiniciar
                break;
            case PERDEU:
                s = scenePerdeu;
                titulo = tfNome.getText() + " perdeu!";
                break;

            
            default:
                break;
        }
        primaryStage.setTitle(titulo);
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public void dificuldadeJogo(int opcao) {// dependendo da dificuldade, o jogador terá mais ou menos chances

        switch (opcao) {
            case 1:
                numTentativas = 12;
                nivelDificuldade = 47;
                break;
            case 2:
                numTentativas = 10;
                nivelDificuldade = 69;
                break;
            case 3:
                numTentativas = 8;
                nivelDificuldade = 93;
                break;
            default:
                break;
        }

    }

    public void verificaSenha(ActionEvent event) {
        ColorPinLine tentativa = linhasDeJogo.get(jogadaAndamento).getTentativa();
        BWPinLine pistas = linhasDeJogo.get(jogadaAndamento).getPista();
        int corretos = 0;
        int foraPos = 0;

        LinhaJogo l = LinhaJogo.criaLinhaJogo();
        linhasDeJogo.add(l);
        nl++;
        grid.add(linhasDeJogo.get(qualLinha),0,nl);
        tentativasCorrente++;
        
        // Determina quantos pinos corretos e quantos fora de posição
        for (int i = 0; i < senhaSecreta.getChildren().size(); i++) {
            Pino pOrig = (Pino) senhaSecreta.getChildren().get(i);
            Pino pTent = (Pino) tentativa.getChildren().get(i);
            if (pOrig.getCor().equals(pTent.getCor())) {
                corretos++;
            } else {
                if (tentativa.getChildren().stream().map(p -> ((Pino) p).getCor()).filter(c -> c.equals(pOrig.getCor()))
                        .count() > 0) {
                    foraPos++;
                }
            }
        }
        
        int pos = 0;

        if(corretos==ColorPinLine.QTDADE){
            ganhouBool=true;
            tempoFinal= System.currentTimeMillis();
            escreveRecordes((17-jogadaAndamento), getTempo(tempoInicial, tempoFinal));
            trocaTela(Estados.GANHOU);
        }
        // Liga um pino preto para cada pino correto
        while (corretos > 0) {
            pistas.setPinPreto(pos);
            pos++;
            corretos--;
        }
        // Liga um pino branco para cada pino fora de posição
        while (foraPos > 0) {
            pistas.setPinBranco(pos);
            pos++;
            foraPos--;
        }
        // Desabilita os pinos restantes
        while (pos < pistas.getChildren().size()) {
            pistas.setEmpty(pos);
            pos++;
        }
        if (numTentativas > 0 && tentativasCorrente == numTentativas) {
            if(ganhouBool==true){
                trocaTela(Estados.GANHOU);
            }
            else{
                trocaTela(Estados.PERDEU);
            }
            tentativasCorrente = 0;
        }
        tentativa.block();
        jogadaAndamento++;
        linhasDeJogo.get(qualLinha).getTentativa().unblock();
        qualLinha++;
    }


    public void lerRecordes(){
        LinkedList<ClasseRecorde> linhas = new LinkedList<>();
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+ "recordes.txt";
        Path path = Paths.get(nameComplete);
            try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
            while (sc.hasNext()){
                String linha = sc.nextLine();
                if(linha.length()>1){
                    String[] dados = linha.split(";");
                    int pont = Integer.parseInt(dados[1]);
                    ClasseRecorde corrente = new ClasseRecorde(dados[0], pont);
                    linhas.add(corrente);
                }
            }
            }catch (IOException x){
                System.err.format("Erro de E/S: %s%n", x);
            }
        ClasseRecorde[] recordesOrdenado =linhas.toArray(new ClasseRecorde[0]);
        Arrays.sort(recordesOrdenado);
        String nomeAux="";
        for(int i=0; i<recordesOrdenado.length;i++){
            if(recordesOrdenado[i].getNome().length()>nomeAux.length()){
                nomeAux= recordesOrdenado[i].getNome();
            }
        }
        String exibir = "";
        exibir += "nome";
        for(int j =0; j<nomeAux.length();j++){
            exibir += " ";
        }
        exibir += "pontuacao";
        for(int i=0; i<recordesOrdenado.length;i++){
            if(i>=10){
                break;
            }
            exibir+= "\n"+recordesOrdenado[i].getNome();
            for(int j =0; j<(nomeAux.length()+4) - recordesOrdenado[i].getNome().length();j++){
                exibir+= " ";
            }
            exibir+= recordesOrdenado[i].getPontuacao();
        }
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Página de recordes");
            dialogoInfo.setHeaderText("A pontuação leva em conta:\nNível de dificuldade escolhida\nTempo até acertar\nTentativa em que se acertou");
            dialogoInfo.setContentText(exibir);
            dialogoInfo.showAndWait();
    }

    public void escreveRecordes(int quandoAcertou, int tempo){
        try {
            File arquivo = new File("recordes.txt"); 
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
                      
            String linha = tfNome.getText()+";"+ ((quandoAcertou*9)+nivelDificuldade+tempo);
                                           
            bw.append("\n" + linha);
            bw.flush();
            bw.close();
                        
                }catch (IOException x){
                  System.err.format("Erro de E/S: %s%n", x);
              }
    }

    public int getTempo(long tInic, long tFin){
        long minutos= ((tFin-tInic)/1000)/60;
        if(minutos>=0 && minutos<=2){
            return 63;
        }
        else if(minutos>=3 && minutos<=4){
            return 55;
        }
        else if(minutos>=5 && minutos<=6){
            return 47;
        }
        else if(minutos>=7 && minutos<=9){
            return 40;
        }
        else if(minutos>=10 && minutos<=12){
            return 33;
        }
        else if(minutos>=13 && minutos<=17){
            return 27;
        }
        else{
            return 21;
        }

    }






    public static void main(String[] args) {
        Application.launch(args);
    }
}