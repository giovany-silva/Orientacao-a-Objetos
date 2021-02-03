
import javax.swing.JOptionPane;


public class LimiteDisciplina {
    private ControleDisciplina objCDisciplina;
    
    public LimiteDisciplina(ControleDisciplina objControleDisciplina){
        this.objCDisciplina = objControleDisciplina;
    }
    
    private void cadastraDisciplina(){
        String Nome = JOptionPane.showInputDialog("Informe o nome da disciplina");
        
        String Codigo = JOptionPane.showInputDialog("Informe o codigo da disciplina");
        int codigo = Integer.parseInt(Codigo);
        
        
        objCDisciplina.insereDisciplina(codigo, Nome);
    }
}
