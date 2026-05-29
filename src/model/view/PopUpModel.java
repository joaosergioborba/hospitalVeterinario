package model.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PopUpModel {

  //esse recurso de dialog foi o unico jeito que achei para que quando eu fechar a tela nao feche o programa inteiro e sim so a janela, mas funciona de um jeito muito pareceido com o Jframe

  private JDialog jDialog;

  public  PopUpModel(JFrame janelaPai, String tituloPagina){

    jDialog = new JDialog(janelaPai, tituloPagina, true);
    jDialog.setSize(800, 800);
    jDialog.setLocationRelativeTo(janelaPai);
    jDialog.setResizable(false);
    jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

  }

  public void setContent (JPanel conteudo){
    jDialog.setContentPane(conteudo);

  }

  public void show(){
    jDialog.setVisible(true);
  }

  public void close(){
    jDialog.dispose();
  }
  
}
