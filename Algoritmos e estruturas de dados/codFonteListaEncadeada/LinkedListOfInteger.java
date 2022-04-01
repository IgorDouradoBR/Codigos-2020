
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


    public Integer[] sublist(int fromIndex, int toIndex){//O(n)
        if(fromIndex<0 || toIndex>size()){
            throw new IndexOutOfBoundsException("índices inválidos");
        }
        if (fromIndex > toIndex){
            throw new IndexOutOfBoundsException("fromIndex deve menor do que o toIndex");
        }
        Integer[] a = new Integer[toIndex-fromIndex];
        Node aux= head;
        for (int i=0; i<fromIndex; i++){
            aux= aux.next;                            
            }
        int cont=0;    
        for(int j=fromIndex; j<toIndex; j++){
                a[cont]= aux.element;
                aux=aux.next;
                cont++;
        }
        return a;
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
        // Implemente o algoritmo        
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
        // Implemente o algoritmo
        return null;
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
        if(index<0 || index>size()){
            throw new IndexOutOfBoundsException();
        }
        Integer num=0;
        if (index==0) { // remocao do primeiro
            if (count==1) //so tem um elemento na lista
                tail = null;
            num = head.element;
            head = head.next;
            count--;
            return num;
        }
        Node ant = head;
        Node aux = head.next;
         
         for(int i=0; i<size(); i++){
             if (i == index-1) {
                     num= aux.element;                                   
                     ant.next = aux.next;
                     count--;
                     return num;
                     
                 }
             if (i == index) {
                break;
             }   
                        
             
             ant = ant.next;
             aux = aux.next;
         }
        

        return -1;
    }
    
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento.
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Integer element) {
        // Implemente o algoritmo
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
