package model.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
  protected List<RegistroClinico> procedimentos; //precisamos atualizar o uml

  //to usando protected em alguns pq isso permite que os filhos tbm acesse diretamente essa tag

  public Atendimento(Animal animal, Date data, String observacoes) {
    this.animal = animal;
    this.data = data;
    this.observacoes = observacoes;
    this.status = StatusAtendimento.AGENDADO;
    this.procedimentos = new ArrayList<>();
  }

  public void atribuirVeterinario(Funcionario veterinario){
    this.veterinario = veterinario;
  }

  public void atrubuirAnimal(Animal animal){
    this.animal = animal;
  }

  public void atribuirMedicacao(Medicacao medicacao){
    this.medicacao = medicacao;
  }
  public void atribuirExame(Exame exame){
    this.exame = exame;
  }
  public void atribuirVacina(Vacina vacina){
    this.vacina = vacina;
  }
  
  public void cancelarAtendimento(){
    this.status = StatusAtendimento.CANCELADO;
  }
  public void recepcaoParaAtendimento(){
    this.status = StatusAtendimento.ESPERA;
  }
  public void iniciarAtendimento(){
    this.status = StatusAtendimento.EM_ATENDIMENTO;
  }
  public void finalizarAtendimento(){
    this.status = StatusAtendimento.FINALIZADO;
  }

  public void adicionarProcedimento(RegistroClinico registro){
    this.procedimentos.add(registro);
  }

  public void exportarProntuario(){
    //nao sei como retornar o list do array /
  }
}
