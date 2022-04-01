public class App{
    public static void main(String args[]){
        ElementoDeExpressao exp;
        exp = Calculadora.avalia("5+4-2+3");
        System.out.println(exp.toString()+" = "+exp.valor());
        exp = Calculadora.avalia("5+4-2+3-8+4");
        System.out.println(exp.toString()+" = "+exp.valor());
    }
}