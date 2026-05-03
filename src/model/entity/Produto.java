package model.entity;

import model.enums.TipoProduto;

public class Produto {
  private int id;
  private String descricao;
  private float valor;
  private TipoProduto tipoProduto;

  public Produto(String descricao, float valor, TipoProduto tipoProduto){
    this.descricao = descricao;
    this.valor = valor;
    this.tipoProduto = tipoProduto;
  }
}
