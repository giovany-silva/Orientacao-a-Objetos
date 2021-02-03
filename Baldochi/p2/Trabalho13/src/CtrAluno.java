
import java.util.*;

public class CtrAluno {

    private ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private LimiteAluno limAluno;

    public void insereAluno(String Nome, String nroMatric, String Data) throws Exception {

    
            Aluno al = new Aluno(nroMatric, Nome, Data);
            listaAlunos.add(al);
        
    }

    public String listaAlunos() {
        String alunos = "";
        for (Aluno a : listaAlunos) {
            alunos += a.getNome() + "      " + a.getNroMatric() + "         " + a.getData() + "\n";

        }
        return alunos;
    }

    public static void main(String[] args) {

        new LimiteAluno();

    }
}
