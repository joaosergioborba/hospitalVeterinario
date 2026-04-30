package model.entity;
public class Produto {
  private int id;
  private String descricao;
  private float valor;
  private String tipoProduto;

  public Produto(String descricao, float valor, String tipoProduto){
    this.descricao = descricao;
    this.valor = valor;
    this.tipoProduto = tipoProduto;
  }
}
