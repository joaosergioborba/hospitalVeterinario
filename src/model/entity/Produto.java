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

  //vamo ter que ver como salvar um dado em um arquivo persistente, um json talvez ou csv

  public int getId() {
    return this.id;
  }

  public String getDescricao(){
    return descricao;
  }

  public void setDescricao(String descricao){
    this.descricao = descricao;
  }
  public float getValor() {
    return valor;
  }

  public void setValor(float valor){
    if(valor >= 0) {
        this.valor = valor;
    }

    System.out.println("O valor deve ser maior ou igual a zero\n");

  }
   // Adicionei um get e um set para o tipoProduto,sem isso, o VS vai continuar dando o aviso de que  o campo 'tipoProduto' não é utilizado
  public TipoProduto getTipoProduto() {
    return tipoProduto;
  }

  public void setTipoProduto(TipoProduto tipoProduto) {
    this.tipoProduto = tipoProduto;
  }
  
}
