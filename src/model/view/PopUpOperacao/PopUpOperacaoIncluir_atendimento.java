package model.view.PopUpOperacao;

import javax.swing.*;

import model.entity.Animal;
import model.entity.Tutor;
import model.enums.PorteAnimal;
import model.enums.Sexo;
import model.enums.TamanhoPelo;
import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpOperacaoIncluir;

public class PopUpOperacaoIncluir_atendimento extends PopUpOperacaoIncluir{

  private JPanel panel;
  private Tutor tutor;
  private JTextField campoIdAnimal;
  private JTextField campoNomeAnimal;
  private JTextField campoIdadeAnimal;
  private JTextField campoRacaAnimal;
  private JRadioButton opcaoMacho;
  private JRadioButton opcaoFemea;
  private JRadioButton opcaoPorteP;
  private JRadioButton opcaoPorteM;
  private JRadioButton opcaoPorteG;
  private ButtonGroup grupoPorteAnimal;
  private JRadioButton opcaoPelagemC;
  private JRadioButton opcaoPelagemM;
  private JRadioButton opcaoPelagemL;
  private ButtonGroup grupoPelagemAnimal;
  private JTextField campoTutorId;
  private JTextField campoTutorNome;
  private ButtonGroup grupoSexo;

  public PopUpOperacaoIncluir_atendimento(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    panel = new JPanel();

    JLabel labelIdAnimal = new JLabel("Id animal: ");
    this.campoIdAnimal = new JTextField(30);

    JLabel labelNomeAnimal = new JLabel("Nome: ");
    this.campoNomeAnimal = new JTextField(30);

    JLabel labelIdadeAnimal = new JLabel("Idade: ");
    this.campoIdadeAnimal = new JTextField(30);

    JLabel labelRacaAnimal = new JLabel("Raça: ");
    this.campoRacaAnimal = new JTextField(30);

    JLabel labelSexoAnimal = new JLabel("Sexo: ");
    this.opcaoMacho = new JRadioButton("MACHO");
     opcaoMacho.setActionCommand(Sexo.MACHO.name());
    this.opcaoFemea= new JRadioButton("FEMEA");
     opcaoFemea.setActionCommand(Sexo.FEMEA.name());

    this.grupoSexo = new ButtonGroup();
    this.grupoSexo.add(opcaoMacho);
    this.grupoSexo.add(opcaoFemea);

    JLabel labelTamanhoPelagemAnimal = new JLabel("Tamanho pelagem: ");
    this.opcaoPelagemC = new JRadioButton("CURTO");
    opcaoPelagemC.setActionCommand(TamanhoPelo.CURTO.name());
    this.opcaoPelagemM = new JRadioButton("MEDIO");
    opcaoPelagemM.setActionCommand(TamanhoPelo.MEDIO.name());
    this.opcaoPelagemL = new JRadioButton("LONGO");
    opcaoPelagemL.setActionCommand(TamanhoPelo.LONGO.name());
    this.grupoPelagemAnimal = new ButtonGroup();
    this.grupoPelagemAnimal.add(opcaoPelagemC);
    this.grupoPelagemAnimal.add(opcaoPelagemM);
    this.grupoPelagemAnimal.add(opcaoPelagemL);

    JLabel labelPorteAnimal = new JLabel("Porte animal: ");
    this.opcaoPorteP = new JRadioButton("PEQUENO");
    opcaoPorteP.setActionCommand(PorteAnimal.PEQUENO.name());
    this.opcaoPorteM= new JRadioButton("MEDIO");
    opcaoPorteM.setActionCommand(PorteAnimal.MEDIO.name());
    this.opcaoPorteG= new JRadioButton("GRANDE");
    opcaoPorteG.setActionCommand(PorteAnimal.GRANDE.name());
    this.grupoPorteAnimal = new ButtonGroup();
    this.grupoPorteAnimal.add(opcaoPorteP);
    this.grupoPorteAnimal.add(opcaoPorteM);
    this.grupoPorteAnimal.add(opcaoPorteG);

    JLabel labelTutorId = new JLabel("Id do Tutor");
    this.campoTutorId = new JTextField(30);

    JLabel labelTutorNome = new JLabel("Nome do Tutor");
    this.campoTutorNome = new JTextField(30);

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

    preencherPadraoBotao.addActionListener(e-> {

      preencherPadraoButtonClicked( campoNomeAnimal, campoIdadeAnimal, campoRacaAnimal, opcaoPelagemC, opcaoMacho, opcaoPorteM, campoTutorId, campoTutorNome);

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
    panel.add(opcaoPelagemC);
    panel.add(opcaoPelagemM);
    panel.add(opcaoPelagemL);

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

    panel.add(preencherPadraoBotao);

    setContent(panel);
    show();

  }

  
  
  public void salvarButtonClickedFunction(JTextField idAnimal, JTextField nome, JTextField  idade, JTextField raca, ButtonGroup tamanhoPelagem, ButtonGroup sexo, ButtonGroup porte, JTextField tutorId) {

    String nomeDigitado = nome.getText();
    String idadeDigitado = (idade.getText());
    String racaDigitado = raca.getText();
    TamanhoPelo tamanhoPelagemDigitado = tamanhoPelagem.getSelection() != null ? TamanhoPelo.valueOf(tamanhoPelagem.getSelection().getActionCommand()): null;
    Sexo sexoDigitado = sexo.getSelection() != null ? Sexo.valueOf(sexo.getSelection().getActionCommand()) : null;
    PorteAnimal porteDigitado = porte.getSelection() != null ? PorteAnimal.valueOf(porte.getSelection().getActionCommand()) : null;
    String tutorIdDigitado = tutorId.getText();

    if(nomeDigitado.isEmpty() || idadeDigitado.isEmpty() || racaDigitado.isEmpty() || tamanhoPelagemDigitado == null || sexoDigitado == null || porteDigitado == null || tutorIdDigitado.isEmpty()){
      JOptionPane.showMessageDialog(null, "Campos preenchidos incprretamente. Tente novamente!");
      return;
    }

    this.tutor = clinicaVeterinaria.procurarTutorPorIdService(Integer.parseInt(tutorIdDigitado));

    if(tutor == null){
      JOptionPane.showMessageDialog(null, "Tutor não encontrado");
      return;
    }

    System.out.println(idAnimal.getText());

    if(idAnimal.getText().isEmpty()){

      Animal animal = new Animal(nomeDigitado, Integer.parseInt(idadeDigitado), racaDigitado, null, null, null, null, tutor);

      int resposta = JOptionPane.showConfirmDialog(null,"COnfirma a geração do id do animal?");

      if(resposta != JOptionPane.YES_OPTION){
        return;
      }

    clinicaVeterinaria.adicionarAnimalService(animal);
    idAnimal.setText(String.valueOf(animal.getId()));

    JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");


    } else {

      Animal animal = clinicaVeterinaria.procurarAnimaisPorIdService(Integer.parseInt(campoIdAnimal.getText()));

      animal.setNome(nomeDigitado);
      animal.setIdade(Integer.parseInt(idadeDigitado));
      animal.setRaca(racaDigitado);
      animal.setPelagemTamanho(null);
      animal.setSexo(sexoDigitado);
      animal.setPorteAnimal(porteDigitado);
      animal.setTutor(tutor);



      JOptionPane.showMessageDialog(null, "Os dados foram atualizados com sucesso!");
    }
  }

   public void preencherPadraoButtonClicked(JTextField nome, JTextField  idade, JTextField raca, JRadioButton tamanhoPelagem,   JRadioButton sexo, JRadioButton porte, JTextField tutorId, JTextField nomeTutor) {
    nome.setText("BURRO");
    idade.setText("15");
    raca.setText("BURRO FALANTE");
    tamanhoPelagem.setSelected(true);
    sexo.setSelected(true);
    porte.setSelected(true);
    tutorId.setText("1");
   }

   public void incluirButtonClickedFunction(JTextField idAnimal, JTextField nome, JTextField  idade, JTextField raca, ButtonGroup tamanhoPelagem, ButtonGroup sexo, ButtonGroup porte, JTextField tutorId){

    if(idAnimal.getText().isEmpty() && (!nome.getText().isEmpty() || !idade.getText().isEmpty() || !raca.getText().isEmpty()  || !tutorId.getText().isEmpty())){

      int resposta = JOptionPane.showConfirmDialog(null, "Você deseja salvar os dados antes de continuar?");

      if(resposta == JOptionPane.YES_OPTION){

        salvarButtonClickedFunction(idAnimal, nome, idade, raca, grupoPelagemAnimal, sexo, porte, tutorId);

      } else if(resposta == JOptionPane.CANCEL_OPTION){

        return;

      }

     

    }

    idAnimal.setText(null);
    nome.setText(null);;
    idade.setText(null);
    raca.setText(null);
    raca.setText(null);
    tutorId.setText(null);

   }
  
@Override
public void salvarButtonClicked(){

  
  salvarButtonClickedFunction(campoIdAnimal, campoNomeAnimal,campoIdadeAnimal, campoRacaAnimal,grupoPelagemAnimal, grupoSexo, grupoPorteAnimal, campoTutorId);

}

@Override
public void incluirButtonClicked(){

  incluirButtonClickedFunction(campoIdAnimal, campoNomeAnimal, campoIdadeAnimal, campoRacaAnimal, grupoPelagemAnimal, grupoSexo, grupoPorteAnimal, campoTutorId);



}
 

   
}

