import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AcmeAir extends Application {
    private TextField tfName;
    private ComboBox<String> cbIda,cbVolta;
    private ComboBox<Integer> cbQtdadeAssentos;
    private ToggleGroup rbGIdaVolta;
    private RadioButton rbSoIda, rbIdaVolta;
    private DatePicker dpIda,dpVolta;
    
    @Override
    public void start(Stage primaryStage) {
        // Define o grid basico
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Define o título do form
        Text tfTitulo = new Text("Selecione sua busca");
        tfTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        tfTitulo.setFill(Color.GREEN);
        grid.add(tfTitulo, 0, 0);    
        
        
        // Define o painel da esquerda
        GridPane leftGrid = new GridPane();
        leftGrid.setAlignment(Pos.BASELINE_LEFT);
        leftGrid.setHgap(4);
        leftGrid.setVgap(6);
        leftGrid.add(new Label("Passageiro:"), 0, 1);
         tfName = new TextField();
        leftGrid.add(tfName, 1, 1);        
        leftGrid.add(new Label("De:"), 0, 2);
        cbIda = new ComboBox<String>(FlightData.getCidadesAtendidas());
        leftGrid.add(cbIda, 1, 2);        
        leftGrid.add(new Label("Para:"), 0, 3);
        cbVolta = new ComboBox<String>(FlightData.getCidadesAtendidas());
        
        
        leftGrid.add(cbVolta, 1, 3);        
        leftGrid.add(new Label("Assentos:"), 0, 4);
        cbQtdadeAssentos = new ComboBox<Integer>(FlightData.getQtdadeAssentos());
        leftGrid.add(cbQtdadeAssentos, 1, 4);        
        
        // Define o painel da direita
        GridPane rightGrid = new GridPane();
        rightGrid.setAlignment(Pos.BASELINE_LEFT);
        rightGrid.setHgap(4);
        rightGrid.setVgap(6);
        rbGIdaVolta = new ToggleGroup();
        rbSoIda = new RadioButton("Somente ida");
        rbSoIda.setToggleGroup(rbGIdaVolta);
        rbIdaVolta = new RadioButton("Ida e volta");
        rbIdaVolta.setToggleGroup(rbGIdaVolta);
        rbIdaVolta.setSelected(true);
        rightGrid.add(rbSoIda,0,0);
        rightGrid.add(rbIdaVolta,0,1);

        rightGrid.add(new Label("Data ida:"), 0, 2);
        dpIda = new DatePicker();
        rightGrid.add(dpIda,1,2); 
        rightGrid.add(new Label("Data volta:"), 0, 3);
        dpVolta = new DatePicker();
        rightGrid.add(dpVolta,1,3); 

        // Adiciona os paineis da direita e da esquerda no grid básico
        grid.add(leftGrid,0,2);
        grid.add(rightGrid,1,2);
        
        // Define os botoes
        Button btSearch = new Button();
        btSearch.setText("Pesquisar");
        btSearch.setOnAction(e->this.trataBotaoPesquisar(e));
        Button btClose = new Button();
        btClose.setText("Encerrar");
        btClose.setOnAction(e -> Platform.exit());
        // Agrupa os botoes em um HBox
        HBox hbBtn = new HBox(30);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btSearch);
        hbBtn.getChildren().add(btClose);
        grid.add(hbBtn, 1, 4);
        
        
        StackPane root = new StackPane();
        root.getChildren().add(grid);
        
        
        Scene scene = new Scene(root, 800, 350);
        primaryStage.setTitle("AcmeAir");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void trataBotaoPesquisar(ActionEvent event){
        System.out.println("Evento pesquisar disparado !!");
        System.out.println(cbQtdadeAssentos.getValue());

    }

    public static void main(String[] args) {
        launch(args);
    }
}

