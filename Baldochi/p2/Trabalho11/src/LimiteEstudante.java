
import javax.swing.JOptionPane;


public class LimiteEstudante {
    private ControleEstudante objCEstudante;
    
    public LimiteEstudante(ControleEstudante objControleEstudante){
        this.objCEstudante = objControleEstudante;
    }
    
    private void cadastraEstudante(){
        String Nome = JOptionPane.showInputDialog("Informe o nome");
        
        String NroMatric = JOptionPane.showInputDialog("Informe o numero de matricula");
        int nroMatric = Integer.parseInt(NroMatric);
        
        objCEstudante.insereEstudante(nroMatric, Nome);
    }
}
