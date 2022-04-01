package Codigos;

import java.util.ArrayList;
import java.util.List;

public class EditorDeComposicao {

    List<Composicao> composicoes = new ArrayList<>();
    List<Composicao> composicoesEditadas = new ArrayList<>();

    public String listarComposicoes() {
        String aux = "";
        for (Composicao trem : composicoes) {
            
            aux += trem.toString() + "\n";
            
        }
        return aux;
    }
    

    public Boolean verificaCodigo(int cod) {
        for(int i=0; i<composicoes.size(); i++){
                if(composicoes.get(i).getIdentificador()== cod){
                    return true;
                }
            }
        return false;
    }
    
    public Composicao getComp(int ident){
        for (Composicao comp: composicoes) {
            if (comp.getIdentificador() == ident) {
                return comp;
            }
        }
        return null;
    }

    public void removerPorCodigo(int codigoRemover){
        int indice = 0;
        for (int i=0; i<composicoes.size(); i++) {
            if (composicoes.get(i).getIdentificador() == codigoRemover) {
                indice = i;
            }
        }
        composicoes.remove(indice);
    }

    public void removerPorCodigoEditadas(int codigoRemover){
        int indice = 0;
        for (int i=0; i<composicoesEditadas.size(); i++) {
            if (composicoesEditadas.get(i).getIdentificador() == codigoRemover) {
                indice = i;
            }
        }
        composicoesEditadas.remove(indice);
    }


    

    
}