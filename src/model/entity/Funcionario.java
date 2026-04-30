package model.entity;

import model.enums.Funcao;

public class Funcionario {
  private Pessoa pessoa;
  private Funcao funcao;
  private String especialidade;
  private boolean funcionarioAtivo;

  public Funcionario(Pessoa pessoa, Funcao funcao, String especialidade) {
    this.pessoa = pessoa;
    this.funcao = funcao;
    this.especialidade = especialidade;
    this.funcionarioAtivo = true;
  }

}
