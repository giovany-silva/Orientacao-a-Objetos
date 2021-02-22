import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ConsultaCirurgia extends JPanel implements ActionListener {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Cirurgia> cirugias = new ArrayList<>();
    private JComboBox comboPac = new JComboBox();
    private JTextArea textArea = new JTextArea();

    public ConsultaCirurgia(ArrayList<Paciente> pacientes, ArrayList<Cirurgia> cirugias) {
        this.pacientes = pacientes;
        this.cirugias = cirugias;

        this.setSize(720, 480);
        this.setLayout(new BorderLayout());

        JPanel p1 = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Nome do paciente: ");

        String str;
        for (Paciente pac : pacientes) {
            str = "";
            str += pac.getNome();
            comboPac.addItem(str);
        }
        comboPac.setSelectedIndex(-1);
        comboPac.addActionListener(this);
                
        p1.add(label);
        p1.add(comboPac);
        
        this.add(p1, BorderLayout.LINE_START);
        this.add(textArea, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String nome = comboPac.getSelectedItem().toString();
        String str = "";
        String medico = "", enfermeiro = "", instrumentador = "";
        for (Cirurgia c : cirugias) {
            if (c.getPaciente().getNome().equals(nome)) {                
                str += "Paciente: " + nome
                        + "\nTipo: " + c.getTipoCirurgia()
                        + "\n\nEquipe Cirurgica:\n";
                for (Funcionario f : c.getListaFun()) {
                    if (f instanceof Medico) {
                        medico = f.getNome();
                    } else {
                        if (((Tecnico) f).getFuncao().equals("Enfermeiro")) {
                            enfermeiro = f.getNome();
                        } else {
                            instrumentador = f.getNome();
                        }
                    }
                }

                str += "Medico: " + medico + "\nEnfermeiro: " + enfermeiro + "\nInstrumentador Cirurgico: " + instrumentador;
            }
        }

        if (str.equals("")) {
            textArea.setText("Não existe cirurgia cadastrada para esse paciente");
        } else {
            textArea.setText(str);
        }
    }

}
