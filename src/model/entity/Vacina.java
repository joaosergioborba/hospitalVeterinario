package model.entity;

import java.sql.Date;

import model.enums.TipoProduto;

public class Vacina extends RegistroClinico {
  private String dose;

  public Vacina( Funcionario veterinario, Animal animal, Date data, Produto produto, String dose){
    
    super(veterinario, animal, produto, data);
    this.dose = dose;
  }

  public String getDose(){
    return this.dose;
  }
  public void setDose(String novaDose) {
     this.dose = novaDose;
  }
  

}


 
