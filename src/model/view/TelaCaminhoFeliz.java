package model.view;
import javax.swing.*;


public class TelaCaminhoFeliz {


    public void janelaTeste(){

      JTextField campoUsuario = new JTextField();
      JPasswordField campoSenha = new JPasswordField();

      JTextField nomeTutor = new JTextField();
      JTextField nomeAnimal = new JTextField();
      JTextField nomeVeterinario = new JTextField();




      Object[] loginFuncionario = {
        "Usuário: ", campoUsuario,
        "Senha: ", campoSenha
      };

      int opcao = JOptionPane.showConfirmDialog(
        null, 
        loginFuncionario, 
        "Login do sistema",
        JOptionPane.OK_CANCEL_OPTION
      );

      if(opcao == JOptionPane.OK_OPTION){

          
          String usuario = campoUsuario.getText();
          JOptionPane.showConfirmDialog(null, "Seja bem-vindo " + usuario);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }

      }


      String menu = JOptionPane.showInputDialog(
        "==== Menu ====\n\n" +
        "1 - Dar entrada em um novo pet\n" + 
        "2 - Sair do sistema\n"
      );

      if(menu.equals("1")){

        Object[] entradaAnimal = {
        "Tutor: ", nomeTutor,
        "Animal: ", nomeAnimal,
        "Veterinario: ", nomeVeterinario
      };

      int telaConfirmcao = JOptionPane.showConfirmDialog(
        null, 
        entradaAnimal, 
        "Login do sistema",
        JOptionPane.OK_CANCEL_OPTION
      );

      if(opcao == JOptionPane.OK_OPTION){

          String tutor = nomeTutor.getText();
          String animal = nomeAnimal.getText();
          String veterinario = nomeVeterinario.getText();
          JOptionPane.showConfirmDialog(null, "O animal " +  animal + " foi cadastrado.");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }

      }



        

      } else if (menu.equals("2")){

      }




    }
  
}
