package model.entity;

import java.sql.Date;

public class Medicacao extends RegistroClinico{

  public Medicacao(Produto produto, Funcionario veterinario, Animal animal, Date data){
    super(veterinario, animal, produto, data);
  }
}
