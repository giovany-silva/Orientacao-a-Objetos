import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CriaCirurgia extends JPanel implements ActionListener {

    private ArrayList<Paciente> listaPac;
    private ArrayList<Funcionario> listaFun;
    private ArrayList<Funcionario> listaFunCirurgia = new ArrayList();
    private ControleApp ctrl;
    private JTextField textField;
    private JComboBox comboPac; 
    private JComboBox comboTipo;

    public CriaCirurgia(ControleApp pCtrl, ArrayList pListaPac, ArrayList pListaFun) {
        listaPac = pListaPac;
        listaFun = pListaFun;
        ctrl = pCtrl;
        this.setSize(720, 480);
        this.setLayout(new GridLayout(3, 1));

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        JLabel label1 = new JLabel("Nome do paciente: ");
        comboPac = new JComboBox();
        for (Paciente p : listaPac) {
            comboPac.addItem(p.getNome());
        }
        p1.add(label1);
        p1.add(comboPac);
        this.add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        JLabel label2 = new JLabel("Tipo de cirurgia: ");
        comboTipo = new JComboBox();
        comboTipo.addItem("Obstetricia");
        comboTipo.addItem("Cirurgia Geral");
        comboTipo.addItem("Neurocirurgia");
        p2.add(label2);
        p2.add(comboTipo);
        this.add(p2);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        JLabel label3 = new JLabel("Número funcional (0 para finalizar): ");
        textField = new JTextField(5);
        textField.addActionListener(this);
        p3.add(label3);
        p3.add(textField);
        this.add(p3);

    }

    public boolean equipeOk() {
        boolean medico = false, enfermeiro = false, instrumentador = false;
        int cont = 0;
        for (Funcionario f : listaFunCirurgia) {
            if (f instanceof Medico) {
                if (((Medico) f).getEspecialidade().equalsIgnoreCase(comboTipo.getSelectedItem().toString())) {
                    medico = true;
                    cont++;
                }
            } else {
                if (f instanceof Tecnico) {
                    if (((Tecnico) f).getFuncao().equalsIgnoreCase("Enfermeiro")) {
                        enfermeiro = true;
                        cont++;
                    } else {
                        if (((Tecnico) f).getFuncao().equalsIgnoreCase("Instrumentador")) {
                            instrumentador = true;
                            cont++;
                        }
                    }
                }
            }
        }
        if (cont != 3){
            return false;
        }
        if (medico && enfermeiro && instrumentador) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nroFun = Integer.parseInt(textField.getText());
        if (nroFun == 0) {
            if (!listaFunCirurgia.isEmpty()) {
                if (!equipeOk()) {
                    JOptionPane.showMessageDialog(null, "Equipe médica não atende requisitos");
                    textField.setText("");
                    listaFunCirurgia.clear();
                    return;
                }
                Paciente pac = listaPac.get(comboPac.getSelectedIndex());
                String tipoCirurgia = comboTipo.getSelectedItem().toString();

                ArrayList listaAux = new ArrayList();
                listaAux = (ArrayList) listaFunCirurgia.clone();
                listaFunCirurgia.clear();

                Cirurgia c = new Cirurgia(pac, tipoCirurgia, listaAux);

                ctrl.insereCirurgia(c);
                textField.setText("");
                JOptionPane.showMessageDialog(null, "Cirurgia criada.");
                return;
            }
        }
        boolean achou = false;
        for (Funcionario fun : listaFun) {
            if (fun.getNroFuncional() == nroFun) {

                
                listaFunCirurgia.add(fun);
                
                achou = true;
                break;

            }
        }
        if (!achou) {
            JOptionPane.showMessageDialog(null, "Funcionário não cadastrado");
        }
        textField.setText("");
    }
}
