package model.view;

import java.net.URL;

import javax.swing.*;

import model.service.ClinicaVeterinaria;


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
    
  }

  private void abrirCentroDiagnostico(){
  }



  private void abrirConsultorio(){
    
  }

  private void abrirRecepcao(){

    login(clinicaVeterinaria);
    
  }

  public void login (ClinicaVeterinaria sistemaClinica){

        Screen tela = new Screen("Tela login - PatasCloud", 400, 300);
        TelaPrincipal telaPrincipal = new TelaPrincipal(sistemaClinica);
        TelaLogin login = new TelaLogin(sistemaClinica, () ->{

            
            tela.adicionarTela(telaPrincipal, "tela principal");;
            tela.navegar("tela principal");
        });

        tela.setContent(login, "login");
        tela.show();

    }
  

}
