package model.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.*;


public class Screen{

  private JFrame frame;
  private JPanel painelPrincipal; 
  private CardLayout cardLayout;

  public Screen(String tituloPagina, int width, int height) {
    frame = new JFrame(tituloPagina);
    frame.setSize(width, height);
    frame.getContentPane().setBackground(new Color(236, 250, 255));
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    cardLayout = new CardLayout();
    painelPrincipal = new JPanel(cardLayout);
    painelPrincipal.setBackground(new Color(236, 250, 255));
    frame.add(painelPrincipal);
  
  }

  public void setContent(JPanel contentPanel) {
    
        // Torna o painel transparente para herdar a cor azul do fundo
        contentPanel.setOpaque(false); 
        //frame.setContentPane(contentPanel);
        //frame.revalidate();
        painelPrincipal.add(contentPanel, "teste");
    }

    public void show() {
        frame.setVisible(true);
    }



  
}
