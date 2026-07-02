package model.view.consultorio.popUpOperacao;

import java.awt.PopupMenu;
import java.util.List;
import javax.swing.*;

import model.entity.Animal;
import model.entity.Atendimento;
import model.enums.StatusAtendimento;
import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpModel;
import model.view.abstract_class.PopUpOperacaoIncluir;


public class PopUpOperacaoListar extends PopUpModel{

  private JPanel panel;  

  public PopUpOperacaoListar(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria, List<Atendimento> lista){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    panel = new JPanel();
  
  
    JLabel procurarAtendimento = new JLabel("------------------------- Listar Atendimento -------------------------");

    panel.add(procurarAtendimento);
     panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    for(Atendimento atendimento: lista){

      String texto = String.format("Id: %d -> Animal: %s -> Tutor: %s",  atendimento.getId(), atendimento.getAnimal().getNome(), atendimento.getAnimal().getTutor().getNome());
        panel.add(new JLabel(texto));
    }

    
    this.setContent(panel);
  }

  @Override
  public JPanel cabecalhoPadrao(){
    return null;
  }
  public JPanel rodapePadrao(){
    return null;
  }

   
}

