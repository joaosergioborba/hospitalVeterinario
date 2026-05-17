package main;

import java.time.LocalDate;

import model.entity.*;
import model.enums.*;

public class App {
    public static void main(String[] args) throws Exception {
       
       // private Date dataNascimento = 20/04/2016

        Tutor tutor1 = new Tutor("123.456.789-00", "Ana Oliveira", LocalDate.of(2020,4,20), "Cuiabá - MT");
        //Tutor tutor1 = new Tutor(p1);

     
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