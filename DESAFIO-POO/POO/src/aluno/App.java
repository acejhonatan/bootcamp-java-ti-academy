package aluno;

import aluno.entidades.Aluno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Aluno aluno = new Aluno(
                "Jhonatan",
                sdf.parse("01/01/2000"),
                "8A",
                new Date()
        );

        System.out.println(aluno);
    }
}
