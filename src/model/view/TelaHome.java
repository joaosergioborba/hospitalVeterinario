package model.view;

import java.net.URL;

import javax.swing.*;

import model.service.ClinicaVeterinaria;
import model.view.manual.TelaManual;
import model.view.recepcao.TelaRecepcao;


//usei heranca de JPanel pq ai nao precisamos ficar colocando JPanel toda hr
public class TelaHome extends JPanel {
  private ClinicaVeterinaria clinicaVeterinaria;

  public TelaHome(ClinicaVeterinaria clinicaVeterinaria){

    this.clinicaVeterinaria = clinicaVeterinaria;
  



    JLabel boasVindas = new JLabel("PatasCloud - Hospital veterinário");
     URL manualSistemaCaminho = getClass().getResource("/assets/manualIcon.png");
     URL centroDiagnosticoCaminho = getClass().getResource("/assets/centroDiagnosticoIcon.png");
     URL consultorioCaminho = getClass().getResource("/assets/consultorioIcon.png");
     URL recepcaoCaminho = getClass().getResource("/assets/recepcaoIcon.png");

     ImageIcon manualSistemaIcon = new ImageIcon(manualSistemaCaminho);
     ImageIcon centroDiagnosticoIcon = new ImageIcon(centroDiagnosticoCaminho);
     ImageIcon consultorioIcon = new ImageIcon (consultorioCaminho);
     ImageIcon recepcaoIcon = new ImageIcon(recepcaoCaminho);

     JButton manualSistemaButton = new JButton();
     JButton centroDiagnosticoButton = new JButton();
     JButton consultorioButton = new JButton();
     JButton recepcaoButton = new JButton();

     manualSistemaButton.setIcon(manualSistemaIcon);
     manualSistemaButton.setText("Manual do sistema");
     
     centroDiagnosticoButton.setIcon(centroDiagnosticoIcon);
     centroDiagnosticoButton.setText("Centro de diagnosticos");

     consultorioButton.setIcon(consultorioIcon);
     consultorioButton.setText("Consultorio");

     recepcaoButton.setIcon(recepcaoIcon);
     recepcaoButton.setText("Recepção");


     manualSistemaButton.addActionListener(e-> {
     abrirManualSistema();
    });

    centroDiagnosticoButton.addActionListener(e->{
      abrirCentroDiagnostico();
    });

    consultorioButton.addActionListener(e->{
     abrirConsultorio();
    });
    recepcaoButton.addActionListener(e->{
      abrirRecepcao();
    });


    add(boasVindas);
    add(recepcaoButton);
    add(consultorioButton);
    add(centroDiagnosticoButton);
    add(manualSistemaButton);

  }

  private void abrirManualSistema(){

     JFrame janelaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
    TelaManual telaRecepcao = new TelaManual(janelaPai, "Tela Manual - PatasCloud", clinicaVeterinaria);
    telaRecepcao.show();
    
  }

  private void abrirCentroDiagnostico(){
    telaEmDesenvolvimento();
  }



  private void abrirConsultorio(){
    telaEmDesenvolvimento();
    
  }

  private void abrirRecepcao(){

    loginRecepcao(clinicaVeterinaria);
    
  }

  public void login(Screen tela, JFrame janelaPai){

  }

  public void loginRecepcao (ClinicaVeterinaria sistemaClinica){
    JFrame janelaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
    TelaLogin login = new TelaLogin(janelaPai, "Login - PatasCloud",sistemaClinica, () ->{
        abrirTelaRecepcao(janelaPai, "tela teste", clinicaVeterinaria);
    });
    
    login.show();

    }


    public void abrirTelaRecepcao(JFrame Pai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){

      TelaRecepcao telaRecepcao = new TelaRecepcao(Pai, "Tela Recepção - PatasCloud", clinicaVeterinaria);
      telaRecepcao.show();
    }

    public void telaEmDesenvolvimento(){

      JOptionPane.showMessageDialog(null, "Quase lá! Esta funcionalidade está recebendo os últimos ajustes para entregar a melhor experiência para você...");

    }
  

}
