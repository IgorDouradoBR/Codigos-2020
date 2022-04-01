

public class BinarySearchTreeOfInteger {

    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        public Integer element;

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

    public BinarySearchTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void add(Integer element) {
        root = add(root, element, null);
        count++;
    }
    private Node add(Node n, Integer e, Node father) {
        if (n==null) {
            Node aux = new Node(e);
            aux.father = father;
            return aux;
        }
        if (n.element.compareTo(e)<0)
            n.right = add(n.right, e, n);
        else
            n.left = add(n.left, e, n);
        return n;
    }

    public Integer getLeft(Integer element) {
        Node aux = searchNodeRef(element, root);
        if (aux==null)
            return null;
        if (aux.left==null)
            return null;
        return aux.left.element;
    }

    public Integer getRight(Integer element) {
        return null;
    }

    public Integer getParent(Integer element) {
        return null;
    }

    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            res.add(n.element); //Visita o nodo
            positionsPreAux(n.left, res); //Visita a subárvore da esquerda
            positionsPreAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsPosAux(n.left, res); //Visita a subárvore da esquerda
            positionsPosAux(n.right, res); //Visita a subárvore da direita
            res.add(n.element); //Visita o nodo
        }
    }

    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subárvore da esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsWidth() {
        Queue<Node> fila = new Queue<>();
        Node atual = null;
        LinkedListOfInteger res = new LinkedListOfInteger();
        if (root != null) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                if (atual.left != null) {
                    fila.enqueue(atual.left);
                }
                if (atual.right != null) {
                    fila.enqueue(atual.right);
                }
                res.add(atual.element);
            }
        }
        return res;
    }

    public String strTraversalCentral() {
        return strTraversalCentral(root);
    }

    private String strTraversalCentral(Node n) {
        String s = "";
        
        if (n != null) {
            s = strTraversalCentral(n.left) +
                    n.element.toString() + "\n" +
                    strTraversalCentral(n.right);
        }
        
        return s;
    }

    public boolean contains(Integer element) {
        Node aux = searchNodeRef(element,root);
        return aux != null;
    }

    private Node searchNodeRef(Integer element, Node target) {
        if (element==null || target==null)
            return null;
        
        int r = target.element.compareTo(element);
        
        if (r==0)
            return target;
        else if (r>0)
            return searchNodeRef(element, target.left);
        else
            return searchNodeRef(element, target.right);
    }

    public boolean remove(Integer element) {
        if (element == null || root == null)
            return false;
        Node aux = searchNodeRef(element,root);
        if (aux == null)
            return false;
        remove(aux);
        count--;
        return true;
    }

    private void remove(Node n) {
        Node pai = n.father;
        
        if (n.left==null && n.right==null) { // remocao de nodo folha
            if (n == root) { // se so´ tinha um elemento na arvore
                root = null;
            }
            else {
                if (pai.left == n) 
                    pai.left = null;
                else 
                    pai.right = null;
            }
        }
        
        else if (n.left!=null && n.right!=null) { // remocao de nodo com dois filhos
            // Troca o elemento pelo menor elemento da subarvore da direita
            Node menor = smallest(n.right);
            n.element = menor.element;
            remove(menor);
        }
        
        else if (n.left == null) { // esquerda nula e direita nao
            if (n == root) {    // se for remocao da raiz
                root = n.right;
                root.father = null;
            }
            else {
                if (pai.left == n)
                    pai.left = n.right;
                else
                    pai.right = n.right;
                n.right.father = pai;
            }
            
        }
        
        else { // direita nula e esquerda nao
            if (n == root) {    // se for remocao da raiz
                root = n.left;
                root.father = null;
            }
            else {
                if (pai.left == n)
                    pai.left = n.left;
                else
                    pai.right = n.left;
                n.left.father = pai;
            }            
        }
    }
    
    private Node smallest(Node n) {
        if (n == null)
            return null;
        if (n.left == null)
            return n;
        return smallest(n.left);
    }

    public Integer set(Integer old, Integer element) {
        return null;
    }

    /**
     * Verifica se o elemento recebido por parametro esta armazenado em um
     * nodo folha.
     * @param element a ser procurado
     * @return true se element estiver em um nodo folha, e false caso contrario
     */
    public boolean isExternal(Integer element) {
        Node n = searchNodeRef(element, root);
        if (n!=null) {
            if (n.left==null && n.right==null)
                return true;
        }
        return false;
    }

    public boolean isInternal(Integer element) {
        return false;
    }
}
