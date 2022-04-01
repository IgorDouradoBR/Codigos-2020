import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class App extends Application {
    private ColorPinLine senhaSecreta;
    private ColorPinLine tentativa;
    private BWPinLine pistas;
    private static Random aleatorio = new Random();
    private static final Cor[] CORES = Cor.values();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Button Experiment 1");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        
        
        // Define uma senha para a senha secreta
        senhaSecreta = new ColorPinLine();
        List<Cor> senha = Arrays.asList(getRandomLetter(),getRandomLetter(),getRandomLetter(),getRandomLetter(),getRandomLetter(),getRandomLetter());
        for(int i=0;i<senha.size();i++){
            senhaSecreta.setCor(senha.get(i),i);
        }
        senhaSecreta.block();
        // O campo de tentativas começa todo em vermelho
        tentativa = new ColorPinLine();
        // Define o campo de pistas todo vazio
        pistas = new BWPinLine();
        for(int i=0;i<pistas.getChildren().size();i++){
            pistas.setEmpty(i);
        }
        Button but = new Button("GetColors");
        but.setOnAction(e->verificaSenha(e));
        grid.add(senhaSecreta,0,1);
        grid.add(tentativa,0,2);
        grid.add(pistas,1,2);
        grid.add(but,0,3);
        Scene scene = new Scene(grid, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Cor getRandomLetter()  {
        return CORES[aleatorio.nextInt(CORES.length)];
      }

    public void verificaSenha(ActionEvent event){
        int corretos = 0;
        int foraPos = 0;
        // Determina quantos pinos corretos e quantos fora de posição
        for(int i=0;i<senhaSecreta.getChildren().size();i++){
            Pino pOrig = (Pino)senhaSecreta.getChildren().get(i);
            Pino pTent = (Pino)tentativa.getChildren().get(i); 
            if (pOrig.getCor().equals(pTent.getCor())){
                corretos++;
            }else{
                if (tentativa.getChildren().stream()
                    .map(p->((Pino)p).getCor())
                    .filter(c->c.equals(pOrig.getCor()))
                    .count() > 0){
                        foraPos++;
                    }
            }
        }
        // Acerta o registrador de pistas conforme o numero de corretos e fora de posição
        System.out.println(corretos+", "+foraPos);
        if(corretos==6){
            Alert a = new Alert(AlertType.INFORMATION, "Você venceu");
            a.showAndWait();
        }
        int pos = 0;
        // Liga um pino preto para cada pino correto
        while(corretos > 0){
            pistas.setPinPreto(pos);
            System.out.println("Preto");
            pos++;
            corretos--;
        }
        // Liga um pino branco para cada pino fora de posição
        while(foraPos > 0){
            pistas.setPinBranco(pos);
            System.out.println("Branco");
            pos++;
            foraPos--;
        }
        // Desabilita os pinos restantes
        while(pos < pistas.getChildren().size()){
            pistas.setEmpty(pos);
            pos++;
        }
        
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}