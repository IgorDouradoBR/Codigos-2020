

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class WordTree {
     private CharNode root;
     private int totalNodes = 0;
     private int totalWords = 0;


     private class CharNode {
          private char character;
          private String significado;
          private boolean isFinal;
          private CharNode father;
          private List<CharNode> children;

          public CharNode(char character) {
               this.character = character;
               this.significado = null;
               this.isFinal = false;
               this.father = null;
               this.children = new ArrayList<>();
          }

          public CharNode(char character, boolean isFinal, CharNode father) {
            this.character = character;
            this.significado = null;
            this.isFinal = isFinal;
            this.father = father;
            this.children = new ArrayList<>();
          }

          /**
           * Adiciona um filho (caracter) no nodo. Não pode aceitar caracteres repetidos.
           * @param character - caracter a ser adicionado
           * @param isfinal - se é final da palavra ou não
           */
          public CharNode addChild (char character, boolean isfinal) {
            return null;
          }

          public int getNumberOfChildren () {
            return this.children.size();
          }

          public CharNode getChild (int index) {
            return null;
          }

          /**
           * Obtém a palavra correspondente a este nodo, subindo até a raiz da árvore
           * @return a palavra
           */
          private String getWord() {
               StringBuilder palavra = new StringBuilder();
               CharNode noAtual = this;
               while(noAtual.father != null){
                    palavra.append(noAtual.character);
                    noAtual = noAtual.father;
               }
               return palavra.reverse().toString();
          }

          /**
           * Encontra e retorna o nodo que tem determinado caracter.
           * @param character - caracter a ser encontrado.
           */
          public CharNode findChildChar (char character) {
               CharNode filho = null;
               for(int i = 0; i < this.getNumberOfChildren(); i++){
                    if(this.children.get(i).character == character){
                         filho = this.children.get(i);
                         break;
                    }
               }
               return filho;
          }

     }

     // construtor
     public WordTree() {
          root = new CharNode('\0', false, null);
          root.significado = null;
     }

     public int getTotalWords() {
        return totalWords;
     }

     public int getTotalNodes() {
        return totalNodes;
     }

     /**
      *Adiciona palavra na estrutura em árvore
      *@param word
      */
     public void addWord(String word, String significado) {
          CharNode noAtual = root;
          for(int i = 0; i < word.length(); i++){
               CharNode novoNo = noAtual.findChildChar(word.charAt(i));
               if(novoNo == null){
                    novoNo = new CharNode(word.charAt(i), false, noAtual);
                    noAtual.children.add(novoNo);
                    totalNodes ++;
               }
               noAtual = novoNo;
          }
          noAtual.isFinal = true;
          noAtual.significado = significado;
          totalWords ++;
     }

     /**
      * Vai descendo na árvore até onde conseguir encontrar a palavra
      * @param word
      * @return o nodo final encontrado
      */
     private CharNode findCharNodeForWord(String word) {
          CharNode noAtual = root;
          for(int i = 0; i < word.length(); i++){
               CharNode noFilho = noAtual.findChildChar(word.charAt(i));
               if(noFilho == null)
                    return null;
               else
                    noAtual = noFilho;
          }
          if(noAtual.isFinal)
               return noAtual;
          else
               return null;
     }

     public String getSignificado(String word){
          CharNode resultado = findCharNodeForWord(word);
          if(resultado != null)
               return resultado.significado;
          else
               return null;
     }

     /**
      * Percorre a árvore e retorna uma lista com as palavras iniciadas pelo prefixo dado.
      * Tipicamente, um método recursivo.
      * @param prefix
      */
     public List<String> searchAll(String prefix) {
          if(prefix.length()<2){
               System.out.println("para pesquisar digite 2 ou mais caracteres");
               return null;
          }
          else{
          CharNode noAtual = root;
          List<CharNode> nosFinais = new ArrayList<CharNode>();
          Stack<CharNode> pilha = new Stack<CharNode>();
          List<String> resultado = new ArrayList<>();

          for(int i = 0; i < prefix.length(); i++){
               CharNode noFilho = noAtual.findChildChar(prefix.charAt(i));
               if(noFilho == null)
                    return null;
               else
                    noAtual = noFilho;
          }

          pilha.addAll(noAtual.children);
          while(!pilha.isEmpty()){
               noAtual = pilha.pop();
               pilha.addAll(noAtual.children);
               if(noAtual.isFinal)
                    nosFinais.add(noAtual);
          }

          for(CharNode no : nosFinais)
               resultado.add(no.getWord());
          Collections.sort(resultado);
          return resultado;
     }
     }
}





