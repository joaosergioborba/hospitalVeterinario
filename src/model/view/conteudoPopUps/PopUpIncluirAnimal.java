package model.view.conteudoPopUps;

import javax.swing.*;

public class PopUpIncluirAnimal extends JPanel{

  public PopUpIncluirAnimal(){

    JLabel labelNomeAnimal = new JLabel("Nome: ");
    JTextField campoNomeAnimal = new JTextField(30);

    JLabel labelIdadeAnimal = new JLabel("Idade: ");
    JTextField campoIdadeAnimal = new JTextField(30);

    JLabel labelRacaAnimal = new JLabel("Raça: ");
    JTextField campoRacaAnimal = new JTextField(30);

    JLabel labelSexoAnimal = new JLabel("Sexo: ");
    JTextField campoSexoAnimal = new JTextField(30);

    JLabel labelTamanhoPelagemAnimal = new JLabel("Tamanho pelagem: ");
    JTextField campoTamanhoPelagemAnimal = new JTextField(30);

    JLabel labelPorteAnimal = new JLabel("Porte animal: ");
    JTextField campoPorteAnimal = new JTextField(30);

    JLabel labelTutorIdAnimal = new JLabel("Id do Tutor");
    JTextField campoTutorIdAnimal = new JTextField(30);


    JButton lancarBotao = new JButton("Lancar entrada");
    JButton preencherPadraoBotao = new JButton("Carregar dados padroes");


    add(labelNomeAnimal);
    add(campoNomeAnimal);

    add(labelIdadeAnimal);
    add(campoIdadeAnimal);

    add(labelRacaAnimal);
    add(campoRacaAnimal);

    add(labelTamanhoPelagemAnimal);
    add(campoTamanhoPelagemAnimal);

    add(labelSexoAnimal);
    add(campoSexoAnimal);

    add(labelPorteAnimal);
    add(campoPorteAnimal);

    add(labelTutorIdAnimal);
    add(campoTutorIdAnimal);

    add(lancarBotao);
    add(preencherPadraoBotao);


  }
  
}
