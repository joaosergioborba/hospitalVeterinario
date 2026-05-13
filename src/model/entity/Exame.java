package model.entity;

import java.sql.Date;
import model.enums.StatusExame;

public class Exame {
    
    private int id;
    private Produto produto;
    private String resultado;
    private Funcionario veterinario;
    private Animal animal;
    private Date data;
    private StatusExame status;

    public Exame(Produto produto, String resultado, Funcionario veterinario, Animal animal, Date data) {
        this.produto = produto;
        this.resultado = resultado;
        this.veterinario = veterinario;
        this.animal = animal;
        this.data = data;
        this.status = StatusExame.AGENDADO;
    }

    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Funcionario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Funcionario veterinario) {
        this.veterinario = veterinario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public StatusExame getStatus() {
        return status;
    }

    public void setStatus(StatusExame status) {
        this.status = status;
    }
}