import java.util.*;

public class TestaImpl {

    public static void main(String args[]) {
        ArrayList< Funcionario> fun = new ArrayList< Funcionario>();
        Professor prof = new Professor(1, "Joao", "Doutor", 35.35, 32);
        prof.adicionaPonto(4, 2009);
        prof.lancaFaltas(4, 2009, 2);
        prof.lancaAtrasos(4, 2009, 3);
        fun.add(prof);
        TecAdmin tec = new TecAdmin(11, "Pedro", "Analista Contabil", 2300);
        tec.adicionaPonto(4, 2009);
        tec.lancaFaltas(4, 2009, 3);
        tec.lancaAtrasos(4, 2009, 4);
        fun.add(tec);
        for (Funcionario f : fun) {
            System.out.println(f.imprimeFolha(4, 2009));
        }
    }
}