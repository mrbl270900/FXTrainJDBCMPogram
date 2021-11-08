import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainControler {
    TrainView view;
    TrainModel model;

    public TrainControler (TrainModel m, TrainView v) throws SQLException {
        this.view=v;
        this.model=m;
        this.view.exitBtn.setOnAction(e-> Platform.exit());
        this.model.connectToTrainData();
        this.model.CreateStatement();
        this.view.stations = getStations();
        this.view.Hours = getHours();
        this.view.Mins = getMins();
        view.findTrains.setOnAction(e-> {
            try {
                HandlerPrintTrainRoutes(view.StartStationComB.getValue(),view.EndStationsCoB.getValue(), view.HoursComb.getValue(), view.MinsComb.getValue(), view.textfield);
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        });
        this.view.configure();
    }

    public ObservableList<String> getStations() throws SQLException{
        ArrayList<String> stations = model.SQLQueryStationNames();
        ObservableList<String> stationsnames = FXCollections.observableArrayList(stations);
        return stationsnames;
    }

    public ObservableList<Integer> getHours(){
        ArrayList<Integer> hours=new ArrayList<>();
        for(int i=0;i<24;i++){
            hours.add(i);
        }
        ObservableList<Integer> HoursObs=FXCollections.observableArrayList(hours);
        return HoursObs;
    }
    public ObservableList<Integer> getMins(){
        ArrayList<Integer> mins=new ArrayList<>();
        for(int i=0;i<60;i++){
            mins.add(i);
        }
        ObservableList<Integer> MinsObs=FXCollections.observableArrayList(mins);
        return MinsObs;
    }

    public void HandlerPrintTrainRoutes(String From, String To, Integer Hour, Integer Minutes, TextArea txtArea) throws SQLException{
        txtArea.clear();
        txtArea.appendText(" Train, From Station: Departure-> To station: arrival \n");double time=(double) Hour +((double) Minutes/100);
        ArrayList<TrainInfo> trips= model.QueryforDepartures(From, To, time);
        for (int i=0;i<trips.size();i++){
            String deptime= String.format("%.2f", trips.get(i).departuretime);
            String arrtime=String.format("%.2f", trips.get(i).arrivaltime);
            txtArea.appendText(i+";"+ trips.get(i).startstation+ ": "+ deptime+ " -> "+ trips.get(i).endstation+": "+ arrtime+ "\n");
        }
    }

}

