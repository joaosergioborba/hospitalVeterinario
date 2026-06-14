package model.view.recepcao.telasBase;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.service.ClinicaVeterinaria;
import model.view.recepcao.popUpOperacao.PopUpOperacaoIncluir_funcionario;
import model.view.recepcao.popUpOperacao.PopUpOperacaoListar_Funcionario;
import model.view.abstract_class.PopUpModel;

public class TelaFuncionario extends PopUpModel{


   public TelaFuncionario(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){

    super(janelaPai, tituloPagina, clinicaVeterinaria);

  }
  

  @Override
  public void incluirButtonClicked() {

    PopUpOperacaoIncluir_funcionario telaCadastro = new PopUpOperacaoIncluir_funcionario(janelaPai, "Cadastrar um novo funcionário - PatasCloud", clinicaVeterinaria);
    
  }


  @Override
  public void pesquisarButtonClicked(JPanel panel){

    PopUpOperacaoListar_Funcionario telaListagem = new PopUpOperacaoListar_Funcionario(janelaPai, "Lista de funcionários cadastrados - PatasCloud", clinicaVeterinaria, clinicaVeterinaria.listarFuncionariosCadastrados(true));
  }
  
}
