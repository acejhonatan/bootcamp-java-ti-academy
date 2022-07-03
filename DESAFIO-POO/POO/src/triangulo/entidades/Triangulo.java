package triangulo.entidades;

public class Triangulo {

    private double x;
    private double y;
    private double z;

    public Triangulo(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean validar() {
        if (Math.abs(x - y) < z && z < (x + y)) {
            return true;
        }
        return false;
    }

    public String classificar() {
        if (x == y && y == z) {
            return  "Equilátero";
        } else if (x == y || x == z || y == z) {
            return "Isósceles";
        }
        return "Escaleno";
    }

    public double perimetro() {
        return (x + y + z) /  2.0;
    }

    public double area() {
        return Math.sqrt(
                perimetro() * (perimetro() - x) * (perimetro() - y) * (perimetro() - z)
        );
    }

    @Override
    public String toString() {
        return "Os lados "
                + x
                + ", "
                + y
                + " e "
                + z
                + " formam um triângulo "
                +  classificar()
                + "."
                + "\nO perímetro do triângulo é "
                + String.format("%.2f", perimetro())
                + "."
                + "\nA área do triangulo é "
                + String.format("%.2f", area())
                + ".\n";
    }
}
