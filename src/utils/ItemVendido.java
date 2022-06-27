package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.ConectarBD;

public class ItemVendido {
  private int id;
  private int quantidade;
  private double valorUnitario;
  private double valorTotal;
  private Produto produto;


  public ItemVendido(String codigoProduto, int quantidade) {
    produto = Produto.getProdutoByCod(codigoProduto);

    this.valorTotal = produto.getValorVenda() * quantidade;
    this.valorUnitario = produto.getValorVenda();
    this.quantidade = quantidade;
  }

  public ItemVendido(int id){
    this.id = id;
  }

  public ItemVendido(){
    
  }

  public int getId(){
    return this.id;
  }

  public void setId(int id){
    this.id = id;
  }

  public int getQuantidade() {
    return this.quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getValorUnitario() {
    return this.valorUnitario;
  }

  public Produto getProduto() {
    return this.produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public void setValorUnitario(double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public double getValorTotal() {
    return this.valorTotal;
  }

  public void setValorTotal(double ValorTotal) {
    this.valorTotal = ValorTotal;
  }

  public void registrarItemVenda(String idVenda){
    try{
      String query = "INSERT INTO ItemVendido VALUES(?,?,?,?,?,?);";

      Connection con = ConectarBD.Connect();
      PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, null);
      stmt.setInt(2, this.quantidade);
      stmt.setDouble(3, this.valorUnitario);
      stmt.setDouble(4, this.valorTotal);
      stmt.setDouble(5, this.produto.getID());
      stmt.setString(6, idVenda);
      stmt.executeUpdate();

      this.produto.setQuantidade(this.produto.getQuantidade() - this.quantidade);
      this.produto.save();
      
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }

  public static List<String[]> getTodosItemsVendidos(String codigoVenda){
    try{
      Connection con = ConectarBD.Connect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt
      .executeQuery("SELECT * FROM ItemVendido WHERE idVenda='"+codigoVenda+"';");

      String id, 
        quantidade, 
        valorUnitario, 
        valorTotal, 
        idProduto, 
        idVenda;


      List<String> values = new ArrayList<String>();
      List<String[]> result = new ArrayList<String[]>();
        
      while(rs.next()){
        id = rs.getString(1);
        quantidade = rs.getString(2);
        valorUnitario = rs.getString(3);
        valorTotal = rs.getString(4);
        idProduto = rs.getString(5);
        idVenda = rs.getString(6);

        values.add(id);
        values.add(quantidade);
        values.add(valorUnitario);
        values.add(valorTotal);
        values.add(idProduto);
        values.add(idVenda);
        
        result.add(values.toArray(new String[0]));
        values.clear();
      }
      
      rs.close();
      stmt.close();
      con.close();

      return result;
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }


  @Override
  public String toString() {
    return "{" +
      " quantidade='" + getQuantidade() + "'" +
      ", valorUnitario='" + getValorUnitario() + "'" +
      ", ValorTotal='" + getValorTotal() + "'" +
      "}";
  }
}
