package model.service;

import java.time.LocalDate;

import model.entity.Animal;
import model.entity.Tutor;
import model.enums.PorteAnimal;
import model.enums.Sexo;
import model.enums.TamanhoPelo;

public class carregarDadosIniciais {

  ClinicaVeterinaria clinicaVeterinaria;

  public carregarDadosIniciais(ClinicaVeterinaria clinicaVeterinaria){
    this.clinicaVeterinaria = clinicaVeterinaria;

    //tutores

    Tutor tutor1 = new Tutor("93041133008", "SOFIA LEMOS", LocalDate.of(2020,4,20), "AV FERNANDO CORREA DA COSTA, CUIABA");
    clinicaVeterinaria.adicionarTutorService(tutor1);

    Tutor tutor2 = new Tutor("02959451090", "BRUNO VASCONCELOS", LocalDate.of(2020,4,20), "AV JOAO PEDRO, CUIABA");
    clinicaVeterinaria.adicionarTutorService(tutor2);

    tutor2.setId(clinicaVeterinaria.buscarProximoIdTutorService());
    Tutor tutor3 = new Tutor("18437295044", "CLARA MENDES", LocalDate.of(2019, 8, 12), "RUA DAS PALMEIRAS, CUIABA");
    clinicaVeterinaria.adicionarTutorService(tutor3);

    Tutor tutor4 = new Tutor("57302941088", "EDUARDO COSTA", LocalDate.of(2021, 1, 15), "AV HISTORIADOR RUBENS DE MENDONCA, CUIABA");
    clinicaVeterinaria.adicionarTutorService(tutor4);

    Tutor tutor5 = new Tutor("36291048033", "SILAS VANCE", LocalDate.of(2018, 11, 3), "RUA VOLUNTARIOS DA PATRIA, CUIABA");
    clinicaVeterinaria.adicionarTutorService(tutor5);

    Tutor tutor6 = new Tutor("84129503022", "ELIAS KAEL", LocalDate.of(2022, 6, 24), "AV GETULIO VARGAS, CUIABA");
    clinicaVeterinaria.adicionarTutorService(tutor6);

    Tutor tutor7 = new Tutor("09348271055", "GRETA PIMENTA", LocalDate.of(2015, 3, 30), "RUA CANDIDO MARIANO, CUIABA");
    clinicaVeterinaria.adicionarTutorService(tutor7);

    Tutor tutor8 = new Tutor("47201938011", "ROMULO COELHO", LocalDate.of(2023, 10, 5), "AV ISAAC POVOAS, CUIABA");
    clinicaVeterinaria.adicionarTutorService(tutor8);

    Tutor tutor9 = new Tutor("62948103077", "ARIC SILVA", LocalDate.of(2020, 12, 18), "RUA BARÃO DE MELGAÇO, CUIABA");
    clinicaVeterinaria.adicionarTutorService(tutor9);

    Tutor tutor10 = new Tutor("25103948066", "LYRA MOONWHISPER", LocalDate.of(2024, 2, 28), "AV TENENTE CORONEL DUARTE, CUIABA");
    clinicaVeterinaria.adicionarTutorService(tutor10);
    clinicaVeterinaria.adicionarTutorService(tutor10);


    // Animais

    Animal animal1 = new Animal("SOL", 10 ,"DOBERMAN", Sexo.FEMEA,TamanhoPelo.CURTO, "PRETO", PorteAnimal.GRANDE, tutor1);
    clinicaVeterinaria.adicionarAnimalService(animal1);
    
    Animal animal2 = new Animal("LUNA", 4, "VIRA-LATA", Sexo.FEMEA, TamanhoPelo.LONGO, "CARAMELO", PorteAnimal.MEDIO, tutor1);
    clinicaVeterinaria.adicionarAnimalService(animal2);

    Animal animal3 = new Animal("THOR", 6, "GOLDEN RETRIEVER", Sexo.MACHO, TamanhoPelo.LONGO, "DOURADO", PorteAnimal.GRANDE, tutor2);
    clinicaVeterinaria.adicionarAnimalService(animal3);

    Animal animal4 = new Animal("ZEUS", 2, "PASTOR ALEMAO", Sexo.MACHO, TamanhoPelo.CURTO, "CAPA PRETA", PorteAnimal.GRANDE, tutor3);
    clinicaVeterinaria.adicionarAnimalService(animal4);

    Animal animal5 = new Animal("MEL", 8, "SHIT_ZU", Sexo.FEMEA, TamanhoPelo.LONGO, "BRANCO E MARROM", PorteAnimal.PEQUENO, tutor4);
    clinicaVeterinaria.adicionarAnimalService(animal5);

    Animal animal6 = new Animal("NINA", 1, "PERSA", Sexo.FEMEA, TamanhoPelo.LONGO, "CINZA", PorteAnimal.PEQUENO, tutor1); // Tutor 1 owns another pet
    clinicaVeterinaria.adicionarAnimalService(animal6);

    Animal animal7 = new Animal("MAX", 5, "ROTTWEILER", Sexo.MACHO, TamanhoPelo.CURTO, "PRETO E TAN", PorteAnimal.GRANDE, tutor5);
    clinicaVeterinaria.adicionarAnimalService(animal7);

    Animal animal8 = new Animal("SIMBA", 3, "SIAMES", Sexo.MACHO, TamanhoPelo.CURTO, "BEGE E MARROM", PorteAnimal.PEQUENO, tutor6);
    clinicaVeterinaria.adicionarAnimalService(animal8);

    Animal animal9 = new Animal("PIPOCA", 7, "PUDLE", Sexo.FEMEA, TamanhoPelo.LONGO, "BRANCO", PorteAnimal.PEQUENO, tutor4); // Tutor 4 owns another pet
    clinicaVeterinaria.adicionarAnimalService(animal9);

    Animal animal10 = new Animal("CHUCK", 12, "CHIHUAHUA", Sexo.MACHO, TamanhoPelo.CURTO, "CREME", PorteAnimal.PEQUENO, tutor7);
    clinicaVeterinaria.adicionarAnimalService(animal10);

    Animal animal11 = new Animal("ATHENA", 5, "BORDER COLLIE", Sexo.FEMEA, TamanhoPelo.LONGO, "PRETO E BRANCO", PorteAnimal.MEDIO, tutor2); // Tutor 2 owns another pet
    clinicaVeterinaria.adicionarAnimalService(animal11);

    
    



    

  }
  
}
