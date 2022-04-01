
public class App {
    public static void main(String[] args){

        Caixa caixa= new Caixa("E14", 45);
        caixa.setVolume(14, 16, 22);
        System.out.println(caixa.toString());
        Cilindrica cilindrica= new Cilindrica("T45", 23);
        cilindrica.setVolume(17, 51);
        System.out.println(cilindrica.toString());
        Conica conica= new Conica("W19", 43);
        conica.setVolume(9, 21);
        System.out.println(conica.toString());
        TroncoDeCone tronco= new TroncoDeCone("P32", 31);
        tronco.setVolume(12, 19, 26);
        System.out.println(tronco.toString());

    }
}