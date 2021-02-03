package Limites;

import Controladores.ControlePaciente;
import java.awt.event.*;
import javax.swing.*;

public class LimitePaciente extends JFrame{

    private ControlePaciente objControlador;
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem adicionarSessao, cadastrarPacConv, cadastrarPacPart, exibirFicha, exibirOrcamento;

    public LimitePaciente(ControlePaciente pControle) {
        objControlador = pControle;

        //Criar objetos do tipo JMenuItem
        cadastrarPacConv = new JMenuItem("Cadastrar paciente com convênio");
        cadastrarPacConv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceCadastroConvenio();
            }
        });
        cadastrarPacPart = new JMenuItem("Cadastrar paciente particular");
        cadastrarPacPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceCadastroParticular();
            }
        });
        exibirFicha = new JMenuItem("Exibir ficha de paciente");
        exibirFicha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceExibicaoFicha();
            }
        });
        adicionarSessao = new JMenuItem("Cadastrar sessão");
        adicionarSessao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceAddSessao();
            }
        });
        exibirOrcamento = new JMenuItem("Visualizar faturamento");
        exibirOrcamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceExibicaoFaturamento();
            }
        });

        //Criar JMenu
        menu = new JMenu("Menu de gerencimento");

        //Criar JMenuBar
        barraMenu = new JMenuBar();

        //Adicionar componentes ao JMenu
        menu.add(cadastrarPacConv);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(cadastrarPacPart);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(adicionarSessao);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(exibirFicha);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(exibirOrcamento);

        //Adicionar menu a barra de menu
        barraMenu.add(menu);

        super.setTitle("Bem Vindo!");
        super.setJMenuBar(barraMenu);
        super.setSize(600, 400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
}
