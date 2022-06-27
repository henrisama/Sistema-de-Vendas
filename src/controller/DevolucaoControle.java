package controller;

import utils.Devolucao;

public class DevolucaoControle {
  private Devolucao devolucao;
  public DevolucaoControle() {
    devolucao = new Devolucao();
  }

  public void setItemId(String itemId){
    devolucao.getItem().setId(Integer.parseInt(itemId));
  }

  public Devolucao getDevolucao(){
    return devolucao;
  }
  

  public int registrarDevolucao(){
    return  devolucao.resgitrarDevolucao();
  }
}
