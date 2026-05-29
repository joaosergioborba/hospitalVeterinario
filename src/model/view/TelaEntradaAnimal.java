package model.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.service.ClinicaVeterinaria;

public class TelaEntradaAnimal extends JPanel {
   private ClinicaVeterinaria clinicaVeterinaria;

   public TelaEntradaAnimal(ClinicaVeterinaria clinicaVeterinaria){
    this.clinicaVeterinaria = clinicaVeterinaria;

    JLabel labelNomeTutor = new JLabel("Nome do tutor:");
    JTextField campoNomeTutor = new JTextField(30);

    JLabel labelCpfTutor = new JLabel("Cpf do tutor:");
    JTextField campoCpfTutor = new JTextField(30);

    JLabel labelEnderecoTutor = new JLabel("Endereco do tutor:");
    JTextField campoEnderecoTutor = new JTextField(30);

    JLabel labelNomeAnimal = new JLabel("Endereco do tutor:");
    JTextField campoNomeAnimal = new JTextField(30);

    JLabel labelIdadeAnimal = new JLabel("Endereco do tutor:");
    JTextField campoIdadeAnimal = new JTextField(30);

    JLabel labelNomeVeterinario = new JLabel("Nome veterinario:");
    JTextField campoNomeVeterinario = new JTextField(30);

    add(labelNomeTutor);
    add(campoNomeTutor);

    add(labelCpfTutor);
    add(campoCpfTutor);

    add(labelEnderecoTutor);
    add(campoEnderecoTutor);

    add(labelNomeAnimal);
    add(campoNomeAnimal);

    add(labelIdadeAnimal);
    add(campoIdadeAnimal);
    
    add(labelNomeVeterinario);
    add(campoNomeVeterinario);






   }
  
}
