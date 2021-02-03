
import java.util.*;
import javax.swing.*;

public class Teste {

    public static void main(String args[]) {

        ArrayList<EmpDomestica> listaEmpregadas = new ArrayList<EmpDomestica>();

        String Nome1, Nome2, Nome3;

        float salario1, salario2, salario3;

        int horas_trabalhadas, diasTrabalhados, tel1, tel2, tel3;

        double valor_por_hora, valorPorDia, valorMensal;

        Nome1 = "Carol";
        Nome2 = "Silvia";
        Nome3 = "Mônica";

        tel1 = 988765632;
        tel2 = 987633212;
        tel3 = 999768900;

        listaEmpregadas.add(new Horista(Nome1, tel1, 160, 10));
        listaEmpregadas.add(new Diarista(Nome2, tel2, 20, 55));
        listaEmpregadas.add(new Mensalista(Nome3, tel3, 1000));

        for (EmpDomestica l : listaEmpregadas) {
            System.out.println("Nome: " + l.getnome() + " telefone " + l.gettelefone() + " salário " + l.getSalario());
        }
        EmpDomestica menor = menorSalario(listaEmpregadas);
        
        System.out.println("Menor Sálario: Nome: " +menor.getnome() + " telefone " +menor.gettelefone() + " salário " +menor.getSalario());
        
        

    }
    
    
    public static EmpDomestica menorSalario(ArrayList <EmpDomestica> empregadas) {
        EmpDomestica aux; // para pegar o primeiro    
        aux = empregadas.get(0);
        
        for(EmpDomestica e: empregadas){
            if(e.getSalario() < aux.getSalario()){
                aux = e; 
            }
        }
        
        return aux;
    }
}
