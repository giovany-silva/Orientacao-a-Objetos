
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CriaTurma extends JPanel implements ActionListener {
        private ArrayList<Disciplina> listaDisciplina;
        private ArrayList<Estudante> listaEstudante;
        private ArrayList<Estudante> listaEstTurma = new ArrayList();
        private ControleApp ctrl;
        private JTextField textField;
        private JComboBox combo;
        
    public CriaTurma(ControleApp pCtrl, ArrayList pListaDisciplina, ArrayList pListaEstudante) {
        listaDisciplina = pListaDisciplina;
        listaEstudante = pListaEstudante;
        ctrl = pCtrl;
        this.setSize(720, 480);
        this.setLayout(new BorderLayout());
        
        combo = new JComboBox();
        String str;
        for(Disciplina d: listaDisciplina){
            str = "";
            str += d.getCodigo();
            str += " - ";
            str += d.getNome();
            combo.addItem(str);
        }
        this.add(combo, BorderLayout.PAGE_START);
        
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel label = new JLabel("Número matrícula estudante (0 para finalizar): ");
        textField = new JTextField(20);
        textField.addActionListener(this);
        p.add(label);
        p.add(textField);        
        this.add(p, BorderLayout.CENTER);
                        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nroMatric = Integer.parseInt(textField.getText());
        if(nroMatric == 0){
            if(!listaEstTurma.isEmpty()){
                Disciplina discip = listaDisciplina.get(combo.getSelectedIndex());  
                
                ArrayList listaAux = new ArrayList();
                listaAux = (ArrayList) listaEstTurma.clone();
                listaEstTurma.clear();       
                
                Turma t = new Turma(discip, listaAux);
                ctrl.insereTurma(t);
                textField.setText("");
                JOptionPane.showMessageDialog(null, "Turma criada.");                
                return;
            }
        }            
        boolean achou = false;
        for(Estudante est: listaEstudante){
            if(est.getNroMatric() == nroMatric){
                listaEstTurma.add(est);                
                achou = true;
                break;
            }        
        }
        if(!achou){
            JOptionPane.showMessageDialog(null, "Estudante não cadastrado");            
        }
        textField.setText("");
    }
}

