package model.view.recepcao.popUpOperacao;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import model.entity.Animal;
import model.entity.Atendimento;
import model.entity.Funcionario;
import model.enums.Funcao;
import model.enums.StatusAtendimento;
import model.service.ClinicaVeterinaria;
import model.service.validarDadosService;
import model.view.abstract_class.PopUpOperacaoIncluir;


public class PopUpOperacaoCheckIn_animal extends PopUpOperacaoIncluir{

  private JPanel panel;
  private JTextField campoIdAtendimento;
  private JTextField campoIdAnimal;
  private JTextField campoIdTutor;
  private JTextField campoIdVeterinario;

  private JTextField campoNomeAnimal;
  private JTextField campoNomeTutor;
  private JTextField campoNomeVeterinario;

  private JTextField campoData;
  private JTextField campoObservacoes;

  private Atendimento atendimentoParaCheckIn;

  
  

  public PopUpOperacaoCheckIn_animal(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    super(janelaPai, tituloPagina, clinicaVeterinaria);



    panel = new JPanel();

    JLabel procurarAtendimento = new JLabel("------------------------- Procurar Atendimento -------------------------");

    JLabel labelIdAtendimento= new JLabel("Procurar por Id atendimento: ");
    this.campoIdAtendimento = new JTextField(30);

    JLabel labelIdAnimal = new JLabel("Produrar Id animal: ");
    this.campoIdAnimal = new JTextField(30);

    JLabel labelIdTutor = new JLabel("Produrar por Id tutor: ");
    this.campoIdTutor = new JTextField(30);

    JLabel labelIdVeterinario = new JLabel("Procurar por Id veterinario: ");
    this.campoIdVeterinario = new JTextField(30);

    JLabel dadosAtendimento = new JLabel("------------------------- Dados Atendimento -------------------------");

    JLabel labelNomeAnimal = new JLabel("Nome animal: ");
    this.campoNomeAnimal = new JTextField(30);
    campoNomeAnimal.setEditable(false);

    JLabel labelTutor = new JLabel("Nome Tutor: ");
    this.campoNomeTutor = new JTextField(30);
    campoNomeTutor.setEditable(false);

    JLabel labelNomeVeterinario = new JLabel("Veterinario: ");
    this.campoNomeVeterinario = new JTextField(30);
    campoNomeVeterinario.setEditable(false);

     JLabel labelObservacao = new JLabel("Observações: ");
     this.campoObservacoes = new JTextField(30);
     campoObservacoes.setEditable(false);

     JLabel labelData = new JLabel("Data prevista: ");
     this.campoData = new JTextField(30);
     campoData.setEditable(false);



    campoIdAtendimento.setInputVerifier(new InputVerifier() {
    @Override
    public boolean verify(JComponent input) {

      try {

        JTextField tf = (JTextField) input;

        if(tf.getText().isEmpty()){
          campoIdAnimal.setEditable(true);
          campoIdTutor.setEditable(true);
          campoIdVeterinario.setEditable(true);
          return true;

        }

        int id = Integer.parseInt(tf.getText());

        
    
        Atendimento data = clinicaVeterinaria.procurarAtendimentoPorIdService(id);
      
    
        if(data == null){
            JOptionPane.showMessageDialog(null, "Não existe um atendimento com esse Id");
            return false;
          }

          if(data.getStatus() != StatusAtendimento.AGENDADO){

            JOptionPane.showMessageDialog(null, "Só é possível fazer checkin de pacientes que estão com status agendado");
            return false;

          }
          campoIdAnimal.setEditable(false);
          campoIdTutor.setEditable(false);
          campoIdVeterinario.setEditable(false);
          campoNomeTutor.setText(data.getAnimal().getTutor().getNome());
          campoNomeAnimal.setText(data.getAnimal().getNome());
          campoNomeVeterinario.setText(data.getVeterinario().getNome());
          campoObservacoes.setText(data.getObservacoes());
          campoData.setText(String.valueOf(data.getData()));

          atendimentoParaCheckIn = data;
          return true;
    
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
          campoIdAnimal.setEditable(true);
          campoIdTutor.setEditable(true);
          campoIdVeterinario.setEditable(true);
          return true;

        }

        int id = Integer.parseInt(tf.getText());

        
    
        List<Atendimento> data = clinicaVeterinaria.listarAtendimentoAtivosPorAnimalIdService(id);
      
    
        if(data.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não existe atendimento pendentes para esse animal");
            return false;
          } else {

            StringBuilder retorno = new StringBuilder("--------------- Escolha um atendimento e digite no id do atendimento ----------------\n");
            for(Atendimento t: data){
              retorno.append("Id atendimento: " + t.getId() + "--> " + "Animal: " + t.getAnimal().getNome() + "--> " + "Observações: " + t.getObservacoes() + "\n\n");
    
            }

            JOptionPane.showConfirmDialog(null, retorno);
          }
      
          return true;
    
      }  catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "O id informado não é um id válido! Digite apenas números");
        return false;
      }
    }});
    campoIdTutor.setInputVerifier(new InputVerifier() {
    @Override
    public boolean verify(JComponent input) {

      try {

        JTextField tf = (JTextField) input;

        if(tf.getText().isEmpty()){
          campoIdAnimal.setEditable(true);
          campoIdTutor.setEditable(true);
          campoIdVeterinario.setEditable(true);
          return true;

        }

        int id = Integer.parseInt(tf.getText());

        
    
        List<Atendimento> data = clinicaVeterinaria.listarAtendimentoAtivosPorTutorIdService(id);
      
    
        if(data.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não existe atendimento pendentes para animal(is) desse tutor");
            return false;
          } else {

            StringBuilder retorno = new StringBuilder("--------------- Escolha um atendimento e digite no id do atendimento ----------------\n");
            for(Atendimento t: data){
              retorno.append("Id atendimento: " + t.getId() + "--> " + "Animal: " + t.getAnimal().getNome() + "--> " + "Observações: " + t.getObservacoes() + "\n\n");
    
            }

            JOptionPane.showConfirmDialog(null, retorno);
          }
      
          return true;
    
      }  catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "O id informado não é um id válido! Digite apenas números");
        return false;
      }
    }});

    campoIdVeterinario.setInputVerifier(new InputVerifier() {
    @Override
    public boolean verify(JComponent input) {

      try {

        JTextField tf = (JTextField) input;

        if(tf.getText().isEmpty()){
          campoIdAnimal.setEditable(true);
          campoIdTutor.setEditable(true);
          campoIdVeterinario.setEditable(true);
          return true;

        }

        int id = Integer.parseInt(tf.getText());

        
    
        List<Atendimento> data = clinicaVeterinaria.listarAtendimentoAtivosPorVeterinarioIdService(id);
      
    
        if(data.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não existe atendimento pendentes para esse animal");
            return false;
          } else {

            StringBuilder retorno = new StringBuilder("--------------- Escolha um atendimento e digite no id do atendimento ----------------\n");
            for(Atendimento t: data){
              retorno.append("Id atendimento: " + t.getId() + "--> " + "Animal: " + t.getAnimal().getNome() + "--> " + "Observações: " + t.getObservacoes() + "\n\n");
    
            }

            JOptionPane.showConfirmDialog(null, retorno);
          }
      
          return true;
    
      }  catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "O id informado não é um id válido! Digite apenas números");
        return false;
      }
    }});

  

    panel.add(procurarAtendimento);

    panel.add(labelIdAtendimento);
    panel.add(campoIdAtendimento);

    panel.add(labelIdAnimal);
    panel.add(campoIdAnimal);

    panel.add(labelIdTutor);
    panel.add(campoIdTutor);

    panel.add(labelIdVeterinario);
    panel.add(campoIdVeterinario);

    panel.add(dadosAtendimento);

    panel.add(labelNomeAnimal);
    panel.add(campoNomeAnimal);

    panel.add(labelTutor);
    panel.add(campoNomeTutor);

    panel.add(labelNomeVeterinario);
    panel.add(campoNomeVeterinario);

    panel.add(labelObservacao);
    panel.add(campoObservacoes);

    panel.add(labelData);
    panel.add(campoData);
  
    setContent(panel);
    show();

  }

  
  
  public void salvarButtonClickedFunction(Atendimento atendimento) {
  
    if(atendimento == null){
      JOptionPane.showMessageDialog(null, "Campos preenchidos incorretamente. Tente novamente!");
      return;
    }

    clinicaVeterinaria.checkInPaciente(atendimento);

    JOptionPane.showMessageDialog(null, "Entrada do paciente realizada com sucesso! paciente na fila");

  }



   public void incluirButtonClickedFunction(JTextField campoIdAtendimento, JTextField campoIdAnimal, JTextField campoIdTutor, JTextField campoIdVeterinario, JTextField campoNomeAnimal, JTextField campoNomeTutor, JTextField campoNomeVeterinario, JTextField campoData, JTextField campoObservacoes){

    campoIdAtendimento.setText(null);
    campoIdAnimal.setText(null);
    campoIdTutor.setText(null);
    campoIdVeterinario.setText(null);

    campoNomeAnimal.setText(null);
    campoNomeTutor.setText(null);
    campoNomeVeterinario.setText(null);

    campoData.setText(null);
    campoObservacoes.setText(null);
   }
  
@Override
public void salvarButtonClicked(){
  salvarButtonClickedFunction(atendimentoParaCheckIn);
}

@Override
public void incluirButtonClicked(){

  incluirButtonClickedFunction(campoIdAtendimento, campoIdAnimal, campoIdTutor, campoIdVeterinario, campoNomeAnimal, campoNomeTutor, campoNomeVeterinario, campoData, campoObservacoes);
}
 

   
}

