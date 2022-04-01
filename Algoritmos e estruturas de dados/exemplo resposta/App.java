
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
        System.out.println("número de folhas: " + b.countLeaves());
        System.out.println(b.positionsCentral());
        System.out.println(b.positionsWidth());
        System.out.println("Esquerda da raiz:" + b.getLeft(15));
        System.out.println("Esquerda de 38:" + b.getLeft(38));
        
        b.remove(15); // remocao de nodo com dois filhos, que e´ a raiz
        System.out.println("ABP sem o 15 \n"+b.strTraversalCentral());
        b.remove(2);
        System.out.println("ABP sem o 2 \n"+b.strTraversalCentral());
        
        BinarySearchTreeOfInteger copia = b.clone();
        System.out.println("Copia\n"+copia.strTraversalCentral());
        
        BinarySearchTreeOfInteger b2 = new BinarySearchTreeOfInteger();
        b2.add(50);
        b2.add(40);
        b2.add(60);
        b2.add(20);
        b2.add(45);
        System.out.println("b2 isPropria()?"+b2.isPropria());
        System.out.println("número de folhas: " + b2.countLeaves());


        BinarySearchTreeOfInteger b3 = new BinarySearchTreeOfInteger();
        b3.add(50);
        b3.add(67);
        b3.add(74);
        b3.add(89);
        b3.add(92);
        b3.add(43);
        b3.add(71);
        b3.add(28);
        b3.add(47);
        b3.add(30);
        b3.add(20);
        b3.add(80);
        System.out.println("número de folhas: " + b3.countLeaves());

     }
   
}
