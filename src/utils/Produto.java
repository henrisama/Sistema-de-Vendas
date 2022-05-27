package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import config.ConectarBD;

public class Produto {
  private String codigo;
  private String nome;
  private double valorVenda;
  private double valorCusto;
  private int quantidade;

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

  public static Produto getProduto(String codigo){
    Produto produto = new Produto();
    boolean hasData = false;

    //do SQL 
    try {
      String search = "select * from produto where codProduto='"+codigo+"';";

      Connection con = ConectarBD.Connect();
      final PreparedStatement ps = con.prepareStatement(search);
      final ResultSet rs = ps.executeQuery();

      final ResultSetMetaData metaRS = rs.getMetaData();
      final int columnCount = metaRS.getColumnCount();

      while (rs.next()) {
        hasData = true;
        for (int i = 1; i <= columnCount; i++) {
          final Object value = rs.getObject(i);
          System.out.println("column: "+i+" Valor: "+value.toString());
        }
        produto.setValorVenda(Double.parseDouble(rs.getObject(2).toString())); //valor de venda
        produto.setValorCusto(Double.parseDouble(rs.getObject(3).toString())); //valor de custo
        produto.setNome(rs.getObject(4).toString()); // nome
        produto.setCodigo(rs.getObject(5).toString()); // codigo
        produto.setQuantidade(Integer.parseInt(rs.getObject(6).toString())); //quantidade
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    System.out.println(produto.toString());

    if(!hasData){
      return null;
    }

    return produto;
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
