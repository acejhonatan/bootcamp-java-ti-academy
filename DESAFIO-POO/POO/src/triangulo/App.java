package triangulo;

import triangulo.entidades.Triangulo;

public class App {

    public static void main(String[] args) {

        Triangulo a = new Triangulo(2, 5, 15);
        Triangulo b = new Triangulo(3, 4, 3);

        if (a.validar()) {
            System.out.println(a);
        } else {
            System.out.println("\nOs lados informados não são de um triângulo.\n");
        }

        if (b.validar()) {
            System.out.println(b);
        } else {
            System.out.println("Os lados informados não são de um triângulo.\n");
        }
    }
}
