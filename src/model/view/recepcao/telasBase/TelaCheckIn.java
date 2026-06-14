package model.view.recepcao.telasBase;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.service.ClinicaVeterinaria;
import model.view.recepcao.popUpOperacao.PopUpOperacaoCheckIn_animal;
import model.view.recepcao.popUpOperacao.PopUpOperacaoIncluir_atendimento;
import model.view.recepcao.popUpOperacao.PopUpOperacaoListar_atendimento;
import model.view.abstract_class.PopUpModel;

public class TelaCheckIn  extends PopUpModel{


   public TelaCheckIn(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){

    super(janelaPai, tituloPagina, clinicaVeterinaria);

  }
  

  @Override
  public void incluirButtonClicked() {

    PopUpOperacaoCheckIn_animal telaCadastro = new PopUpOperacaoCheckIn_animal(janelaPai, "CheckIn animal - PatasCloud", clinicaVeterinaria);
    
  }


  @Override
  public void pesquisarButtonClicked(JPanel panel){


    PopUpOperacaoListar_atendimento telaListagem = new PopUpOperacaoListar_atendimento(janelaPai, "Lista de atendimentos cadastrados - PatasCloud", clinicaVeterinaria, clinicaVeterinaria.listarAtendimentosCadastrados(true));
  }
  
}
