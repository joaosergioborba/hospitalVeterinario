package model.view.manual;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.*;

import model.service.ClinicaVeterinaria;

public class TelaManual {
  private ClinicaVeterinaria clinicaVeterinaria;
  private JFrame janelaPai;
  private JDialog jDialog;
  private JPanel painelBase;
  
  public  TelaManual(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
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
  
    URL qrCode = getClass().getResource("/assets/qrCode.png");

    ImageIcon qrCodeImage =new ImageIcon(qrCode);
    JLabel qrCodeLabel = new JLabel(qrCodeImage);

    JLabel label = new JLabel("Manual do sistema");
    JLabel label2 = new JLabel("escaneie o qr code ou acesse: https://drive.google.com/drive/folders/1Vl6s2RcGzxh4QfWeYoeCHHD8fn360E1d?usp=sharing");

    panel.add(label);
    panel.add(qrCodeLabel);
    panel.add(label2);
    
    return panel;
   

  }

  
   public void show(){
    jDialog.setVisible(true);
  }

  public void close(){
    jDialog.dispose();
  }
  

}
