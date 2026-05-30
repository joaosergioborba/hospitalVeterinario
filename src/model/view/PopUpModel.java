package model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PopUpModel {

  //esse recurso de dialog foi o unico jeito que achei para que quando eu fechar a tela nao feche o programa inteiro e sim so a janela, mas funciona de um jeito muito pareceido com o Jframe

  private JDialog jDialog;
  //private JPanel panel;
  private JPanel painelBase;

  public  PopUpModel(JFrame janelaPai, String tituloPagina){

    jDialog = new JDialog(janelaPai, tituloPagina, false);
    jDialog.setSize(900, 500);
    jDialog.setLocationRelativeTo(janelaPai);
    jDialog.setResizable(false);
    jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    JPanel CabecalhoPanel = cabecalhoPadrao();
    painelBase = new JPanel(new BorderLayout());
    painelBase.add(CabecalhoPanel, BorderLayout.NORTH);
    jDialog.setContentPane(painelBase);
    

  }

  public JPanel cabecalhoPadrao(){
    
    JPanel panel = new JPanel();

    URL enderecoIconeIncluir = getClass().getResource("/assets/incluirIcon.png");
    URL enderecoIconeEditar = getClass().getResource("/assets/editarIcon.png");
    URL enderecoIconeCarregar = getClass().getResource("/assets/carregarIcon.png");
    URL enderecoIconePesquisar = getClass().getResource("/assets/pesquisarIcon.png");
    URL enderecoIconeBaixar = getClass().getResource("/assets/BaixarIcon.png");

    ImageIcon incluirIcon=new ImageIcon(enderecoIconeIncluir);
    ImageIcon editarIcon=new ImageIcon(enderecoIconeEditar);
    ImageIcon carregarIcon=new ImageIcon(enderecoIconeCarregar);
    ImageIcon pesquisarIcon=new ImageIcon(enderecoIconePesquisar);
    ImageIcon baixarIcon=new ImageIcon(enderecoIconeBaixar);

    JLabel incluirImagem = (new JLabel(incluirIcon));
    JLabel editarImagem = new JLabel(editarIcon);
    JLabel carregarImagem = new JLabel(carregarIcon);
    JLabel pesquisarImagem = new JLabel(pesquisarIcon);
    JLabel baixarImagem = new JLabel(baixarIcon);

    incluirImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    

    panel.setBackground(new Color(41, 128, 185));

    JLabel AvisoLabel = new JLabel("botoes em desenvolvimento");
    

    panel.add(pesquisarImagem);
    panel.add(incluirImagem);
    panel.add(editarImagem);
    panel.add(carregarImagem);
    panel.add(baixarImagem);
    panel.add(AvisoLabel);
    

    return panel;

  }


  
  public void setContent (JPanel conteudo){
    painelBase.add(conteudo);

  }

  public void show(){
    jDialog.setVisible(true);
  }

  public void close(){
    jDialog.dispose();
  }
  
}
