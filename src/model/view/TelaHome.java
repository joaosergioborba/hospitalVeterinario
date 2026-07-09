package model.view;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

import model.service.ClinicaVeterinaria;
import model.view.consultorio.TelaConsultorio;
import model.view.manual.TelaManual;
import model.view.recepcao.TelaRecepcao;

public class TelaHome extends JPanel {
    private ClinicaVeterinaria clinicaVeterinaria;

    private final Color FUNDO = new Color(245, 250, 252);
    private final Color AZUL = new Color(43, 126, 210);
    private final Color TEXTO = new Color(35, 45, 55);

    public TelaHome(ClinicaVeterinaria clinicaVeterinaria) {
        this.clinicaVeterinaria = clinicaVeterinaria;

        setLayout(new BorderLayout());
        setBackground(FUNDO);
        setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));

        add(criarCabecalho(), BorderLayout.NORTH);
        add(criarMenuPrincipal(), BorderLayout.CENTER);
    }
private JPanel criarCabecalho() {

    JPanel painel = new JPanel(new GridLayout(3, 1));
    painel.setOpaque(false);

    JLabel titulo = new JLabel("PatasCloud", SwingConstants.CENTER);
    titulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
    titulo.setForeground(AZUL);

    JLabel subtitulo = new JLabel("Hospital Veterinário", SwingConstants.CENTER);
    subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
    subtitulo.setForeground(TEXTO);

    JLabel descricao = new JLabel("Escolha um setor para continuar", SwingConstants.CENTER);
    descricao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    descricao.setForeground(new Color(120, 120, 120));

    painel.add(titulo);
    painel.add(subtitulo);
    painel.add(descricao);

    return painel;
}

    private JPanel criarMenuPrincipal() {
        JPanel painel = new JPanel(new GridLayout(2, 2, 28, 28));
        painel.setOpaque(false);
        painel.setBorder(BorderFactory.createEmptyBorder(35, 160, 20, 160));

        JButton recepcaoButton = criarBotaoMenu("Recepção", "/assets/recepcaoIcon.png");
        JButton consultorioButton = criarBotaoMenu("Consultório", "/assets/consultorioIcon.png");
        JButton centroDiagnosticoButton = criarBotaoMenu("Centro de Diagnósticos", "/assets/centroDiagnosticoIcon.png");
        JButton manualSistemaButton = criarBotaoMenu("Manual do Sistema", "/assets/manualIcon.png");

        recepcaoButton.addActionListener(e -> abrirRecepcao());
        consultorioButton.addActionListener(e -> abrirConsultorio());
        centroDiagnosticoButton.addActionListener(e -> abrirCentroDiagnostico());
        manualSistemaButton.addActionListener(e -> abrirManualSistema());

        painel.add(recepcaoButton);
        painel.add(consultorioButton);
        painel.add(centroDiagnosticoButton);
        painel.add(manualSistemaButton);

        return painel;
    }

    private JButton criarBotaoMenu(String texto, String caminhoIcone) {
        URL caminho = getClass().getResource(caminhoIcone);
        ImageIcon iconeOriginal = new ImageIcon(caminho);

        Image imagemRedimensionada = iconeOriginal.getImage().getScaledInstance(170, 130, Image.SCALE_SMOOTH);
        ImageIcon icone = new ImageIcon(imagemRedimensionada);

        JButton botao = new JButton(texto, icone);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 18));
        botao.setForeground(TEXTO);
        botao.setVerticalTextPosition(SwingConstants.BOTTOM);
        botao.setHorizontalTextPosition(SwingConstants.CENTER);
        botao.setIconTextGap(8);
        botao.setFocusPainted(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setBackground(Color.WHITE);
        botao.setPreferredSize(new Dimension(320, 260));
        botao.setIconTextGap(16);
        botao.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(205, 225, 235), 1),
        BorderFactory.createEmptyBorder(18, 18, 26, 18)
));
        

        return botao;
    }

    private void abrirManualSistema() {
        JFrame janelaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
        TelaManual telaManual = new TelaManual(janelaPai, "Tela Manual - PatasCloud", clinicaVeterinaria);
        telaManual.show();
    }

    private void abrirCentroDiagnostico() {
        telaEmDesenvolvimento();
    }

    private void abrirConsultorio() {
        loginConsultorio(clinicaVeterinaria);
    }

    private void abrirRecepcao() {
        loginRecepcao(clinicaVeterinaria);
    }

    public void loginRecepcao(ClinicaVeterinaria sistemaClinica) {
        JFrame janelaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
        TelaLogin login = new TelaLogin(janelaPai, "Login - PatasCloud", sistemaClinica, () -> {
            abrirTelaRecepcao(janelaPai, "Tela Recepção - PatasCloud", clinicaVeterinaria);
        });

        login.show();
    }

    public void loginConsultorio(ClinicaVeterinaria sistemaClinica) {
        JFrame janelaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
        TelaLogin login = new TelaLogin(janelaPai, "Login - PatasCloud", sistemaClinica, () -> {
            abrirTelaConsultorio(janelaPai, "Tela Consultório - PatasCloud", clinicaVeterinaria);
        });

        login.show();
    }

    public void abrirTelaRecepcao(JFrame pai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria) {
        TelaRecepcao tela = new TelaRecepcao(pai, "Tela Recepção - PatasCloud", clinicaVeterinaria);
        tela.show();
    }

    public void abrirTelaConsultorio(JFrame pai, String tituloPagina, ClinicaVeterinaria clinicaVeterinaria) {
        TelaConsultorio tela = new TelaConsultorio(pai, "Tela Consultório - PatasCloud", clinicaVeterinaria);
        tela.show();
    }

    public void telaEmDesenvolvimento() {
        JOptionPane.showMessageDialog(
                null,
                "Quase lá! Esta funcionalidade está recebendo os últimos ajustes para entregar a melhor experiência para você."
        );
    }
}