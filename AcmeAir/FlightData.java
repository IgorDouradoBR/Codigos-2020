import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightData{
    public static ObservableList<String> getCidadesAtendidas(){
        List<String> cidades = Arrays.asList("Porto Alegre","Florianopolis","Curitiba",
                                             "São Paulo","Rio de Janeiro","Brasilia","Belo Horizonte");

        return FXCollections.observableList(cidades);
    }

    public static ObservableList<Integer> getQtdadeAssentos(){
        List<Integer> qtdadeAssentos = Arrays.asList(1,2,3,4,5,6,7,8,9);
        return FXCollections.observableList(qtdadeAssentos);
    }
}
