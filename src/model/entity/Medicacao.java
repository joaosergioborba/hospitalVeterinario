package model.entity;

import java.sql.Date;

public class Medicacao extends RegistroClinico{

    private String dose;

  public Medicacao(Produto produto, Funcionario veterinario, Animal animal, Date data, String dose){
    super(veterinario, animal, produto, data);

    this.dose = dose;
  }

  public String getDose(){
    return dose;
  }

  public void setDose(String dose){
    this.dose = dose;
  }
    
}
