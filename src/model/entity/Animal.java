package model.entity;


import model.enums.PorteAnimal;
import model.enums.TamanhoPelo;

public class Animal {
  private int id;
  private String nome;
  private int idade;
  private String raca;
  private String sexo;
  private TamanhoPelo pelagemTamanho;
  private String pelagemCor;
  private PorteAnimal porteAnimal;
  private Tutor tutor;
  private boolean animalAtivo;

  public Animal (String nome, int idade, String raca, String sexo, TamanhoPelo pelagemTamanho, String pelagemCor, PorteAnimal porteAnimal, Tutor tutor) {
    this.nome = nome;
    this.idade = idade;
    this.raca = raca;
    this.sexo = sexo;
    this.pelagemTamanho = pelagemTamanho;
    this.pelagemCor = pelagemCor;
    this.porteAnimal = porteAnimal;
    this.tutor = tutor;
    this.animalAtivo = true;
  }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade >= 0) { 
            this.idade = idade;
        }
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public TamanhoPelo getPelagemTamanho() {
        return pelagemTamanho;
    }

    public void setPelagemTamanho(TamanhoPelo pelagemTamanho) {
        this.pelagemTamanho = pelagemTamanho;
    }

    public String getPelagemCor() {
        return pelagemCor;
    }

    public void setPelagemCor(String pelagemCor) {
        this.pelagemCor = pelagemCor;
    }

    public PorteAnimal getPorteAnimal() {
        return porteAnimal;
    }

    public void setPorteAnimal(PorteAnimal porteAnimal) {
        this.porteAnimal = porteAnimal;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public boolean isAnimalAtivo() {
        return animalAtivo;
    }

    public void setAnimalAtivo(boolean animalAtivo) {
        this.animalAtivo = animalAtivo;
    }
}