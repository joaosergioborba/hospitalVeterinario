package model.view.PopUpOperacao;

import java.awt.event.FocusListener;

import javax.swing.*;

import model.entity.Animal;
import model.entity.Tutor;
import model.enums.PorteAnimal;
import model.enums.Sexo;
import model.enums.TamanhoPelo;
import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpOperacao;

public class PopUpOperacaoIncluir_animal extends PopUpOperacao{

  private JPanel panel;
  

  public PopUpOperacaoIncluir_animal(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    panel = new JPanel();

    JLabel labelIdAnimal = new JLabel("Id animal: ");
    JTextField campoIdAnimal = new JTextField(30);

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

    campoTutorId.setInputVerifier(new InputVerifier() {
    @Override
    public boolean verify(JComponent input) {

      try {

        JTextField tf = (JTextField) input;

        if(tf.getText().isEmpty()){
          return true;

        }
        int id = Integer.parseInt(tf.getText());

        
    
        Tutor tutor = clinicaVeterinaria.procurarTutorPorIdService(id);
    
        if(tutor != null){
          campoTutorNome.setText(tutor.getNome());
          return true;
        }
        JOptionPane.showMessageDialog(null, "O id do tutor informado é invalido!");
        return false;
      }  catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "O id informado não é um id válido! Digite apenas números");
        return false;
      }
    }});


    lancarBotao.addActionListener(e->{

      salvarButtonClicked(campoIdAnimal, campoNomeAnimal, campoIdadeAnimal, campoRacaAnimal, campoTamanhoPelagemAnimal, campoSexoAnimal, campoPorteAnimal, campoTutorId);

    

    });

    preencherPadraoBotao.addActionListener(e->{

      preencherPadraoButtonClicked( campoNomeAnimal, campoIdadeAnimal, campoRacaAnimal, campoTamanhoPelagemAnimal, campoSexoAnimal, campoPorteAnimal, campoTutorId, campoTutorNome);

    });


    panel.add(labelIdAnimal);
    panel.add(campoIdAnimal);

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

    panel.add(labelTutorNome);
    panel.add(campoTutorNome);

    panel.add(lancarBotao);
    panel.add(preencherPadraoBotao);

    setContent(panel);
    show();

  }

  
  
  public void salvarButtonClicked(JTextField idAnimal, JTextField nome, JTextField  idade, JTextField raca, JTextField tamanhoPelagem, JTextField sexo, JTextField porte, JTextField tutorId) {

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

    

    Tutor tutor = clinicaVeterinaria.procurarTutorPorIdService(Integer.parseInt(tutorIdDigitado));

    if(tutor == null){
      JOptionPane.showConfirmDialog(null, "Tutor não encontrado");
      return;
    }

    Animal animal = new Animal(nomeDigitado, Integer.parseInt(idadeDigitado), racaDigitado, null, null, null, null, tutor);

    clinicaVeterinaria.adicionarAnimalService(animal);
    idAnimal.setText(String.valueOf(animal.getId()));
    
    
    
  }

   public void preencherPadraoButtonClicked(JTextField nome, JTextField  idade, JTextField raca, JTextField tamanhoPelagem, JTextField sexo, JTextField porte, JTextField tutorId, JTextField nomeTutor) {
    nome.setText("BURRO");
    idade.setText("15");
    raca.setText("BURRO FALANTE");
    tamanhoPelagem.setText("CURTA");
    sexo.setText("MACHO");
    porte.setText("MEDIO");
    tutorId.setText("1");
   }
  
}
