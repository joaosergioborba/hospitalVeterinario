package model.entity;

public class RegistroClinico {

  private int id;
  private Funcionario veterinario;
  private Animal animal;
  private Produto produto;

  public RegistroClinico(Funcionario veterinario, Animal animal, Produto produto){
    this.veterinario = veterinario;
    this.animal = animal;
  }

  
}
