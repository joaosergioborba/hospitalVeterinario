package model.entity;

import java.sql.Date;


//estou usando herança pq nao estava fazendo sentido nao usar herença. da forma q estava basicamemente esta duplicando o cadastro, entao um tutor teria um id e a pessoa ligada a esse tutor teria outro id. 
public class Tutor extends Pessoa {
  private boolean tutorAtivo;

  public Tutor(String cpf, String nome, Date dataNascimento, String endereco) {
    super(cpf, nome, dataNascimento, endereco); // aqui esta chamando o construtor (acho q é esse o nome )da classe pai (Pessoa) - tipo a funcao principal la da classe principal.

    this.tutorAtivo = true;
  }

  public void desativarTutor(){
    tutorAtivo = false;
  }


}
