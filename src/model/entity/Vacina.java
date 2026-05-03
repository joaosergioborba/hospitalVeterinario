package model.entity;

import java.sql.Date;

import model.enums.TipoProduto;

public class Vacina extends RegistroClinico {
  private String dose;
  private Date data;

  public Vacina( Funcionario veterinario, Animal animal, Date data, Produto produto, String dose){
    
    super(veterinario, animal, produto);
    this.data = data;
    this.dose = dose;
  }

  public void alterarDose (String novaDose) {
    this.dose = novaDose;
  }

}


 