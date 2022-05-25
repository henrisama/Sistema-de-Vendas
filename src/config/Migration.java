package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Migration {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "I'myourfather#";
    private static final String URL = "jdbc:mysql://localhost:3306/";

    public static void main(String[] args) {
    

        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = con.createStatement();
            BufferedReader reader = new BufferedReader(new FileReader("src/config/Migration.txt"));
            String query = null;

            while((query = reader.readLine()) != null){
              stmt.execute(query);
            }
            
            con.close();
            reader.close();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }catch(IOException e){
          throw new RuntimeException(e);
        }
    }
}