//PROFESSORA, EU FIZ O METODO getBiggestComumValue COMO PARTE DA OUTRA CLASSE, A DOUBLELINKEDLIST
//AÍ FIZ UMA LÓGICA PARA ELE SER CHAMADO AQUI
public class App {
    public static void imprimir(Integer[] vetor)
    {
        for(int i=0; i<vetor.length; i++) {// dá o tamanho do vetor
            System.out.println(vetor[i]);
        }
    }

    

    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        DoubleLinkedListOfInteger l2 = new DoubleLinkedListOfInteger();
        DoubleLinkedListOfInteger l3 = new DoubleLinkedListOfInteger();


        
        l.add(1);
        l.add(1);
        l.add(2);
        l.add(2);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(25);
        l.add(6);
        l.add(7);
        l.add(7);
        l.add(14);

        l.add(14);
        l.add(14);
        l.add(25);
        l.add(26);
        l.add(72);
        l.add(-20);
        l.add(-25);
        l.add(-15);
        l.add(1);
        l.add(1);

        l.add(14);

        l2.add(-44);
        l2.add(-45);
        l2.add(-56);
        l2.add(-20);
        l2.add(-25);
        l2.add(-15);
        l2.add(1);
        l2.add(199);
        l2.add(102);
        l2.add(22);
        l2.add(132);
        l2.add(132);
        l2.add(132);
        l2.add(2);
        
        l2.add(2);

        l2.add(2);
        l2.add(12);
        l2.add(22);
        l2.add(-25);
        l2.add(21);
        l2.add(42);

        
        l3.add(23);
        l3.add(23);
        l3.add(2);
        l3.add(13);
        l3.add(23);
        l3.add(23);
        l3.add(11);













        
       
        
        System.out.println("\n"+ l.countOccurrences(1)+"\n");
        l.unique();
        System.out.println("\n"+ l);
        System.out.println("\n maior número em comum nas duas listas "+ l.getBiggestComumValue(l,l2) +"\n");
        l2.removeEvenNumbers();
        System.out.println("\n"+ l2);
        System.out.println("\n"+ l3.lastIndexOf(23));





        

    }
}
