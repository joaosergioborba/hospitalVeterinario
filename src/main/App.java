package main;

import model.persistencia.Persistencia;

//imports


import model.service.ClinicaVeterinaria;
import model.view.Screen;
import model.view.TelaHome;
import com.formdev.flatlaf.FlatLightLaf;



public class App {

    private ClinicaVeterinaria clinica;

    public App(ClinicaVeterinaria clinica) {
        this.clinica = clinica;
    }

    public void abrirInterface(ClinicaVeterinaria sistemaClinica){

        Screen tela = new Screen("Screen", 1500, 700);
        tela.configurarPersistencia(sistemaClinica);

        TelaHome home = new TelaHome(sistemaClinica);

        tela.setContent(home, "Home - PatasCloud");
        tela.show();
    }


    public static void main(String[] args) throws Exception {
 
        //ClinicaVeterinaria sistemaClinica = new ClinicaVeterinaria();
        ClinicaVeterinaria sistemaClinica = Persistencia.carregar();
        App app = new App(sistemaClinica);
       // carregarDadosIniciais inicar = new carregarDadosIniciais(sistemaClinica);
        // Inicializa o FlatLaf antes de criar as telas
        try {
           FlatLightLaf.setup();    
        } catch (Exception ex) {
            System.err.println("Falha ao iniciar o FlatLaf.");
        }





        app.abrirInterface(sistemaClinica);
    }

}
    

   
