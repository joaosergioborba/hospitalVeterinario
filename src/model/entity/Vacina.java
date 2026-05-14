package model.entity;

import java.sql.Date;

//  Removi o "import model.enums.TipoProduto;" que aparecia em aviso amarelo
//  Comonãi usamos o enum TipoProduto dentro desta classe  o import é desnecessário

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


 
