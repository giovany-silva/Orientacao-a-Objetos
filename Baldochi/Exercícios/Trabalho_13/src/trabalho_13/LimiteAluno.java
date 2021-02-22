package trabalho_13;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

// Limite responsavel por prover a interface grafica com o usuario
public class LimiteAluno extends JFrame {

    // craicao de um objeto do tipo CtrAluno para as classes "se comunicarem"
    private CrtAluno objCtrPrincipal;
    
    // criacao dos cards
    public JPanel cards;

    // construtor do LimiteAluno que recebe o objeto da funcao main
    public LimiteAluno(CrtAluno objCtrPrin) {
        // Criação da JFrame
        super("Alunos");
        this.setSize(900, 400);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        // passa o objeto da funcao main para o objeto dessa classe
        objCtrPrincipal = objCtrPrin;

        // Listener para fechar e serializar os dados --------------------------
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    // quando o programa eh fechado, eh chamada a funcao finalize,
                    // que grava os alunos em um arquivo
                    objCtrPrincipal.finalize();
                    System.exit(0);
                } 
                // caso a excecao seja disparada, executar oq esta dentro do catch
                catch (Exception y) {
                    System.exit(0);
                }

            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        //----------------------------------------------------------------------

        // criacao da bara de menu 
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);

        // criacao do menu "Aluno"
        JMenu AlunoMenu = new JMenu("Aluno");
        menu.add(AlunoMenu);

        //----------------------------------------------------------------------
        // criacao do item "cadastrar" do menu Aluno e add no menu
        JMenuItem cadAluno = new JMenuItem("Cadastrar");
        AlunoMenu.add(cadAluno);

        // criacao do item "listar" do menu Aluno e add no menu
        JMenuItem ListaAluno = new JMenuItem("Listar Alunos");
        AlunoMenu.add(ListaAluno);

        // Cards de ações ------------------------------------------------------
        // criacao do card inicial 
        cards = new JPanel(new CardLayout());
        this.add(cards, BorderLayout.CENTER);
        
        // criacao do painel inicial e add ele no card
        JPanel inicial = new JPanel(new BorderLayout());
        cards.add(inicial, "Tela Principal");

        // criacao de um painel aux e add ele no card
        JPanel auxiliar = new JPanel();
        auxiliar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cards.add(auxiliar, "Auxiliar");

        // Cards para adicionar ------------------------------------------------ 
        // Painel do cadastrar aluno 
        // P1 corresponde ao painel do cadastrar aluno
        JPanel p1 = new JPanel(new FlowLayout());

        // criacao dos labels 
        JLabel textnome = new JLabel("Digite o nome:");
        JLabel textmatricula = new JLabel("Digite a matricula:");
        JLabel textdia = new JLabel("Digite Dia de nascimento:");
        JLabel textmes = new JLabel("Digite Mês de nascimento:");
        JLabel textano = new JLabel("Digite Ano de nascimento:");

        // criacao dos textfields
        JTextField Nome = new JTextField(30);
        JTextField Matricula = new JTextField(20);
        JTextField dia = new JTextField(6);
        JTextField mes = new JTextField(6);
        JTextField ano = new JTextField(6);

        // criacao do botao cadastrar
        JButton Cadastrar = new JButton("Cadastrar");
        // add os componentes no P1
        p1.add(textnome);
        p1.add(Nome);
        p1.add(textmatricula);
        p1.add(Matricula);
        p1.add(textdia);
        p1.add(dia);
        p1.add(textmes);
        p1.add(mes);
        p1.add(textano);
        p1.add(ano);
        p1.add(Cadastrar);
        
        // add o P1 no card
        cards.add(p1, "Cadastrar Aluno");

        // ActionListener do botao "Cadastrar"
        Cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // if para verificar se a data de nascimento esta entre 1950 e 2005
                    if (Integer.parseInt(ano.getText()) > 1950 && Integer.parseInt(ano.getText()) < 2005) {
                        // se a data estiver no intervalo pedido, chama a funcao "CriaAluno"
                        // e passa os dados digitados nos textfields como parametro
                        objCtrPrincipal.CriaAluno(Nome.getText(), Matricula.getText(), Integer.parseInt(dia.getText()), Integer.parseInt(mes.getText()), Integer.parseInt(ano.getText()));
                        JOptionPane.showMessageDialog(null, "Cadastro correto!");
                    } 
                    // caso a data de nascimento nao esteja no periodo certo
                    // eh retornado uma msg e "zerado" os textfields, exceto o do nome
                    else {
                        JOptionPane.showMessageDialog(null, "A idade tem que ser entre 1950 e 2005, digite novamente!");
                        Matricula.setText("");
                        dia.setText("");
                        mes.setText("");
                        ano.setText("");
                    }

                } 
                // caso seja disparada alguma excecao, retornarah uma msg e serah "zerado" os textfields, exceto o do nome
                catch (Exception t) {
                    JOptionPane.showMessageDialog(null, "Erro! Tente novamente !");

                    Matricula.setText("");
                    dia.setText("");
                    mes.setText("");
                    ano.setText("");

                }
            }
        });

        //Painel da Busca
        // criacao do painel para listar alunos
        JPanel p2 = new JPanel(new FlowLayout());

        // criacao de um textArea e add ele no P2
        JTextArea area = new JTextArea();
        p2.add(area);

        // add o P2 no card
        cards.add(p2, "Listar Alunos");

        // Ações dos submenus -----------------------------------------------------
        // ActioneListener usado quando a opcao "Cadastrar" for selecionada
        cadAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // chama o card "Cadastrar Aluno"
                CardLayout cardAluno = (CardLayout) (cards.getLayout());
                cardAluno.show(cards, "Cadastrar Aluno");
            }
        });

        // ActionListener usado quando a opcao "Listar" for selecionada
        ListaAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // chama a funcao Listagem e coloca no textArea
                area.setText(objCtrPrincipal.Listagem());
                // chama o card "Listar Alunos"
                CardLayout ListaAluno = (CardLayout) (cards.getLayout());
                ListaAluno.show(cards, "Listar Alunos");
            }
        });

    }
}
