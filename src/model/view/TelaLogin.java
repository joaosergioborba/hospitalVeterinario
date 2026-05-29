package model.view;

import java.awt.*;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.service.ClinicaVeterinaria;

public class TelaLogin extends JPanel {

  private ClinicaVeterinaria clinicaVeterinaria;

  public TelaLogin(){
    
    JLabel labelBemVindo = new JLabel("Bem-vindo ao PatasCloud");
    URL imageURL = getClass().getResource("/assets/logo_sem_fundo.png");
    ImageIcon logo = new ImageIcon(((new ImageIcon(imageURL)).getImage()).getScaledInstance(180, 180, Image.SCALE_SMOOTH));
    JLabel imagem = new JLabel(logo);

    
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


    });


    add(imagem);
    add(labelBemVindo);

    add(labelUsuario);
    add(campoUsuario);

    add(labelSenha);
    add(campoSenha);

    add(loginButton);

  }

}
