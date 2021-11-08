import java.sql.*;

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
