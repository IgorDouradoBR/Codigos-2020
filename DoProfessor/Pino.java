import javafx.event.ActionEvent;
import javafx.scene.control.Button;


public class Pino extends Button {
    private Cor cor;
    private boolean blocked;

    private Pino(Cor cor,boolean blocked){
        super("O");
        this.blocked = blocked;
        this.cor = cor;
        this.setStyle(cor.getStyle());
        this.setOnAction(e->eventChangeColor(e));
    }

    public static Pino criaPinoPretoBranco(){
        return new Pino(Cor.BRANCO,true);
    }

    public static Pino criaPinoColorido(){
        return new Pino(Cor.VERMELHO,false);
    }

    public Cor getCor(){
        return cor;
    }

    public void block(){
        blocked = true;
    }

    public void unblock(){
        blocked = false;
    }

    public void setCor(Cor c){
        // Essa operação só é válida para pinos coloridos
        // Para os P&B use changeColor somente
        if (cor == Cor.PRETO || cor == Cor.BRANCO){
            throw new UnsupportedOperationException();
        }
        cor = c;
        this.setStyle(cor.getStyle());
    }

    public void changeColor(){
        switch(cor){
            case VERMELHO:
                cor = Cor.VERDE;
                break;
            case VERDE:
                cor = Cor.AMARELO;
                break;
            case AMARELO:
                cor = Cor.AZUL;
                break;
            case AZUL:
                cor = Cor.ROXO;
                break;
            case ROXO:
                cor = Cor.LARANJA;
                break;
            case LARANJA:
                cor = Cor.CINZA;
				break;
            case CINZA:
                cor = Cor.MARROM;
				break;
            case MARROM:
                cor = Cor.OLIVA;
				break;
            case OLIVA:
                cor = Cor.ROSA;
				break;
            case ROSA:
                cor = Cor.VERMELHO;
				break;
            case BRANCO:
                cor = Cor.PRETO;
				break;
            case PRETO:
                cor = Cor.BRANCO;
				break;
			default:
				break;
        }
        this.setStyle(cor.getStyle());
    }

    public void eventChangeColor(ActionEvent event){
        if (blocked){
            return;
        }
        Pino p = (Pino)event.getSource();
        p.changeColor();
    }
}