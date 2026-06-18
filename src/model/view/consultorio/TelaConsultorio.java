package model.view.consultorio;

import java.awt.BorderLayout;

import javax.swing.*;

import model.service.ClinicaVeterinaria;
import model.view.conteudoPopUps.PopUpEmDesenvolvimento;
import model.view.recepcao.telasBase.TelaAnimal;
import model.view.recepcao.telasBase.TelaAtendimento;
import model.view.recepcao.telasBase.TelaCheckIn;
import model.view.recepcao.telasBase.TelaFuncionario;
import model.view.recepcao.telasBase.TelaTutor;


public class TelaConsultorio {
  private ClinicaVeterinaria clinicaVeterinaria;
  private JFrame janelaPai;
  private JDialog jDialog;
  private JPanel painelBase;
  

  public  TelaConsultorio(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
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
  
    JButton visualizarProximosButton = new JButton("Proximos atendimentos");
    JButton iniciarAtendimentoButton = new JButton("Atender proximo paciente");
    

    visualizarProximosButton.addActionListener(e->{
      gerenciarFuncionarioButtonClicked(Pai);
    });

    iniciarAtendimentoButton.addActionListener(e->{
     gerenciarTutorButtonClicked(Pai);
    });
   


    return panel;
   

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
  

   public void show(){
    jDialog.setVisible(true);
  }

  public void close(){
    jDialog.dispose();
  }
  

}
