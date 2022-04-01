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
        
        System.out.println("Pre: \n" + b.positionsPre().toString());
        System.out.println("Central: \n" + b.positionsCentral().toString());
    }
}
