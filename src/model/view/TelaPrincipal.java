package model.view;

import javax.swing.*;

import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpModel;
import model.view.abstract_class.PopUpOperacao;
import model.view.conteudoPopUps.PopUpEmDesenvolvimento;

//usei heranca de JPanel pq ai nao precisamos ficar colocando JPanel toda hr
public class TelaPrincipal extends JPanel {
  private ClinicaVeterinaria clinicaVeterinaria;

  public TelaPrincipal(ClinicaVeterinaria clinicaVeterinaria){

    this.clinicaVeterinaria = clinicaVeterinaria;
    JLabel labelBemVindo = new JLabel("Seja Bem-vindo de volta, usuario!");
    JLabel labelInstrucoes = new JLabel("Fluxo para o caminho feliz -> \n 1- Aperte no botão lancar entrada \n 2- Digite os dados solicitados ou aperte no botão carregar dados padrao \n 3 - Aperte em lançar OBS: OS BOTÕES SUPERIORES DA TELA APERTA AINDA ESTÃO EM DESENVOLVIMENTO");

    JLabel caminho = new JLabel("------------ CAMINHO PARA GERENCIAR ANIMAIS ---------");

    JLabel labelInstrucoesAnimal = new JLabel("1 - Click em gerenciar animais \n 2 - Click no botão INCLUIR no cabeçalho da tela \n 3 - preencha os dados (OBS: O CAMPO ID ANIMAL  E NOME DO TUTOR NÃO DEVE SER PREENCHIDO) OU APERTE EM CARREGAR DADOS PADROES \n" );
    JLabel labelInstrucoesAnimal2 = new JLabel("5 - Apos apertar em lancar, o campo ID ANIMAL será preenchido com o id do animal OBS(O CAMPO NOME DO TUTOR SERÁ PREENCHIDO AUTOMATICAMENTE APOS UM ID TUTOR VALIDOR FOR PREENCHIDO)" );

    JButton funcionarioButton = new JButton("Gerenciar funcionários");
    JButton tutorButton = new JButton("Gerenciar tutores");
    JButton animalButton = new JButton("Gerenciar animais");
    JButton EntradaAnimalButton = new JButton("Dar entrada animal");
    JButton atendimentolButton = new JButton("Gerenciar Atendimentos");
    

    EntradaAnimalButton.addActionListener(e-> {
     entradaAnimal();
    });

    funcionarioButton.addActionListener(e->{
      telaEmDesenvolvimento();
    });

    tutorButton.addActionListener(e->{
      telaEmDesenvolvimento();
    });
    animalButton.addActionListener(e->{
      gerenciarAnimalButtonClicked();
    });


    add(labelBemVindo);
    add(EntradaAnimalButton);
    add(funcionarioButton);
    add(tutorButton);
    add(animalButton);
    add(atendimentolButton);

    add(labelInstrucoes);
    add(caminho);
    add(labelInstrucoesAnimal);
    add(labelInstrucoesAnimal2);
   

  }

  private void entradaAnimal(){
     JFrame janelaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
      PopUpModel telaEntrada = new PopUpModel(janelaPai, "Tela entrada de animal - PatasCloud", clinicaVeterinaria);
      TelaEntradaAnimal telaLancamentoEntrada = new TelaEntradaAnimal(clinicaVeterinaria);

      telaEntrada.setContent(telaLancamentoEntrada);
        telaEntrada.show();
  }

  private void funcionarioButtonClicked(){

    JFrame janelaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
    PopUpModel telaFuncionarios = new PopUpModel(janelaPai, "Gerenciamento de funcionarios", clinicaVeterinaria);

    



    
  }



  private void telaEmDesenvolvimento(){
    JFrame janelaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
    PopUpOperacao telaDesenvolvimento = new PopUpOperacao(janelaPai, "Tela em desenvolvimento", clinicaVeterinaria);
    //PopUpModel telaDesenvolvimento = new PopUpModel(janelaPai, "Tela em desenvolvimento");
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    telaDesenvolvimento.setContent(popUp);
    telaDesenvolvimento.show();
  }

  private void gerenciarAnimalButtonClicked(){
    JFrame janelaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
    TelaAnimal telaGerenciarAnimais = new TelaAnimal(janelaPai, "Gerenciar animais - PatasCloud", clinicaVeterinaria);
    //PopUpModel telaDesenvolvimento = new PopUpModel(janelaPai, "Tela em desenvolvimento");
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    telaGerenciarAnimais.setContent(popUp);
    telaGerenciarAnimais.show();
  }
  

}
