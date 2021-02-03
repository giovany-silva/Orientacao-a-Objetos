import java.io.Serializable;
import java.util.ArrayList;

public class Turma implements Serializable {
    private Disciplina disciplina;
    private ArrayList<Estudante> estudantes = new ArrayList<>();

    public Turma() {
    }

    public Turma(Disciplina disciplina, ArrayList<Estudante> estudantes) {
        this.disciplina = disciplina;
        this.estudantes = estudantes;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
}
