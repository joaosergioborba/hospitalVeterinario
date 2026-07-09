package model.view.recepcao.popUpOperacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.entity.Animal;
import model.service.ClinicaVeterinaria;
import model.view.abstract_class.PopUpOperacaoIncluir;

public class PopUpOperacaoListar_animal extends PopUpOperacaoIncluir {
  
  public PopUpOperacaoListar_animal(JFrame janelaPai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria, List<Animal> lista){
    super(janelaPai, tituloPagina, clinicaVeterinaria);

    // 1. Painel interno que vai empilhar os itens verticalmente
    JPanel panelLista = new JPanel();
    panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS)); 
    panelLista.setBackground(new Color(245, 247, 250)); // Fundo cinza suave moderno
    panelLista.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Margem interna

    // 2. Cabeçalho sutil para a lista de pacientes
    JLabel titulo = new JLabel("<html><h3 style='color: #2C3E50; margin-bottom: 0;'>Pacientes Cadastrados</h3></html>");
    titulo.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    panelLista.add(titulo);
    panelLista.add(Box.createVerticalStrut(15)); // Espaço abaixo do título

    // 3. Laço de repetição para renderizar os cards dos animais
    for(Animal animal : lista){
      panelLista.add(criarCardAnimal(animal));
      panelLista.add(Box.createVerticalStrut(10)); // Espaçamento entre os registros
    }
    
    // 4. Criação da barra de rolagem (JScrollPane) envolvendo o painel de itens
    JScrollPane scrollPane = new JScrollPane(panelLista);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Bloqueia rolagem lateral
    scrollPane.setBorder(null); // Remove a borda padrão antiquada do componente
    
    // 5. SOLUÇÃO DO ERRO DE TIPO: Painel Wrapper (Intermediário)
    // Como setContent exige um JPanel, encapsulamos o JScrollPane dentro de um JPanel com BorderLayout
    JPanel painelWrapper = new JPanel(new BorderLayout());
    painelWrapper.setBackground(new Color(245, 247, 250));
    painelWrapper.add(scrollPane, BorderLayout.CENTER); // Força o scroll a ocupar todo o espaço
    
    // Envia o painel compatível para a classe base
    setContent(painelWrapper);
    show();
  }

  // --- Método Auxiliar: Constrói o layout visual em "Card" para cada registro de animal ---
  private JPanel criarCardAnimal(Animal animal) {
    JPanel card = new JPanel(new BorderLayout());
    card.setBackground(Color.WHITE);
    
    // Define contorno suave e padding interno do card
    card.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(220, 224, 228), 1, true),
        BorderFactory.createEmptyBorder(12, 15, 12, 15)
    ));

    // Código HTML estruturado para criar hierarquia tipográfica limpa
    String textoFormatado = "<html>"
        + "<span style='font-size: 13px; color: #34495E;'><b>Pet:</b> <span style='color: #3498DB;'>" + animal.getNome() + "</span></span><br>"
        + "<span style='font-size: 11px; color: #7F8C8D;'><b>Tutor:</b> " + animal.getTutor().getNome() + "</span>"
        + "</html>";

    JLabel labelInfo = new JLabel(textoFormatado);
    card.add(labelInfo, BorderLayout.CENTER);

    // Limita a altura do card para impedir que o BoxLayout estique as linhas de forma bizarra
    card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));

    return card;
  }
}