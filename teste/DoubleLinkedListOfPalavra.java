
public class DoubleLinkedListOfPalavra {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Contador do numero de elementos da lista.
    private double count;
    private int numeroOcorrencias = 0;

     private class Node {
        public Palavra element;
        public Node next;
        public Node prev;
        public Node(Palavra e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfPalavra() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Palavra element) {
        // Primeiro: cria o nodo
        Node n = new Node(element);
        // Depois "gruda" o nodo criado na lista
        n.next = trailer;
        n.prev = trailer.prev;
        // Ajustar os encadeamentos para o novo nodo
        trailer.prev.next = n;
        trailer.prev = n;
        // Por fim, atualiza o contador
        count++;
    }

    
    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Palavra element) throws IndexOutOfBoundsException {
         if (index < 0 || index > count ) // indice invalido
        	throw new IndexOutOfBoundsException();
         if (index==count) {
             add(element);
         }
         else {
             Node aux = getNodeRef(index);
             Node n = new Node(element);
             n.next = aux;
             n.prev = aux.prev;
             aux.prev.next = n;
             aux.prev = n;
             count++;
         }
    }
    
    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Palavra element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    
    /**
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Palavra removeByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }        
        // "Caminhar" até a posição index
        Node aux = this.getNodeRef(index);
        Palavra num = aux.element;
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;
        return num;
    }
    
    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Palavra element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    public boolean containsString(Palavra element) {
        String auxiliar = element.getPalavra();
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.getPalavra().equals(auxiliar)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    
    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Palavra get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeRef(index);
        return aux.element;
    }
    
    // Metodo que retorna a referencia para o nodo
    // da posicao index
    private Node getNodeRef(int index) {
        Node aux = null;
        if (index < count/2) {
            aux = header.next;
            for(int i=0; i<index; i++)
                aux = aux.next;
        }
        else {
            aux = trailer.prev;
            for (double i=count-1; i>index; i--)
                aux = aux.prev;
        }
        return aux;
    }
    
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Palavra element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }
    
   /**
    * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
    * @param index a posicao da lista
    * @param element o elemento a ser armazenado na lista
    * @return o elemento armazenado anteriormente na posicao da lista
    * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
    */
    public Palavra set(int index, Palavra element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeRef(index);
        Palavra num = aux.element;
        aux.element = element;
        return num;
    }
    
    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }    
        
    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public double size() {
        return count;
    }
    
    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }
        
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }    
    
    public String toStringBackToFront() {
        StringBuilder s = new StringBuilder();
        Node aux = trailer.prev;
        for (int i=0; i<count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.prev;
        }
        return s.toString();
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
    public Palavra[] subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size())
            throw new IndexOutOfBoundsException();
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();
        
        Palavra a[] = new Palavra[toIndex-fromIndex];
        
        Node aux = header.next;
       
        for(int i=0; i<fromIndex; i++) // "caminha" ate posicao fromIndex
            aux = aux.next;
        
        for(int i=0; i<(toIndex-fromIndex); i++) {
            a[i] = aux.element;
            aux = aux.next;
        }
        
        return a;
    }  
    public int getNumeroOcorrencias() {
        return numeroOcorrencias;
    }

    public void setNumeroOcorrencias() {
        numeroOcorrencias += 1;
    }  
}
