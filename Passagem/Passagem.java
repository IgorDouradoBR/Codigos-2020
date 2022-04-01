public class Passagem{
    String cpf;
    String nome;
    String assento;
    double custoPassagem;
    public Passagem(String cpf, String nome, String assento, double custoPassagem){
        this.cpf= cpf;
        this.nome= nome;
        this.assento= assento;
        this.custoPassagem= custoPassagem;
    }
    public double custoBagagem(int quant, int[] pesos){
        double cont=0;
        for(int i=0; i<quant; i++){
            cont+= pesos[i];
        }
        return cont/2;

    }

    public double defineAssento(String numAssento){
        return 5;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public double getCustoPassagem() {
        return custoPassagem;
    }

    public void setCustoPassagem(double custoPassagem) {
        this.custoPassagem = custoPassagem;
    }
    
}