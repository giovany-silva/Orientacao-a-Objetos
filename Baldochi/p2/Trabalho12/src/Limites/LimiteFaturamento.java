package Limites;

import Controladores.ControlePaciente;
import Entidades.Convenio;
import Entidades.Paciente;
import Entidades.Particular;
import Entidades.Sessao;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LimiteFaturamento extends JFrame implements ActionListener{

    private ControlePaciente objControlador;
    private JPanel painel, p1;
    private JLabel identificadorJL;
    private JTextField identificadorTF;
    private JButton buscar;
    private JTextArea resultado;

    public LimiteFaturamento(ControlePaciente pControle) {
        objControlador = pControle;

        //Criar os objetos do tipo JLabel
        identificadorJL = new JLabel("Mês:");

        //Criar os objetos do tipo TextField
        identificadorTF = new JTextField(15);

        //Criar os objetos do tipo JButton e adicionar listener a eles
        buscar = new JButton("Calcular");
        buscar.addActionListener(this);

        //Criar os paineis
        painel = new JPanel(new BorderLayout(0, 10));
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        resultado = new JTextArea();
        
        //Adicionar componentes aos painéis
        p1.add(identificadorJL);
        p1.add(identificadorTF);
        p1.add(buscar);
        p1.add(resultado);
        painel.add(p1, BorderLayout.NORTH);
        
        resultado.setVisible(false);
        resultado.setSize(150, 150);
        
        super.setTitle("Calcular Faturamento");
        super.add(painel);
        super.setSize(600, 400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
   

    public void actionPerformed(ActionEvent e) {
        JButton auxiliar = (JButton) e.getSource();
        String pIden = "";

        if (auxiliar.equals(buscar)) {
            pIden = identificadorTF.getText();

            if (pIden.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Você não informou nenhum dado!");
            } else {
                double t1=0, t2=0, fim=0;
                for(Paciente p: objControlador.getObjPacientes()){
                    if(p instanceof Particular)
                        t1+=retornaFatura((Particular) p);
                    else if(p instanceof Convenio)
                        t2+=retornaFatura((Convenio) p);
                }
                fim=t1+t2;
                String str = "Particular: R$ " + t1 + "\n";
                str+= "Convenio: R$ " + t2 + "\n";
                str+= "Total: R$ " + fim + "\n\n\n";
                resultado.setText(str);
                resultado.setEditable(false);
                resultado.setVisible(true);
            }
        }
    }
    
    public double retornaFatura(Paciente auxilia){
        double result = 0;
        String mees = identificadorTF.getText();
        //System.out.println(mees);
        int mes = Integer.parseInt(mees);
        result+=auxilia.calculaFaturamento(mes);
        return result;
    }

}
