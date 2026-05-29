package main;

//imports

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entity.*;
import model.enums.*;
import model.service.ClinicaVeterinaria;
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


    
    
    public static void main(String[] args) throws Exception {

        

        App app = new App();
        ClinicaVeterinaria sistemaClinica = new ClinicaVeterinaria();

        Veterinario vet = new Veterinario("05705129130", "joao", LocalDate.of(2020,4,20), "cuiabraza", "este", 1500.00, "1234");
        sistemaClinica.adicionarFuncionarioService(vet);

        Screen tela = new Screen("Tela login - PatasCloud", 400, 300);
        TelaPrincipal telaPrincipal = new TelaPrincipal(sistemaClinica);

        TelaLogin login = new TelaLogin(sistemaClinica, () ->{

            tela.adicionarTela(telaPrincipal, "tela principal");;
            tela.navegar("tela principal");
        });

        tela.setContent(login, "login");
        tela.show();
        
       // TelaCaminhoFeliz telaCaminhoFeliz = new TelaCaminhoFeliz();

       // app.iniciarMenu();



       //telaCaminhoFeliz.janelaTeste();
       // app.janelaTeste();
       
      /*

        Tutor tutor1 = new Tutor("123.456.789-00", "Ana Oliveira", LocalDate.of(2020,4,20), "Cuiabá - MT");
        

     
        Animal animal1 = new Animal(
            "Thor", 5, "Golden Retriever", "Macho", 
            TamanhoPelo.LONGO, "Dourado", PorteAnimal.GRANDE, tutor1
        );

        System.out.println("\n=======================================");
        System.out.println("      SISTEMA HOSPITAL VETERINÁRIO     ");
        System.out.println("=======================================");
        System.out.println(" PACIENTE: " + animal1.getNome());
        System.out.println(" RESPONSÁVEL (Tutor): " + animal1.getTutor().getPessoa().getNome());   
        System.out.println(" CIDADE: " + animal1.getTutor().getPessoa().getEndereco());
        */
    }
}