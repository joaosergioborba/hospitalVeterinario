
package model.view.PopUpOperacao;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import model.entity.Funcionario;
import model.entity.Tutor;
import model.enums.Funcao;
import model.service.ClinicaVeterinaria;
import model.service.validarDadosService;
import model.view.abstract_class.PopUpOperacaoIncluir;

public class PopUpOperacaoIncluir_funcionario extends PopUpOperacaoIncluir{

  private JPanel panel;
  private JTextField campoId;
  private JTextField campoNome;
  private JTextField campoCPF;
  private JTextField campoNascimento;
  private JTextField campoEndereco;
  private JTextField campoEspecialidade;
  private JTextField campoSenha;
  
  private JRadioButton opcaoVeterinario;
  private JRadioButton opcaoLimpeza;
  private JRadioButton opcaoAtendente;
  private JRadioButton opcaoGerencia;
  private JRadioButton opcaoTI;

  private ButtonGroup grupoFuncao;

  public PopUpOperacaoIncluir_funcionario(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    this.panel = new JPanel();

    JLabel labelId = new JLabel("Id funcionario: ");
    this.campoId = new JTextField(30);

    JLabel labelNome = new JLabel("Nome: ");
    this.campoNome = new JTextField(30);

    JLabel labelNascimento = new JLabel("Nascimento (dd/mm/aaaa): ");
    this.campoNascimento = new JTextField(30);

    JLabel labelCPF = new JLabel("CPF: ");
    this.campoCPF = new JTextField(30);

    JLabel labelEndereco = new JLabel("endereco: ");
    this.campoEndereco = new JTextField(30);

    JLabel labelFuncao = new JLabel("Função: ");
    this.opcaoVeterinario = new JRadioButton("Veterinário");
    opcaoVeterinario.setActionCommand(Funcao.MEDICO_VETERINARIO.name());
    this.opcaoLimpeza = new JRadioButton("Limpeza");
    opcaoLimpeza.setActionCommand(Funcao.LIMPEZA.name());
    this.opcaoAtendente = new JRadioButton("Atendente");
    opcaoAtendente.setActionCommand(Funcao.ATENDENTE.name());
    this.opcaoGerencia = new JRadioButton("Gerencia");
    opcaoGerencia.setActionCommand(Funcao.GERENCIA.name());
    this.opcaoTI = new JRadioButton("TI");
    opcaoTI.setActionCommand(Funcao.TI.name());
    this.grupoFuncao = new ButtonGroup();
    this.grupoFuncao.add(opcaoVeterinario);
    this.grupoFuncao.add(opcaoLimpeza);
    this.grupoFuncao.add(opcaoAtendente);
    this.grupoFuncao.add(opcaoGerencia);
    this.grupoFuncao.add(opcaoTI);

    JLabel labelEspecialidade = new JLabel("Especialidade: ");
    this.campoEspecialidade = new JTextField(30);

    JLabel labelSenha = new JLabel("Senha: ");
    this.campoSenha = new JTextField(30);



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

    panel.add(labelFuncao);
    panel.add(opcaoVeterinario);
    panel.add(opcaoLimpeza);
    panel.add(opcaoAtendente);
    panel.add(opcaoGerencia);
    panel.add(opcaoTI);

    panel.add(labelEspecialidade);
    panel.add(campoEspecialidade);

    panel.add(labelSenha);
    panel.add(campoSenha);

    setContent(panel);
    show();

  }

  
  
  public void salvarButtonClickedFunction(JTextField id, JTextField nome, JTextField  cpf, JTextField nascimento, JTextField endereco, ButtonGroup funcao, JTextField especialidade, JTextField senha) {

    String nomeDigitado = nome.getText();
    String cpfDigitado = (cpf.getText());
    String nascimentoDigitado = nascimento.getText();
    String enderecoDigitado = endereco.getText();
    String especialidadeDigitado = especialidade.getText();
    String senhaDigitado = senha.getText();
    Funcao funcaoDigitada = funcao.getSelection() != null ? Funcao.valueOf(funcao.getSelection().getActionCommand()) : null;


    if(funcaoDigitada == Funcao.MEDICO_VETERINARIO && especialidadeDigitado.isEmpty()){
      JOptionPane.showMessageDialog(null, "O usuário a ser cadastrado é um veterinário. Informar sua especialidade é obrigatorio!");
      return;
    }


    if(nomeDigitado.isEmpty() || cpfDigitado.isEmpty() || nascimentoDigitado.isEmpty() || enderecoDigitado.isEmpty() || senhaDigitado.isEmpty() || funcaoDigitada == null){
      JOptionPane.showMessageDialog(null, "Campos preenchidos incorretamente. Tente novamente!");
      return;
    }

    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataNascimento = LocalDate.parse(nascimentoDigitado, formatador);


    if(id.getText().isEmpty()){

      Funcionario funcionario = new Funcionario(cpfDigitado, nomeDigitado, dataNascimento, enderecoDigitado, funcaoDigitada, especialidadeDigitado, 0.0, senhaDigitado);

      int resposta = JOptionPane.showConfirmDialog(null,"Confirma a geração do id do funcionario?");

      if(resposta != JOptionPane.YES_OPTION){
        return;
      }

    int idGerado = clinicaVeterinaria.adicionarFuncionarioService(funcionario);

    if(idGerado == -1){

      Funcionario usuarioCadastrado = clinicaVeterinaria.procurarFuncionarioPorCPFservice(cpfDigitado);

      JOptionPane.showConfirmDialog(null, "CPF já cadastrado para o tutor " + usuarioCadastrado.getId() + " - " + usuarioCadastrado.getNome());
      return;
    }
    id.setText(String.valueOf(idGerado));

    JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");

    } else {

      Funcionario data = clinicaVeterinaria.procurarFuncionarioPorIdService(Integer.parseInt(id.getText()));

      data.setNome(nomeDigitado);
      data.setEndereco(enderecoDigitado);
      data.setCpf(cpfDigitado);
      data.setNascimento(dataNascimento);
      data.setEspecialidade(especialidadeDigitado);
      data.setFuncao(funcaoDigitada);
      data.setSenha(senhaDigitado);

      JOptionPane.showMessageDialog(null, "Os dados foram atualizados com sucesso!");
    }
  }

   public void incluirButtonClickedFunction(JTextField id, JTextField nome, JTextField  cpf, JTextField nascimento, JTextField endereco, ButtonGroup funcao, JTextField especialidade, JTextField senha){

    if(id.getText().isEmpty() && (!nome.getText().isEmpty() || !nascimento.getText().isEmpty() || !cpf.getText().isEmpty()  || !endereco.getText().isEmpty())){

      int resposta = JOptionPane.showConfirmDialog(null, "As alterações não foram salvas! Você deseja salvar os dados antes de continuar?");

      if(resposta == JOptionPane.YES_OPTION){

        salvarButtonClickedFunction(id, nome, cpf, nascimento, endereco, funcao, especialidade, senha );

      } else if(resposta == JOptionPane.CANCEL_OPTION){

        return;

      }

     

    }

    id.setText(null);
    nome.setText(null);;
    nascimento.setText(null);
    cpf.setText(null);
    endereco.setText(null);
    especialidade.setText(null);
    senha.setText(null);
   }
  
@Override
public void salvarButtonClicked(){

  
  salvarButtonClickedFunction(campoId, campoNome,campoCPF, campoNascimento, campoEndereco, grupoFuncao, campoEspecialidade, campoSenha);

}

@Override
public void incluirButtonClicked(){

  incluirButtonClickedFunction(campoId, campoNome, campoCPF, campoNascimento, campoEndereco, grupoFuncao, campoEspecialidade, campoSenha);



}
 

   
}
