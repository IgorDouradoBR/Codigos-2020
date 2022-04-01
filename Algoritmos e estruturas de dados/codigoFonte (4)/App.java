
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();

        l.add(3);
        l.add(5);
        l.add(7);
        l.add(11);
        l.add(13);
        l.add(0,1);
        l.add(4,9);
        l.add(7,15);
        
        System.out.println(l);
        System.out.println("size="+l.size());
        System.out.println("Elem da posic 1: " + l.get(1));
        System.out.println("Elem da posic 6: " + l.get(6));
        l.removeByIndex(0);
        l.removeByIndex(5);
        l.removeByIndex(2);
        
        l.add(3);
        l.add(11);
        System.out.println(l);
        l.remove(3);
        l.remove(11);
        l.remove(5);
        System.out.println("Apos remover 3,11,5: \n"+l);
        System.out.println("Contem 5?" + l.contains(5));
        System.out.println("Contem 11?" + l.contains(11));
        System.out.println("IndexOf 9?" + l.indexOf(9));
        System.out.println("IndexOf 4?" + l.indexOf(4));
        Integer num = l.set(0, 1);
        System.out.println("Numero trocado na primeira posicao:" +num);
        l.set(1, 5);
        System.out.println("Apos chamada para metodo set: \n"+l);
        System.out.println("Lista de tras para frente: \n"+l.toStringBackToFront());
        
        DoubleLinkedListOfInteger l1 = new DoubleLinkedListOfInteger();
        DoubleLinkedListOfInteger l2 = new DoubleLinkedListOfInteger();
        l1.add(3);l1.add(4);l1.add(5);l1.add(8);
        l2.add(1);l2.add(4);
        System.out.println("Maior valor comum? " + getBiggestComumValue(l1,l2));
        
        l1.removeEvenNumbers();
        System.out.println(l1);
    }
    /**
     * Metodo que recebe duas listas de inteiros por parametro, l1 e l2, e 
     * retorna o maior valor que aparece simultaneamente nas duas listas. 
     * Caso as listas nao possuam valores em comum, o metodo retorna null.
     * Nao podem ser usados os atributos da lista, isto e´, apenas os seus  
     * metodos podem ser chamados. Exemplo: 
     *      lista1 = {1,2,3,4,5,6,7,8} 
     *      lista2 = {0,2,4,6,8,10} 
     *      Integer n = getBiggestComumValue(lista1,lista2) 
     *      Conteúdo de n = 8
     *
     * @param l1 lista a ser verificada
     * @param l2 lista a ser verificada
     * @return Integer maior valor que aparece simultaneamente nas duas listas
     */

 public static Integer getBiggestComumValue (DoubleLinkedListOfInteger l1, DoubleLinkedListOfInteger l2) {
     int maior =0;
     boolean achou = false;
     // O(n(n+m)) --> classe quadrática
     // O(n*m) --> com os metodos reset e next
     l1.reset();
     for (int i=0; i<l1.size(); i++) {
         int n = l1.next(); //l1.get(i);
         if (l2.contains(n)) {
             if (achou == false) { // primeiro elemento em comum encontrado
                 maior = n;
                 achou=true;
             }
             else {
                 if (n > maior)
                     maior = n;
             }
         }
     }
     if (achou)
         return maior;
     else
         return null;
 }
   
}
