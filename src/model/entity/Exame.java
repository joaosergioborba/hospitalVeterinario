package model.entity;

import java.sql.Date;
import model.enums.StatusExame;
//coloquei a explicacao desse extends e do super em outras classes :)
public class Exame extends RegistroClinico{
  private String resultado;
  private StatusExame status;

  public Exame(Funcionario veterinario, Animal animal, Produto produto, Date data, String resultado) {

    super(veterinario, animal, produto, data);
    this.resultado = "Aguardando resultado...";
    this.status = StatusExame.AGENDADO;
  }

  public void checkInAnimal () {
    this.status = StatusExame.EM_ESPERA;
  }
  public void iniciarColeta(){
    this.status = StatusExame.EM_COLETA;
  }
  public void enviarColetaParaAnalise(){
    this.status = StatusExame.EM_ANALISE;
  }
  public void enviarResultado(){
    this.status = StatusExame.FINALIZADO;
    this.resultado = "O Exame indica infecção ...";
    //acho uma boa colocar uma aplicacao para enviar email para o tutor
  }


    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public StatusExame getStatus() {
        return status;
    }

    public void setStatus(StatusExame status) {
        this.status = status;
    }
}
