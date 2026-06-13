package model.view.PopUpOperacao;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.entity.Tutor;
import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpOperacaoIncluir;

public class PopUpOperacaoListar_tutor extends PopUpOperacaoIncluir {
  
  public PopUpOperacaoListar_tutor(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria, List<Tutor> lista){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    JPanel panel = new JPanel();

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // essa parte eu vi nas pesquisas q seria para meio que pular a linha entre um animal e outro

    for(Tutor t: lista){

      panel.add(new JLabel("Id: " + t.getId() + " -> Nome: "+ t.getNome() + "-> cpf: " + t.getCpf() + "\n"));
    
    }
    
    setContent(panel);
    show();
  }

  public JPanel criarLista(JPanel panel, List<Tutor> lista){

     panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

    for(Tutor t: lista){

      panel.add(new JLabel("Nome: "+ t.getNome() + "-> cpf: " + t.getCpf() + "\n"));
    
    }
    setContent(panel);

    return panel;

  }


  
}
