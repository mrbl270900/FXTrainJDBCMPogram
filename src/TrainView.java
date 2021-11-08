import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class TrainView {
    GridPane startview;
    Label StartStationLbl;
    Label EndStationsLbl;
    Label TimeLal;
    Button exitBtn;
    Button findTrains;
    ComboBox<String> StartStationComB;
    ObservableList<String> stations; // remember to put something in it
    ObservableList<Integer> Hours;
    ObservableList<Integer> Mins;
    ComboBox<String> EndStationsCoB;
    ComboBox<Integer> HoursComb;
    ComboBox<Integer> MinsComb;
    TextArea textfield;
    public TrainView(){
        startview=new GridPane();
        CreateView();
    }
    public Parent asParent() {return startview;}

    private void CreateView(){
        startview.setMinSize(300,200);// Settingsizeof the pane(width, height)
        startview.setPadding(new Insets(10,10,10,10)); //margins around the grid(top/right/bottom/left)setPadding(Insetsi)
        startview.setVgap(5);
        startview.setHgap(5);

        StartStationLbl=new Label("Select start station:");
        startview.add(StartStationLbl,1,1);

        exitBtn=new Button("Exit");
        startview.add(exitBtn,20,20);

        findTrains = new Button("Find Trains");
        startview.add(findTrains,1,7);

        StartStationComB=new ComboBox<>();
        startview.add(StartStationComB,2,1);

        TimeLal = new Label("Select time of trip:");
        startview.add(TimeLal,1,5);

        EndStationsLbl = new Label("Select End station:");
        startview.add(EndStationsLbl,1,3);

        EndStationsCoB = new ComboBox<>();
        startview.add(EndStationsCoB,2,3);

        HoursComb = new ComboBox<>();
        startview.add(HoursComb,2,5);

        MinsComb = new ComboBox<>();
        startview.add(MinsComb,3,5);

        textfield = new TextArea();
        startview.add(textfield,1,9,15,10);

    }

    public void configure(){
        StartStationComB.setItems(stations); //(here the observable list is given to the ComboBox)
        StartStationComB.getSelectionModel().selectFirst();
        EndStationsCoB.setItems(stations);
        EndStationsCoB.getSelectionModel().selectFirst();
        HoursComb.setItems(Hours);
        HoursComb.getSelectionModel().selectFirst();
        MinsComb.setItems(Mins);
        MinsComb.getSelectionModel().selectFirst();
    }


}
