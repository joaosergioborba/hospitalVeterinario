package model.view.PopUpOperacao;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.entity.Funcionario;
import model.entity.Tutor;
import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpOperacaoIncluir;

public class PopUpOperacaoListar_Funcionario extends PopUpOperacaoIncluir {
  
  public PopUpOperacaoListar_Funcionario(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria, List<Funcionario> lista){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    JPanel panel = new JPanel();

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // essa parte eu vi nas pesquisas q seria para meio que pular a linha entre um animal e outro

    for(Funcionario t: lista){

      panel.add(new JLabel("Id: " + t.getId() + " -> Nome: "+ t.getNome() + "-> cpf: " + t.getCpf() + " -> senha: " + t.getSenha() + "\n"));
    
    }
    
    setContent(panel);
    show();
  }

  public JPanel criarLista(JPanel panel, List<Funcionario> lista){

     panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

    for(Funcionario t: lista){

      panel.add(new JLabel("Nome: "+ t.getNome() + "-> cpf: " + t.getCpf() + "\n"));
    
    }
    setContent(panel);

    return panel;

  }


  
}
