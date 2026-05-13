package model.entity;

import model.enums.Funcao;

public class Funcionario {

    private Pessoa pessoa;
    private Funcao funcao;
    private String especialidade;
    private boolean funcionarioAtivo;

    public Funcionario(Pessoa pessoa, Funcao funcao, String especialidade) {
        this.pessoa = pessoa;
        this.funcao = funcao;
        this.especialidade = especialidade;
        this.funcionarioAtivo = true;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    public void setFuncionarioAtivo(boolean funcionarioAtivo) {
        this.funcionarioAtivo = funcionarioAtivo;
    }
}
