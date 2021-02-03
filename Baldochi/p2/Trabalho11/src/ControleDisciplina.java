import java.util.ArrayList;

public class ControleDisciplina {
    private ArrayList<Disciplina> listaDisc = new ArrayList<>();
    private LimiteDisciplina objCLimDisciplina;
    
    public ControleDisciplina(){
        this.objCLimDisciplina = new LimiteDisciplina(this);
    }
    
    public void insereDisciplina(int codigo, String Nome){
        Disciplina disc = new Disciplina(codigo, Nome);
        listaDisc.add(disc);
    }
}
