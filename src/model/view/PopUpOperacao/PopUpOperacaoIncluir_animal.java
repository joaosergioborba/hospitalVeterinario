package model.view.PopUpOperacao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpOperacao;

public class PopUpOperacaoIncluir_animal extends PopUpOperacao{

  private JPanel panel;
  

  public PopUpOperacaoIncluir_animal(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    panel = new JPanel();

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

    JLabel labelTutorId = new JLabel("Id do Tutor");
    JTextField campoTutorId = new JTextField(30);

    JLabel labelTutorNome = new JLabel("Nome do Tutor");
    JTextField campoTutorNome = new JTextField(30);


    JButton lancarBotao = new JButton("Lancar entrada");
    JButton preencherPadraoBotao = new JButton("Carregar dados padroes");


    lancarBotao.addActionListener(e->{

      salvarButtonClicked(campoNomeAnimal, campoIdadeAnimal, campoRacaAnimal, campoTamanhoPelagemAnimal, campoSexoAnimal, campoPorteAnimal, campoTutorId);

    

    });

    preencherPadraoBotao.addActionListener(e->{

    });


    panel.add(labelNomeAnimal);
    panel.add(campoNomeAnimal);

    panel.add(labelIdadeAnimal);
    panel.add(campoIdadeAnimal);

    panel.add(labelRacaAnimal);
    panel.add(campoRacaAnimal);

    panel.add(labelTamanhoPelagemAnimal);
    panel.add(campoTamanhoPelagemAnimal);

    panel.add(labelSexoAnimal);
    panel.add(campoSexoAnimal);

    panel.add(labelPorteAnimal);
    panel.add(campoPorteAnimal);

    panel.add(labelTutorId);
    panel.add(campoTutorId);

    panel.add(lancarBotao);
    panel.add(preencherPadraoBotao);

    setContent(panel);
    show();

  }

  
  
  public void salvarButtonClicked(JTextField nome, JTextField  idade, JTextField raca, JTextField tamanhoPelagem, JTextField sexo, JTextField porte, JTextField tutorId) {

    String nomeDigitado = nome.getText();
    String idadeDigitado = (idade.getText());
    String racaDigitado = raca.getText();
    String tamanhoPelagemDigitado = tamanhoPelagem.getText();
    String sexoDigitado = sexo.getText();
    String porteDigitado = porte.getText();
    String tutorIdDigitado = tutorId.getText();

    if(nomeDigitado.isEmpty() || idadeDigitado.isEmpty() || racaDigitado.isEmpty() || tamanhoPelagemDigitado.isEmpty() || sexoDigitado.isEmpty() || porteDigitado.isEmpty() || tutorIdDigitado.isEmpty()){

      JOptionPane.showMessageDialog(null, "Campos preenchidos incprretamente. Tente novamente!");
    }
    
  }
  
}
