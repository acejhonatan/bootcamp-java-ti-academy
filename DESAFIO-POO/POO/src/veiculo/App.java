package veiculo;

import veiculo.entidades.Veiculo;

public class App {

    public static void main(String[] args) {

        Veiculo v1 = new Veiculo("Gol", 40, 5, 12);

        double distancia = 575.5;
        double precoDoCombustivel = 6.79;

        System.out.println(v1.planejamento(distancia, precoDoCombustivel));
    }
}
