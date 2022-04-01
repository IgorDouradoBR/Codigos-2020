import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class ColorPinLine extends HBox{
    public static final int QTDADE = 6;

    public ColorPinLine(){
        for(int i=0;i<QTDADE;i++){
            this.getChildren().add(Pino.criaPinoColorido());
        }
    }

    public List<Cor> getColors(){
        return this.getChildren()
             .stream()
             .map(n->((Pino)n).getCor())
             .collect(Collectors.toList());
    }

    public void setCor(Cor cor,int pos){
        ObservableList<Node> pinos = this.getChildren();
        if (pos < 0 || pos>=pinos.size()){
            throw new IllegalArgumentException("Posição ilegal!");
        }else{
            Pino pino = (Pino)pinos.get(pos);
            pino.setCor(cor);
        }
    }

    public void block(){
        this.getChildren().forEach(p->((Pino)(p)).block());
    }

    public void unblock(){
        this.getChildren().forEach(p->((Pino)(p)).unblock());
    }

}