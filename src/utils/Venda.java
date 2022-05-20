package utils;

import java.sql.Date;
import java.util.List;

public class Venda {
  private Date data;
  private double valorTotal;
  private int tempoGarantia;
  private String tipoPagamento;
  private Date dataPagamento;
  private double valorPagamento;

  private List<ItemVendido> itemsVendidos;

  public Date getData() {
    return this.data;
  }

  public void setData(Date data) {
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

  public Date getDataPagamento() {
    return this.dataPagamento;
  }

  public void setDataPagamento(Date dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public double getValorPagamento() {
    return this.valorPagamento;
  }

  public void setValorPagamento(double valorPagamento) {
    this.valorPagamento = valorPagamento;
  }

  public void adicionarItem(int codigoProduto, int quantidade){
    itemsVendidos.add(new ItemVendido(codigoProduto, quantidade));
  }

  public void adicionarItem(int codigoProduto){
    itemsVendidos.add(new ItemVendido(codigoProduto));
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
