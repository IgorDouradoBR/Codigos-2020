/**
 * Classe App.
 * @author Isabel H. Manssour
 */

public class App {

    public static void main(String[] args) {
        BinaryTreeOfInteger b = new BinaryTreeOfInteger();
        b.addRoot(1);
        b.addLeft(2, 1);
        b.addRight(3, 1);
        b.addRight(0, 3);
        b.addLeft(4, 2);
        b.addRight(5, 2);
        b.addRight(6, 5);
        b.addRight(7, 6);
        

        System.out.println("2 esta em um nodo folha: " + b.isExternal(2));
        System.out.println("7 esta em um nodo folha: " + b.isExternal(7));
        System.out.println("2 esta em um nodo interno: " + b.isInternal(2));
        System.out.println("7 esta em um nodo interno: " + b.isInternal(7));
        System.out.println("6 esta em um nodo interno: " + b.isInternal(6));
        System.out.println("1 esta em um nodo interno: " + b.isInternal(1));
        System.out.println("0 esta em um nodo interno: " + b.isInternal(0));
        System.out.println("...");
        System.out.println("3 tem filho a direita: " + b.hasRight(3));
        System.out.println("3 tem filho a esqurda: " + b.hasLeft(3));
    


        b.removeBranch(2);
        System.out.println("Width apos remocao: \n" + b.positionsWidth());
        b.set(0, 8);
        b.set(1, 12);
        System.out.println("..."+b.set(3, 5));
        System.out.println("Width apos remocao: \n" + b.positionsWidth());
    }
}
