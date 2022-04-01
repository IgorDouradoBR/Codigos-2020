
public class LinkedListOfInteger {

    // Classe interna Node
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }
        
        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }        
    }

    
    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;

    
    /**
     * Construtor da lista.
     */
    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }
    
    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Retorna o numero de elementos da lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }    

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element)  { // O(1)
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n; 
        }
        tail = n;
        count++;
    }
    
    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) { // O(n)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count-1)
            return tail.element;
        
        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return (aux.element);
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }    
    
    
    ////////////////////////////////////////////////////////////////
    
    
    /**
     * Insere um elemento em uma determinada posicao da lista.
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) { 
        // Verificar se index eh valido
        if (index < 0 || index > size()) 
            throw new IndexOutOfBoundsException();
        
        Node n = new Node(element);
        
        if (index==0) {// Se insercao na primeira posicao
            if (count==0)
                tail=n;
            else 
                n.next = head;
            head = n;
        } else if (index==count) {// Se insercao no final
            tail.next = n;
            tail = n;
        } else { // Se insercao no meio
            Node ant = head;
            for(int i=0; i<index-1; i++)
                ant = ant.next;
            n.next = ant.next;
            ant.next = n;
        }
        
        count++;
    }

    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
     * elemento indicado.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count - 1) {
            Integer n = tail.element;
            tail.element = element;
            return n;
        }

        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        Integer n = aux.element;
        aux.element = element;
        return n;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
         if (count == 0)
             return false;
         
         if (head.element.equals(element)) { // remocao do primeiro
             if (count==1) //so tem um elemento na lista
                 tail = null;
             head = head.next;
             count--;
             return true;
         }
         
         Node ant = head;
         Node aux = head.next;
         
         while(aux != null) {
             if (aux.element.equals(element)) {
                 if (aux == tail) { // remocao do ultimo
                     tail = ant;
                     tail.next = null;
                 }
                 else {
                     ant.next = aux.next;
                 }
                 count--;
                 return true;       
             }
             ant = ant.next;
             aux = aux.next;
         }
         
         return false;
    }

    /**
     * Remove o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        Node aux = head;
        if (index == 0) { // remocao do primeiro elemento da lista
            if (tail == head) // se tiver apenas um elemento
                tail = null;
            head = head.next;
            count--;
            return aux.element;
        }
        int c = 0;
        while (c < index - 1) {
            aux = aux.next;
            c++;
        }
        Integer element = aux.next.element;
        if (tail == aux.next) // se remocao do ultimo elemento da lista
            tail = aux;
        aux.next = aux.next.next;
        count--;
        return element;
    }
    
    /**
     * Retorna um arranjo com uma copia de um subconjunto dos elementos da
     * lista.
     *
     * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
     * incluídos
     * @param toIndex a posição final ("exclusive") dos elementos a serem
     * incluídos
     * @return um arranjo com um subconjunto da lista
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */
    public Integer[] subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size()) 
            throw new IndexOutOfBoundsException("Índices inválidos!");
        if (fromIndex > toIndex) 
            throw new IllegalArgumentException("fromIndex deve ser menor que toIndex!");

        Integer []a = new Integer[toIndex-fromIndex];
        Node aux = head;
        for (int i = 0; i < fromIndex; i++) { // para "chegar" ate a posicao fromIndex
            aux = aux.next;
        }
        int pos = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            a[pos] = aux.element;
            aux = aux.next;
            pos++;
        }
        return a;
    }
    
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento.
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Integer element) {
        Node aux = head;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Retorna true se a lista contem o elemento especificado.
     * @param element o elemento a ser testado
     * @return true se a lista contem o elemento especificado
     */
    public boolean contains(Integer element) { // O(n)
        // Implemente o algoritmo
        Node aux = head;
        while (aux!=null) {
            if (element.equals(aux.element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

}
