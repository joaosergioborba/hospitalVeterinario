package model.entity;

import java.sql.Date;

import model.enums.Funcao;

//to usando herança pq nao estava fazendo sentido nao usar herença. da forma q estava basicamemente esta duplicando o cadastro, entao um funcioario teria um id e a pessoa ligada a esse func teria outro id. 
public class Funcionario extends Pessoa {
  private Funcao funcao;
  private String especialidade;
  private boolean funcionarioAtivo;

  public Funcionario(String cpf, String nome, Date dataNascimento, String endereco, Funcao funcao, String especialidade) {

    super(cpf, nome, dataNascimento, endereco);// aqui esta chamando o construtor (acho q é esse o nome )da classe pai (Pessoa) - tipo a funcao principal la da classe principal.

    this.funcao = funcao;
    this.especialidade = especialidade;
    this.funcionarioAtivo = true;
  }

  public void setDesativado(){
    funcionarioAtivo = false;
  }

  public void setAtivado(){
    funcionarioAtivo = true;
  }


    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isFuncionarioAtivo() {
        return funcionarioAtivo;
    }

    
  
}


