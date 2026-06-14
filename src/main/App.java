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
import model.view.TelaHome;
import model.view.TelaLogin;
import model.view.recepcao.TelaRecepcao;

import javax.swing.*;
import java.awt.*;




public class App {

    private ClinicaVeterinaria clinica;

     public App(ClinicaVeterinaria clinica) {
         this.clinica = clinica; 
     }

    

    // public void login(ClinicaVeterinaria sistemaClinica){


    //     Screen tela = new Screen("Tela login - PatasCloud", 400, 300);
    //     TelaPrincipal telaPrincipal = new TelaPrincipal(sistemaClinica);
    //     TelaHome home = new TelaHome(sistemaClinica);

    //     TelaLogin login = new TelaLogin(sistemaClinica, () ->{


    //         tela.adicionarTela(home, "tela principal");;
    //         tela.navegar("tela principal");
    //     });

    //     tela.setContent(login, "login");
    //     tela.show();

    // }

    public void abrirInterface(ClinicaVeterinaria sistemaClinica){

        Screen tela = new Screen("Screen", 1500, 700);
        TelaHome home = new TelaHome(sistemaClinica);

        tela.setContent(home, "Home - PatasCloud");
        tela.show();    
    }

    
    public static void main(String[] args) throws Exception {

        

        
        ClinicaVeterinaria sistemaClinica = new ClinicaVeterinaria();
        App app = new App(sistemaClinica);
        carregarDadosIniciais inicar = new carregarDadosIniciais(sistemaClinica);

        app.abrirInterface(sistemaClinica);

       

}
}