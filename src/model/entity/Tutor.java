package model.entity;

import java.time.LocalDate;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


//estou usando herança pq nao estava fazendo sentido nao usar herença. da forma q estava basicamemente esta duplicando o cadastro, entao um tutor teria um id e a pessoa ligada a esse tutor teria outro id. 
public class Tutor extends Pessoa {
  private boolean tutorAtivo;
  private List<Atendimento> atendimentos;

  public Tutor(String cpf, String nome, LocalDate dataNascimento, String endereco) {
    super(cpf, nome, dataNascimento, endereco); // aqui esta chamando o construtor (acho q é esse o nome )da classe pai (Pessoa) - tipo a funcao principal la da classe principal.

    this.tutorAtivo = true;
    this.atendimentos = new ArrayList<>();
  }

  public void desativarTutor(){
    tutorAtivo = false;
  }
  public void ativarTutor(){
    tutorAtivo = true;
  }

  public void adicionarAtendimento (Atendimento atendimento){
    this.atendimentos.add(atendimento);
  }

  public Pessoa getPessoa() {
    return this;
  }



}
