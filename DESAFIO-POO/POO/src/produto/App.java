package produto;

import produto.entidades.Produto;

public class App {

    public static void main(String[] args) {

        Produto produto = new Produto("Sapato", 250.00, 10);

        System.out.println("Produto...............: " + produto.getNome());
        System.out.println("Preço.................: R$" + String.format("%.2f", produto.getValorUnitario()));
        System.out.println("Quantidade............: " + produto.getQuantidade());
        System.out.println("Imposto...............: R$ " + String.format("%.2f", produto.valorImposto()));
        System.out.println("Valor total em estoque: R$ " + String.format("%.2f", produto.valorEstoque()));
    }
}
