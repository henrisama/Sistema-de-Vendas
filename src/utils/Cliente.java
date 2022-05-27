package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.ConectarBD;

public class Cliente extends Pessoa{
  private String CPF;

  public String getCPF() {
    return this.CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  public boolean registrarCliente(){
    return false;
  }

  static public boolean existeCliente(String cpf){
    try {
      Connection con = ConectarBD.Connect();
      Statement stmt = con.createStatement();
      String search = "select * from Cliente where cpf='"+cpf+"';";
      ResultSet result = stmt.executeQuery(search);
      boolean isAvailable;

      if(result.next()){
        isAvailable = true;
      }else{
        isAvailable = false;
      }

      result.close();
      con.close();
      return isAvailable;

    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}