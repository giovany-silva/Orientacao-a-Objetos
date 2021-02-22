package Limites;

import Controladores.ControlePaciente;
import Entidades.Paciente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LimiteAdicaoSessao extends JFrame implements ActionListener {

    // objControlador para esta classe "se comunicar" com a controle principal
    private ControlePaciente objControlador;
    
    // obj aux do tipo Paciente
    private Paciente aux = null;
    
    // declaracao de paineis, labels, textfields e botoes
    private JPanel painel, p1, p2, p3, p4, p5, centro;
    private JLabel identificadorJL, diaJL, mesJL, tipoJL;
    private JTextField identificadorTF, diaTF, mesTF, tipoTF;
    private JButton cadastrar, buscar;

    // construtor da LimtieAdicaoSessao, passa um obj do tipo controle paciente como parametro
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
        // o painel "painel" eh o principal nessa interface add sessao
        painel = new JPanel(new BorderLayout(0, 10));
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        // painel "centro" eh oq os campos para serem informados na interface add sessao
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
    }//------- CONSTRUTOR TERMINA AQUI -------------

    // ActionListener para os botoes "Buscar Paciente" e "Adicionar Sessao"
    // ActionListener fora do construtor
    @Override
    public void actionPerformed(ActionEvent e) {
        // criacao de um botao auxiliar para ver se o botao eh o buscar ou cadastrar
        JButton auxiliar = (JButton) e.getSource();
        
        // criacao de variaveis para receber os dados digitados
        String dia, mes, tipo, pIden = "";
        int pDia, pMes;

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
                // obj aux do tipo paciente chama a funcao buscaPaciente do controle 
                // e passa oq foi digitado como parametro
                aux = objControlador.buscaPaciente(pIden);

                // se aux diferente de null significa que existe o paciente
                if (aux != null) {
                    // habilita o painel para informar os dados da sessao
                    centro.setVisible(true);
                    identificadorTF.setEditable(false);
                } 
                // caso nao exista o paciente retornar uma msg
                else {
                    JOptionPane.showMessageDialog(this, "Nenhum paciente encontrado!");
                }
            }
        } 
        // caso o botao auxiliar seja igual ao cadastrar
        else {
            // pega as informacoes digitadas e coloca nas variaveis
            dia = diaTF.getText();
            mes = mesTF.getText();
            pDia = Integer.parseInt(dia);
            pMes = Integer.parseInt(mes);
            tipo = tipoTF.getText();
            
            try {
                // chama a funcao cadastraSessao e passa os parametros na mesma ordem da funcao do controle
                objControlador.cadastraSessao(aux, pDia, pMes, tipo);
                JOptionPane.showMessageDialog(this, "Sessão cadastrada!");
                super.dispose();
            } 
            // caso a excecao seja disparada, significa que o tipo de sessao esta errado
            // retornar msg
            catch (Exception exc) {
                JOptionPane.showMessageDialog(this,"Tipo de sessão inválido!");
            }
        }
    }
}
