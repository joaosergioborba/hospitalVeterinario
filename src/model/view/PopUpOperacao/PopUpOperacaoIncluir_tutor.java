package model.view.PopUpOperacao;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import model.entity.Tutor;
import model.service.ClinicaVeterinaria;
import model.service.validarDadosService;
import model.view.abstract_class.PopUpOperacaoIncluir;

public class PopUpOperacaoIncluir_tutor extends PopUpOperacaoIncluir{

  private JPanel panel;
  private JTextField campoId;
  private JTextField campoNome;
  private JTextField campoCPF;
  private JTextField campoNascimento;
  private JTextField campoEndereco;

  

  public PopUpOperacaoIncluir_tutor(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    this.panel = new JPanel();

    JLabel labelId = new JLabel("Id tutor: ");
    this.campoId = new JTextField(30);

    JLabel labelNome = new JLabel("Nome: ");
    this.campoNome = new JTextField(30);

    JLabel labelNascimento = new JLabel("Nascimento (dd/mm/aaaa): ");
    this.campoNascimento = new JTextField(30);

    JLabel labelCPF = new JLabel("CPF: ");
    this.campoCPF = new JTextField(30);

    JLabel labelEndereco = new JLabel("endereco: ");
    this.campoEndereco = new JTextField(30);


    campoId.setEditable(false);

    campoCPF.setInputVerifier(new InputVerifier() {
      @Override
      public boolean verify(JComponent input){
        try {

          JTextField inputToVerificar = (JTextField) input;

          if(inputToVerificar.getText().isEmpty()){
            return true;
          }

          validarDadosService validador = new validarDadosService();

          if(!validador.cpfValido(inputToVerificar.getText())){
            JOptionPane.showMessageDialog(null, "CPF não é um cpf válido");
            return false;
          } 

            return true;
          

        } catch (NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Alguma coisa não ocorreu bem, tente novamente!");
          return false;

        }
      }
    })
    ;
    campoNascimento.setInputVerifier(new InputVerifier() {
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


    panel.add(labelId);
    panel.add(campoId);

    panel.add(labelNome);
    panel.add(campoNome);

    panel.add(labelCPF);
    panel.add(campoCPF);

    panel.add(labelNascimento);
    panel.add(campoNascimento);

    panel.add(labelEndereco);
    panel.add(campoEndereco);

    setContent(panel);
    show();

  }

  
  
  public void salvarButtonClickedFunction(JTextField id, JTextField nome, JTextField  cpf, JTextField nascimento, JTextField endereco) {

    String nomeDigitado = nome.getText();
    String cpfDigitado = (cpf.getText());
    String nascimentoDigitado = nascimento.getText();
    String enderecoDigitado = endereco.getText();

    if(nomeDigitado.isEmpty() || cpfDigitado.isEmpty() || nascimentoDigitado.isEmpty() || enderecoDigitado.isEmpty()){
      JOptionPane.showMessageDialog(null, "Campos preenchidos incorretamente. Tente novamente!");
      return;
    }
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataNascimento = LocalDate.parse(nascimentoDigitado, formatador);


    if(id.getText().isEmpty()){


      

      Tutor tutor = new Tutor(cpfDigitado, nomeDigitado, dataNascimento, enderecoDigitado);

      int resposta = JOptionPane.showConfirmDialog(null,"Confirma a geração do id do tutor?");

      if(resposta != JOptionPane.YES_OPTION){
        return;
      }

    int idGerado = clinicaVeterinaria.adicionarTutorService(tutor);

    if(idGerado == -1){

      Tutor tutorCadastrado = clinicaVeterinaria.procurarTutorPorCPFservice(cpfDigitado);

      JOptionPane.showConfirmDialog(null, "CPF já cadastrado para o tutor " + tutorCadastrado.getId() + " - " + tutorCadastrado.getNome());
      return;
    }
    id.setText(String.valueOf(idGerado));

    JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");

    } else {

      Tutor data = clinicaVeterinaria.procurarTutorPorIdService(Integer.parseInt(id.getText()));

      data.setNome(nomeDigitado);
      data.setEndereco(enderecoDigitado);
      data.setCpf(cpfDigitado);
      data.setNascimento(dataNascimento);
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

   public void incluirButtonClickedFunction(JTextField id, JTextField nome, JTextField  cpf, JTextField nascimento, JTextField endereco){

    if(id.getText().isEmpty() && (!nome.getText().isEmpty() || !nascimento.getText().isEmpty() || !cpf.getText().isEmpty()  || !endereco.getText().isEmpty())){

      int resposta = JOptionPane.showConfirmDialog(null, "Você deseja salvar os dados antes de continuar?");

      if(resposta == JOptionPane.YES_OPTION){

        salvarButtonClickedFunction(id, nome, cpf, nascimento, endereco);

      } else if(resposta == JOptionPane.CANCEL_OPTION){

        return;

      }

     

    }

    id.setText(null);
    nome.setText(null);;
    nascimento.setText(null);
    cpf.setText(null);
    endereco.setText(null);
   }
  
@Override
public void salvarButtonClicked(){

  
  salvarButtonClickedFunction(campoId, campoNome,campoCPF, campoNascimento,campoEndereco);

}

@Override
public void incluirButtonClicked(){

  incluirButtonClickedFunction(campoId, campoNome, campoCPF, campoNascimento, campoEndereco);



}
 

   
}
