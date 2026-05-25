package model.entity;

import java.time.LocalDate;

import model.enums.Funcao;

public class Veterinario extends Funcionario{
  private int qtdConsultasRealizadas;

  public Veterinario(String cpf, String nome, LocalDate dataNascimento, String endereco, Funcao funcao, String especialidade, double salarioBase) {

    super(cpf, nome, dataNascimento, endereco, funcao, especialidade, salarioBase);
  }
  

  @Override
    public double calcularSalario() {
      return this.getSalarioBase() + (qtdConsultasRealizadas * 50.0);
    }

    public void setQtdConsultasRealizadas(int qtd){
      this.qtdConsultasRealizadas = qtd;
    }

    public int getQtdConsultasRealizadas(){
      return qtdConsultasRealizadas;
    }
}
