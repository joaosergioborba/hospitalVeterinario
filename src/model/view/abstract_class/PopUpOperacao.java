package model.view.abstract_class;

import java.awt.Color;
import java.awt.Cursor;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.service.ClinicaVeterinaria;


//decidimos utilizar as classes abstratas porque nao devem ser instanciadas, uma vez que serão apenas um molde para as subclasses
public class PopUpOperacao extends PopUpModel{

  public PopUpOperacao(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    super(janelaPai, tituloPagina, clinicaVeterinaria);
  }


  @Override
  public JPanel cabecalhoPadrao(){
    
    JPanel panel = new JPanel();

    URL enderecoSalvarIcon = getClass().getResource("/assets/salvarIcon.png");
    
    ImageIcon salvarIcon=new ImageIcon(enderecoSalvarIcon);
    
    JButton salvar = new JButton();
    salvar.setIcon(salvarIcon);
    salvar.setText("Salvar");

    salvar.addActionListener(e->{
      salvarButtonClicked();
    });

    panel.setBackground(new Color(41, 128, 185));

    JLabel AvisoLabel = new JLabel("botoes em desenvolvimento");
    panel.add(salvar);
    return panel;

  }


  @Override
  public JPanel rodapePadrao(){

    JPanel panel = new JPanel();

    URL enderecoSalvarIcon = getClass().getResource("/assets/salvarIcon.png");
    
    ImageIcon salvarIcon=new ImageIcon(enderecoSalvarIcon);
    
   

    JButton salvar = new JButton();
    salvar.setIcon(salvarIcon);
    salvar.setText("Salvar");

    salvar.addActionListener(e->{
      salvarButtonClicked();
    });

   
    

    panel.setBackground(new Color(41, 128, 185));
    panel.add(salvar);
    return panel;

  }

  public void salvarButtonClicked(){}
  
}
