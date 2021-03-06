import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TreeSet;
import java.nio.charset.StandardCharsets;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    public enum Estados {
        ABERTURA, JOGO, PERDEU, GANHOU, JOGADORES2, JOGADOR1, SENHAJOGADOR2
    }

    public enum Dificuldade {
        FACIL, MEDIO, DIFICIL
    }

    private ColorPinLine senhaSecreta;
    private TextField tfNome;
    private TextField tfNome2;

    private List<LinhaJogo> linhasDeJogo = new ArrayList<>();
    private int jogadaAndamento;
    GridPane grid;

    private ComboBox<Integer> quantasTent;
    private ComboBox<Integer> quantosPino;

    private Scene sceneJogada;
    private Scene sceneAbertura;
    private Scene sceneSenhaNome;
    private Scene sceneSenhaTela;
    private Scene sceneGanhou;
    private Scene scenePerdeu;
    private Stage primaryStage;

    int nl = 2;
    int qualLinha = 1;

    private int numTentativas = 0;
    private int tentativasCorrente = 0;
    long tempoInicial;
    long tempoFinal;

    private String quantJogagores = "";
    private String adver = " ";

    Button mostraSenha;

    private boolean ganhouBool = false;
    private boolean demo = false;

    private Scene montaCenaJogada() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(250, 250, 250, 250));

        primeiraLinha();

        Button but = new Button("Fazer tentativa");
        but.setOnAction(e -> verificaSenha(e));
        Button btVolta = new Button("Desistir");
        btVolta.setOnAction(e -> trocaTela(Estados.PERDEU));
        mostraSenha = new Button("mostrar Senha");
        mostraSenha.setOnAction(e -> trataMostraSenha());

        Button ajuda = new Button("Ajuda");
        ajuda.setOnAction(e -> manualTelaDeJogo());

        grid.add(ajuda, 0, 19);
        grid.add(but, 2, 17);
        grid.add(btVolta, 1, 19);
        grid.add(mostraSenha, 2, 19);

        return new Scene(grid, 600, 200);

    }

    int contadorMostra = 0;

    public void trataMostraSenha() {
        if (contadorMostra == 0) {
            if (demo == true) {
                exibirSenha();
                contadorMostra++;
            } else {
                Alert campoVazio = new Alert(Alert.AlertType.INFORMATION);
                campoVazio.setTitle("Modo normal");
                campoVazio.setHeaderText("Essa op????o s?? est?? dispon??vel no modo demo");
                campoVazio.showAndWait();
            }
        }
    }

    public void caso1Jogador() {
        quantJogagores = "individual";

        GridPane gridSenha = new GridPane();

        gridSenha.setAlignment(Pos.CENTER);
        gridSenha.setHgap(20);
        gridSenha.setVgap(10);
        gridSenha.setPadding(new Insets(200, 200, 200, 200));

        Button demoB = new Button("Jogar na vers??o demo");
        gridSenha.add(demoB, 2, 7);

        gridSenha.add(new Label("N??mero de pinos: "), 0, 2);
        gridSenha.add(new Label("N??mero de tentativas: "), 0, 3);

        Button ajuda = new Button("Ajuda");
        ajuda.setOnAction(e -> manualTelaInformacoes1());

        gridSenha.add(ajuda, 0, 7);

        quantasTent = new ComboBox<Integer>(FlightData.getTentDisp());
        gridSenha.add(quantasTent, 1, 3);

        quantosPino = new ComboBox<Integer>(FlightData.getPinosDisp());
        gridSenha.add(quantosPino, 1, 2);

        adver = "PC";

        gridSenha.add(new Label("Seu nome: "), 1, 0);
        tfNome = new TextField();
        gridSenha.add(tfNome, 2, 0);
        Button definir = new Button("prosseguir");
        gridSenha.add(definir, 4, 7);
        definir.setOnAction(e -> alteraSenhaEtent());
        demoB.setOnAction(e -> versaoDemoTrue1jogador());

        sceneSenhaNome = new Scene(gridSenha);

    }

    public void alteraSenhaEtent() {
        if (tfNome.getLength() < 1) {
            Alert campoVazio = new Alert(Alert.AlertType.ERROR);
            campoVazio.setTitle("Nome do jogador 1 vazio");
            campoVazio.setHeaderText("O campo do nome do jogador n??o foi preenchido, esse campo ?? obrigat??rio");
            campoVazio.setContentText("clique em 'OK' para voltar para a tela das defini????es");
            campoVazio.showAndWait();
            versaoDemoFalse();
            caso1Jogador();
            trocaTela(Estados.JOGADOR1);

        } else if (getQuanTent() == null) {
            Alert campoVazio = new Alert(Alert.AlertType.ERROR);
            campoVazio.setTitle("N?? de tentativas n??o informado");
            campoVazio.setHeaderText("N??o foi selecionado o n??mero de tentativas, esse campo ?? obrigat??rio");
            campoVazio.setContentText("clique em 'OK' para voltar para a tela das defini????es");
            campoVazio.showAndWait();
            versaoDemoFalse();
            caso1Jogador();
            trocaTela(Estados.JOGADOR1);
        } else if (getQuanPino() == null) {
            Alert campoVazio = new Alert(Alert.AlertType.ERROR);
            campoVazio.setTitle("N?? de pinos n??o informado");
            campoVazio.setHeaderText("N??o foi selecionado o n??mero de pinos da senha, esse campo ?? obrigat??rio");
            campoVazio.setContentText("clique em 'OK' para voltar para a tela das defini????es");
            campoVazio.showAndWait();
            versaoDemoFalse();
            caso1Jogador();
            trocaTela(Estados.JOGADOR1);
        } else {
            mudaQnt();
            numTentativas = getQuanTent() + 1;
            geraSenhaAle();
        }
    }

    public void geraSenhaAle() {
        senhaSecreta = new ColorPinLine();

        senhaSecreta.unblock();
        List<Cor> listaCor = Arrays.asList(Cor.values());
        Collections.shuffle(listaCor);
        ArrayList<Cor> vetorAux = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            if (listaCor.get(i) != Cor.BRANCO && listaCor.get(i) != Cor.PRETO) {
                vetorAux.add(listaCor.get(i));
            }
        }
        for (int i = 0; i < getQuanPino(); i++) {
            senhaSecreta.setCor(vetorAux.get(i), i);
        }
        senhaSecreta.block();
        trocaTela(Estados.JOGO);
    }

    boolean aux = false;
    List<Cor> senha;
    ColorPinLine senhaDefinir;

    TreeSet<Cor> verificaIgualdade;

    public void capturaSenha() {
        verificaIgualdade = new TreeSet<>();
        senha = new LinkedList<>();
        numTentativas = getQuanTent() + 1;
        senhaSecreta.unblock();
        adver = tfNome2.getText();
        for (int i = 0; i < ColorPinLine.QTDADE; i++) {
            senha.add(senhaDefinir.getColors().get(i));
        }

        for (int i = 0; i < ColorPinLine.QTDADE; i++) {
            verificaIgualdade.add(senha.get(i));
            senhaSecreta.setCor(senha.get(i), i);
        }
        senhaSecreta.block();
        trocaTela(Estados.JOGO);
    }

    public void caso2Jogadores() {
        quantJogagores = "multiplayer";
        GridPane gridSenha = new GridPane();
        gridSenha.setAlignment(Pos.CENTER);
        gridSenha.setHgap(20);
        gridSenha.setVgap(10);
        gridSenha.setPadding(new Insets(75, 75, 75, 75));

        Button ajuda = new Button("Ajuda");
        ajuda.setOnAction(e -> manualTelaInformacoes2());
        gridSenha.add(ajuda, 0, 6);

        gridSenha.add(new Label("                            N??mero de pinos: "), 0, 4);
        gridSenha.add(new Label("N??mero de tentativas: "), 4, 4);

        quantasTent = new ComboBox<Integer>(FlightData.getTentDisp());
        gridSenha.add(quantasTent, 5, 4);

        quantosPino = new ComboBox<Integer>(FlightData.getPinosDisp());
        gridSenha.add(quantosPino, 2, 4);

        Button demo = new Button("jogar na vers??o demo");
        gridSenha.add(demo, 2, 6);

        Text n1 = new Text("Nome 1?? jogador: ");
        n1.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        gridSenha.add(n1, 1, 1);
        tfNome = new TextField();
        gridSenha.add(tfNome, 2, 1);

        Text n2 = new Text("Nome 2?? jogador: ");
        n2.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        gridSenha.add(n2, 1, 2);
        tfNome2 = new TextField();
        gridSenha.add(tfNome2, 2, 2);

        Button definir = new Button("Definir e prosseguir");
        gridSenha.add(definir, 4, 6);
        senha = new LinkedList<>();
        definir.setOnAction(e -> trocaTela(Estados.SENHAJOGADOR2));
        demo.setOnAction(e -> versaoDemoTrue());
        sceneSenhaNome = new Scene(gridSenha);
    }

    public void telaDaSenha() {
        GridPane gridTelaSenha = new GridPane();
        gridTelaSenha.setAlignment(Pos.CENTER);
        gridTelaSenha.setHgap(20);
        gridTelaSenha.setVgap(10);
        gridTelaSenha.setPadding(new Insets(100, 100, 100, 100));
        senhaSecreta.unblock();
        senhaDefinir = new ColorPinLine();
        gridTelaSenha.add(senhaDefinir, 1, 1);
        Button definir = new Button("definir senha");
        gridTelaSenha.add(definir, 3, 3);
        definir.setOnAction(e -> capturaSenha());
        Button ajudar = new Button("Ajuda");
        ajudar.setOnAction(e -> manualTelaSenha());
        gridTelaSenha.add(ajudar, 0, 3);
        sceneSenhaTela = new Scene(gridTelaSenha);
    }

    public void versaoDemoTrue() {
        demo = true;
        trocaTela(Estados.SENHAJOGADOR2);
    }

    public Integer getQuanTent() {
        return quantasTent.getValue();
    }

    public Integer getQuanPino() {
        return quantosPino.getValue();
    }

    public void versaoDemoTrue1jogador() {
        demo = true;
        alteraSenhaEtent();
    }

    public void exibirSenha() {
        grid.add(new Label("Senha secreta:"), 2, 3);
        grid.add(senhaSecreta, 3, 3);
    }

    public void versaoDemoFalse() {
        demo = false;
    }

    public void ganhouOuN() {
        ganhouBool = true;
    }

    public void mudaQnt() {
        ColorPinLine.setQTDADE(getQuanPino());

    }

    public void manualTelaPerdedor() {
        Alert campoVazio = new Alert(Alert.AlertType.INFORMATION);
        campoVazio.setTitle("Ajuda");
        campoVazio.setHeaderText("Manual sobre a essa tela abaixo ");
        campoVazio.setContentText(
                "Bot??o 'ver recordes' -> ver o top 10 de melhores pontua????es\nBot??o 'Fechar jogo -> fecha o jogo, simulando o X na parte superior direita da tela\nBot??o 'tentar novamente' -> tentar em uma nova partida\n*Caso a senha n??o tenha sido exibida durante a partida, ela ser?? exibida nessa tela para o jogador saber qual era");
        campoVazio.showAndWait();
    }

    public void manualTelaVencedor() {
        Alert campoVazio = new Alert(Alert.AlertType.INFORMATION);
        campoVazio.setTitle("Ajuda");
        campoVazio.setHeaderText("Manual sobre a essa tela abaixo ");
        campoVazio.setContentText(
                "Bot??o 'ver recordes' -> ver o top 10 de melhores pontua????es\nBot??o 'Fechar jogo -> fecha o jogo, simulando o X na parte superior direita da tela\nBot??o 'tentar novamente' -> tentar em uma nova partida");
        campoVazio.showAndWait();
    }

    public void manualTelaInformacoes2() {
        Alert campoVazio = new Alert(Alert.AlertType.INFORMATION);
        campoVazio.setTitle("Ajuda");
        campoVazio.setHeaderText("Manual sobre a essa tela abaixo ");
        campoVazio.setContentText(
                "Todos os campos com aster??stico s??o de preenchimento obrigat??rio\n*Nome 1?? jogador -> definir?? o nome do jogador que ir?? fazer as tentativas \n*Nome 2?? jogador -> jogador que deve definir a senha, o n??mero de tentativas e o n??mero de pinos \n*N??mero de tentativas-> define o n??mero de tentativas que o jogador 1 ter?? para tentar advinhar \n*N??mero de pinos: define o n??mero de pinos que a senha e as tentativas ter??o\n Bot??o 'jogar na vers??o demo' -> voc?? ser?? encaminhado para tela de definir a senha e deixar?? dispon??vel a op????o do jogador 1 ver essa senha definida (no modo demo a pontua????o n??o ?? salva)\nBot??o 'Definir e prosseguir' -> voc?? ser?? encaminhado para tela de definir a senha e com a op????o do jogador 1 ver essa senha definida DESLIGADA");
        campoVazio.showAndWait();
    }

    public void manualTelaInformacoes1() {
        Alert campoVazio = new Alert(Alert.AlertType.INFORMATION);
        campoVazio.setTitle("Ajuda");
        campoVazio.setHeaderText("Manual sobre a essa tela abaixo ");
        campoVazio.setContentText(
                "Todos os campos com aster??stico s??o de preenchimento obrigat??rio\n*Nome 1?? jogador -> definir?? o nome do jogador ??nico contra a m??quina \n*N??mero de tentativas-> define o n??mero de tentativas que o jogador ter?? para tentar advinhar \n*N??mero de pinos: define o n??mero de pinos que a senha e as tentativas ter??o\n Bot??o 'jogar na vers??o demo' -> voc?? ser?? encaminhado para tela de jogo e deixar?? dispon??vel a op????o do jogador ver a senha gerada (no modo demo a pontua????o n??o ?? salva)\nBot??o 'Prosseguir' -> voc?? ser?? encaminhado para tela de jogo e com a op????o de ver essa senha gerada DESLIGADA");
        campoVazio.showAndWait();
    }

    public void manualTelaSenha() {
        Alert campoVazio = new Alert(Alert.AlertType.INFORMATION);
        campoVazio.setTitle("Ajuda");
        campoVazio.setHeaderText("Manual sobre a essa tela abaixo ");
        campoVazio.setContentText(
                "A senha N??O poder?? ter pinos de cores repetidas entre si\nBot??o 'Definir senha' -> voc?? ser?? encaminhado para tela de jogo");
        campoVazio.showAndWait();
    }

    public void manualTelaDeJogo() {
        Alert campoVazio = new Alert(Alert.AlertType.INFORMATION);
        campoVazio.setTitle("Ajuda");
        campoVazio.setHeaderText("Manual sobre a essa tela abaixo ");
        campoVazio.setContentText(
                "Bot??o 'Fazer tentativa' -> ir?? verificar se a senha est?? de acordo com a senha secreta\nBot??o 'Mostrar senha'-> se estiver jogando na vers??o demo, esse bot??o mostrar?? a senha secreta na tela\nBot??o 'Desistir' -> declarar?? derrota e o jogador ser?? encaminhado para tela de derrota\n*Importante*:\nPinos de dica:\nCor preta -> H?? um pino da cor certa na posi????o certa da senha\nCor branca com O -> H?? um pino da cor certa por??m que est?? na posi????o errada em relac??o a senha secreta\n Pino vazio -> H?? um pino com a cor que n??o ocorre entre as cores dos pinos da senha secreta\nTentativa:\nA cada tentativa, uma linha nova de tentativa ser?? liberada e a linha anterior ser?? bloqueada, at?? o limite de tentativas\nClique em cada um dos pinos da tentativa at?? a cor que desejar\nN??o h?? cores repetidas entre os pinos da senha original");
        campoVazio.showAndWait();
    }

    public void manualTelaAbertura() {
        Alert campoVazio = new Alert(Alert.AlertType.INFORMATION);
        campoVazio.setTitle("Ajuda");
        campoVazio.setHeaderText("Manual sobre a essa tela abaixo ");
        campoVazio.setContentText(
                "Bot??o '1 jogador' -> voc?? ser?? encaminhado para tela de defini????es e a senha ser?? gerada automaticamente pela m??quina\nBot??o '2 jogadores' -> voc??s ser??o encaminhados para tela de defini????es, o jogador 2 dever?? preencher as informa????es e a senha secreta e o jogador 1 ir?? fazer as tentativas");
        campoVazio.showAndWait();
    }

    public void primeiraLinha() {
        LinhaJogo l = LinhaJogo.criaLinhaJogo();
        linhasDeJogo.add(l);
        linhasDeJogo.get(0).getTentativa().unblock();
    }

    GridPane gridP;
    GridPane gridG;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        tempoInicial = System.currentTimeMillis();
        sceneJogada = montaCenaJogada();

        GridPane gridA = new GridPane();
        gridA.setAlignment(Pos.CENTER);
        gridA.setHgap(20);
        gridA.setVgap(10);
        gridA.setPadding(new Insets(75, 75, 75, 75));
        Button forma1 = new Button("1 jogador");
        Button forma2 = new Button("2 jogadores");

        Rectangle r = new Rectangle();
        r.setX(10.0f);
        r.setY(10.0f);
        r.setWidth(380.0f);
        r.setHeight(80.0f);
        r.setFill(Color.DARKGRAY);
        gridA.add(r, 0, 0);

        Text tfObs = new Text("Selecione a forma de jogar ao lado para prosseguir");
        tfObs.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        gridA.add(tfObs, 0, 5);
        gridA.add(forma1, 1, 5);
        gridA.add(forma2, 2, 5);

        Button ajuda = new Button("Ajuda");
        ajuda.setOnAction(e -> manualTelaAbertura());
        gridA.add(ajuda, 0, 7);

        Text tfTitulo = new Text("  MINI SENHA JOGO");
        tfTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        tfTitulo.setFill(Color.AQUA);
        gridA.add(tfTitulo, 0, 0);

        forma2.setOnAction(e -> trocaTela(Estados.JOGADORES2));
        forma1.setOnAction(e -> trocaTela(Estados.JOGADOR1));
        sceneAbertura = new Scene(gridA);

        gridG = new GridPane();
        gridG.setAlignment(Pos.CENTER);
        gridG.setHgap(20);
        gridG.setVgap(10);
        gridG.setPadding(new Insets(100, 100, 100, 100));

        Button verRecordes = new Button("Ver recordes");
        gridG.add(verRecordes, 4, 3);
        verRecordes.setOnAction(e -> lerRecordes());

        Button reset = new Button("Tentar novamente");
        gridG.add(reset, 3, 3);
        reset.setOnAction(__ -> {
            primaryStage.close();
            Platform.runLater(() -> new App().start(new Stage()));
        });

        Button ajudar = new Button("Ajuda");
        ajudar.setOnAction(e -> manualTelaVencedor());
        gridG.add(ajudar, 0, 3);

        Button endGamee = new Button("Fechar Jogo");
        endGamee.setOnAction(e -> fecharJogo());
        gridG.add(endGamee, 2, 3);

        sceneGanhou = new Scene(gridG);

        gridP = new GridPane();
        gridP.setAlignment(Pos.CENTER);
        gridP.setHgap(20);
        gridP.setVgap(10);
        gridP.setPadding(new Insets(100, 100, 100, 100));

        Button verRecordesPerdeu = new Button("Ver recordes");
        gridP.add(verRecordesPerdeu, 4, 3);
        verRecordesPerdeu.setOnAction(e -> lerRecordes());
        Button ajudarr = new Button("Ajuda");
        ajudarr.setOnAction(e -> manualTelaPerdedor());
        gridP.add(ajudarr, 0, 3);

        Button resetar = new Button("Tentar novamente");
        gridP.add(resetar, 3, 3);
        resetar.setOnAction(__ -> {
            primaryStage.close();
            Platform.runLater(() -> new App().start(new Stage()));
        });

        Button endGame = new Button("Fechar Jogo");
        endGame.setOnAction(e -> fecharJogo());
        gridP.add(endGame, 2, 3);

        scenePerdeu = new Scene(gridP);

        // Exibe a cena da abertura no palco
        primaryStage.setTitle("Inicio do jogo");
        primaryStage.setScene(sceneAbertura);
        primaryStage.show();
    }

    public void trocaTela(Estados est) {// muda manualmente a tela
        Scene s = null;
        String titulo = "";
        switch (est) {
            case JOGO:
                if (quantJogagores == "individual") {
                    verificaSenha(new ActionEvent());

                }
                if (quantJogagores == "multiplayer") {

                    if (verificaIgualdade.size() < getQuanPino()) {
                        Alert campoVazio = new Alert(Alert.AlertType.ERROR);
                        campoVazio.setTitle("Cor repetida na senha");
                        campoVazio.setHeaderText("A senha n??o pode ter duas ou mais cores repetidas entre os pinos");
                        campoVazio.setContentText("clique em 'OK' para voltar para a tela das defini????es  ");
                        campoVazio.showAndWait();
                        telaDaSenha();
                        s = sceneSenhaTela;
                        titulo = "Defini????o de senha";
                        break;
                    }
                    verificaSenha(new ActionEvent());
                }
                gridP.add(senhaSecreta, 2, 2);

                s = sceneJogada;
                Alert info = new Alert(Alert.AlertType.INFORMATION);
                info.setTitle("Aviso");
                info.setHeaderText("Recomenda????o para o decorrer do jogo");
                info.setContentText(
                        "recomenda-se p??r essa parte do jogo em modo tela cheia para enxergar todo o hist??rico de tentativas ao decorrer do jogo");
                info.show();
                titulo = "Jogo";

                break;

            case JOGADORES2:
                caso2Jogadores();
                s = sceneSenhaNome;
                titulo = "nome, dificuldade e definir senha";
                break;
            case SENHAJOGADOR2:
                int cont = 0;
                if (tfNome.getLength() < 1 || tfNome2.getLength() < 1) {
                    Alert campoVazio = new Alert(Alert.AlertType.ERROR);
                    campoVazio.setTitle("Nome do jogador 1 e/ou nome do jogador 2 n??o informado(s)");
                    campoVazio.setHeaderText(
                            "O campo de nome dos jogadores n??o foi preenchido totalmente, esse(s) campo(s) ??/s??o obrigat??rios");
                    campoVazio.setContentText("clique em 'OK' para voltar para a tela das defini????es  ");
                    campoVazio.showAndWait();
                    versaoDemoFalse();
                    cont++;
                }
                if (getQuanTent() == null) {
                    Alert campoVazio = new Alert(Alert.AlertType.ERROR);
                    campoVazio.setTitle("N?? de tentativas n??o informado");
                    campoVazio.setHeaderText("N??o foi selecionado o n??mero de tentativas, esse campo ?? obrigat??rio");
                    campoVazio.setContentText("clique em 'OK' para voltar para a tela das defini????es  ");
                    campoVazio.showAndWait();
                    versaoDemoFalse();
                    cont++;
                }
                if (getQuanPino() == null) {
                    Alert campoVazio = new Alert(Alert.AlertType.ERROR);
                    campoVazio.setTitle("N?? de pinos n??o informado");
                    campoVazio
                            .setHeaderText("N??o foi selecionado o n??mero de pinos da senha, esse campo ?? obrigat??rio");
                    campoVazio.setContentText("clique em 'OK' para voltar para a tela das defini????es  ");
                    campoVazio.showAndWait();
                    versaoDemoFalse();
                    cont++;
                }
                if (cont > 0) {
                    versaoDemoFalse();
                    caso2Jogadores();
                    s = sceneSenhaNome;
                    titulo = "Nome, dificuldade e pinos";
                    break;
                }
                mudaQnt();
                senhaSecreta = new ColorPinLine();
                telaDaSenha();
                s = sceneSenhaTela;
                titulo = "definir senha";
                break;
            case JOGADOR1:

                caso1Jogador();

                s = sceneSenhaNome;
                titulo = "Nome e dificuldade";
                break;
            case ABERTURA:
                s = sceneAbertura;
                titulo = "Tela de abertura";
                break;
            case GANHOU:
                gridG.add(new Label(tfNome.getText() + " voc?? ganhou do(a) " + adver + ", parab??ns!!"), 1, 1);
                s = sceneGanhou;
                titulo = tfNome.getText() + " ganhou!";
                break;
            case PERDEU:
                perdedor();
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

    int contAdd = 0;

    public void perdedor() {
        if (contAdd == 0) {
            gridP.add(new Label(tfNome.getText() + " voc?? perdeu para o(a) " + adver + ", tente novamente!"), 1, 1);
            contAdd++;
        }
    }

    int confere = 0;

    public void verificaSenha(ActionEvent event) {
        ColorPinLine tentativa = linhasDeJogo.get(jogadaAndamento).getTentativa();
        BWPinLine pistas = linhasDeJogo.get(jogadaAndamento).getPista();
        int corretos = 0;
        int foraPos = 0;

        LinhaJogo l = LinhaJogo.criaLinhaJogo();
        linhasDeJogo.add(l);
        nl++;
        grid.add(linhasDeJogo.get(qualLinha), 0, nl);
        tentativasCorrente++;

        if (confere == 0) {

        }
        // Determina quantos pinos corretos e quantos fora de posi????o
        else {
            for (int i = 0; i < ColorPinLine.QTDADE; i++) {
                Pino pOrig = (Pino) senhaSecreta.getChildren().get(i);
                Pino pTent = (Pino) tentativa.getChildren().get(i);
                if (pOrig.getCor().equals(pTent.getCor())) {
                    corretos++;
                } else {
                    if (tentativa.getChildren().stream().map(p -> ((Pino) p).getCor())
                            .filter(c -> c.equals(pOrig.getCor())).count() > 0) {
                        foraPos++;
                    }
                }
            }

            int pos = 0;

            if (corretos == ColorPinLine.QTDADE) {
                ganhouOuN();
                tempoFinal = System.currentTimeMillis();
                if (demo == false) {
                    escreveRecordes((17 - jogadaAndamento), getTempo(tempoInicial, tempoFinal));
                }
                trocaTela(Estados.GANHOU);
            }
            // Liga um pino preto para cada pino correto
            while (corretos > 0) {
                pistas.setPinPreto(pos);
                pos++;
                corretos--;
            }
            // Liga um pino branco para cada pino fora de posi????o
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
                if (ganhouBool == true) {
                    trocaTela(Estados.GANHOU);
                } else {
                    trocaTela(Estados.PERDEU);
                }
                tentativasCorrente = 0;
            }
        }
        tentativa.block();
        confere++;
        jogadaAndamento++;
        linhasDeJogo.get(qualLinha).getTentativa().unblock();
        qualLinha++;
    }

    public void lerRecordes() {
        LinkedList<ClasseRecordes> linhas = new LinkedList<>();
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "\\" + "recordes.txt";
        Path path = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            while (sc.hasNext()) {
                String linha = sc.nextLine();
                if (linha.length() > 1) {
                    String[] dados = linha.split(";");
                    int pont = Integer.parseInt(dados[1]);
                    ClasseRecordes corrente = new ClasseRecordes(dados[0], pont, dados[2], dados[3]);
                    linhas.add(corrente);
                }
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        ClasseRecordes[] recordesOrdenado = linhas.toArray(new ClasseRecordes[0]);
        Arrays.sort(recordesOrdenado);

        String linha = "";
        for (int i = 0; i < recordesOrdenado.length; i++) {
            if (i >= 10) {
                break;
            }
            linha += "\n" + (i + 1) + "??       " + String.format("%-20s %-25s %-1s", recordesOrdenado[i].getPontuacao(),
                    recordesOrdenado[i].getModo(), recordesOrdenado[i].getNome());
            linha += " / " + recordesOrdenado[i].getAdversario();

        }
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Top 10 maiores pontua????es");
        dialogoInfo.setHeaderText(
                "(Partidas em modo demo n??o s??o contabilizadas)\nA pontua????o leva em conta:\nQuantidade de pinos da senha escolhido\nTempo at?? acertar\nTentativa em que se acertou\n\nE ?? exibido pelos campos de: pontua????o/modo/nome do jogador 1/advers??rio");

        dialogoInfo.setContentText(linha);
        dialogoInfo.showAndWait();
    }

    public void escreveRecordes(int quandoAcertou, int tempo) {
        try {
            File arquivo = new File("recordes.txt");
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            String linha = tfNome.getText() + ";" + ((quandoAcertou * 9) + (quantosPino.getValue() * 9) + tempo) + ";"
                    + quantJogagores + ";" + adver;

            bw.append("\n" + linha);
            bw.flush();
            bw.close();

        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public int getTempo(long tInic, long tFin) {
        long minutos = ((tFin - tInic) / 1000) / 60;
        if (minutos >= 0 && minutos <= 2) {
            return 63;
        } else if (minutos >= 3 && minutos <= 4) {
            return 55;
        } else if (minutos >= 5 && minutos <= 6) {
            return 47;
        } else if (minutos >= 7 && minutos <= 9) {
            return 40;
        } else if (minutos >= 10 && minutos <= 12) {
            return 33;
        } else if (minutos >= 13 && minutos <= 17) {
            return 27;
        } else {
            return 21;
        }

    }

    public void fecharJogo() {
        System.exit(0);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}