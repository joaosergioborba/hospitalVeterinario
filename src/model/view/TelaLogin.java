package model.view;

import java.awt.*;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.service.ClinicaVeterinaria;

//usei heranca de JPanel pq ai nao precisamos ficar colocando JPanel toda hr
public class TelaLogin {

  private JDialog jDialog;
  private JPanel painelBase;
  private JFrame janelaPai;

  private ClinicaVeterinaria clinicaVeterinaria;
  private Runnable acaoAoLogar;

  public  TelaLogin(JFrame Pai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria, Runnable acao){
    this.janelaPai = Pai;
    this.clinicaVeterinaria = clinicaVeterinaria;
    this.acaoAoLogar = acao;
    jDialog = new JDialog(janelaPai, tituloPagina, false);
    jDialog.setSize(420, 330);
    jDialog.setLocationRelativeTo(janelaPai);
    jDialog.setResizable(false);
    jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    painelBase = new JPanel(new BorderLayout());
    jDialog.setContentPane(painelBase);
    painelBase.add(conteudoPagina(Pai, clinicaVeterinaria, acao));
    
  }



  public JPanel conteudoPagina(JFrame pai, ClinicaVeterinaria clinicaVeterinaria, Runnable acaoAoLogar){

    JPanel panel = new JPanel(new GridLayout(7, 1, 8, 8));
    panel.setBackground(Color.WHITE);
    panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 35, 15, 35));
    
    JLabel labelBemVindo = new JLabel("Bem-vindo ao PatasCloud", JLabel.CENTER);
    URL imageURL = getClass().getResource("/assets/logo_sem_fundo.png");
    ImageIcon logo = new ImageIcon(((new ImageIcon(imageURL)).getImage()).getScaledInstance(130, 80, Image.SCALE_SMOOTH));
    JLabel imagem = new JLabel(logo, JLabel.CENTER);

    
    JLabel labelUsuario = new JLabel("Usuário:");
    JTextField campoUsuario = new JTextField(30);


    JLabel labelSenha = new JLabel("Senha:");
    JPasswordField campoSenha = new JPasswordField(30);


    JButton loginButton = new JButton("Entrar");
  

    loginButton.addActionListener(e -> {
      String usuarioDigitado = campoUsuario.getText();
      String senhaDigitada = new String(campoSenha.getPassword());


      if(usuarioDigitado.isEmpty() || senhaDigitada.trim().isEmpty()){

        JOptionPane.showMessageDialog(null, "Campos preenchidos incorretamente.");
        return;

      }

      if(!(clinicaVeterinaria.login(usuarioDigitado, senhaDigitada))){

        JOptionPane.showMessageDialog(null, "Usuário ou senha são invalidos");
        return;

      }

      acaoAoLogar.run();
      close();


    });

    panel.add(imagem);

    panel.add(labelBemVindo);

    panel.add(labelUsuario);
    panel.add(campoUsuario);

    panel.add(labelSenha);
    panel.add(campoSenha);

  panel.add(loginButton);
    return panel;
  }

   public void show(){
    jDialog.setVisible(true);
  }

  public void close(){
    jDialog.dispose();
  }

}
