

public class Algoritmos {
	
    public static void main(String args[]) {
		
		// Loop para alterar o tamanho da entrada passada 
		// como parâmetro para os algoritmos
        for (int i=10; i<400; i=i+10) 
		{ 
            // Cria e inicializa o vetor - valores do maior para o menor
            int vet[] = new int[i];
            for(int j=0; j<vet.length; j++)
                vet[vet.length-1-j] = j;      
			
            // Chama o algoritmo para testá-lo.
			// Trocar a chamada do método para testar os demais algoritmos.
            int c = pesquisaSequencial(vet,0);
            
			System.out.println(i+";"+c);
        }
		
    }
	
	///////////////////////////////////////////////////////////
	// Notacao O: ___________
    public static int pesquisaSequencial(int vet[], int num) {
        int cont=0; // para contar o numero de operacoes
		
		// Inclua o algoritmo (lembre de incrementar cont)

        return cont;    
	}
		
	///////////////////////////////////////////////////////////		
	// Notacao O: ___________		
    public static int pesquisaBinaria(int vet[], int num) {
        int cont=0; // para contar o numero de operacoes
		
		// Inclua o algoritmo (lembre de incrementar cont)

        return cont;        
	}

	///////////////////////////////////////////////////////////	
	// Notacao O: ___________
    public static int bubblesort(int vet[]) {
        int cont=0; // para contar o numero de operacoes
		
		// Inclua o algoritmo (lembre de incrementar cont)

        return cont;        
	} 
 
}
