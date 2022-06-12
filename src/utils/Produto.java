package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import config.ConectarBD;

public class Produto {
  private int ID;
  private String codigo;
  private String nome;
  private double valorVenda;
  private double valorCusto;
  private int quantidade;

  public int getID(){
    return this.ID;
  }

  public void setID(int id) {
    this.ID = id;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getValorVenda() {
    return this.valorVenda;
  }

  public void setValorVenda(double valorVenda) {
    this.valorVenda = valorVenda;
  }

  public double getValorCusto() {
    return this.valorCusto;
  }

  public void setValorCusto(double valorCusto) {
    this.valorCusto = valorCusto;
  }

  public int getQuantidade() {
    return this.quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public void save(){
    try {
      Connection con = ConectarBD.Connect();
      final PreparedStatement stmt = con.prepareStatement(
        "UPDATE Produto SET quantidade = ? WHERE id='"+this.ID+"'"
      );
      stmt.setInt(1, this.quantidade);
      stmt.executeUpdate();

      stmt.close();
      con.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static Produto getProdutoByCod(String codProduto){
    Produto produto = new Produto();
    
    //do SQL 
    try {
      Connection con = ConectarBD.Connect();
      final PreparedStatement stmt = con.prepareStatement(
        "SELECT * FROM Produto WHERE codProduto='"+codProduto+"'"
      );
      final ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        produto.setID(rs.getInt(1));
        produto.setValorVenda(rs.getDouble(2)); //valor de venda
        produto.setValorCusto(rs.getDouble(3)); //valor de custo
        produto.setNome(rs.getString(4)); // nome
        produto.setCodigo(rs.getString(5)); // codigo
        produto.setQuantidade(rs.getInt(6)); //quantidade
      }

      rs.close();
      stmt.close();
      con.close();

      return produto;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String toString() {
    return "{" +
      " codigo='" + getCodigo() + "'" +
      ", nome='" + getNome() + "'" +
      ", valorVenda='" + getValorVenda() + "'" +
      ", valorCusto='" + getValorCusto() + "'" +
      ", quantidade='" + getQuantidade() + "'" +
      "}";
  }

}
