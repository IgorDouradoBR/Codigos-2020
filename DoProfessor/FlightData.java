import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightData{
    public static ObservableList<Integer> getPinosDisp(){
        List<Integer> pinos = Arrays.asList(4,5,6,7,8);
        return FXCollections.observableList(pinos);
    }

    public static ObservableList<Integer> getTentDisp(){
        List<Integer> tentativas = Arrays.asList(8,9,10,11,12,13,14,15);
        return FXCollections.observableList(tentativas);
    }
}
