package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import config.ConectarBD;
import utils.Atendente;
import utils.Cliente;
import utils.Produto;
import utils.Produtos;
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
    if(venda.getData() == null){
      return false;
    }
    if(!venda.getData().matches("\\d{4}-\\d{2}-\\d{2}")){
      return false;
    }
    return true;
  }

  public boolean verificarValorTotal(){
    //System.out.println(venda.getValorTotal());
    /* if(venda.getValorTotal() ){
      return false;
    } */
    if(venda.getValorTotal() < 0){
      return false;
    }
    return true;
  }

  public boolean verificarTempoGarantia(){
    //System.out.println(venda.getTempoGarantia());
    if(venda.getTempoGarantia() < 0){
      return false;
    }
    return true;
  }

  public boolean verificarTipoPagamento(){
    String[] valoresPermitidos = {"PIX", "DINHEIRO", "CRÉDITO", "DÉBITO", "OUTRO"};
    
    if(!Arrays.asList(valoresPermitidos).contains(venda.getTipoPagamento())){
      return false;
    }

    return true;
  }

  public boolean verificarDataPagamento(){
    if(venda.getDataPagamento() == null){
      return false;
    }
    if(!venda.getDataPagamento().matches("\\d{4}-\\d{2}-\\d{2}")){
      return false;
    }
    return true;
  }

  public boolean verificarValorPagamento(){
    if(venda.getValorPagamento() < 0){
      return false;
    }
    return true;
  }

  public boolean verificarCodigoCliente(){
    boolean result = Cliente.existeCliente(cliente.getCPF());
    return result;
  }

  public boolean verificarCodigoAtentende(){
    return true;
  }

  public int handleConcluir(Produtos produtos){
    if(!verificarData()){ return 1; }

    if(!verificarValorTotal()){ return 2; }

    if(!verificarTempoGarantia()){ return 3; }

    if(!verificarTipoPagamento()){ return 4; }

    if(!verificarDataPagamento()){ return 5; }

    if(!verificarValorPagamento()){ return 6; }

    if(!verificarCodigoCliente()){ return 7; }

    atendente.setID(1);

    if(!verificarCodigoAtentende()){ return 8; }

    
    //do sql
    try{
      String insert = "INSERT INTO Venda "
        + "VALUES(?,?,?,?,?,?,?,?,?);";

      Connection con = ConectarBD.Connect();
      PreparedStatement stmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, null);
      stmt.setString(2, venda.getData());
      stmt.setString(3, Double.toString(venda.getValorTotal()));
      stmt.setString(4, Integer.toString(venda.getTempoGarantia()));
      stmt.setString(5, venda.getTipoPagamento());
      stmt.setString(6, venda.getDataPagamento().toString());
      stmt.setString(7, Double.toString(venda.getValorPagamento()));
      stmt.setString(8, Integer.toString(atendente.getID()));
      stmt.setString(9, cliente.getCPF());
      stmt.executeUpdate();

      long venda_id = 1;
      try (ResultSet generatedKeys = stmt.getGeneratedKeys()){
        if(generatedKeys.next()){
          venda_id = generatedKeys.getLong(1);
        }
      }

      //System.out.println(venda_id);
      
      int i = 0;
      String insert2 = "INSERT INTO ItemVendido " + "VALUES(?,?,?,?,?);";
      
      for(i=0; i<produtos.index_produtos; i++){
        /* produtos.produtos[i][0] //codigo
        produtos.produtos[i][1] //nome
        produtos.produtos[i][2] //quantidade
        produtos.produtos[i][3] //valor unitario */
        Produto produto = Produto.getProduto(produtos.produtos[i][0]);
        PreparedStatement stmt2 = con.prepareStatement(insert2, Statement.RETURN_GENERATED_KEYS);
        stmt2.setString(1, null);
        stmt2.setString(2, produtos.produtos[i][2]);
        stmt2.setString(3, Double.toString(produto.getValorCusto()));
        stmt2.setString(4, Double.toString(produto.getValorVenda()*Integer.parseInt(produtos.produtos[i][2])));
        stmt2.setString(5, Integer.toString(produto.getID()));
        stmt2.executeUpdate();
        
        long item_id = 1;
        try (ResultSet generatedKeys2 = stmt2.getGeneratedKeys()){
          if(generatedKeys2.next()){
            item_id = generatedKeys2.getLong(1);
          }
        }
        
        String insert3 = "INSERT INTO Venda_ItemVendido "+ "VALUES(?,?)";
        PreparedStatement stmt3 = con.prepareStatement(insert3);
        stmt3.setString(1, Long.toString(venda_id));
        stmt3.setString(2, Long.toString(item_id));
        stmt3.executeUpdate();
        
      }
      
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
