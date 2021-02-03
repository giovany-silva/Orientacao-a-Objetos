import java.util.ArrayList;

public class ControleEstudante {
    private ArrayList<Estudante> listaEstud = new ArrayList<>();
    private LimiteEstudante objCLimEstudante;
    
    public ControleEstudante (){
        this.objCLimEstudante = new LimiteEstudante(this);
    }
    
    public void insereEstudante(int nroMatric, String Nome){
        Estudante est = new Estudante(nroMatric, Nome);
        listaEstud.add(est);
    }
}
