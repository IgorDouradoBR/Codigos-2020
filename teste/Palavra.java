

public class Palavra {

    
    
 

    private String palavra = null;
    private  ListArrayOfInteger paginasOcorre= new ListArrayOfInteger();
    private  int numeroOcorrencias = 1;

    
    public Palavra(String palavra, int pagina){//linha para solucao tampao

        paginasOcorre.add(pagina);
        this.palavra= palavra;
    }
    
    
    
    

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int[] paginasInt()
    {
        int[] vetor = new int[paginasOcorre.size()];
        for(int i=0; i<paginasOcorre.size(); i++){
            vetor[i]=paginasOcorre.get(i);
        }
        return vetor;
    }
    public void adicionaPag(int pagina){
        if(!paginasOcorre.contains(pagina)){
            paginasOcorre.add(pagina);
        }
    }

    public int getNumeroOcorrencias() {
        return numeroOcorrencias;
    }

    public void setNumeroOcorrencias() {
        numeroOcorrencias += 1;
    }

    public ListArrayOfInteger getPaginasOcorre() {
        return paginasOcorre;
    }

    

    

    
}