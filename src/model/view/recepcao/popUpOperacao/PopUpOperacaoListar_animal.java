package model.view.recepcao.popUpOperacao;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.entity.Animal;
import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpOperacaoIncluir;

public class PopUpOperacaoListar_animal extends PopUpOperacaoIncluir {
  
  public PopUpOperacaoListar_animal(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria, List<Animal> lista){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    JPanel panel = new JPanel();

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // essa parte eu vi nas pesquiss q seria para meio que pular a linha entre um animal e outro

    for(Animal animal: lista){

      panel.add(new JLabel("Animal: "+ animal.getNome() + "-> Tutor: " + animal.getTutor().getNome() + "\n"));
    
    }
    
    setContent(panel);
    show();
  }

  public JPanel criarLista(JPanel panel, List<Animal> lista){

     panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

    for(Animal animal: lista){

      panel.add(new JLabel("Animal: "+ animal.getNome() + "-> Tutor: " + animal.getTutor().getNome() + "\n"));
    
    }
    setContent(panel);

    return panel;

  }


  
}
