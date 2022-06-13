package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import config.ConectarBD;

public class Venda {
  private String data;
  private double valorTotal;
  private int tempoGarantia;
  private String tipoPagamento;
  private String dataPagamento;
  private double valorPagamento;

  private Cliente cliente;
  private Atendente atendente;

  private List<ItemVendido> itemsVendidos = new ArrayList<ItemVendido>();

  public Venda(){
    cliente = new Cliente();
    atendente = new Atendente();
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Atendente getAtendente() {
    return this.atendente;
  }

  public void setAtendente(Atendente atendente) {
    this.atendente = atendente;
  }

  public List<ItemVendido> getItemsVendidos() {
    return this.itemsVendidos;
  }

  public void setItemsVendidos(List<ItemVendido> itemsVendidos) {
    this.itemsVendidos = itemsVendidos;
  }

  public String getData() {
    return this.data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public double getValorTotal() {
    return this.valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public int getTempoGarantia() {
    return this.tempoGarantia;
  }

  public void setTempoGarantia(int tempoGarantia) {
    this.tempoGarantia = tempoGarantia;
  }

  public String getTipoPagamento() {
    return this.tipoPagamento;
  }

  public void setTipoPagamento(String tipoPagamento) {
    this.tipoPagamento = tipoPagamento;
  }

  public String getDataPagamento() {
    return this.dataPagamento;
  }

  public void setDataPagamento(String dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public double getValorPagamento() {
    return this.valorPagamento;
  }

  public void setValorPagamento(double valorPagamento) {
    this.valorPagamento = valorPagamento;
  }

  public int adicionarItem(String codigoProduto, int quantidade){
    ItemVendido iv = new ItemVendido(codigoProduto, quantidade);
    if(iv.getProduto().getQuantidade() < quantidade){
      return 0; // qtd ivalid
    }else{
      itemsVendidos.add(iv);
      return 1; // work
    }
  }

  public int registrarVenda(){
    this.atendente.setID(1);

    try{
      String insert = "INSERT INTO Venda "
        + "VALUES(?,?,?,?,?,?,?,?,?);";

      Connection con = ConectarBD.Connect();
      PreparedStatement stmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, null);
      stmt.setString(2, this.data);
      stmt.setDouble(3, this.valorTotal);
      stmt.setInt(4, this.tempoGarantia);
      stmt.setString(5, this.tipoPagamento);
      stmt.setString(6, this.dataPagamento);
      stmt.setDouble(7, this.valorPagamento);
      stmt.setInt(8, this.atendente.getID());
      stmt.setString(9, this.cliente.getCPF());
      stmt.executeUpdate();

      String idVenda = "";
      try (ResultSet generatedKeys = stmt.getGeneratedKeys()){
        if(generatedKeys.next()){
          idVenda = generatedKeys.getString(1);
        }
        generatedKeys.close();
      }
      
      ListIterator<ItemVendido> iter = itemsVendidos.listIterator();
      for( ; iter.hasNext(); ){
        iter.next().registrarItemVenda(idVenda);
      }
      
      stmt.close();
      con.close();

      return 0;
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }

  public static List<String[]> getTodasVendas(){
    try{
      Connection con = ConectarBD.Connect();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM Venda;");

      String id, 
        data, 
        valorTotal, 
        tempoGarantia, 
        tipoPagamento, 
        dataPagaemnto, 
        valorPagamento, 
        idFuncionario, 
        cpfCliente;

      List<String> values = new ArrayList<String>();
      List<String[]> result = new ArrayList<String[]>();
        
      while(rs.next()){
        id = rs.getString(1);
        data = rs.getString(2);
        valorTotal = rs.getString(3);
        tempoGarantia = rs.getString(4);
        tipoPagamento = rs.getString(5);
        dataPagaemnto = rs.getString(6);
        valorPagamento = rs.getString(7);
        idFuncionario = rs.getString(8);
        cpfCliente = rs.getString(9);

        values.add(id);
        values.add(data);
        values.add(valorTotal);
        values.add(tempoGarantia);
        values.add(tipoPagamento);
        values.add(dataPagaemnto);
        values.add(valorPagamento);
        values.add(idFuncionario);
        values.add(cpfCliente);
        
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
      " data='" + getData() + "'" +
      ", valorTotal='" + getValorTotal() + "'" +
      ", tempoGarantia='" + getTempoGarantia() + "'" +
      ", tipoPagamento='" + getTipoPagamento() + "'" +
      ", dataPagamento='" + getDataPagamento() + "'" +
      ", valorPagamento='" + getValorPagamento() + "'" +
      "}";
  }
}
