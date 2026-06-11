package model.view;
import javax.swing.*;
import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpModel;

public class TelaFuncionario extends JPanel{
  private ClinicaVeterinaria clinicaVeterinaria;

  public TelaFuncionario(ClinicaVeterinaria clinicaVeterinaria){
    
   this.clinicaVeterinaria = clinicaVeterinaria;

  }

}