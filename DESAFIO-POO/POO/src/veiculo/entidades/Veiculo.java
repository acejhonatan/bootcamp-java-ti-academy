package veiculo.entidades;

public class Veiculo {

    private String nome;
    private double capacidade;
    private int passageiros;
    private double consumo;

    public Veiculo() {
    }

    public Veiculo(String nome, double capacidade, int passageiros, double consumo) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.passageiros = passageiros;
        this.consumo = consumo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public int getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(int passageiros) {
        this.passageiros = passageiros;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double tanqueViagem(double km) {
        return km / consumo;
    }

    public double custoTotal(double km, double combustivel) {
        return tanqueViagem(km) * combustivel;
    }

    public double dividirDespesas(double km, double combustivel) {
        return custoTotal(km, combustivel) / passageiros;
    }

    public String planejamento(double km, double combustivel) {
        return "Veiculo: "
                + nome
                + "\n Capacidade do tanque: "
                + capacidade
                + " litros "
                + "\nTotal necessário para completar a viagem: "
                + String.format("%.1f", tanqueViagem(km))
                + " litros"
                + "\nDespeza total: R$ "
                + String.format("%.2f", custoTotal(km, combustivel))
                + "\nCusto por passageiro: R$ "
                + String.format("%.2f", dividirDespesas(km, combustivel));
    }
}
