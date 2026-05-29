package model.view;

import javax.swing.*;

import model.service.ClinicaVeterinaria;

//usei heranca de JPanel pq ai nao precisamos ficar colocando JPanel toda hr
public class TelaPrincipal extends JPanel {
  private ClinicaVeterinaria clinicaVeterinaria;

  public TelaPrincipal(ClinicaVeterinaria clinicaVeterinaria){

    this.clinicaVeterinaria = clinicaVeterinaria;
    JLabel labelBemVindo = new JLabel("Seja Bem-vindo de volta, usuario");

    JButton cadastrarFuncionario = new JButton("cadastrar_funcionario");
    JButton cadastrarTutor = new JButton("cadastrar_tutor");
    JButton cadastrarAnimal = new JButton("cadastrar_tutor");
    JButton EntradaAnimal = new JButton("dar_entrada_animal");

    EntradaAnimal.addActionListener(e-> {
      JFrame janelaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
      PopUpModel telaEntrada = new PopUpModel(janelaPai, "Tela entrada de animal - PatasCloud");
      TelaEntradaAnimal telaLancamentoEntrada = new TelaEntradaAnimal(clinicaVeterinaria);

      telaEntrada.setContent(telaLancamentoEntrada);
        telaEntrada.show();

    });


    add(labelBemVindo);
    add(EntradaAnimal);
   

  }
  

}
