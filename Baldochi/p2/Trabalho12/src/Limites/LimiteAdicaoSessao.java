package Limites;

import Controladores.ControlePaciente;
import Entidades.Paciente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LimiteAdicaoSessao extends JFrame implements ActionListener {

    private ControlePaciente objControlador;
    private Paciente aux = null;
    private JPanel painel, p1, p2, p3, p4, p5, centro;
    private JLabel identificadorJL, diaJL, mesJL, tipoJL;
    private JTextField identificadorTF, diaTF, mesTF, tipoTF;
    private JButton cadastrar, buscar;

    public LimiteAdicaoSessao(ControlePaciente pControle) {
        objControlador = pControle;

        //Criar os objetos do tipo JLabel
        identificadorJL = new JLabel("Número do cartão ou número de CPF:");
        diaJL = new JLabel("Dia :");
        mesJL = new JLabel("Mês :");
        tipoJL = new JLabel("Tipo:");

        //Criar os objetos do tipo TextField
        identificadorTF = new JTextField(15);
        diaTF = new JTextField(15);
        mesTF = new JTextField(15);
        tipoTF = new JTextField(15);

        //Criar os objetos do tipo JButton e adicionar listener a eles
        cadastrar = new JButton("Adicionar sessão");
        cadastrar.addActionListener(this);
        buscar = new JButton("Buscar Paciente");
        buscar.addActionListener(this);

        //Criar os paineis
        painel = new JPanel(new BorderLayout(0, 10));
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setVisible(false);

        //Adicionar componentes aos painéis
        p1.add(identificadorJL);
        p1.add(identificadorTF);
        p1.add(buscar);
        p2.add(diaJL);
        p2.add(diaTF);
        p3.add(mesJL);
        p3.add(mesTF);
        p4.add(tipoJL);
        p4.add(tipoTF);
        p5.add(cadastrar);
        centro.add(Box.createVerticalGlue());
        centro.add(p2);
        centro.add(p3);
        centro.add(p4);
        centro.add(p5);
        centro.add(Box.createVerticalGlue());
        painel.add(p1, BorderLayout.NORTH);
        painel.add(centro, BorderLayout.CENTER);

        super.setTitle("Adicionar sessão de fisioterapia");
        super.add(painel);
        super.setSize(600, 400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton auxiliar = (JButton) e.getSource();
        String dia, mes, tipo, pIden = "";
        int pDia, pMes;

        if (auxiliar.equals(buscar)) {
            pIden = identificadorTF.getText();

            if (pIden.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Você não informou nenhum dado!");
            } else {
                aux = objControlador.buscaPaciente(pIden);

                if (aux != null) {
                    centro.setVisible(true);
                    identificadorTF.setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum paciente encontrado!");
                }
            }
        } else {
            dia = diaTF.getText();
            mes = mesTF.getText();
            pDia = Integer.parseInt(dia);
            pMes = Integer.parseInt(mes);
            tipo = tipoTF.getText();
            
            try {
                objControlador.cadastraSessao(aux, pDia, pMes, tipo);
                JOptionPane.showMessageDialog(this, "Sessão cadastrada!");
                super.dispose();
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(this,"Tipo de sessão inválido!");
            }
        }
    }
}
