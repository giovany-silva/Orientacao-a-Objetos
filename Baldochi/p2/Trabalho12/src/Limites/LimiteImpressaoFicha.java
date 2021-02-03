package Limites;

import Controladores.ControlePaciente;
import Entidades.Convenio;
import Entidades.Paciente;
import Entidades.Particular;
import Entidades.Sessao;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LimiteImpressaoFicha extends JFrame implements ActionListener{
    
    private ControlePaciente objControlador;
    private Paciente aux = null;
    private JPanel painel, p1;
    private JLabel identificadorJL;
    private JTextField identificadorTF;
    private JButton buscar;
    private JTextArea resultado;

    public LimiteImpressaoFicha(ControlePaciente pControle) {
        objControlador = pControle;

        //Criar os objetos do tipo JLabel
        identificadorJL = new JLabel("Número do cartão ou número de CPF:");

        //Criar os objetos do tipo TextField
        identificadorTF = new JTextField(15);

        //Criar os objetos do tipo JButton e adicionar listener a eles
        buscar = new JButton("Buscar Paciente");
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
        
        super.setTitle("Listar Ficha");
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
                aux = objControlador.buscaPaciente(pIden);

                if (aux != null) {
                    identificadorTF.setEditable(false);
                    resultado.setEditable(false);
                    String str = retornaSessoes(aux);
                    resultado.setText(str);
                    resultado.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum paciente encontrado!");
                }
            }
        }
    }
    
    public String retornaSessoes(Object auxilia){
        String str = "";
        if(auxilia instanceof Convenio){
            str+=((Convenio) auxilia).getDescricao();
            str+="\nConvenio: "+((Convenio) auxilia).getNomeConvenio()+" Cartao: "+((Convenio) auxilia).getNroCartao();
            str+="\nSESSÕES:\nData\tTipo\n";
            for(Sessao s: ((Convenio) auxilia).getSessoes()){
                str+=s.getDia()+"/"+s.getMes()+"\t"+s.getTipo()+"\n";
            }
        }else if(auxilia instanceof Particular){
            str+=((Particular) auxilia).getDescricao();
            str+="\nCpf: "+((Particular) auxilia).getCpf();
            str+="\nSESSÕES:\n";
            for(Sessao s: ((Particular) auxilia).getSessoes()){
                str+=s.getDia()+"/"+s.getMes()+"\t"+s.getTipo()+"\n";
            }
        }else{
            JOptionPane.showMessageDialog(null, "Objeto incorreto para retorno da sessões.", "ERRO", 1);
        }
        str+="\n\n\n\n";
        return str;
    }
}
