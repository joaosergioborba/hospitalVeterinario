package model.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.service.ClinicaVeterinaria;
import model.view.PopUpOperacao.PopUpOperacaoIncluir_animal;
import model.view.PopUpOperacao.PopUpOperacaoIncluir_funcionario;
import model.view.PopUpOperacao.PopUpOperacaoIncluir_tutor;
import model.view.PopUpOperacao.PopUpOperacaoListar_Funcionario;
import model.view.PopUpOperacao.PopUpOperacaoListar_animal;
import model.view.PopUpOperacao.PopUpOperacaoListar_tutor;
import model.view.abstract_class.PopUpModel;

public class TelaFuncionario extends PopUpModel{


   public TelaFuncionario(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){

    super(janelaPai, tituloPagina, clinicaVeterinaria);

  }
  

  @Override
  public void incluirButtonClicked() {

    PopUpOperacaoIncluir_funcionario telaCadastro = new PopUpOperacaoIncluir_funcionario(janelaPai, "Cadastrar um novo animal - PatasCloud", clinicaVeterinaria);
    
  }


  @Override
  public void pesquisarButtonClicked(JPanel panel){

    PopUpOperacaoListar_Funcionario telaListagem = new PopUpOperacaoListar_Funcionario(janelaPai, "Lista de tutores cadastrados - PatasCloud", clinicaVeterinaria, clinicaVeterinaria.listarFuncionariosCadastrados(true));
  }
  
}
