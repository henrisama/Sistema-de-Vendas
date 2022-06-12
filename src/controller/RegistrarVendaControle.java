package controller;

import java.util.Arrays;

import utils.Cliente;
import utils.Venda;

public class RegistrarVendaControle {
  public Venda venda;


  public RegistrarVendaControle() {
    venda = new Venda();
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
    if(venda.getValorTotal() < 0){
      return false;
    }
    return true;
  }

  public boolean verificarTempoGarantia(){
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
    boolean result = Cliente.existeCliente(venda.getCliente().getCPF());
    return result;
  }

  public boolean verificarCodigoAtentende(){
    return true;
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

    int result = this.venda.registrarVenda();

    return result;
  }

  public void handleAdicionar(){
    
  }
  
}
