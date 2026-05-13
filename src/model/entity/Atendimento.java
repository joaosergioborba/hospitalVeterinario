package model.entity;

import java.sql.Date;
import model.enums.StatusAtendimento;

public class Atendimento {
   
    private int id;
    private Animal animal;
    private Funcionario veterinario;
    private Date data;
    private String observacoes;
    private Exame exame;
    private Medicacao medicacao;
    private Vacina vacina;
    private Produto produto;
    private StatusAtendimento status;

   
    public Atendimento(Animal animal, Funcionario veterinario, Date data, String observacoes, Exame exame, Medicacao medicacao, Vacina vacina, Produto produto) {
        this.animal = animal;
        this.veterinario = veterinario;
        this.data = data;
        this.observacoes = observacoes;
        this.exame = exame;
        this.medicacao = medicacao;
        this.vacina = vacina;
        this.produto = produto;
        this.status = StatusAtendimento.AGENDADO;
    }

    public int getId() {
        return id;
    }
    
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Funcionario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Funcionario veterinario) {
        this.veterinario = veterinario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Medicacao getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(Medicacao medicacao) {
        this.medicacao = medicacao;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public StatusAtendimento getStatus() {
        return status;
    }

    public void setStatus(StatusAtendimento status) {
        this.status = status;
    }
}
