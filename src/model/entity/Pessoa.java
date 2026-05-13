package model.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
  private int id;
  private String cpf;
  private String nome;
  private Date dataNascimento;
  protected String endereco;
  protected boolean pessoaAtiva;

  public Pessoa(String cpf, String nome, Date dataNascimento, String endereco){
    this.cpf = cpf;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.endereco = endereco;
    this.pessoaAtiva = true;
  }

  public void desativarPessoa(){
    this.pessoaAtiva = false;
  }
  public void ativarPessoa(){
    this.pessoaAtiva = true;
  }

  public int getId(){
    return id;
  }

  public String getCpf(){
    return cpf;
  }

  public void setCpf(String cpf){
    this.cpf = cpf;
  }

  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public int getIdade(){

    LocalDate hoje = LocalDate.now();
    LocalDate nascimento = dataNascimento.toLocalDate();
    return Period.between(nascimento, hoje).getYears();

  }

  public String getEndereco(){
    return endereco;
  }

  public void setEndereco(String endereco){
    this.endereco = endereco;
  }
}
