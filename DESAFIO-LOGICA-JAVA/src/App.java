import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double valorTotalEstoqueProdutosE = 0.00;
        double valorTotalEstoqueProdutosC = 0.00;
        double valorTotalEstoqueProdutosV = 0.00;

        int numeroDeProdutos = 3;
        for (int i = 1; i <= numeroDeProdutos; i++) {
            System.out.println("Produto #" + i + ": ");
            System.out.print("Preço unitário: ");
            double preco = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();
            sc.nextLine();
            System.out.print("Categoria (C, E, V): ");
            char categoria = sc.nextLine().charAt(0);
            categoria = Character.toLowerCase(categoria);

            double porcentagemAliquota = 0;
            int porcentagemMargemDeLucro = 0;
            switch (categoria) {
                case 'c':
                    porcentagemAliquota = 37.41;
                    porcentagemMargemDeLucro = 30;
                    break;
                case 'e':
                    porcentagemAliquota = 43.14;
                    porcentagemMargemDeLucro = 35;
                    break;
                case 'v':
                    porcentagemAliquota = 38.42;
                    porcentagemMargemDeLucro = 50;
                    break;
                default:
                    throw new IllegalArgumentException("Entrada inválida.");
            }
            double imposto = preco * porcentagemAliquota / 100;
            double precoFinal = preco + imposto;
            double precoSugerido = precoFinal + (precoFinal * porcentagemMargemDeLucro / 100);
            System.out.println("Imposto aplicado: R$" + String.format("%.2f", imposto));
            System.out.println("Preço final: R$" + String.format("%.2f", precoFinal));
            System.out.println("Preço sugerido: R$" + String.format("%.2f", precoSugerido) + " (margem de lucro de " + porcentagemMargemDeLucro + "%)\n");

            if (categoria == 'c') {
                valorTotalEstoqueProdutosC += precoFinal * quantidade;
            } else if (categoria == 'e') {
                valorTotalEstoqueProdutosE += precoFinal * quantidade;
            } else {
                valorTotalEstoqueProdutosV += precoFinal * quantidade;
            }
        }
        sc.close();

        System.out.println("PRODUTOS CATALOGADOS COM SUCESSO!\n");
        System.out.println("Valor total dos produtos em estoque separados por categoria:");
        System.out.println("Categoria C - R$" + String.format("%.2f", valorTotalEstoqueProdutosC));
        System.out.println("Categoria E - R$" + String.format("%.2f", valorTotalEstoqueProdutosE));
        System.out.println("Categoria V - R$" + String.format("%.2f", valorTotalEstoqueProdutosV));
    }
}
