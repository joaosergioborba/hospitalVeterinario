package model.view.PopUpOperacao;

import java.awt.Color;
import java.awt.event.FocusListener;
import java.net.URL;

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
    JRadioButton opcaoMacho = new JRadioButton("MACHO");
     opcaoMacho.setActionCommand(Sexo.MACHO.name());
    JRadioButton opcaoFemea= new JRadioButton("FEMEA");
     opcaoFemea.setActionCommand(Sexo.FEMEA.name());

    ButtonGroup grupoSexo = new ButtonGroup();
    grupoSexo.add(opcaoMacho);
    grupoSexo.add(opcaoFemea);

    JLabel labelTamanhoPelagemAnimal = new JLabel("Tamanho pelagem: ");
    JTextField campoTamanhoPelagemAnimal = new JTextField(30);

    JLabel labelPorteAnimal = new JLabel("Porte animal: ");
    JRadioButton opcaoPorteP = new JRadioButton("PEQUENO");
    opcaoPorteP.setActionCommand(PorteAnimal.PEQUENO.name());
    JRadioButton opcaoPorteM= new JRadioButton("MEDIO");
    opcaoPorteM.setActionCommand(PorteAnimal.MEDIO.name());
    JRadioButton opcaoPorteG= new JRadioButton("GRANDE");
    opcaoPorteG.setActionCommand(PorteAnimal.GRANDE.name());
    ButtonGroup grupoPorteAnimal = new ButtonGroup();
    grupoPorteAnimal.add(opcaoPorteP);
    grupoPorteAnimal.add(opcaoPorteM);
    grupoPorteAnimal.add(opcaoPorteG);

    JLabel labelTutorId = new JLabel("Id do Tutor");
    JTextField campoTutorId = new JTextField(30);

    JLabel labelTutorNome = new JLabel("Nome do Tutor");
    JTextField campoTutorNome = new JTextField(30);

    JButton incluirBotao = new JButton("Incluir");
    JButton lancarBotao = new JButton("Salvar");
    JButton preencherPadraoBotao = new JButton("Carregar dados padroes");

    campoIdAnimal.setEditable(false);
    campoTutorNome.setEditable(false);
    campoIdadeAnimal.setInputVerifier(new InputVerifier() {
    @Override
    public boolean verify(JComponent input) {

      try {

        JTextField tf = (JTextField) input;

        if(tf.getText().isEmpty()){
          return true;

        }
        int id = Integer.parseInt(tf.getText());

        if(id < 0){
          JOptionPane.showMessageDialog(null, "A idade informada é invalida! o animal não pode ter uma idade menor que zero.");
          return false;
        }
    
    
        return true;
      }  catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "O id informado não é um id válido! Digite apenas números");
        return false;
      }
    }});
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

      salvarButtonClicked(campoIdAnimal, campoNomeAnimal, campoIdadeAnimal, campoRacaAnimal, campoTamanhoPelagemAnimal, grupoSexo, grupoPorteAnimal, campoTutorId);

    

    });

    preencherPadraoBotao.addActionListener(e->{

      preencherPadraoButtonClicked( campoNomeAnimal, campoIdadeAnimal, campoRacaAnimal, campoTamanhoPelagemAnimal, opcaoMacho, opcaoPorteM, campoTutorId, campoTutorNome);

    });

    incluirBotao.addActionListener(e->{

      incluirButtonClicked(campoIdAnimal, campoNomeAnimal, campoIdadeAnimal, campoRacaAnimal, campoTamanhoPelagemAnimal, grupoSexo, grupoPorteAnimal, campoTutorId);

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
    panel.add(opcaoMacho);
    panel.add(opcaoFemea);

    panel.add(labelPorteAnimal);
    panel.add(opcaoPorteP);
    panel.add(opcaoPorteM);
    panel.add(opcaoPorteG);

    panel.add(labelTutorId);
    panel.add(campoTutorId);

    panel.add(labelTutorNome);
    panel.add(campoTutorNome);

    panel.add(incluirBotao);
    panel.add(lancarBotao);
    panel.add(preencherPadraoBotao);

    setContent(panel);
    show();

  }

  
  
  public void salvarButtonClicked(JTextField idAnimal, JTextField nome, JTextField  idade, JTextField raca, JTextField tamanhoPelagem, ButtonGroup sexo, ButtonGroup porte, JTextField tutorId) {

    String nomeDigitado = nome.getText();
    String idadeDigitado = (idade.getText());
    String racaDigitado = raca.getText();
    String tamanhoPelagemDigitado = tamanhoPelagem.getText();
    Sexo sexoDigitado = sexo.getSelection() != null ? Sexo.valueOf(sexo.getSelection().getActionCommand()) : null;
    PorteAnimal porteDigitado = porte.getSelection() != null ? PorteAnimal.valueOf(porte.getSelection().getActionCommand()) : null;
    String tutorIdDigitado = tutorId.getText();

    if(nomeDigitado.isEmpty() || idadeDigitado.isEmpty() || racaDigitado.isEmpty() || tamanhoPelagemDigitado.isEmpty() || sexoDigitado == null || porteDigitado == null || tutorIdDigitado.isEmpty()){
      JOptionPane.showMessageDialog(null, "Campos preenchidos incprretamente. Tente novamente!");
      return;
    }

    Tutor tutor = clinicaVeterinaria.procurarTutorPorIdService(Integer.parseInt(tutorIdDigitado));

    if(tutor == null){
      JOptionPane.showMessageDialog(null, "Tutor não encontrado");
      return;
    }

    System.out.println(idAnimal.getText());

    if(idAnimal.getText().isEmpty()){

      Animal animal = new Animal(nomeDigitado, Integer.parseInt(idadeDigitado), racaDigitado, null, null, null, null, tutor);

    clinicaVeterinaria.adicionarAnimalService(animal);
    idAnimal.setText(String.valueOf(animal.getId()));

    JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");

    } else {
      JOptionPane.showConfirmDialog(null, "Para iniciar um novo cadastro aperte em incluir ou reabra a pagina, por enquanto não é possivel atualizar um cadastro");
    }

    

    

    
    
    
    
  }

   public void preencherPadraoButtonClicked(JTextField nome, JTextField  idade, JTextField raca, JTextField tamanhoPelagem,   JRadioButton sexo, JRadioButton porte, JTextField tutorId, JTextField nomeTutor) {
    nome.setText("BURRO");
    idade.setText("15");
    raca.setText("BURRO FALANTE");
    tamanhoPelagem.setText("CURTA");
    sexo.setSelected(true);
    porte.setSelected(true);
    tutorId.setText("1");
   }

   public void incluirButtonClicked(JTextField idAnimal, JTextField nome, JTextField  idade, JTextField raca, JTextField tamanhoPelagem, ButtonGroup sexo, ButtonGroup porte, JTextField tutorId){

    if(idAnimal.getText().isEmpty() && (!nome.getText().isEmpty() || !idade.getText().isEmpty() || !raca.getText().isEmpty()  || !tutorId.getText().isEmpty())){

      int resposta = JOptionPane.showConfirmDialog(null, "Você deseja salvar os dados antes de continuar?");

      if(resposta == JOptionPane.YES_OPTION){

        salvarButtonClicked(idAnimal, nome, idade, raca, tamanhoPelagem, sexo, porte, tutorId);

      } else if(resposta == JOptionPane.CANCEL_OPTION){

        return;

      }

     

    }

    idAnimal.setText(null);
    nome.setText(null);;
    idade.setText(null);
    raca.setText(null);
    raca.setText(null);
    tamanhoPelagem.setText(null);
    tutorId.setText(null);

   }
  

   @Override
   public JPanel cabecalhoPadrao(){
    
    JPanel panel = new JPanel();

    URL enderecoSalvarIcon = getClass().getResource("/assets/salvarIcon.png");
    URL enderecoIncluirIcon = getClass().getResource("/assets/incluirIcon.png");
    
    ImageIcon salvarIcon=new ImageIcon(enderecoSalvarIcon);
    ImageIcon incluirIcon=new ImageIcon(enderecoIncluirIcon);
    
    JButton salvar = new JButton();
    salvar.setIcon(salvarIcon);
    salvar.setText("Salvar");

    JButton incluir = new JButton();
    incluir.setIcon(incluirIcon);
    incluir.setText("Incluir");

    salvar.addActionListener(e->{
      salvarButtonClicked();
    });

    panel.setBackground(new Color(41, 128, 185));

    JLabel AvisoLabel = new JLabel("botoes em desenvolvimento");
    panel.add(incluir);
    panel.add(salvar);
    return panel;

  }
   
}
