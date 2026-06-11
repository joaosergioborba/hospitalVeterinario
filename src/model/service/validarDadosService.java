package model.service;

public class validarDadosService {

  boolean cpfValido(String cpf){

    if(cpf.length() != 11){
      return false;
    }

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

  

  
  
}
