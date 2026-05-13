package main;

import model.entity.*;
import model.enums.*;

public class App {
    public static void main(String[] args) throws Exception {
       
        Pessoa p1 = new Pessoa("123.456.789-00", "Ana Oliveira", 20, "Cuiabá - MT");
        Tutor tutor1 = new Tutor(p1);

      
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