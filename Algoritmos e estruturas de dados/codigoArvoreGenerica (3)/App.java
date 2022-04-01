
public class App {

    public static void main(String[] args) {

        GeneralTreeOfInteger arv = new GeneralTreeOfInteger();
        arv.add(1, null); // insere 1 como raiz
        arv.add(2, 1);   // insere 2 como filho de 1
        arv.add(3, 1);   // insere 3 como filho de 1
        arv.add(4, 2);   // insere 4 como filho de 2
        arv.add(5, 2);   // insere 5 como filho de 2
        arv.add(6, 2);   // insere 6 como filho de 2
        arv.add(7, 2); 

        System.out.println("Nivel do 1: " + arv.level(1));
        System.out.println("Nivel do 2: " + arv.level(2));
        System.out.println("Nivel do 6: " + arv.level(6));
        
        System.out.println("Num max filhos: " + arv.getMaxChildren());
        
        System.out.println("Caminhamento em largura:");
        System.out.println(arv.positionsWidth());

        System.out.println("Caminhamento pré-fixado:");
        System.out.println(arv.positionsPre());

        System.out.println("Caminhamento pós-fixado:");
        System.out.println(arv.positionsPos());
    }
}
