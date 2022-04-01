import java.util.LinkedList;
import java.util.List;


public class App {

    public static void main(String args[]){
        List<Integer> matriculasSemNome = new LinkedList<Integer>();
        matriculasSemNome.add(10000);
        matriculasSemNome.add(10001);
        matriculasSemNome.add(10001);
        matriculasSemNome.add(10001);
        matriculasSemNome.add(10002);
        matriculasSemNome.add(10003);
        matriculasSemNome.add(10004);
        matriculasSemNome.add(10004);
        matriculasSemNome.add(10004);
        matriculasSemNome.add(10005);
        matriculasSemNome.add(10005);
        matriculasSemNome.add(10006);
        matriculasSemNome.add(10007);
        matriculasSemNome.add(10008);
        matriculasSemNome.add(10009);
        matriculasSemNome.add(10009);
        matriculasSemNome.add(10010);
        MetodoSemNome teste = new MetodoSemNome();
        matriculasSemNome= teste.matriculaUnica(matriculasSemNome);
        System.out.println("matriculas que não possui o nome do funcionário sem repetição: \n"+ matriculasSemNome.toString());
        //tes
        //PROFESSOR, FIZ ESSA PARTE ABAIXO SÓ PARA TESTAR CASO FOSSE O CASO
        //teste
        //PROFESSOR, FIZ ESSA PARTE ABAIXO SÓ PARA TESTAR CASO FOSSE O CASO test quase acabado
        List<nomeComMatricula> matriculasComNomes = new LinkedList<nomeComMatricula>();
        nomeComMatricula x1 = new nomeComMatricula(20000, "Zezinho");
        nomeComMatricula x2 = new nomeComMatricula(20000, "Aroldo");
        nomeComMatricula x3 = new nomeComMatricula(20001, "Antonio");
        nomeComMatricula x4 = new nomeComMatricula(20002, "Cristiano");
        nomeComMatricula x5 = new nomeComMatricula(20003, "Fabiano");
        nomeComMatricula x6 = new nomeComMatricula(20004, "Messi");
        nomeComMatricula x7 = new nomeComMatricula(20005, "Ribamar");
        nomeComMatricula x8 = new nomeComMatricula(20005, "VASCO");
        nomeComMatricula x9 = new nomeComMatricula(20006, "Caça-rato");
        nomeComMatricula x10 = new nomeComMatricula(20007, "Suco De Fruta");
        nomeComMatricula x11 = new nomeComMatricula(20008, "Só um segurança");
        nomeComMatricula x12 = new nomeComMatricula(20008, "Esse não vai aparecer");
        nomeComMatricula x13 = new nomeComMatricula(20008, "Nem esse");
        //meio 
        matriculasComNomes.add(x1);
        matriculasComNomes.add(x2);
        matriculasComNomes.add(x3);
        matriculasComNomes.add(x4);
        matriculasComNomes.add(x5);
        matriculasComNomes.add(x6);
        matriculasComNomes.add(x7);
        matriculasComNomes.add(x8);
        matriculasComNomes.add(x9);
        matriculasComNomes.add(x10);
        matriculasComNomes.add(x11);
        matriculasComNomes.add(x12);
        matriculasComNomes.add(x13);
        MetodoComNome testeComNome= new MetodoComNome();
        matriculasComNomes= testeComNome.matriculaUnica(matriculasComNomes);
        System.out.println("funcionarios nomeados e suas matriculas sem repetição de matricula: ");
        for(int i=0; i<matriculasComNomes.size(); i++){
            System.out.println("nome: "+ matriculasComNomes.get(i).getNome()+ ", Matricula: "+  matriculasComNomes.get(i).getMatricula());
        }//com o github
        //novo comentario
        System.out.println("A parte só com matricula sem o nome ficou na parte de cima do terminal");
    }
}