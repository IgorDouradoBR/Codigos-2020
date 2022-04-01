
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
    }
}
