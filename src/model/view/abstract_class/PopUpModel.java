package model.view.abstract_class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.service.ClinicaVeterinaria;


//decidimos utilizar as classes abstratas porque nao devem ser instanciadas, uma vez que serão apenas um molde para as subclasses

public class PopUpModel extends JPanel{
  //esse recurso de dialog foi o unico jeito que achei para que quando eu fechar a tela nao feche o programa inteiro e sim so a janela, mas funciona de um jeito muito pareceido com o Jframe

  private JDialog jDialog;
  //private JPanel panel;
  protected JPanel painelBase;
  protected JFrame janelaPai;
  protected ClinicaVeterinaria clinicaVeterinaria;

  public  PopUpModel(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    this.janelaPai = janelaPai;
    this.clinicaVeterinaria = clinicaVeterinaria;

    jDialog = new JDialog(janelaPai, tituloPagina, false);
    jDialog.setSize(900, 500);
    jDialog.setLocationRelativeTo(janelaPai);
    jDialog.setResizable(false);
    jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    painelBase = new JPanel(new BorderLayout());

    JPanel CabecalhoPanel = cabecalhoPadrao();
    painelBase.add(CabecalhoPanel, BorderLayout.NORTH);

    JPanel rodapePanel = rodapePadrao();
    painelBase.add(rodapePanel, BorderLayout.SOUTH);

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

    JButton incluirButton = new JButton();
    JButton editarButton = new JButton();
    JButton carregarButton = new JButton();
    JButton pesquisarButton = new JButton();
    JButton baixarButton = new JButton();
    

    incluirButton.setIcon(incluirIcon);
    editarButton.setIcon(editarIcon);
    carregarButton.setIcon(carregarIcon);
    pesquisarButton.setIcon(pesquisarIcon);
    baixarButton.setIcon(baixarIcon);

    incluirButton.setText("Incluir");
    editarButton.setText("Editar");
    carregarButton.setText("Carregar");
    pesquisarButton.setText("Pesquisar");
    baixarButton.setText("Baixar");

    incluirButton.addActionListener(e->{
      incluirButtonClicked();
    });

    pesquisarButton.addActionListener(e->{
      pesquisarButtonClicked(panel);
    });


    //JLabel incluirImagem = (new JLabel(incluirIcon));
    //JLabel editarImagem = new JLabel(editarIcon);
    //JLabel carregarImagem = new JLabel(carregarIcon);
    //JLabel pesquisarImagem = new JLabel(pesquisarIcon);
    //JLabel baixarImagem = new JLabel(baixarIcon);

    //incluirImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    //incluirImagem.addMouseListener();
    

    panel.setBackground(new Color(41, 128, 185));

    JLabel AvisoLabel = new JLabel("botoes em desenvolvimento");
    

    panel.add(pesquisarButton);
    panel.add(incluirButton);
    panel.add(editarButton);
    panel.add(carregarButton);
    panel.add(baixarButton);
    panel.add(AvisoLabel);
    

    return panel;

  }

  public JPanel rodapePadrao(){

    JPanel panel = new JPanel();
    URL enderecoIconePesquisar = getClass().getResource("/assets/pesquisarIcon.png");
    ImageIcon pesquisarIcon=new ImageIcon(enderecoIconePesquisar);
    JLabel pesquisarImagem = new JLabel(pesquisarIcon);

    JLabel descricaoPesquiser = new JLabel("Pesquisar");
    
    panel.add(pesquisarImagem);
    panel.add(descricaoPesquiser);

    return panel;
  }

  

  public void incluirButtonClicked(){}

  public void pesquisarButtonClicked(JPanel panel){}


  
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
