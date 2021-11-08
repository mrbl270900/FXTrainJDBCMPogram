import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

import static javafx.application.Application.launch;

/*
public class Main {

    public static void main(String[] args) {

        String url="jdbc:sqlite:identifier.sqlite";
        TrainModel TDB=new TrainModel(url);
        try {
   //         conn = DriverManager.getConnection(url);
            TDB.connectToTrainData();
//            stmt= conn.createStatement();
            TDB.CreateStatement();
 //           rs=stmt.executeQuery(sql);
            TDB.SQLQueryStationNames();
 //           while(rs!=null && rs.next()){
 //               String name=rs.getString(1);
 //               System.out.println(name);
  //          }
           // TDB.PstmtRetrieveDeparturesforStation();
            TDB.QueryforDepartures();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
                try {
                    TDB.closeTrainDataConnection();
                }catch (SQLException e2){
                    System.out.println(e2.getMessage());

            }
        }
    }
}

*/
public class Main extends Application {
    public void start(Stage primaryStage) {
        TrainView view=new TrainView();
        TrainModel model = new TrainModel("jdbc:sqlite:identifier.sqlite");


        TrainControler controler = null;
        try {
            controler = new TrainControler(model, view);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        primaryStage.setTitle("Train Trip Finder");
        primaryStage.setScene(new Scene(view.asParent(), 600, 475));
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}