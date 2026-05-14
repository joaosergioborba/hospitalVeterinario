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
  private StatusAtendimento status;
  //Removi os atributos individuais exame, medicacao, etc. conforme os avisos no seu VS , como todos eles herdam de RegistroClinico
  // usamos somente a lista abaixo
  protected List<RegistroClinico> procedimentos; //precisamos atualizar o uml

  //to usando protected em alguns pq isso permite que os filhos tbm acesse diretamente essa tag

  public Atendimento(Animal animal, Date data, String observacoes, Funcionario veterinario ) {
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

  public void atribuirAnimal(Animal animal){
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
//Mudei o retorno de 'void' para 'List<RegistroClinico>', permitindo que outras classes acessem o histórico do atendimento ( dica da professora)
public List<RegistroClinico> exportarProntuario(){
        return this.procedimentos; 
    }
   
    public int getId() {
        return id;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public StatusAtendimento getStatus() {
        return status;
    }

    public void setStatus(StatusAtendimento status) {
        this.status = status;
    }
}
