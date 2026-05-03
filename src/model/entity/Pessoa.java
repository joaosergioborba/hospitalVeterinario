package model.entity;

import java.sql.Date;

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

  public void alterarEndereco(String enderecoNovo){
    this.endereco = enderecoNovo;
  }

  public void buscarDados(){
    // nao sei como fazer o return  ainda :(
  }
}
