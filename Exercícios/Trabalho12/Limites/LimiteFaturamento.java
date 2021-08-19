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
    // objControlador para esta classe "se comunicar" com a Controle Principal
    private ControlePaciente objControlador;
    
    // declaracao dos paineis, labels, textFields e botoes
    private JPanel painel, p1;
    private JLabel identificadorJL;
    private JTextField identificadorTF;
    private JButton buscar;
    private JTextArea resultado;

    // construtor do LimiteFaturamento passa um obj do tipo ControlePaciente como parametro
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
         // painel "painel" eh o principal desta interface faturamento
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
        
        super.setTitle("Faturamento");
        super.add(painel);
        super.setSize(600, 400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }// --------------------  CONSTRUTOR TERMINA AQUI -----------------
   

    // ActionListener para o botao "Calcular"
    public void actionPerformed(ActionEvent e) {
        // criacao de um botao auxiliar
        JButton auxiliar = (JButton) e.getSource();
        
         // variaveis para receber os dados digitados
        String pIden = "";

        // if para ver se o botao auxiliar eh igual ao buscar
        if (auxiliar.equals(buscar)) {
             // caso o botao seja o buscar, passar oq foi digitado para a variavel
            pIden = identificadorTF.getText();

            // caso nao seja digitado nada, retornar uma msg
            if (pIden.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Você não informou nenhum dado!");
            } 
            // se foi digitado alguma coisa
            else {
                // variaveis para armazenar os valores dos faturamentos
                double T1=0, T2=0, fim=0;
                
                // for para varrer o ArrayList com os pacientes
                for(Paciente p: objControlador.getObjPacientes()){
                    // se o paciente p for Particular
                    if(p instanceof Particular)
                        // T1 recebe o faturamento de todos os particulares no mes informado
                        T1+=retornaFaturamento((Particular) p);
                    // se o paciente for Convenio
                    else if(p instanceof Convenio)
                        // T2 recebe o faturamento de todos os convenios no mes informado
                        T2+=retornaFaturamento((Convenio) p);
                }
                // faturamento total
                fim=T1+T2;
                
                // string para printar os faturamentos
                String str = "Particular: R$ " + T1 + "\n";
                str+= "Convenio: R$ " + T2 + "\n";
                str+= "Total: R$ " + fim + "\n\n";
                
                // joga a string com os faturamentos no textArea
                resultado.setText(str);
                resultado.setEditable(false);
                resultado.setVisible(true);
            }
        }
    }
    // funcao para retornar o faturamento precisa de um paciente como parametro
    public double retornaFaturamento(Paciente auxilia){
        // variavel para armazenar o faturamento do mes
        double result = 0;
        
        // variavel recebe o mes digitado
        String mees = identificadorTF.getText();
        int mes = Integer.parseInt(mees);
        // chama a funcao calculaFaturamento de acordo com o tipo de paciente passado
        // e passa o mes como parametro
        result+=auxilia.calculaFaturamento(mes);
        return result;
    }

}