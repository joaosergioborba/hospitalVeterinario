package model.entity;

import java.time.LocalDate;

import model.enums.Funcao;

public class Veterinario extends Funcionario{
  

  public Veterinario(String cpf, String nome, LocalDate dataNascimento, String endereco, String especialidade, double salarioBase, String senha) {

    super(cpf, nome, dataNascimento, endereco, Funcao.MEDICO_VETERINARIO, especialidade, salarioBase, senha);
  }
  

  @Override
    public double calcularSalario(int qtdConsultasRealizadas) {
      return this.getSalarioBase() + (qtdConsultasRealizadas * 50.0);
    }
}
