package model.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;

import java.awt.event.WindowAdapter;


import javax.swing.*;

import model.persistencia.Persistencia;
import model.service.ClinicaVeterinaria;


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

  public void setContent(JPanel contentPanel, String nomeTela) {
    
        // Torna o painel transparente para herdar a cor azul do fundo
        contentPanel.setOpaque(false); 
        //frame.setContentPane(contentPanel);
        //frame.revalidate();
        painelPrincipal.add(contentPanel, nomeTela);
    }

    public void show() {
        frame.setVisible(true);

    }

    public void adicionarTela(JPanel novaTela, String nomeTela){

      painelPrincipal.add(novaTela, nomeTela);

    }

    public void navegar(String nomeTela){

      cardLayout.show(painelPrincipal, nomeTela);
      frame.setSize(1500, 700);
      frame.setLocationRelativeTo(null);

    }

    public void configurarPersistencia(ClinicaVeterinaria clinica) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Persistencia.salvar(clinica);
                System.out.println("Dados salvos!");
            }
        });
    }


  
}
