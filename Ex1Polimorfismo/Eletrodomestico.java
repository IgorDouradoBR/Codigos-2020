
public class Eletrodomestico extends Produto{
    private boolean volts = false;
    private int voltagem= 0;
    public Eletrodomestico(int codigo, String descricao, double preco, int voltagem){
        super(codigo, descricao, preco);
        this.voltagem= voltagem;
        if(getVoltagem()==220){
            setVolts(true);
        }
    }

    

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public boolean isVolts() {
        return volts;
    }

    public void setVolts(boolean volts) {
        this.volts = volts;
    }

    

}