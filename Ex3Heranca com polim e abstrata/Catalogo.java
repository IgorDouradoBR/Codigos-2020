import java.util.ArrayList;
public class Catalogo {
    ArrayList<Modelo> catal = new ArrayList<>();
    public void catalogoo(){       
        Cilindrica c1 = new Cilindrica("", 0);
        catal.add(c1);
        Conica c2 = new Conica("", 0);
        catal.add(c2);
        c2.setVolume(5, 6);
        Caixa c3 = new Caixa("", 0);
        catal.add(c3);
        c3.setVolume(2, 11, 7);
        TroncoDeCone c4 = new TroncoDeCone("", 0);
        c4.setVolume(3, 4, 4);
        catal.add(c4);
        arquivoTexto();
    }
    public void cadastra(Modelo embalagem, double volume, String nome){
        Modelo novaEmbalagem = embalagem;
        novaEmbalagem.setVolume(volume);
        novaEmbalagem.setNome(nome);
        catal.add(novaEmbalagem);       
    }

    public void arquivoTexto(){
        Modelo m1 = new Modelo("E14R", 25.0);
        Modelo m2 = new Modelo("E24R", 43.0);
        cadastra(m1, 145, "cúbico");
        cadastra(m2, 179, "Esférica");
    }

    public boolean diferenciada(int index){
        if (catal.get(index) instanceof TroncoDeCone ||catal.get(index) instanceof Conica){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        catalogoo();
        String aux = "";
        for (int i=0; i<catal.size();i++){
            
            if(catal.get(i) instanceof TroncoDeCone ||catal.get(i) instanceof Conica ||catal.get(i) instanceof Caixa||catal.get(i) instanceof Cilindrica){
                aux+= "\n Modelo: "+ catal.get(i).getClass().getName();
            }
            else {
                aux+= "\n Modelo: "+ catal.get(i).getNome();
            }
            aux += "\n Volume: "+ catal.get(i).getVolume()+ "\n";
            if(catal.get(i) instanceof TroncoDeCone){
                aux += "\n o tempo de produção da embalagem com carateristica de tronco de cone é maior \n";
            }            
        }
        return aux; 
    }
    
}