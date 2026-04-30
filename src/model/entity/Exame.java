package model.entity;

import java.sql.Date;

import model.enums.StatusExame;

public class Exame {
  private int id;
  private Produto produto;
  private String resultado;
  private Funcionario veterinario;
  private Animal animal;
  private Date data;
  private StatusExame status;

  public Exame(Produto produto, String resultado, Funcionario veterinario, Animal animal, Date data) {
    this.produto = produto;
    this.resultado = resultado;
    this.veterinario = veterinario;
    this.animal = animal;
    this.data = data;
    this.status = StatusExame.AGENDADO;
  }
}
