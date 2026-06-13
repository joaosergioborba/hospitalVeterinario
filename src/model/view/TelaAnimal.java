package model.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.entity.Animal;
import model.service.ClinicaVeterinaria;
import model.view.PopUpOperacao.PopUpOperacaoIncluir_animal;
import model.view.PopUpOperacao.PopUpOperacaoListar_animal;
import model.view.abstract_class.PopUpModel;
import model.view.abstract_class.PopUpOperacaoIncluir;
import model.view.conteudoPopUps.PopUpEmDesenvolvimento;
import model.view.conteudoPopUps.PopUpIncluirAnimal;

public class TelaAnimal extends PopUpModel {

  public TelaAnimal(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){

    super(janelaPai, tituloPagina, clinicaVeterinaria);

  }
  

  @Override
  public void incluirButtonClicked() {

    //JPanel janelaPai = (JPanel) SwingUtilities.getWindowAncestor(this);
    PopUpOperacaoIncluir_animal telaCadastro = new PopUpOperacaoIncluir_animal(janelaPai, "Cadastrar um novo animal - PatasCloud", clinicaVeterinaria);
    //PopUpModel telaDesenvolvimento = new PopUpModel(janelaPai, "Tela em desenvolvimento");
    //PopUpIncluirAnimal popUp = new PopUpIncluirAnimal();
    //telaCadastro.setContent(popUp);
    //telaCadastro.show();
  }


  @Override
  public void pesquisarButtonClicked(JPanel panel){

    PopUpOperacaoListar_animal telaListagem = new PopUpOperacaoListar_animal(janelaPai, "Lista de animais cadastrado - PatasCloud", clinicaVeterinaria, clinicaVeterinaria.listarAnimaisCadastrados(true));
  }
}
