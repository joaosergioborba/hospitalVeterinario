package model.view;
import javax.swing.JFrame;

import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpOperacao;


public class PopUpOperacaoIncluir_atendimento extends PopUpOperacao {

  public PopUpOperacaoIncluir_atendimento (JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria) {
    super(janelaPai, tituloPagina, clinicaVeterinaria);
  }

  
  
}
