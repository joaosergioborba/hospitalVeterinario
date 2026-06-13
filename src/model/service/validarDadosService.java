package model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class validarDadosService {

  public boolean cpfValido(String cpf){

    if(cpf.length() != 11){
      return false;
    }

    if(!cpf.matches("\\d+")){
        return false;
    }

    //esse validação é para ver se tem alguma letra na string

    char[] cpfSeparado =  cpf.toCharArray();
    int soma = 0;
    for(int i = 0; i < 9; i++){
     soma += Character.getNumericValue(cpfSeparado[i])*(10-i);
    }
    soma = (soma*10)%11;
    if(soma != Character.getNumericValue(cpfSeparado[9])){
  
      return false;
    }

    soma = 0;

    for(int i = 0; i < 10; i++){

     soma += Character.getNumericValue(cpfSeparado[i])*(11-i);

    }

    soma = (soma*10)%11;

    if(soma != Character.getNumericValue(cpfSeparado[10])){
  
      return false;
    }

    System.out.println("deu certo");

    return true;
    
  }

  public boolean isDataValida(String dataTexto) {
      
    
    try {
          DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                  .withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(dataTexto, formatador);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }



  

  
  
}



