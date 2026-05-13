package model.entity;

import java.sql.Date;

public class Vacina {

    private int id;
    private Produto produto;
    private Funcionario funcionario;
    private Animal animal;
    private Date data;

    public Vacina(Produto produto, Funcionario funcionario, Animal animal, Date data){
        this.produto = produto;
        this.funcionario = funcionario;
        this.animal = animal;
        this.data = data;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
}