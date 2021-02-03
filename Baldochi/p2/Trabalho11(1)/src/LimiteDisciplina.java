
import javax.swing.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LimiteDisciplina extends JFrame {
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
