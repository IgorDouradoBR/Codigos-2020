import java.util.Scanner;
public class App{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("*** Área do setor de controle de estoque de loja ***");
        Geladeira geladeiraQ = new Geladeira(0);
        Ferro ferroQ = new Ferro(0);
        Ventilador ventiladorQ= new Ventilador(0);
        Fogao fogaoQ= new Fogao(0);
        System.out.println("Digite a quantidade em estoque de geladeiras, ferros de passar, fogões e de ventiladores, respectivamente");
        int geladeiras = teclado.nextInt();
        int ferros = teclado.nextInt();
        int fogoes = teclado.nextInt();
        int ventiladores= teclado.nextInt();
        geladeiraQ.setGeladeiraEstMais(geladeiras);
        ferroQ.setFerroEstMais(ferros);
        fogaoQ.setFogaoEstMais(fogoes);
        ventiladorQ.setVentiladorEstMais(ventiladores);
        SistemaDeEstoque sist = new SistemaDeEstoque(geladeiraQ, ferroQ, fogaoQ, ventiladorQ);
        int totalPossivel= sist.getGeladeira()+ sist.getFogao()+ sist.getFerro()+ sist.getVentilador();
        double matriz[][] = new double[totalPossivel+1000][totalPossivel+ 1000];
        int clienteQuant =0;
        System.out.println("-=-=-= Área do cliente =-=-=-");
        System.out.println("");
        System.out.println("Digite 1 se for cliente novo:  ");
        int clienteNovo= teclado.nextInt();
        while(clienteNovo==1){       
            boolean compras=false;
            while(compras == false){
                int vetor[]= new int[totalPossivel];
                String vetorStr[] = new String[totalPossivel];
                int cont=0;
                
                for(int i=0; i<totalPossivel; i++){
                    System.out.println("Digite o número do "+ (i+1) +"º eletrodoméstico que voce deseja comprar primeiro: \n0- Para não comprar mais nenhum e ver seu recibo\n1-Geladeira (ainda em estoque: " + sist.getGeladeira()+ ")"+ "\n2-Ferro (ainda em estoque: " + sist.getFerro()+ ")" + "\n3-Fogao (ainda em estoque: " + sist.getFogao()+ ")" + "\n4-Ventilador (ainda em estoque: " + sist.getVentilador()+ ")" +"\n5-Excluir uma compra feita");
                    int opcaoCompra = teclado.nextInt();
                    if(opcaoCompra== 0){
                        int geladeiraRecibo = 0; // pra imprimir no recibo
                        int fogaoRecibo = 0;
                        int ferroRecibo = 0;
                        int ventiladorRecibo = 0;
                        double desconto =0;
                        for(int j=0; j<vetorStr.length; j++){
                            if(vetorStr[j]=="geladeira"){
                                geladeiraRecibo+= vetor[j];
                            } 
                        }
                        for(int j=0; j<vetorStr.length; j++){
                            if(vetorStr[j]=="fogao"){
                                fogaoRecibo+= vetor[j];
                            } 
                        }
                        for(int j=0; j<vetorStr.length; j++){
                            if(vetorStr[j]=="ferro"){
                                ferroRecibo+= vetor[j];
                            } 
                        }
                        for(int j=0; j<vetorStr.length; j++){
                            if(vetorStr[j]=="ventilador"){
                                ventiladorRecibo+= vetor[j];
                            } 
                        }
                        double total = geladeiraRecibo+ferroRecibo+fogaoRecibo+ventiladorRecibo;
                        double totalReais= (geladeiraRecibo*geladeiraQ.getGeladeiraPreco())+(ferroRecibo*ferroQ.getFerroPreco())+(fogaoRecibo*fogaoQ.getFogaoPreco())+(ventiladorRecibo*ventiladorQ.getVentiladorPreco());
                        if(total>10){
                            desconto= totalReais/10;

                        }

                        double imposto= totalReais/4;
                        
                        matriz[0][clienteQuant] = geladeiraRecibo;
                        matriz[1][clienteQuant] = ferroRecibo;
                        matriz[2][clienteQuant] = fogaoRecibo;
                        matriz[3][clienteQuant] = ventiladorRecibo;
                        matriz[4][clienteQuant]= total;
                        matriz[5][clienteQuant]= totalReais;
                        matriz[6][clienteQuant]= desconto;
                        matriz[7][clienteQuant]= imposto;



                            
                        
                        System.out.println("Recibo de venda numero: " + (clienteQuant+1));
                        System.out.println("Número de item         código        descrição     preço/und     quantidade      valor final");
                        sist.imprimeGeladeira(geladeiraRecibo);
                        sist.imprimeFerro(ferroRecibo);
                        sist.imprimeFogao(fogaoRecibo);
                        sist.imprimeVentilador(ventiladorRecibo);
                        System.out.println("                                                                                Total   "+ totalReais);
                        System.out.println("                                                                                Desconto   "+ desconto);
                        System.out.println("                                                                                Imposto   "+ imposto);
                        System.out.println("                                                                          Valor da venda   "+ ((totalReais-desconto)+imposto));


                        break;
                    }
                    if(opcaoCompra==1){
                        System.out.println("Quantas geladeiras você deseja?");
                        int quantasGel= teclado.nextInt();
                        if(sist.getGeladeira() - quantasGel < 0){
                            System.out.println("Não tem Geladeiras o suficiente em estoque");
                        }
                        else{
                            sist.setGeladeiraMenos(quantasGel);
                            cont++;
                            vetor[i+1]= quantasGel;
                            vetorStr[i+1]= "geladeira";
                            System.out.println("** Número dessa venda: "+ cont+ " **");

                        }
                    }
                    if(opcaoCompra==2){
                        System.out.println("quantos ferros você deseja?");
                        int quantosFer= teclado.nextInt();
                        if(sist.getFerro() - quantosFer < 0){
                            System.out.println("Não tem Ferros o suficiente em estoque");
                        }
                        else{
                            sist.setFerroMenos(quantosFer);
                            cont++;
                            vetor[i+1]= quantosFer;
                            vetorStr[i+1]= "ferro";
                            System.out.println("** Número dessa venda: "+ cont+ " **");
                        }
                    }
                    if(opcaoCompra==3){
                        System.out.println("quantos Fogões você deseja?");
                        int quantosFog= teclado.nextInt();
                        if(sist.getFogao() - quantosFog < 0){
                            System.out.println("Não tem Fogões o suficiente em estoque");
                        }
                        else{
                            sist.setFogaoMenos(quantosFog);
                            cont++;
                            vetor[i+1]= quantosFog;
                            vetorStr[i+1]= "fogao";
                            System.out.println("** Número dessa venda: "+ cont+ " **");
                        }
                    }
                    if(opcaoCompra==4){
                        System.out.println("quantos ventiladores você deseja?");
                        int quantosVen= teclado.nextInt();
                        if(sist.getVentilador() - quantosVen < 0){
                            System.out.println("Não tem ventiladores o suficiente em estoque");
                        }
                        else{
                            sist.setVentiladorMenos(quantosVen);
                            cont++;
                            vetor[i+1]= quantosVen;
                            vetorStr[i+1]= "ventilador";
                            System.out.println("** Número dessa venda: "+ cont+ " **");
                        }
                    }
                    if(opcaoCompra==5){
                        System.out.println("Digite o número da venda que você deseja exluir");
                        int excluir= teclado.nextInt();
                        int aux= vetor[excluir];
                        vetor[excluir]= 0;
                        if(vetorStr[excluir]=="geladeira"){
                            sist.setGeladeiraMais(aux);
                        }
                        else if(vetorStr[excluir]=="fogao"){
                            sist.setFogaoMais(aux);
                        }
                        else if(vetorStr[excluir]=="ventilador"){
                            sist.setVentiladorMais(aux);
                        }
                        else if(vetorStr[excluir]=="ferro"){
                            sist.setFerroMais(aux);
                        }

                    }
            }
            
            
            
            
            matrizCont +=1;
            clienteQuant +=1;
            compras= true;// aqui sai do while interno
            
            clienteNovo =0;
            }
            System.out.println("Número do seu recibo: "+ clienteQuant+ "\nUse-o para poder fazer consultas mais tarde");
            System.out.println("Digite 1 se for cliente novo, 2 para saber os dados das últimas 5 vendas ou 3 para saber apenas o recibo de uma venda específica");
            int clienteNovo1= teclado.nextInt();
            if(clienteNovo1==1){
                clienteNovo= 1;//reinicia o while
            }
            if(clienteNovo1==2){
                int diminuir=5;
                if(clienteQuant<5){
                    diminuir= clienteQuant;

                }
                for(int i=clienteQuant-diminuir; i<clienteQuant; i++){
                            System.out.println("*NÚMERO DO RECIBO: "+ (i+1) + " *");
                            System.out.println("Número de item         código        descrição     preço/und     quantidade      valor final");
                            sist.imprimeGeladeira((int)matriz[0][i]);
                            sist.imprimeFerro((int)matriz[1][i]);
                            sist.imprimeFogao((int)matriz[2][i]);
                            sist.imprimeVentilador((int)matriz[3][i]);
                            System.out.println("                                                                                Total   "+ (int)matriz[5][i]);
                            System.out.println("                                                                                Desconto   "+ (int)matriz[6][i]);
                            System.out.println("                                                                                Imposto   "+ (int)matriz[7][i]);
                            System.out.println("                                                                          Valor da venda   "+ (((((int)matriz[5][i])-(int)matriz[6][i]))+(int)matriz[7][i]));
            }
            
        }
            if(clienteNovo1==3){
                System.out.println("Digite o numero do recibo da compra que você quer obter os dados: ");
                int reciboN= teclado.nextInt();
                            System.out.println("Número de item         código        descrição     preço/und     quantidade      valor final");
                            sist.imprimeGeladeira((int)matriz[0][reciboN-1]);
                            sist.imprimeFerro((int)matriz[1][reciboN-1]);
                            sist.imprimeFogao((int)matriz[2][reciboN-1]);
                            sist.imprimeVentilador((int)matriz[3][reciboN-1]);
                            System.out.println("                                                                                Total   "+ (int)matriz[5][reciboN-1]);
                            System.out.println("                                                                                Desconto   "+ (int)matriz[6][reciboN-1]);
                            System.out.println("                                                                                Imposto   "+ (int)matriz[7][reciboN-1]);
                            System.out.println("                                                                          Valor da venda   "+ ((((int)matriz[5][reciboN-1])-(int)matriz[6][reciboN-1])+(int)matriz[7][reciboN-1]));

            }
            if(clienteNovo==0){
                System.out.println("***FIM DE PROGRAMA!***");
                break;
            }
        }
    }

}