package utils;

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

  public static Produto getProduto(int codigo){
    Produto produto = new Produto();

    //do SQL 

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
