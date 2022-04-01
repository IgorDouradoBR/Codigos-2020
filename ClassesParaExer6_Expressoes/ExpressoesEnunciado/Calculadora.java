public class Calculadora {
    private static final String regEx = "(?<=\\+)|(?=\\+)|(?<=\\-)|(?=\\-)";
    // Por simplicidade as expressoes começam sempre por um numero positivo
    // e todos os operadores são binarios
	public static ElementoDeExpressao avalia(String expression) {
        String tokens[] = expression.split(regEx);
        ElementoDeExpressao expressao;

        // Monta o primeiro operador binário
        if (tokens.length < 3){
            return null;
        }else{
            ElementoDeExpressao opEsq = new ValorInteiro(Integer.parseInt(tokens[0]));
            String operador = tokens[1];
            ElementoDeExpressao opDir = new ValorInteiro(Integer.parseInt(tokens[2]));
            expressao = Calculadora.montaOperadorBinario(opEsq,operador,opDir);
        }

        // Se terminou, retorna
        if (tokens.length == 3){
            return expressao;
        }

        // Faz o parsing do restante da expressão
        int pos = 2;
        while(pos <= tokens.length - 2){
            ElementoDeExpressao opEsq = expressao;
            pos++;
            String operador = tokens[pos];
            pos++;
            ElementoDeExpressao opDir = new ValorInteiro(Integer.parseInt(tokens[pos]));
            expressao = Calculadora.montaOperadorBinario(opEsq, operador, opDir);
        }
        return  expressao;
    }
    
    public static ElementoDeExpressao montaOperadorBinario(ElementoDeExpressao opEsq,String operador,ElementoDeExpressao opDir){
        switch(operador){
            case "+":
            return new OperadorSoma(opEsq,opDir);
            case "-":
            return new OperadorSubtracao(opEsq, opDir);
            default:
            return null;
        }
    }
}
