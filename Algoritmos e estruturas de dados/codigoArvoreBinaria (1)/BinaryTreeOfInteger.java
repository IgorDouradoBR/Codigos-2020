/**
 * Classe de arvore binaria de numeros inteiros.
 * @author Isabel H. Manssour
 */

public class BinaryTreeOfInteger {

    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        private Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    
    // Atributos
    private int count; //contagem do número de nodos
    private Node root; //referência para o nodo raiz

    
    // Metodos
    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    /**
     * Remove todos os elementos da arvore.
     */
    public void clear() {
        count = 0;
        root = null;
    }

    /**
     * Verifica se a arvore esta vazia ou nao.
     * @return true se arvore vazia e false caso contrario.
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Retorna o total de elementos da arvore.
     * @return total de elementos
     */
    public int size() {
        return count;
    }

    /**
     * Retorna o elemento armazenado na raiz da arvore.
     * @throws EmptyTreeException se arvore vazia.
     * @return elemento da raiz.
     */
    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    /**
     * Retorna quem e o elemento pai do elemento passado por parametro.
     * @param element 
     * @return pai de element
     */
    public Integer getParent(Integer element) {
        return null;
    }

    /**
     * Altera o elemento da raiz da arvore.
     * @param element a ser colocado na raiz da arvore.
     */
    public void setRoot(Integer element) {
    }


    /**
     * Insere o elemento como raiz da arvore, se a arvore estiver vazia.
     * @param element a ser inserido.
     * @return true se for feita a insercao, e false caso a arvore nao
     * estiver vazia e a insercao não for feita.
     */
    public boolean addRoot(Integer element) {
        if (root != null)
            return false;
        
        Node n = new Node(element);
        root = n;
        count++;
        return true;
    }

    /**
     * Insere element a esquerda de father. Se nao encontrar father,
     * ou se father ja tiver um filho a esquerda, element nao e´ 
     * inserido.
     * @param element a ser inserido
     * @param father
     * @return true se foi feita a inserção, e false caso contrario.
     */ 
    public boolean addLeft(Integer element, Integer father) {
        Node aux = searchNodeRef(father,root);
        if (aux == null) // se nao encontrou father
            return false;
        if (aux.left != null) // se father ja tem filho a esquerda
            return false;
        Node n = new Node(element);
        n.father = aux;
        aux.left = n;
        count++;
        return true;
    }
  
    /**
     * Insere element a direita de father. Se nao encontrar father,
     * ou se father ja tiver um filho a direita, element nao e´ 
     * inserido.
     * @param element a ser inserido
     * @param father
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addRight(Integer element, Integer father) {
        Node aux = searchNodeRef(father,root);
        if (aux == null) // se nao encontrou father
            return false;
        if (aux.right != null) // se father ja tem filho a direita
            return false;
        Node n = new Node(element);
        n.father = aux;
        aux.right = n;
        count++;
        return true;
    }

    /**
     * Verifica se element esta ou nao armazenado na arvore.
     * @param element
     * @return true se element estiver na arvore, false caso contrario.
     */
    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    // Metodo privado que procura por element a partir de target
    // e retorna a referencia para o nodo no qual element esta
    // armazenado.
    private Node searchNodeRef(Integer element, Node target) {
        if (target == null)
            return null;
        if (element.equals(target.element)) // visita a raiz
            return target;
        Node aux = searchNodeRef(element, target.left); // procura na subarv da esq
        if (aux == null)
            aux = searchNodeRef(element, target.right); // procura na subarv da dir
        return aux;
    }
    
    /**
     * Remove um galho da arvore a partir do elemento recebido por parametro.
     * @param element raiz da subarvore a ser removida.
     * @return true se for feita a remocao.
     */
    public boolean removeBranch(Integer element) {
        return false;
    }

    // Conta o numero de nodos a partir de "n"
    private int count(Node n) {
        return 0;
    }
    
    /**
     * Troca um elemento da arvore pelo elemento passado por parametro.
     * @param old elemento a ser encontrado para ser substituido.
     * @param element elemento a ser colocado no lugar de old.
     * @return o elemento que foi substituido.
     */
    public Integer set(Integer old, Integer element) {
        return null;
    }
    
    /**
     * Retorna true se element esta armazenado em um nodo externo.
     * @param element
     * @return true se element esta em um nodo externo.
     */     
    public boolean isExternal(Integer element) {
        return false;
    }

    /**
     * Retorna true se element esta armazenado em um nodo interno.
     * @param element
     * @return true se element esta em um nodo interno.
     */     
    public boolean isInternal(Integer element) {
        return false;
    }

    /**
     * Retorna true se element tem um filho a esquerda.
     * @param element
     * @return true se element tem um filho a esquerda, false caso contrario.
     */    
    public boolean hasLeft(Integer element) {
        return false;
    }

    /**
     * Retorna true se element tem um filho a direita.
     * @param element
     * @return true se element tem um filho a direita, false caso contrario.
     */
    public boolean hasRight(Integer element) {
        return false;
    }

    /**
     * Retorna o filho a esquerda de element.
     * @param element
     * @return o filho a esquerda, ou null se nao tiver filho a esquerda.
     */
    public Integer getLeft(Integer element) {
        return null;
    }

    /**
     * Retorna o filho a direita de element.
     * @param element
     * @return o filho a direita, ou null se nao tiver filho a direita.
     */    
    public Integer getRight(Integer element) {
        return null;
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do 
     * caminhamento pre-fixado.
     * @return lista com todos os elementos da arvore.
     */
    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }
    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            res.add(n.element);// visita raiz
            positionsPreAux(n.left,res); // visita subarvore da esquerda
            positionsPreAux(n.right,res); // visita subarvore da direita
        }
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do 
     * caminhamento pos-fixado.
     * @return lista com todos os elementos da arvore.
     */    
    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }
    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsPosAux(n.left,res); // visita subarvore da esquerda
            positionsPosAux(n.right,res); // visita subarvore da direita
            res.add(n.element);// visita raiz            
        }        
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do 
     * caminhamento central.
     * @return lista com todos os elementos da arvore.
     */    
    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }
    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
         if (n != null) {
            positionsCentralAux(n.left,res); // visita subarvore da esquerda
            res.add(n.element);// visita raiz  
            positionsCentralAux(n.right,res); // visita subarvore da direita          
        }       
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do 
     * caminhamento em largura (por niveis).
     * @return lista com todos os elementos da arvore.
     */    
    public LinkedListOfInteger positionsWidth() {

        return null;
    }

    /**
     * Retorna uma String com todos os elementos da arvore na ordem do 
     * caminhamento central.
     * @return String com todos os elementos da arvore.
     */
    public String strPositionsCentral() {
        return strPositionsCentral(root);
    }
    private String strPositionsCentral(Node n) {
        String s = "";

        return s;
    }
   




    public int height() {
        return -1;
    }

 
    public int level(Integer element) {
        return -1;
    }

  
}
