
public class App {
    public static void main(String[] args) {
        BinarySearchTreeOfInteger b = new BinarySearchTreeOfInteger();
        b.add(15);
        b.add(23);
        b.add(9);
        b.add(11);
        b.add(2);
        b.add(20);
        b.add(38);
        System.out.println(b.positionsCentral());
        System.out.println(b.positionsWidth());
        System.out.println("Esquerda da raiz:" + b.getLeft(15));
        System.out.println("Esquerda de 38:" + b.getLeft(38));
        
        b.remove(15); // remocao de nodo com dois filhos, que e´ a raiz
        System.out.println("ABP sem o 15 \n"+b.strTraversalCentral());
        b.remove(2);
        System.out.println("ABP sem o 2 \n"+b.strTraversalCentral());
     }
   
}
