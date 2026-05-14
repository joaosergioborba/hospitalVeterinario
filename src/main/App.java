//Eloisa Franco de Souza RGA:202421901024
//João Sergio Borba      RGA:202421901037SS

package main;

import java.sql.Date;

import model.entity.*;
import model.enums.*;

public class App {
    public static void main(String[] args) throws Exception {
       
        Tutor tutor1 = new Tutor("123.456.789-00", "Ana Oliveira",Date.valueOf("2005-11-01"), "Cuiabá - MT");

      
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
    }
}