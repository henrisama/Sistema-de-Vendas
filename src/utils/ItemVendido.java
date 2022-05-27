package utils;

public class ItemVendido {
  private int quantidade;
  private double valorUnitario;
  private double ValorTotal;
  private Produto produto;


  public ItemVendido(String codigoProduto, int quantidade) {
    produto = Produto.getProduto(codigoProduto);
    this.ValorTotal = produto.getValorVenda() * quantidade;
    
    this.quantidade = quantidade;
  }

  public ItemVendido(String codigoProduto) {
    produto = Produto.getProduto(codigoProduto);
    this.quantidade = 1;
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

  public void setValorUnitario(double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public double getValorTotal() {
    return this.ValorTotal;
  }

  public void setValorTotal(double ValorTotal) {
    this.ValorTotal = ValorTotal;
  }

  public void registrarItemVenda(int codVenda){

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
