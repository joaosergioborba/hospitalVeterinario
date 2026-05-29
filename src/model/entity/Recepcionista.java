package model.entity;

import java.time.LocalDate;

import model.enums.Funcao;

public class Recepcionista extends Funcionario{

  public Recepcionista(String cpf, String nome, LocalDate dataNascimento, String endereco, Funcao funcao, String especialidade, double salarioBase, String senha) {

    super(cpf, nome, dataNascimento, endereco, funcao, especialidade, salarioBase, senha);
  }

  @Override
        public double calcularSalario(int qtdConsultasRealizadas) {
            return this.getSalarioBase();
        }
  
}
