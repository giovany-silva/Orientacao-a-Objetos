
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConsultaTurma extends JPanel implements ActionListener {

    private ControleApp ctrl;
    private JTextField textField;
    private JTextArea textArea;
    private ArrayList<Disciplina> listaDisciplina;
    private ArrayList<Turma> listaTurma;

    public ArrayList<Disciplina> getListaDisciplina() {
        return listaDisciplina;
    }
  
    public ConsultaTurma(ArrayList listaDisciplina, ArrayList listaTurma) {
        this.listaDisciplina = listaDisciplina;
        this.listaTurma = listaTurma;
        this.setSize(720, 480);
        this.setLayout(new BorderLayout());
        String str;
        textField = new JTextField(20);

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());

        textArea = new JTextArea();
        JLabel label = new JLabel("Alunos");
        
        textField.addActionListener(this);

        p.add(label);
        p.add(textArea);
        this.add(textField, BorderLayout.PAGE_START);

        this.add(p, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nroDisc = Integer.parseInt(textField.getText());
        System.out.println(nroDisc);
                        textArea.append("");
        
        boolean achou = false, achou1 = false;
        for (Disciplina d : listaDisciplina) {
            if (d.getCodigo() == nroDisc) {

                    achou = true;
                for (Turma t : listaTurma) {
                    if (t.getDisciplina().getCodigo() == nroDisc) {

                        ArrayList<Estudante> listEst = t.getEstudantes();
                        String string="";
                        for(Estudante es: listEst)
                        {
                            string+=es.getNome()+"\n";
                        }
                        
                        textArea.append(string);
                        achou1 = true;
                        break;

                    }

                    
                }
            }
            if (!achou) {
                JOptionPane.showMessageDialog(null, "Este código de disciplina não existe");
            }
            else if(!achou1)
            {
                                JOptionPane.showMessageDialog(null, "Não existem turmas dessa disciplina");
            }
            textField.setText("");

        }

    }

}
