import javafx.scene.layout.HBox;

public class LinhaJogo extends HBox{
    private ColorPinLine tentativa;
    private BWPinLine pista;

    public LinhaJogo(){
        super(10);
        tentativa = new ColorPinLine();
        tentativa.block();
        pista = new BWPinLine();
        for (int i = 0; i < pista.getChildren().size(); i++) {
            pista.setEmpty(i);
        }

        this.getChildren().add(tentativa);
        this.getChildren().add(pista);
    }

    public ColorPinLine getTentativa(){
        return tentativa;
    }

    public BWPinLine getPista(){
        return pista;
    }

    public static LinhaJogo criaLinhaJogo(){
        return new LinhaJogo();
    }
}