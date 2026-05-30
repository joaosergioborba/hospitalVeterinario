package model.view;

import java.awt.Color;
import java.awt.Cursor;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopUpOperacoes extends PopUpModel{

  public PopUpOperacoes(JFrame janelaPai, String tituloPagina){
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
  
}
