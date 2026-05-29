package model.view;

import javax.swing.*;

import model.service.ClinicaVeterinaria;

public class TelaPrincipal extends JPanel {
  private ClinicaVeterinaria clinicaVeterinaria;

  public TelaPrincipal(ClinicaVeterinaria clinicaVeterinaria){

    this.clinicaVeterinaria = clinicaVeterinaria;
    JLabel labelBemVindo = new JLabel("Seja Bem-vindo de volta, usuario");


    add(labelBemVindo);
   

  }
  

}
