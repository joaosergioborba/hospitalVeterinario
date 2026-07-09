package model.view.recepcao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

import model.service.ClinicaVeterinaria;
import model.view.conteudoPopUps.PopUpEmDesenvolvimento;
import model.view.recepcao.telasBase.TelaAnimal;
import model.view.recepcao.telasBase.TelaAtendimento;
import model.view.recepcao.telasBase.TelaCheckIn;
import model.view.recepcao.telasBase.TelaFuncionario;
import model.view.recepcao.telasBase.TelaTutor;

public class TelaRecepcao {
  private ClinicaVeterinaria clinicaVeterinaria;
  private JFrame janelaPai;
  private JDialog jDialog;
  private JPanel painelBase;
  
  public TelaRecepcao(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria){
    this.janelaPai = janelaPai;
    this.clinicaVeterinaria = clinicaVeterinaria;

    jDialog = new JDialog(janelaPai, tituloPagina, false);
    jDialog.setSize(1400, 600);
    jDialog.setLocationRelativeTo(janelaPai);
    jDialog.setResizable(false);
    jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    
    painelBase = new JPanel(new BorderLayout());
    painelBase.setBackground(new Color(245, 247, 250)); // Cor de fundo leve e moderna
    jDialog.setContentPane(painelBase);
    painelBase.add(conteudoPagina(janelaPai));
  }

  public JPanel conteudoPagina(JFrame Pai){

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
    panel.setBackground(new Color(245, 247, 250));

    JLabel labelBemVindo = new JLabel("<html><h1 style='color: #2C3E50;'>Patas Cloud - Módulo de Recepção</h1><p style='color: #7F8C8D; font-size: 14px;'>Bem-vindo(a)! Escolha uma das opções abaixo para iniciar o atendimento.</p></html>");
    labelBemVindo.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

    JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
    painelBotoes.setBackground(new Color(245, 247, 250));
    
    JButton funcionarioButton = new JButton("Funcionários");
    JButton tutorButton = new JButton("Tutores");
    JButton animalButton = new JButton("Animais");
    JButton atendimentolButton = new JButton("Agendamentos");
    JButton checkInButton = new JButton("Check-In");
    
    estilizarBotao(funcionarioButton);
    estilizarBotao(tutorButton);
    estilizarBotao(animalButton);
    estilizarBotao(atendimentolButton);
    estilizarBotao(checkInButton);
    
    funcionarioButton.addActionListener(e -> gerenciarFuncionarioButtonClicked(Pai));
    tutorButton.addActionListener(e -> gerenciarTutorButtonClicked(Pai));
    animalButton.addActionListener(e -> gerenciarAnimalButtonClicked(Pai));
    atendimentolButton.addActionListener(e -> gerenciarAtendimentoButtonClicked(Pai));
    checkInButton.addActionListener(e -> checkInButtonClicked(Pai));

    painelBotoes.add(funcionarioButton);
    painelBotoes.add(tutorButton);
    painelBotoes.add(animalButton);
    painelBotoes.add(atendimentolButton);
    painelBotoes.add(checkInButton);

    // Instruções reescritas com foco no processo de negócio
    JLabel labelInstrucoes = new JLabel("<html>"
        + "<div style='background-color: #FFFFFF; padding: 20px; border-radius: 10px; border: 1px solid #BDC3C7; width: 600px;'>"
        + "<h3 style='color: #34495E; margin-top: 0;'>Guia Rápido de Atendimento</h3>"
        + "<ol style='color: #2C3E50; font-size: 13px; line-height: 1.5;'>"
        + "<li><b>Cadastro Inicial:</b> Registre os dados do Tutor e, em seguida, inclua o seu respectivo Animal.</li>"
        + "<li><b>Agendamento:</b> Acesse 'Agendamentos' para vincular o paciente a um médico veterinário.</li>"
        + "<li><b>Recepção (Dia da Consulta):</b> Quando o paciente chegar à clínica, realize o <b>Check-In</b> para enviá-lo à fila do consultório.</li>"
        + "</ol>"
        + "<p style='color: #E74C3C; font-size: 11px;'><i>* Nota: Algumas funcionalidades de edição ainda estão em fase de desenvolvimento.</i></p>"
        + "</div>"
        + "</html>");
    labelInstrucoes.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

    panel.add(labelBemVindo);
    panel.add(Box.createVerticalStrut(30));
    panel.add(painelBotoes);
    panel.add(Box.createVerticalStrut(40));
    panel.add(labelInstrucoes);

    return panel;
  }

  // --- MÉTODO NOVO: Centraliza a lógica de design dos botões ---
  private void estilizarBotao(JButton botao) {
    botao.setBackground(new Color(52, 152, 219)); // Azul moderno
    botao.setForeground(Color.WHITE); // Texto branco
    botao.setFont(new Font("Segoe UI", Font.BOLD, 14));
    botao.setFocusPainted(false); // Remove aquela borda pontilhada feia ao clicar
    botao.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25)); // Padding interno
    botao.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Muda o mouse para 'mãozinha'
    
    // Efeito Hover (Muda de cor ao passar o mouse)
    botao.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            botao.setBackground(new Color(41, 128, 185)); // Azul mais escuro
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            botao.setBackground(new Color(52, 152, 219)); // Retorna ao azul original
        }
    });
  }

  private void gerenciarAnimalButtonClicked(JFrame Pai){
    TelaAnimal telaGerenciarAnimais = new TelaAnimal(Pai, "Gerenciar animais - PatasCloud", clinicaVeterinaria);
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    telaGerenciarAnimais.setContent(popUp);
    telaGerenciarAnimais.show();
  }
  
  private void gerenciarTutorButtonClicked(JFrame Pai){
    TelaTutor telaGerenciarTutores = new TelaTutor(Pai, "Gerenciar tutores - PatasCloud", clinicaVeterinaria);
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    telaGerenciarTutores.setContent(popUp);
    telaGerenciarTutores.show();
  }
  
  private void gerenciarFuncionarioButtonClicked(JFrame Pai){
    TelaFuncionario telaGerenciarFuncionario = new TelaFuncionario(Pai, "Gerenciar Funcionarios - PatasCloud", clinicaVeterinaria);
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    telaGerenciarFuncionario.setContent(popUp);
    telaGerenciarFuncionario.show();
  }
  
  private void gerenciarAtendimentoButtonClicked(JFrame Pai){
    TelaAtendimento telaGerenciarAtendimento = new TelaAtendimento(Pai, "Gerenciar Atendimentos - PatasCloud", clinicaVeterinaria);
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    telaGerenciarAtendimento.setContent(popUp);
    telaGerenciarAtendimento.show();
  }
  
  private void checkInButtonClicked(JFrame Pai){
    TelaCheckIn tela = new TelaCheckIn(Pai, "Gerenciar Check-IN - PatasCloud", clinicaVeterinaria);
    PopUpEmDesenvolvimento popUp = new PopUpEmDesenvolvimento();
    tela.setContent(popUp);
    tela.show();
  }

  public void show(){
    jDialog.setVisible(true);
  }

  public void close(){
    jDialog.dispose();
  }
}