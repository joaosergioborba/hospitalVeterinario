package model.view;

import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.entity.Animal;
import model.entity.Tutor;
import model.entity.Veterinario;
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

    JLabel labelNomeAnimal = new JLabel("Nome do animal:");
    JTextField campoNomeAnimal = new JTextField(30);

    JLabel labelIdadeAnimal = new JLabel("Idade do animal");
    JTextField campoIdadeAnimal = new JTextField(30);

    JLabel labelNomeVeterinario = new JLabel("Nome veterinario Responsável:");
    JTextField campoNomeVeterinario = new JTextField(30);

    JButton lancarBotao = new JButton("Lancar entrada");
    JButton preencherPadraoBotao = new JButton("Carregar dados padroes");

    lancarBotao.addActionListener(e->{

      String nomeTutorDigitado = campoNomeTutor.getText();
      String cpfTutorDigitado = campoCpfTutor.getText();
      String enderecoTutorDigitado = campoEnderecoTutor.getText();
      String nomeAnimalDigitado = campoNomeAnimal.getText();
      String idadeAnimalDigitado = campoIdadeAnimal.getText();
      String nomeVeterinarioDigitado = campoNomeTutor.getText();

      if(nomeTutorDigitado.isEmpty() || cpfTutorDigitado.isEmpty() || enderecoTutorDigitado.isEmpty() || nomeAnimalDigitado.isEmpty() || idadeAnimalDigitado.isEmpty() || nomeVeterinarioDigitado.isEmpty()){

        JOptionPane.showMessageDialog(null, "Campos preenchidos incorretamente. Tente novamente!");

      }

      Tutor tutor = new Tutor(cpfTutorDigitado, nomeTutorDigitado, null, enderecoTutorDigitado);
      Veterinario veterinario = new Veterinario(null, nomeVeterinarioDigitado, null, null, null, 0.00, null);
      Animal animal = new Animal(nomeAnimalDigitado, Integer.parseInt(idadeAnimalDigitado), null, null, null, null, null, tutor);

      JOptionPane.showMessageDialog(null, "Paciente registrado. Em breve será chamado");
      JOptionPane.showMessageDialog(null, "Animal: " + animal.getNome() + "\n" + "Tutor: " + animal.getTutor().getNome() + "\n");

    
      

    });


    preencherPadraoBotao.addActionListener(e->{
      campoNomeTutor.setText("SALSICHA");
      campoCpfTutor.setText("65364238016");
      campoEnderecoTutor.setText("NORVILLE ROGERS");
      campoNomeAnimal.setText("SCOOBY DOO");
      campoIdadeAnimal.setText("7");
      campoNomeVeterinario.setText("JOE RUBY");
    });

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

    add(lancarBotao);
    add(preencherPadraoBotao);






   }
  
}
