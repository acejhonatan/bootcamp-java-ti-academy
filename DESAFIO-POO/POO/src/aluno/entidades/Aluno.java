package aluno.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String nome;
    private Date dataDeNascimento;
    private String turma;
    private Date dataDeMatricula;

    public Aluno(String nome, Date dataDeNascimento, String turma, Date dataDeMatricula) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.turma = turma;
        this.dataDeMatricula = dataDeMatricula;
    }

    public int calcularIdade(Date dataDeNascimento) {
        return new Date().getYear() - dataDeNascimento.getYear();
    }

    @Override
    public String toString() {
        return "Aluno: "
                + nome
                + "\nIdade: "
                + calcularIdade(dataDeNascimento)
                + "\nTurma: "
                + turma
                + "\nData de matrícula: "
                + sdf.format(dataDeMatricula);
    }
}
