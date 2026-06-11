package main;

//imports

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entity.*;
import model.enums.*;
import model.service.ClinicaVeterinaria;
import model.service.carregarDadosIniciais;
import model.view.Screen;
import model.view.TelaCaminhoFeliz;
import model.view.TelaLogin;
import model.view.TelaPrincipal;

import javax.swing.*;
import java.awt.*;




public class App {

    private Scanner leitor;
    private ClinicaVeterinaria clinica;

     public App() {
         this.leitor = new Scanner(System.in);
         this.clinica = new ClinicaVeterinaria(); 
     }


    public void iniciarMenu(){

         String[] opcoesMenu = {"Marcar consulta", "Consultar exame", "Acessar portal do funcionario", "Sair"};

        System.out.println("\n=======================================");
        System.out.println("      SISTEMA HOSPITAL VETERINÁRIO     ");
        System.out.println("=======================================\n");

        System.out.println("Seja bem-vindo(a) ao hospital. Como posso ajudar hoje?");

        for(int i = 0; i<opcoesMenu.length; i++){

            System.out.println(String.valueOf(i+1) + " - " + opcoesMenu[i] + ";");

        }

        System.out.println("Escolha uma opção [digite apenas o numero]: ");
        //Scanner leitor = new Scanner(System.in);
        int opcaoSelecionada = this.leitor.nextInt();
        this.leitor.nextLine();


        

        switch(opcaoSelecionada){
            case 1: 
                System.out.println("Função em desenvolvimento\n");
            break;

            case 2: 
                System.out.println("Função em desenvolvimento\n");
            break;

            case 3:
                System.out.println("Função em desenvolvimento\n");
            break;
            case 4:
                this.leitor.close();
            break;
        }

    }



    public void cadastrarTutor(){

        String cpf;
        String nome;
        LocalDate dataNascimento;
        String endereco;
  
        

        System.out.println("Nome do tutor: ");
        nome = leitor.nextLine();

        System.out.println("Informe a dataNascimento: ");
        String data = leitor.nextLine();
        String[] partes = data.split("/");

        dataNascimento = LocalDate.of(Integer.parseInt(partes[2]),Integer.parseInt(partes[1]),Integer.parseInt(partes[0]));
        
        System.out.println("Informe o CPF: ");
        cpf = leitor.nextLine();

        System.out.println("Informe o endereço: ");
        endereco = leitor.nextLine();

        Tutor tutor = new Tutor(cpf, nome, dataNascimento, endereco);

        clinica.adicionarTutorService(tutor);

    }

    public void cadastrarAnimal(){

    }

    public void marcarConsulta(){

         

        System.out.println("Você já possui cadastro em nosso hospital?\n");
        System.out.println("1 - sim\n");
        System.out.println("2 - Não");

        int opcaoSelecionada = leitor.nextInt();
        

        if(opcaoSelecionada == 2){
            cadastrarTutor();
            System.out.println("Vamos cadastrar o usuario");
        } 

        System.out.println("Você seu bichinho já possui cadastro com a gente?\n");
        System.out.println("1 - sim\n");
        System.out.println("2 - Não");

         opcaoSelecionada = leitor.nextInt();

         if(opcaoSelecionada == 2){
            cadastrarAnimal();
            System.out.println("Vamos cadastrar o usuario");
        } 

        System.out.println("Otimo ... para qual dia você deseja marcar sua consulta?");
        System.out.println("Consulta agendada");



    }

    

    public void login(ClinicaVeterinaria sistemaClinica){


        
        
        Screen tela = new Screen("Tela login - PatasCloud", 400, 300);
        TelaPrincipal telaPrincipal = new TelaPrincipal(sistemaClinica);

        TelaLogin login = new TelaLogin(sistemaClinica, () ->{

            tela.adicionarTela(telaPrincipal, "tela principal");;
            tela.navegar("tela principal");
        });

        tela.setContent(login, "login");
        tela.show();

    }


    
    public static void main(String[] args) throws Exception {

        

        App app = new App();

        ClinicaVeterinaria sistemaClinica = new ClinicaVeterinaria();
        carregarDadosIniciais inicar = new carregarDadosIniciais(sistemaClinica);

        Animal teste = new Animal ("teste", 17, null, null, null, null, null, null);

        String nome = teste.getNome();

        System.out.println(nome);

        Veterinario vet = new Veterinario("123456789", "joao", LocalDate.of(2020,4,20), "cuiabraza", "este", 1500.00, "1234");
        sistemaClinica.adicionarFuncionarioService(vet);
        Veterinario vet2 = new Veterinario("123456", "Usuario teste", LocalDate.of(2020,4,20), "cuiabraza", "Quality Assurance", 1500.00, "123456");
        sistemaClinica.adicionarFuncionarioService(vet2);

        Tutor tutor1 = new Tutor("123456", "Joana", null, null);
        tutor1.setId(1);

        sistemaClinica.adicionarTutorService(tutor1);
        //app.login(sistemaClinica);

        String menu = JOptionPane.showInputDialog(
        "==== Menu ====\n\n" +
        "1 - Testar versão simplificado (codigo aula passada)\n" + 
        "2 - testar versão premium - Beta (em desenvolvimento)\n"
      );

      if(menu.equals("1")){
        TelaCaminhoFeliz telaCaminhoFeliz = new TelaCaminhoFeliz();
        telaCaminhoFeliz.janelaTeste();
        //app.janelaTeste();
    } else {
        JOptionPane.showConfirmDialog(null, "Essa versão foi desenvolvida usando paineis, botões e funções de validação de dados.\n Utilize o usuario e senha -> 123456");
        JOptionPane.showConfirmDialog(null, "Será carregado um conjunto de informações predefinidas");
        app.login(sistemaClinica);
    }
}
}