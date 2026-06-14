package model.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.service.ClinicaVeterinaria;
import model.view.PopUpOperacao.PopUpOperacaoIncluir_animal;
import model.view.PopUpOperacao.PopUpOperacaoIncluir_tutor;
import model.view.PopUpOperacao.PopUpOperacaoListar_animal;
import model.view.PopUpOperacao.PopUpOperacaoListar_tutor;
import model.view.abstract_class.PopUpModel;

public class TelaTutor extends PopUpModel{


   public TelaTutor(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){

    super(janelaPai, tituloPagina, clinicaVeterinaria);

  }
  

  @Override
  public void incluirButtonClicked() {

    PopUpOperacaoIncluir_tutor telaCadastro = new PopUpOperacaoIncluir_tutor(janelaPai, "Cadastrar um novo tutor - PatasCloud", clinicaVeterinaria);
    
  }


  @Override
  public void pesquisarButtonClicked(JPanel panel){

    PopUpOperacaoListar_tutor telaListagem = new PopUpOperacaoListar_tutor(janelaPai, "Lista de tutores cadastrados - PatasCloud", clinicaVeterinaria, clinicaVeterinaria.listarTutoresCadastrados(true));
  }
  
}
