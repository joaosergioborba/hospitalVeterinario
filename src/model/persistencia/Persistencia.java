package model.persistencia;

import java.io.*;

import model.service.ClinicaVeterinaria;

public class Persistencia {

    private static final String ARQUIVO = "clinica.dat";

    public static void salvar(ClinicaVeterinaria clinica) {

        try(ObjectOutputStream out =
                new ObjectOutputStream(
                    new FileOutputStream(ARQUIVO))) {

            out.writeObject(clinica);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static ClinicaVeterinaria carregar() {

        File arquivo = new File(ARQUIVO);

        if(!arquivo.exists()) {
            return new ClinicaVeterinaria();
        }

        try(ObjectInputStream in =
                new ObjectInputStream(
                    new FileInputStream(arquivo))) {

            return (ClinicaVeterinaria) in.readObject();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return new ClinicaVeterinaria();
    }
}