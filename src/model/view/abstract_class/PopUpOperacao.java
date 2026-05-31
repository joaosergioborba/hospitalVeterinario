package model.view.abstract_class;

import java.awt.Color;
import java.awt.Cursor;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//decidimos utilizar as classes abstratas porque nao devem ser instanciadas, uma vez que serão apenas um molde para as subclasses
abstract class PopUpOperacao extends PopUpModel{

  public PopUpOperacao(JFrame janelaPai, String tituloPagina){
    super(janelaPai, tituloPagina);
  }


  @Override
  public JPanel cabecalhoPadrao(){
    
    JPanel panel = new JPanel();

    URL enderecoSalvarIcon = getClass().getResource("/assets/salvarIcon.png");
    
    ImageIcon salvarIcon=new ImageIcon(enderecoSalvarIcon);
    
    JLabel salvarImagem = (new JLabel(salvarIcon));
   
    salvarImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    

    panel.setBackground(new Color(41, 128, 185));

    JLabel AvisoLabel = new JLabel("botoes em desenvolvimento");
    panel.add(salvarImagem);
    return panel;

  }


  @Override
  public JPanel rodapePadrao(){

    JPanel panel = new JPanel();

    URL enderecoSalvarIcon = getClass().getResource("/assets/salvarIcon.png");
    
    ImageIcon salvarIcon=new ImageIcon(enderecoSalvarIcon);
    
    JLabel salvarImagem = (new JLabel(salvarIcon));
   
    salvarImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    

    panel.setBackground(new Color(41, 128, 185));
    panel.add(salvarImagem);
    return panel;

  }
  
}
