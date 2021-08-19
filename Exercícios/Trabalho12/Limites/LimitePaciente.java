package Limites;

import Controladores.ControlePaciente;
import java.awt.event.*;
import javax.swing.*;

public class LimitePaciente extends JFrame{
    // objControlador para esta classe "se comunicar" com a Controle Principal
    private ControlePaciente objControlador;
    
    // declaracao da barra de menus, do menu e dos menuItens
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem adicionarSessao, cadastrarPacConv, cadastrarPacPart, exibirFicha, exibirOrcamento;
    
    // construtor da classe LimitePaciente passa um obj do tipo Controle Paciente como parametro
    public LimitePaciente(ControlePaciente pControle) {
        objControlador = pControle;

        //Criar objetos do tipo JMenuItem
        cadastrarPacConv = new JMenuItem("Cadastrar paciente com convênio");
        
        // add ActionListener para o item
        cadastrarPacConv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ao clicar no item do menu "Cadastrar paciente com convênio"
                // chama a funcao interfaceCadastroConvenio do Controle
                objControlador.interfaceCadastroConvenio();
            }
        });
        cadastrarPacPart = new JMenuItem("Cadastrar paciente particular");
        cadastrarPacPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ao clicar no item do menu "Cadastrar paciente particular"
                // chama a funcao interfaceCadastroParticular do Controle
                objControlador.interfaceCadastroParticular();
            }
        });
        exibirFicha = new JMenuItem("Exibir ficha de paciente");
        exibirFicha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ao clicar no item do menu "Exibir ficha do paciente"
                // chama a funcao interfaceExibicaoFicha do Controle
                objControlador.interfaceExibicaoFicha();
            }
        });
        adicionarSessao = new JMenuItem("Cadastrar sessão");
        adicionarSessao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ao clicar no item do menu "Cadastrar sessao"
                // chama a funcao interfaceAddSessao do Controle
                objControlador.interfaceAddSessao();
            }
        });
        exibirOrcamento = new JMenuItem("Visualizar faturamento");
        exibirOrcamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ao clicar no item do menu "Visualizar faturamento"
                // chama a funcao interfaceExibicaoFaturamento do Controle
                objControlador.interfaceExibicaoFaturamento();
            }
        });

        //Criar JMenu
        menu = new JMenu("Menu de gerencimento");

        //Criar JMenuBar
        barraMenu = new JMenuBar();

        //Adicionar os menuItens no JMenu
        menu.add(cadastrarPacConv);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(cadastrarPacPart);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(adicionarSessao);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(exibirFicha);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(exibirOrcamento);

        //Adicionar menu na barra de menu
        barraMenu.add(menu);

        super.setTitle("Bem Vindo!");
        // barra de menu eh adicionada no super
        super.setJMenuBar(barraMenu);
        super.setSize(600, 400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
}
