package model.entity;

public class Produto {

    private int id;
    private String descricao;
    private float valor;
    private String tipoProduto;

    public Produto(String descricao, float valor, String tipoProduto){
        this.descricao = descricao;
        this.valor = valor;
        this.tipoProduto = tipoProduto;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        if (valor >= 0) { 
            this.valor = valor;
        }
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}