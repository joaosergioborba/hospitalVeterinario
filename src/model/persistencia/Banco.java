package model.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ListIterator;

public class Banco {

  private Connection conexao;
  private String url = "jdbc:mysql://localhost:3307/patasCloud_db";
  private String user = "root";
  private String password = "root";


  public void conectar(){
    try{
      conexao = DriverManager.getConnection(url, user, password);
    } catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public void executarSQL (String sql){

    try{
      conexao.createStatement().execute(sql);

    } catch (Exception e){

      e.printStackTrace();
      throw new RuntimeException(e);

    }

  }


  public void fechar(){
    try{
      conexao.close();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public void executarPreparedStatement(String sql, List parametros){

    try{
      PreparedStatement pstm = conexao.prepareStatement(sql);
      for (int i =0; i<parametros.size(); i++){

        Object obj = parametros.get(i);
        pstm.setObject(i+1, obj); 

      }
      pstm.execute();
    }  catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public ResultSet executarConsulta(String sql){
    try{
      return conexao.createStatement().executeQuery(sql);
    }  catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
