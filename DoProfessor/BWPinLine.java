import java.util.List;
import java.util.stream.Collectors;

import javafx.scene.layout.HBox;

public class BWPinLine extends HBox {
    public BWPinLine(){
        for(int i=0;i<ColorPinLine.QTDADE;i++){
            this.getChildren().add(Pino.criaPinoPretoBranco());
        }
    }

    public List<Cor> getColors(){
        return this.getChildren()
             .stream()
             .map(n->((Pino)n).getCor())
             .collect(Collectors.toList());
    }  
    
    private void setPin(Cor cor,int index){
        if (index<0 || index>=ColorPinLine.QTDADE){
            throw new IllegalArgumentException("Indice de pino invalido");
        }else{
            Pino p = (Pino)(this.getChildren().get(index));
            if (p.getCor().equals(cor)){
                p.setText("O");
                return;
            }else{
                p.changeColor();
                p.setText("O");
            }
        }
    }

    public void setPinPreto(int index){
        setPin(Cor.PRETO,index);
    }

    public void setPinBranco(int index){
        setPin(Cor.BRANCO,index);
    }

    public void setEmpty(int index){
        setPin(Cor.BRANCO,index);
        Pino p = (Pino)(this.getChildren().get(index));
        p.setText(" ");
        
    }
}