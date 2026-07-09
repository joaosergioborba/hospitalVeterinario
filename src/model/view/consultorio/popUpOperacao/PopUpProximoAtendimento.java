package model.view.consultorio.popUpOperacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

import model.entity.Animal;
import model.entity.Atendimento;
import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpOperacaoIncluir;

public class PopUpProximoAtendimento extends PopUpOperacaoIncluir {
  
  private Atendimento atendimentoAtual;

  // Componentes visuais
  private JTextField campoNomeAnimal;
  private JTextField campoRaca;
  private JTextField campoIdade;
  private JTextField campoSexo;
  private JTextField campoPorte;
  private JTextField campoCor;
  private JTextField campoTutor;
  private JTextField campoDataAtendimento;
  private JTextArea campoObservacoes;
  private JTextArea campoDiagnostico;
  private JLabel labelStatusFila;

  public PopUpProximoAtendimento(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria) {
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    JPanel painelBase = new JPanel();
    painelBase.setLayout(new BoxLayout(painelBase, BoxLayout.Y_AXIS));
    painelBase.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

    // Label de aviso para fila vazia (invisível por padrão)
    labelStatusFila = new JLabel("<html><h3 style='color: #E74C3C;'>Nenhum paciente aguardando na fila no momento.</h3></html>");
    labelStatusFila.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    labelStatusFila.setVisible(false);
    painelBase.add(labelStatusFila);

    // Inicialização dos campos vazios
    campoNomeAnimal = criarCampoFixo();
    campoIdade = criarCampoFixo();
    campoRaca = criarCampoFixo();
    campoSexo = criarCampoFixo();
    campoCor = criarCampoFixo();
    campoPorte = criarCampoFixo();
    campoTutor = criarCampoFixo();
    campoDataAtendimento = criarCampoFixo();

    // --- SEÇÃO 1: Dados do Animal ---
    JLabel tituloAnimal = new JLabel("<html><h3 style='color: #2C3E50; margin-bottom: 5px;'>Dados do Paciente</h3></html>");
    JPanel painelAnimal = new JPanel(new GridLayout(4, 4, 8, 8)); 
    painelAnimal.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120)); // Impede que o grid estique demais
    
    painelAnimal.add(new JLabel("Nome do Pet:")); painelAnimal.add(campoNomeAnimal);
    painelAnimal.add(new JLabel("Idade (anos):")); painelAnimal.add(campoIdade);
    painelAnimal.add(new JLabel("Raça:")); painelAnimal.add(campoRaca);
    painelAnimal.add(new JLabel("Sexo:")); painelAnimal.add(campoSexo);
    painelAnimal.add(new JLabel("Cor:")); painelAnimal.add(campoCor);
    painelAnimal.add(new JLabel("Porte:")); painelAnimal.add(campoPorte);
    painelAnimal.add(new JLabel("Tutor:")); painelAnimal.add(campoTutor);
    painelAnimal.add(new JLabel("")); painelAnimal.add(new JLabel("")); 

    // --- SEÇÃO 2: Dados do Atendimento ---
    JLabel tituloAtendimento = new JLabel("<html><h3 style='color: #2C3E50; margin-top: 10px; margin-bottom: 5px;'>Detalhes do Atendimento</h3></html>");
    JPanel painelTopAtendimento = new JPanel(new GridLayout(1, 2, 8, 8));
    painelTopAtendimento.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
    painelTopAtendimento.add(new JLabel("Data do Check-in:"));
    painelTopAtendimento.add(campoDataAtendimento);

    campoObservacoes = new JTextArea(3, 20);
    campoObservacoes.setEditable(false);
    campoObservacoes.setBackground(new Color(245, 245, 245));
    campoObservacoes.setLineWrap(true);
    campoObservacoes.setWrapStyleWord(true);
    JScrollPane scrollObs = new JScrollPane(campoObservacoes);
    scrollObs.setPreferredSize(new Dimension(500, 60)); 
    scrollObs.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

    // --- SEÇÃO 3: Diagnóstico ---
    JLabel tituloDiagnostico = new JLabel("<html><h3 style='color: #27AE60; margin-top: 10px; margin-bottom: 5px;'>Diagnóstico Médico</h3></html>");
    campoDiagnostico = new JTextArea(5, 20);
    campoDiagnostico.setLineWrap(true);
    campoDiagnostico.setWrapStyleWord(true);
    JScrollPane scrollDiag = new JScrollPane(campoDiagnostico);
    // Solução para o corte: Forçar um tamanho mínimo e preferencial
    scrollDiag.setPreferredSize(new Dimension(500, 100));
    scrollDiag.setMinimumSize(new Dimension(500, 80));

    // --- MONTAGEM ---
    painelBase.add(tituloAnimal);
    painelBase.add(painelAnimal);
    
    painelBase.add(tituloAtendimento);
    painelBase.add(painelTopAtendimento);
    painelBase.add(Box.createVerticalStrut(5));
    painelBase.add(new JLabel("Observações da Recepção:"));
    painelBase.add(scrollObs);
    
    painelBase.add(tituloDiagnostico);
    painelBase.add(new JLabel("Descreva o diagnóstico (pode ser deixado em branco):"));
    painelBase.add(scrollDiag);
    
    // Cola flexível: empurra tudo para o topo da janela para os campos não ficarem flutuando
    painelBase.add(Box.createVerticalGlue());

    JPanel wrapper = new JPanel(new BorderLayout());
    wrapper.add(painelBase, BorderLayout.CENTER);
    setContent(wrapper);
    
    // Busca o primeiro paciente automaticamente assim que a tela abre
    chamarProximoPaciente();
    
    show();
  }

  // --- MÉTODOS DE COMPORTAMENTO DA TELA ---

  private void chamarProximoPaciente() {
      this.atendimentoAtual = clinicaVeterinaria.AtenderProximo();
      
      if (this.atendimentoAtual == null) {
          // Fila vazia: Limpa a tela, desabilita a digitação e avisa o médico
          labelStatusFila.setVisible(true);
          limparCampos();
          campoDiagnostico.setEditable(false);
          campoDiagnostico.setBackground(new Color(245, 245, 245));
          JOptionPane.showMessageDialog(null, "Não há pacientes aguardando na fila de atendimento.", "Fila Vazia", JOptionPane.INFORMATION_MESSAGE);
      } else {
          // Paciente encontrado: Habilita diagnóstico e preenche os dados
          labelStatusFila.setVisible(false);
          campoDiagnostico.setEditable(true);
          campoDiagnostico.setBackground(Color.WHITE);
          preencherDadosNaTela(this.atendimentoAtual);
      }
  }

  private void preencherDadosNaTela(Atendimento atendimento) {
      Animal animal = atendimento.getAnimal();
      
      campoNomeAnimal.setText(animal.getNome() != null ? animal.getNome() : "");
      campoIdade.setText(String.valueOf(animal.getIdade()));
      campoRaca.setText(animal.getRaca() != null ? animal.getRaca() : "");
      campoSexo.setText(animal.getSexo() != null ? animal.getSexo().toString() : "");
      campoCor.setText(animal.getPelagemCor() != null ? animal.getPelagemCor() : "");
      campoPorte.setText(animal.getPorteAnimal() != null ? animal.getPorteAnimal().toString() : "");
      campoTutor.setText(animal.getTutor() != null ? animal.getTutor().getNome() : "");

      campoDataAtendimento.setText(atendimento.getData() != null ? atendimento.getData().toString() : "");
      campoObservacoes.setText(atendimento.getObservacoes() != null ? atendimento.getObservacoes() : "");
      campoDiagnostico.setText(atendimento.getDiagnostico() != null ? atendimento.getDiagnostico() : "");
  }

  private void limparCampos() {
      campoNomeAnimal.setText("");
      campoIdade.setText("");
      campoRaca.setText("");
      campoSexo.setText("");
      campoCor.setText("");
      campoPorte.setText("");
      campoTutor.setText("");
      campoDataAtendimento.setText("");
      campoObservacoes.setText("");
      campoDiagnostico.setText("");
  }

  private JTextField criarCampoFixo() {
      JTextField campo = new JTextField();
      campo.setEditable(false);
      campo.setBackground(new Color(245, 245, 245));
      return campo;
  }

  // --- EVENTOS DOS BOTÕES DA CLASSE PAI ---

  @Override
  public void salvarButtonClicked() {
      if (atendimentoAtual == null) {
          JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado para salvar.", "Erro", JOptionPane.ERROR_MESSAGE);
          return;
      }
      
      atendimentoAtual.setDiagnostico(campoDiagnostico.getText());
      
      JOptionPane.showMessageDialog(null, "Diagnóstico salvo com sucesso no prontuário do paciente!", "Atendimento Finalizado", JOptionPane.INFORMATION_MESSAGE);
  }

  @Override
  public void incluirButtonClicked() {
      // O botão incluir agora funciona como "Chamar Próximo"
      chamarProximoPaciente();
  }
}