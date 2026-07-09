package model.view.recepcao;

import java.awt.BorderLayout;

import javax.swing.*;

import model.service.ClinicaVeterinaria;
import model.view.conteudoPopUps.PopUpEmDesenvolvimento;
import model.view.recepcao.telasBase.TelaAnimal;
import model.view.recepcao.telasBase.TelaAtendimento;
import model.view.recepcao.telasBase.TelaCheckIn;
import model.view.recepcao.telasBase.TelaFuncionario;
import model.view.recepcao.telasBase.TelaTutor;


public class TelaRecepcao {
  private ClinicaVeterinaria clinicaVeterinaria;
  private JFrame janelaPai;
  private JDialog jDialog;
  private JPanel painelBase;
  

  public  TelaRecepcao(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    this.janelaPai = janelaPai;
    this.clinicaVeterinaria = clinicaVeterinaria;

   

    jDialog = new JDialog(janelaPai, tituloPagina, false);
    jDialog.setSize(1400, 600);
    jDialog.setLocationRelativeTo(janelaPai);
    jDialog.setResizable(false);
    jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    painelBase = new JPanel(new BorderLayout());
    jDialog.setContentPane(painelBase);
    painelBase.add(conteudoPagina(janelaPai));
    
  }

  public JPanel conteudoPagina(JFrame Pai){

  
    JPanel panel = new JPanel();
    JLabel labelBemVindo = new JLabel("Seja Bem-vindo de volta, usuario!");
    JLabel labelInstrucoes = new JLabel("Fluxo para o caminho feliz -> \n 1- Aperte no botão lancar entrada \n 2- Digite os dados solicitados ou aperte no botão carregar dados padrao \n 3 - Aperte em lançar OBS: OS BOTÕES SUPERIORES DA TELA APERTA AINDA ESTÃO EM DESENVOLVIMENTO");

    JLabel caminho = new JLabel("------------ CAMINHO PARA GERENCIAR ANIMAIS ---------");

    JLabel labelInstrucoesAnimal = new JLabel("1 - Click em gerenciar animais \n 2 - Click no botão INCLUIR no cabeçalho da tela \n 3 - preencha os dados (OBS: O CAMPO ID ANIMAL  E NOME DO TUTOR NÃO DEVE SER PREENCHIDO) OU APERTE EM CARREGAR DADOS PADROES \n" );
    JLabel labelInstrucoesAnimal2 = new JLabel("5 - Apos apertar em lancar, o campo ID ANIMAL será preenchido com o id do animal OBS(O CAMPO NOME DO TUTOR SERÁ PREENCHIDO AUTOMATICAMENTE APOS UM ID TUTOR VALIDOR FOR PREENCHIDO)" );

    JButton funcionarioButton = new JButton("Gerenciar funcionários");
    JButton tutorButton = new JButton("Gerenciar tutores");
    JButton animalButton = new JButton("Gerenciar animais");
    JButton atendimentolButton = new JButton("Gerenciar Atendimentos");
    JButton checkInButton = new JButton("CheckIn Animal");
    

    funcionarioButton.addActionListener(e->{
      gerenciarFuncionarioButtonClicked(Pai);
    });

    tutorButton.addActionListener(e->{
     gerenciarTutorButtonClicked(Pai);
    });
    animalButton.addActionListener(e->{
      gerenciarAnimalButtonClicked(Pai);
    });

    atendimentolButton.addActionListener(e->{

      gerenciarAtendimentoButtonClicked(Pai);

    });

    checkInButton.addActionListener(e->{

      checkInButtonClicked(Pai);

    });

    panel.add(labelBemVindo);
    panel.add(funcionarioButton);
    panel.add(tutorButton);
    panel.add(animalButton);
    panel.add(atendimentolButton);
    panel.add(checkInButton);

    panel.add(labelInstrucoes);
    panel.add(caminho);
    panel.add(labelInstrucoesAnimal);
    panel.add(labelInstrucoesAnimal2);
    return panel;
   

  }


  private void gerenciarAnimalButtonClicked(JFrame Pai){
    TelaAnimal telaGerenciarAnimais = new TelaAnimal(Pai, "Gerenciar animais - PatasCloud", clinicaVeterinaria);
    //PopUpModel telaDesenvolvimento = new PopUpModel(janelaPai, "Tela em desenvolvimento");
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    telaGerenciarAnimais.setContent(popUp);
    telaGerenciarAnimais.show();
  }
  private void gerenciarTutorButtonClicked(JFrame Pai){
    TelaTutor telaGerenciarTutores = new TelaTutor(Pai, "Gerenciar tutores - PatasCloud", clinicaVeterinaria);
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    telaGerenciarTutores.setContent(popUp);
    telaGerenciarTutores.show();
  }
  private void gerenciarFuncionarioButtonClicked(JFrame Pai){
    TelaFuncionario telaGerenciarFuncionario = new TelaFuncionario(Pai, "Gerenciar Funcionarios - PatasCloud", clinicaVeterinaria);
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    telaGerenciarFuncionario.setContent(popUp);
    telaGerenciarFuncionario.show();
  }
  private void gerenciarAtendimentoButtonClicked(JFrame Pai){
    TelaAtendimento telaGerenciarAtendimento = new TelaAtendimento(Pai, "Gerenciar Atendimentos - PatasCloud", clinicaVeterinaria);
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    telaGerenciarAtendimento.setContent(popUp);
    telaGerenciarAtendimento.show();
  }
  private void checkInButtonClicked(JFrame Pai){
    TelaCheckIn tela = new TelaCheckIn(Pai, "Gerenciar Check-IN - PatasCloud", clinicaVeterinaria);
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    tela.setContent(popUp);
    tela.show();
  }

   public void show(){
    jDialog.setVisible(true);
  }

  public void close(){
    jDialog.dispose();
  }
  

}
