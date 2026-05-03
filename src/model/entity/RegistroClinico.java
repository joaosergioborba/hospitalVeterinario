package model.entity;

import java.sql.Date;

public class RegistroClinico {

  private int id;
  private Funcionario veterinario;
  private Animal animal;
  private Produto produto;
  private Date data;

  public RegistroClinico(Funcionario veterinario, Animal animal, Produto produto, Date data){
    this.veterinario = veterinario;
    this.animal = animal;
    this.data = data;
  }

  
}
