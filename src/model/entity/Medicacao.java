package model.entity;

import java.sql.Date;

public class Medicacao {
  private int id;
  private Produto produto;
  private Funcionario funcionario;
  private Animal animal;
  private Date data;

  public Medicacao(Produto produto, Funcionario funcionario, Animal animal, Date data){
    this.produto = produto;
    this.funcionario = funcionario;
    this.animal = animal;
    this.data = data;
  }
}
