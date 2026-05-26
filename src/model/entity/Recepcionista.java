package model.entity;

import java.time.LocalDate;

import model.enums.Funcao;

public class Recepcionista extends Funcionario{

  public Recepcionista(String cpf, String nome, LocalDate dataNascimento, String endereco, Funcao funcao, String especialidade, double salarioBase) {

    super(cpf, nome, dataNascimento, endereco, funcao, especialidade, salarioBase);
  }

  @Override
        public double calcularSalario(int qtdConsultasRealizadas) {
            return this.getSalarioBase();
        }
  
}
