
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class GeneralTreeOfInteger {

    // Classe interna Node
    private class Node {
        // Atributos da classe Node
        public Node father;
        public Integer element;
        public LinkedList<Node> subtrees;
        // Métodos da classe Node
        public Node(Integer element) {
            father = null;
            this.element = element;
            subtrees = new LinkedList<>();
        }
        private void addSubtree(Node n) {
            n.father = this;
            subtrees.add(n);
        }
        private boolean removeSubtree(Node n) {
            n.father = null;
            return subtrees.remove(n);
        }
        public Node getSubtree(int i) {
            if ((i < 0) || (i >= subtrees.size())) {
                throw new IndexOutOfBoundsException();
            }
            return subtrees.get(i);
        }
        public int getSubtreesSize() {
            return subtrees.size();
        }
    }

    
    
    // Atributos da classe GeneralTreeOfInteger
    private Node root;
    private int count;

    
    
    // Metodos da classe GeneralTreeOfInteger
    
    public GeneralTreeOfInteger() {
        root = null;
        count = 0;
    }
    
    // Percorre a arvore procurando por elem a partir de n e
    // retorna a referencia para o nodo no qual elem esta armazenado
    private Node searchNodeRef(Integer elem, Node n) {
        if (n == null)
            return null;

        if (elem.equals(n.element)) { // visita a raiz
            return n;
        }
        else { // visita os filhos
            Node aux = null;
            int i=0;
            while ( (aux==null) && (i<n.getSubtreesSize()) ) {
                aux = searchNodeRef(elem,n.getSubtree(i));
                i++;
            }
            return aux;
        }
    }
    
    public boolean add(Integer elem, Integer father) {
        Node n = new Node(elem);
        if (father==null) { // insere elem como raiz da arvore
            if (root != null) { //se ja haviam elementos na arvores
                n.addSubtree(root);
                root.father = n;
            }
            root = n;
            count++;
            return true;
        }
        else {
            Node aux = searchNodeRef(father, root);
            if (aux == null) { // nao encontrou o father
                return false;
            }
            else { // se encontrou father, insere n como filho
                aux.addSubtree(n);
                n.father=aux;
                count++;
                return true;       
            }
        }
    }
    
    // Retorna uma lista com todos os elementos da árvore numa ordem de 
    // caminhamento em largura
        
    
    // Retorna uma lista com todos os elementos da árvore numa ordem de 
    // caminhamento pré-fixado
    public LinkedList<Integer> positionsPre() {  
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPreAux(root,lista);
        return lista;
    }  
    private void positionsPreAux(Node n, LinkedList<Integer> lista) {
        if (n != null) {
            lista.add(n.element); // visita a raiz
            for(int i=0; i<n.getSubtreesSize(); i++) { // vai visitar os filhos
                positionsPreAux(n.getSubtree(i), lista);
            }
        } 
    }

    // Retorna uma lista com todos os elementos da árvore numa ordem de 
    // caminhamento pós-fixado
    public LinkedList<Integer> positionsPos() {  
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPosAux(root,lista);
        return lista;
    }  
    private void positionsPosAux(Node n, LinkedList<Integer> lista) {
        if (n != null) {
            for(int i=0; i<n.getSubtreesSize(); i++) { // vai visitar os filhos
                positionsPosAux(n.getSubtree(i), lista);
            }
            lista.add(n.element); // visita a raiz
        }         
    }    
    
    // Retorna em que nível o elemento está 
    public int level(Integer element) {
        Node aux = searchNodeRef(element, root);
        if(aux == null) 
            throw new NoSuchElementException();
        
        int c = 0;
        while (aux != root) {
            aux = aux.father;
            c++;
        }
        return c;
    }     
    
    // Remove um galho da arvore
    public boolean removeBranch(Integer element) { 
        
        if (root == null) {
            return false;
        }
        
        if(element.equals(root.element)) {
            root = null;
            count = 0;
            return true;
        }
        
        Node aux = searchNodeRef(element, root);
        if (aux == null) { // se nao encontrou element
            return false;
        }
        Node pai = aux.father;
        pai.removeSubtree(aux);
        count = count - countNodes(aux);
        return true;
    }

    // Conta o numero de nodos da subarvore cuja raiz eh passada por parametro
    private int countNodes(Node n) {
        if ( n == null )
            return 0;
        
        int c=0;
        for(int i=0; i<n.getSubtreesSize(); i++) {
            c = c + countNodes(n.getSubtree(i));
        }
        return c+1;
        
    }    
    
    // Procura pelo elemento e retorna true se ele estiver armazenado 
    // em um nodo folha
    public boolean isExternal(Integer element) {
        Node aux = searchNodeRef(element, root);
        if (aux == null)
            return false;
        if (aux.getSubtreesSize()==0)
            return true;
        else
            return false;
    }

    // Procura pelo elemento e retorna true se ele estiver armazenado 
    // em um nodo interno
    public boolean isInternal(Integer element) {
        Node aux = searchNodeRef(element, root);
        if (aux==null)
            return false;
        if (aux==root || aux.getSubtreesSize()==0)
            return false;
        else
            return true;
    }   
    
    // Retorna quantos filhos tem, o nodo com mais filhos
    public int getMaxChildren() {
        return getMaxChildren(root,0);
    }
    private int getMaxChildren (Node n, int numFilhos) {
        if (n==null) {
            return numFilhos;
        }
        if(n.getSubtreesSize()==0) {
            return numFilhos;
        }
        
        if (n.getSubtreesSize() > numFilhos)
            numFilhos = n.getSubtreesSize();
        
        for(int i=0; i<n.getSubtreesSize(); i++) {
            numFilhos = getMaxChildren(n.getSubtree(i), numFilhos);
        }
        
        return numFilhos;
    }
}
