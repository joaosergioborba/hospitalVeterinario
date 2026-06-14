package model.view.PopUpOperacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import model.entity.Animal;
import model.entity.Atendimento;
import model.entity.Funcionario;
import model.enums.Funcao;
import model.service.ClinicaVeterinaria;
import model.service.validarDadosService;
import model.view.abstract_class.PopUpOperacaoIncluir;


public class PopUpOperacaoIncluir_atendimento extends PopUpOperacaoIncluir{

  private JPanel panel;
  private JTextField campoIdAnimal;
  private JTextField campoNomeAnimal;
  private JTextField campoNomeTutor;
  private JTextField campoRaca;
  private JTextField campoIdade;
  private JTextField campoSexo;
  private JTextField campoVeterinarioId;
  private JTextField campoNomeVeterinario;
  private JTextField campoData;
  private JTextField campoObservacoes;
  private JTextField campoIdAtendimento;
  

  public PopUpOperacaoIncluir_atendimento(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    panel = new JPanel();

    JLabel labelIdAtendimento= new JLabel("Id atendimento: ");
    this.campoIdAtendimento = new JTextField(30);
    campoIdAtendimento.setEditable(false);

    JLabel labelIdAnimal = new JLabel("Id animal: ");
    this.campoIdAnimal = new JTextField(30);

    JLabel labelNomeAnimal = new JLabel("Nome: ");
    this.campoNomeAnimal = new JTextField(30);
    campoNomeAnimal.setEditable(false);

    JLabel labelRacaAnimal = new JLabel("Raça: ");
    this.campoRaca = new JTextField(30);
    campoRaca.setEditable(false);

    JLabel labelIdadeAnimal = new JLabel("Raça: ");
    this.campoIdade = new JTextField(30);
    campoIdade.setEditable(false);
    
    
    JLabel labelSexo = new JLabel("Sexo: ");
    this.campoSexo = new JTextField(30);
    campoSexo.setEditable(false);

    JLabel labelTutor = new JLabel("Tutor: ");
    this.campoNomeTutor = new JTextField(30);
    campoNomeTutor.setEditable(false);

    JLabel labelVeterinarioId = new JLabel("Veterinario id: ");
    this.campoVeterinarioId = new JTextField(30);

    JLabel labelNomeVeterinario = new JLabel("Veterinario: ");
    this.campoNomeVeterinario = new JTextField(30);
    campoNomeVeterinario.setEditable(false);

    JLabel labelObservacao = new JLabel("Observações: ");
    this.campoObservacoes = new JTextField(30);

    JLabel labelData = new JLabel("Data: ");
    this.campoData = new JTextField(30);

    campoVeterinarioId.setInputVerifier(new InputVerifier() {
    @Override
    public boolean verify(JComponent input) {

      try {

        JTextField tf = (JTextField) input;

        if(tf.getText().isEmpty()){
          return true;

        }
        int id = Integer.parseInt(tf.getText());

        
    
        Funcionario data = clinicaVeterinaria.procurarFuncionarioPorIdService(id);
      
    
        if(data != null){

          if(data.getFuncao() != Funcao.MEDICO_VETERINARIO){
            JOptionPane.showMessageDialog(null, "O id informado não é de um veterinario. Apenas veterinarios podem realizar atendimentos");
            return false;
          }
          campoNomeVeterinario.setText(data.getNome());
          return true;
        }

        JOptionPane.showMessageDialog(null, "O id do veterinario informado é invalido!");
        return false;
      }  catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "O id informado não é um id válido! Digite apenas números");
        return false;
      }
    }});

    campoIdAnimal.setInputVerifier(new InputVerifier() {
    @Override
    public boolean verify(JComponent input) {

      try {

        JTextField tf = (JTextField) input;

        if(tf.getText().isEmpty()){
          return true;

        }
        int id = Integer.parseInt(tf.getText());

        
    
        Animal data = clinicaVeterinaria.procurarAnimaisPorIdService(id);
    
        if(data != null){
          campoNomeAnimal.setText(data.getNome());
          campoRaca.setText(data.getRaca());
          campoIdade.setText(String.valueOf(data.getIdade()));
          campoSexo.setText(data.getSexo().name());
          campoNomeTutor.setText(data.getTutor().getNome());
          return true;
        }

        JOptionPane.showMessageDialog(null, "O id do animal informado é invalido!");
        return false;
      }  catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "O id informado não é um id válido! Digite apenas números");
        return false;
      }
    }});

    campoData.setInputVerifier(new InputVerifier() {
    @Override
    public boolean verify(JComponent input) {

      try {

        JTextField tf = (JTextField) input;

        if(tf.getText().isEmpty()){
          return true;

        }

        validarDadosService validador = new validarDadosService();

        if(!validador.isDataValida(tf.getText())){
          JOptionPane.showMessageDialog(null, "A data informada é invalida! Siga a estrutura DD/MM/AAAA");
          return false;
        }
        return true;
      }  catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "A idade informada é inválida! Houve um erro ao processar essa data");
        System.out.println("algo deu errado");
        return false;
      }
    }});

    panel.add(labelIdAtendimento);
    panel.add(campoIdAtendimento);

    panel.add(labelIdAnimal);
    panel.add(campoIdAnimal);

    panel.add(labelNomeAnimal);
    panel.add(campoNomeAnimal);

    panel.add(labelIdadeAnimal);
    panel.add(campoIdade);

    panel.add(labelRacaAnimal);
    panel.add(campoRaca);

    panel.add(labelSexo);
    panel.add(campoSexo);

    panel.add(labelTutor);
    panel.add(campoNomeTutor);

    panel.add(labelVeterinarioId);
    panel.add(campoVeterinarioId);

    panel.add(labelNomeVeterinario);
    panel.add(campoNomeVeterinario);

    panel.add(labelObservacao);
    panel.add(campoObservacoes);

    panel.add(labelData);
    panel.add(campoData);
  
    setContent(panel);
    show();

  }

  
  
  public void salvarButtonClickedFunction(JTextField idAtendimento ,JTextField idAnimal, JTextField idVeterinario, JTextField data, JTextField observacoes) {

  
    String idAnimalDigitado = idAnimal.getText();
    String idVeterinarioDigitado = (idVeterinario.getText());
    String dataDigitado = data.getText();
    String observacoesDigitada = observacoes.getText();


  
    if(idAnimalDigitado.isEmpty() || idVeterinarioDigitado.isEmpty()){
      JOptionPane.showMessageDialog(null, "Campos preenchidos incprretamente. Tente novamente!");
      return;
    }

    if(dataDigitado.isEmpty()){
      int resposta = JOptionPane.showConfirmDialog(null, "Deseja definir a data para a data de hoje?");

      if(resposta != JOptionPane.YES_OPTION){
        JOptionPane.showMessageDialog(null, "Campos preenchidos incprretamente. Tente novamente!");
        return;
      }

     LocalDate hoje = LocalDate.now();
     DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     String dataFormatada = hoje.format(formatador);
     dataDigitado = dataFormatada;
     data.setText(dataFormatada);

      
    }

    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataFormatada = LocalDate.parse(dataDigitado, formatador);

    Animal a = clinicaVeterinaria.procurarAnimaisPorIdService(Integer.parseInt(idAnimalDigitado));

    if(a == null){
      JOptionPane.showMessageDialog(null, "Animal não encontrado");
      return;
    }

    Funcionario v = clinicaVeterinaria.procurarFuncionarioPorIdService(Integer.parseInt(idVeterinarioDigitado));

    if(v == null){
      JOptionPane.showMessageDialog(null, "Veterinario não encontrado");
      return;
    }

    
    if(idAtendimento.getText().isEmpty()){


      Atendimento atendimento = new Atendimento(a, dataFormatada, observacoesDigitada, v);

      int resposta = JOptionPane.showConfirmDialog(null,"COnfirma a geração do id do atendimento?");

      if(resposta != JOptionPane.YES_OPTION){
        return;
      }

    int id = clinicaVeterinaria.adicionarAtendimentoService(atendimento);
    idAtendimento.setText(String.valueOf(id));

    JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");


    } else {

      Atendimento atendimento = clinicaVeterinaria.procurarAtendimentoPorIdService(Integer.parseInt(campoIdAnimal.getText()));

      atendimento.setObservacoes(observacoesDigitada);
      atendimento.setData(dataFormatada);
      atendimento.setAnimal(a);
      atendimento.setVeterinario(v);
      JOptionPane.showMessageDialog(null, "Os dados foram atualizados com sucesso!");
    }
  }



   public void incluirButtonClickedFunction(JTextField idAtendimento, JTextField idAnimal, JTextField nomeAnimal, JTextField  nomeTutor, JTextField raca, JTextField idade, JTextField sexo, JTextField veterinarioId, JTextField nomeVeterinario, JTextField data, JTextField observacoes){

    if(idAtendimento.getText().isEmpty() && (!idAnimal.getText().isEmpty() || !veterinarioId.getText().isEmpty() || !data.getText().isEmpty()  || !observacoes.getText().isEmpty())){

      int resposta = JOptionPane.showConfirmDialog(null, "Você deseja salvar os dados antes de continuar?");

      if(resposta == JOptionPane.YES_OPTION){

        salvarButtonClickedFunction(idAtendimento, idAnimal, veterinarioId, data, observacoes);

      } else if(resposta == JOptionPane.CANCEL_OPTION){

        return;

      }

     

    }

    idAtendimento.setText(null);
    nomeAnimal.setText(null);;
    idAnimal.setText(null);
    nomeTutor.setText(null);
    raca.setText(null);
    idade.setText(null);
    sexo.setText(null);
    veterinarioId.setText(null);
    nomeVeterinario.setText(null);
    data.setText(null);
    observacoes.setText(null);

   }
  
@Override
public void salvarButtonClicked(){
  salvarButtonClickedFunction(campoIdAtendimento, campoIdAnimal,campoVeterinarioId, campoData,campoObservacoes);
}

@Override
public void incluirButtonClicked(){

  incluirButtonClickedFunction(campoIdAtendimento, campoIdAnimal, campoNomeAnimal, campoNomeTutor, campoRaca, campoIdade, campoSexo, campoVeterinarioId, campoNomeVeterinario,campoData, campoObservacoes);
}
 

   
}

