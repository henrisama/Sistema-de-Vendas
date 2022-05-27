package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import config.ConectarBD;
import utils.Atendente;
import utils.Cliente;
import utils.Venda;

public class RegistrarVendaControle {
  public Venda venda;
  public Cliente cliente;
  public Atendente atendente;

  public RegistrarVendaControle() {
    venda = new Venda();
    cliente = new Cliente();
    atendente = new Atendente();
  }

  public boolean verificarData(){
    return false;
  }

  public boolean verificarValorTotal(){
    return false;
  }

  public boolean verificarTempoGarantia(){
    return false;
  }

  public boolean verificarTipoPagamento(){
    String[] valoresPermitidos = {"PIX", "DINHEIRO", "CRÉDITO", "DÉBITO", "OUTRO"};
    
    if(!Arrays.asList(valoresPermitidos).contains(venda.getTipoPagamento())){
      return false;
    }

    return true;
  }

  public boolean verificarDataPagamento(){
    return false;
  }

  public boolean verificarValorPagamento(){
    return false;
  }

  public boolean verificarCodigoCliente(){
    boolean result = Cliente.existeCliente(cliente.getCPF());
    return result;
  }

  public boolean verificarCodigoAtentende(){
    return false;
  }

  public int handleConcluir(){
    if(!verificarData()){ return 1; }

    if(!verificarValorTotal()){ return 2; }

    if(!verificarTempoGarantia()){ return 3; }

    if(!verificarTipoPagamento()){ return 4; }

    if(!verificarDataPagamento()){ return 5; }

    if(!verificarValorPagamento()){ return 6; }

    if(!verificarCodigoCliente()){ return 7; }

    if(!verificarCodigoAtentende()){ return 8; }
    
    //do sql
    try{
      String insert = "INSERT INTO Venda "
        + "VALUES(?,?,?,?,?,?,?,?,?);";

      Connection con = ConectarBD.Connect();
      PreparedStatement stmt = con.prepareStatement(insert);
      stmt.setString(1, null);
      stmt.setString(2, venda.getData().toString());
      stmt.setString(3, Double.toString(venda.getValorTotal()));
      stmt.setString(4, Integer.toString(venda.getTempoGarantia()));
      stmt.setString(5, venda.getTipoPagamento());
      stmt.setString(6, venda.getDataPagamento().toString());
      stmt.setString(7, Double.toString(venda.getValorPagamento()));
      stmt.setString(8, Integer.toString(atendente.getID()));
      stmt.setString(9, cliente.getCPF());
      stmt.execute();
      con.close();

      return 0;
    }catch(SQLException e){
      System.out.println(e.getMessage());
      return 9;
    }

  }

  public void handleAdicionar(){

  }
  
}
