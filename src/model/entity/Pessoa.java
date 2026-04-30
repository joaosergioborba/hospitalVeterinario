package model.entity;

public class Pessoa {
  private int id;
  private String cpf;
  private String nome;
  private int idade;
  private String endereco;

  public Pessoa(String cpf, String nome, int idade, String endereco){
    this.cpf = cpf;
    this.nome = nome;
    this.idade = idade;
    this.endereco = endereco;
  }
}
