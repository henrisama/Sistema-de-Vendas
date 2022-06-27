package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ConectarBD;

public class Devolucao {
  private String data;
  private String motivo;
  private double valor;
  private String forma;
  private ItemVendido item;



  public Devolucao(int idItem) {
    item = new ItemVendido();
  }

  public Devolucao(){
    item = new ItemVendido();
  }
  

  public String getData() {
    return this.data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getMotivo() {
    return this.motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  public double getValor() {
    return this.valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public String getForma() {
    return this.forma;
  }

  public void setForma(String forma) {
    this.forma = forma;
  }

  public ItemVendido getItem() {
    return this.item;
  }

  public void setItem(ItemVendido item) {
    this.item = item;
  }

  public int resgitrarDevolucao(){
    try{
      String insert = "INSERT INTO Devolucao "
        + "VALUES(?,?,?,?,?,?);";

      Connection con = ConectarBD.Connect();
      PreparedStatement stmt = con.prepareStatement(insert);
      stmt.setString(1, null); // ID
      stmt.setString(2, this.data);
      stmt.setDouble(3, this.valor);
      stmt.setString(4, this.forma);
      stmt.setString(5, this.motivo);
      stmt.setInt(6, this.item.getId());
      stmt.executeUpdate();
      
      stmt.close();
      con.close();
      return 1;
    }catch(SQLException e){
      System.out.println(e);
      return 0;
    }
  }


  @Override
  public String toString() {
    return "{" +
      " data='" + getData() + "'" +
      ", motivo='" + getMotivo() + "'" +
      ", valor='" + getValor() + "'" +
      ", forma='" + getForma() + "'" +
      ", item='" + getItem() + "'" +
      "}";
  }


}
