package model.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.enums.StatusAtendimento;

public class Atendimento {
  private int id;
  private Animal animal;
  private Funcionario veterinario;
  private LocalDate data;
  private String observacoes;
  private String diagnostico; //atualizar uml
  private StatusAtendimento status;
  protected List<RegistroClinico> procedimentos; //precisamos atualizar o uml

  //to usando protected em alguns pq isso permite que os filhos tbm acesse diretamente essa tag

  public Atendimento(Animal animal, LocalDate data, String observacoes, Funcionario veterinario ) {
    this.animal = animal;
    this.data = data;
    this.veterinario = veterinario;
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
   
    public int getId() {
        return id;
    }

    public void setId(int id){
      this.id = id;
    }
    
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Funcionario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Funcionario veterinario) {
        this.veterinario = veterinario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDiagnostico(){
      return this.diagnostico;
    }

    public void setDiagnostico(String diagnostico){
      this.diagnostico = diagnostico;
    }

    public StatusAtendimento getStatus() {
        return status;
    }

    public void setStatus(StatusAtendimento status) {
        this.status = status;
    }

}
