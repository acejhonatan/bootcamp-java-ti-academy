package funcionario;

import funcionario.entidades.Contrato;
import funcionario.entidades.Departamento;
import funcionario.entidades.Funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static funcionario.entidades.Nivel.JUNIOR;

public class App {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Funcionario funcionario = new Funcionario(
                "Jhonatan",
                JUNIOR,
                4000.0,
                new Departamento("Suporte")
        );

        Date data = sdf.parse("23/02/2021");
        funcionario.addContrato(new Contrato(
                data,
                60.0,
                4
        ));

        System.out.println("Funcionário: " + funcionario.getNome());
        System.out.println("Departamento: " + funcionario.getDepartamento().getNome());
        System.out.println("Salário: R$" + String.format("%.2f", funcionario.ganho(data.getYear(), data.getMonth())));
    }
}
