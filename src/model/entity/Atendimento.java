package model.entity;

import java.sql.Date;

import model.enums.StatusAtendimento;

public class Atendimento {
  private int id;
  private Animal animal;
  private Funcionario veterinario;
  private Date data;
  private String observacoes;
  private Exame exame;
  private Medicacao medicacao;
  private Vacina vacina;
  private Produto produto;
  private StatusAtendimento status;

  public Atendimento(Animal animal, Funcionario veterinario, Date data, String observacoes, Exame exame, Medicacao medicacao, Vacina vacina, Produto produto) {
    this.animal = animal;
    this.veterinario = veterinario;
    this.data = data;
    this.observacoes = observacoes;
    this.exame = exame;
    this.medicacao = medicacao;
    this.vacina = vacina;
    this.produto = produto;
    this.status = StatusAtendimento.AGENDADO;
  }

}
