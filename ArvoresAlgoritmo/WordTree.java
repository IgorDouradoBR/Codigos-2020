import java.util.LinkedList;
import java.util.List;

public class WordTree {
     private CharNode root;

     private class CharNode {

          private char caractere;
          private CharNode father;
          private String significado;
          private List<CharNode> children;
          private boolean finalOuN;

          public CharNode(char caractere, CharNode father, boolean finalOuN) {
               this.caractere = caractere;
               this.father = father;
               this.significado = null;
               this.children = new LinkedList<>();
               this.finalOuN = finalOuN;
          }

          public int getChildrens() {
               return this.children.size();
          }

          public CharNode procuraCaractere(char caractere) {
               CharNode filho = null;
               for (int i = 0; i < this.getChildrens(); i++) {
                    if (this.children.get(i).caractere == caractere) {
                         filho = this.children.get(i);
                         break;
                    }
               }
               return filho;
          }


          public String reverte(String entra) {
               String auxiliar = "";
               for (int i = entra.length() - 1; i >= 0; i--)
                    auxiliar += entra.charAt(i);
               return auxiliar;
          }

          private String getPalavra() {
               String palavra = "";
               CharNode corrente = this;
               while (corrente.father != null) {
                    palavra += corrente.caractere;
                    corrente = corrente.father;
               }
               palavra = reverte(palavra);
               return palavra;
          }

          

     }

     public WordTree() {
          root = new CharNode(' ', null, false);
          root.significado = null;
     }

     public void addPalav(String palavra, String significado) {
          CharNode corrente = root;
          for (int i = 0; i < palavra.length(); i++) {
               CharNode auxBusca = corrente.procuraCaractere(palavra.charAt(i));
               if (auxBusca == null) {
                    auxBusca = new CharNode(palavra.charAt(i), corrente, false);
                    corrente.children.add(auxBusca);
               }
               corrente = auxBusca;
          }
          corrente.significado = significado;
          corrente.finalOuN = true;
     }

     public List<String> buscaGeral(String busca) {
          List<CharNode> contaUltima = new LinkedList<CharNode>();
          List<CharNode> listaReversora = new LinkedList<CharNode>();
          List<String> listaDePalavra = new LinkedList<>();
          CharNode corrente = root;
          for (int i = 0; i < busca.length(); i++) {
               CharNode filho = corrente.procuraCaractere(busca.charAt(i));
               if (filho == null) {
                    return null;
               } else {
                    corrente = filho;
               }
          }

          listaReversora.addAll(corrente.children);
          while (listaReversora.isEmpty() == false) {
               corrente = listaReversora.remove(listaReversora.size() - 1);
               listaReversora.addAll(corrente.children);
               if (corrente.finalOuN == true) {
                    contaUltima.add(corrente);
               }
          }

          for (int i = 0; i < contaUltima.size(); i++) {
               listaDePalavra.add(contaUltima.get(i).getPalavra());
          }
          return listaDePalavra;
     }

     public String getSignificado(String palavra) {
          CharNode temPalavra = procuraPalavra(palavra);
          if (temPalavra == null) {
               return null;
          } else {
               return temPalavra.significado;
          }
     }

     private CharNode procuraPalavra(String palavra) {
          CharNode corrente = root;
          for (int i = 0; i < palavra.length(); i++) {
               CharNode filho = corrente.procuraCaractere(palavra.charAt(i));
               if (filho != null) {
                    corrente = filho;
               } else {
                    return null;
               }
          }
          if (corrente.finalOuN == true) {
               return corrente;
          } else {
               return null;
          }
     }

     

}
