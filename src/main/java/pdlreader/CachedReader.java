package pdlreader;

import java.io.IOException;
import java.sql.*;

public class CachedReader{
    public String parse(String ulr) throws SQLException {
        String DbUrl = "jdbc:postgresql://localhost:5433/photos";
        String username = "postgres";
        String password = "postgres";
        String info = null;
        try{
            Connection connection = DriverManager.getConnection(DbUrl, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS appartments (link TEXT, homesInfo TEXT)");
            ResultSet result = statement.executeQuery("SELECT homesInfo FROM appartments WHERE link='" +  ulr + "'");
            while (result.next()){
                info = result.getString("homesInfo");
            }
            if (info != null){
                System.out.println(info);
                return info;
            }
            else {
                info = new WBReader().parse(ulr);
                if (info == null)
                {return  null;}
                System.out.println("The location is added");
                statement.executeUpdate(("INSERT INTO appartments VALUES ('" + ulr + "', '" + info + "')"));
            }
            connection.close();
        }
        catch (SQLException | IOException e){
            System.out.println("Can't connect to DataBase");
            throw new RuntimeException(e);
    }
        return info;
}}
