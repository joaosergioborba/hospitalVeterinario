package model.entity;


import model.enums.PorteAnimal;
import model.enums.TamanhoPelo;

public class Animal {
  private int id;
  private String nome;
  private int idade;
  private String raca;
  private String sexo;
  private TamanhoPelo pelagemTamanho;
  private String pelagemCor;
  private PorteAnimal porteAnimal;
  private Tutor tutor;
  private boolean animalAtivo;

  public Animal (String nome, int idade, String raca, String sexo, TamanhoPelo pelagemTamanho, String pelagemCor, PorteAnimal porteAnimal, Tutor tutor) {
    this.nome = nome;
    this.idade = idade;
    this.raca = raca;
    this.sexo = sexo;
    this.pelagemTamanho = pelagemTamanho;
    this.pelagemCor = pelagemCor;
    this.porteAnimal = porteAnimal;
    this.tutor = tutor;
    this.animalAtivo = true;
  }

}
