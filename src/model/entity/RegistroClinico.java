package model.entity;

import java.io.Serializable;
import java.sql.Date;

public class RegistroClinico implements Serializable {
  private static final long serialVersionUID = 1L;
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

  public int getId(){
    return id;
  }

  public Funcionario getVeterinario(){
    return veterinario;
  }

  public void setVeterinario(Funcionario veterinario){
    this.veterinario = veterinario;
  }

  public Animal getAnimal(){
    return animal;
  }

  public void setAnimal(Animal animal){
    this.animal = animal;
  }

  public Produto getProduto(){
    return produto;
  }

  public void setProduto(Produto produto){
    this.produto = produto;
  }

  public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

  
}
