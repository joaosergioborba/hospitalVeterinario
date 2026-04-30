package model.entity;
public class Tutor {
  private Pessoa pessoa;
  private boolean tutorAtivo;

  public Tutor(Pessoa pessoa) {
    this.pessoa = pessoa;
    this.tutorAtivo = true;
  }
}
