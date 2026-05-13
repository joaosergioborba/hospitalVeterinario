package model.entity;

public class Tutor {

    private Pessoa pessoa;
    private boolean tutorAtivo;

    public Tutor(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.tutorAtivo = true;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isTutorAtivo() {
        return tutorAtivo;
    }

    public void setTutorAtivo(boolean tutorAtivo) {
        this.tutorAtivo = tutorAtivo;
    }
}