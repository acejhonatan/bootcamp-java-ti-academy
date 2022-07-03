package produto.entidades;

public class Produto {

    private String nome;
    private double valorUnitario;
    private int quantidade;

    public Produto(String nome, double valorUnitario, int quantidade) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double valorImposto() {
        if (valorUnitario < 1000) {
            return valorUnitario * 0.06;
        }
        return valorUnitario * 0.12;
    }

    public double valorEstoque() {
        return (valorUnitario + valorImposto()) * quantidade;
    }
}
