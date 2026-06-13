package model.entity;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
  private int id;
  private String cpf;
  private String nome;
  private LocalDate dataNascimento;
  
  protected String endereco;
  protected boolean pessoaAtiva;

  public Pessoa(String cpf, String nome, LocalDate dataNascimento, String endereco){
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
  public void setId(int id){
    this.id = id;
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
    LocalDate nascimento = dataNascimento;
    return Period.between(nascimento, hoje).getYears();

  }

  public String getEndereco(){
    return endereco;
  }

  public void setEndereco(String endereco){
    this.endereco = endereco;
  }

  public void setNascimento(LocalDate data){
    this.dataNascimento = data;
  }
  public LocalDate getNascimento(){
    return this.dataNascimento;
  }

  public boolean isPessoaAtiva(){
    return this.pessoaAtiva;
  }
}
