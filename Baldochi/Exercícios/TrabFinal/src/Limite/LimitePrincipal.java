package Limite;

import Controle.ControleComprador;
import Controle.ControleCorretor;
import Controle.ControleImovel;
import Controle.ControlePrincipal;
import Controle.ControleVendedor;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 *
 * @author fernando
 */
public class LimitePrincipal extends JFrame implements WindowListener {

    //private ControlePrincipal objControladorPrincipal;
    JTextArea menuVisitasJT, listaImovelJT, FatPeriodoJT, FatPeriodoCorretorJT, RelatorioJT, EventosJT;
    JLabel menuVisitasJL, codigoJL, CPFlistaImovelJL, nomeFatPeriodoCorretorJL, creciFatPeriodoCorretorJL, dataIniRelatorioJL, dataFimRelatorioJL;
    JMenu menuImoveis, menuCorretores, menuVendedores, menuCompradores, menuFaturamento, menuRelatorio;
    JMenuItem menuRegistrarImoveis, menuEventos, menuRegistrarCorretores,
            menuVisitas, menuRegistrarVendedores, menuListarImoveis, menuRegistrarComprador, menuFaturamentoporPeriodo,
            menuFaturamentoCorretor, menuRelatorioVendas;
    ControlePrincipal objControladorPrincipal;
    ControleVendedor controleVendedor;
    ControleCorretor controleCorretor;
    ControleComprador controleComprador;
    ControleImovel controleImovel;

    LimiteFaturamento limiteFaturamento;
    JPanel painelEventos, painelDataInicial, painelDataFinal, painelCodigo, painellistaImoveis, painelCPFlistaImovel, painelFatPeriodo,
            painelDataInicialFatPeriodo, painelDataFinalFatPeriodo, painelFatPeriodoCorretor, painelnomeFatPeriodoCorretor, painelcreciFatPeriodoCorretor,
            painellistaFatPeriodoCorretorInformacoes, painelDataInicialFatPeriodoCorretor, painelDataFinalFatPeriodoCorretor, painelDataInicialVisitas, painelDataFinalVisitas,
            painelRelatorio, painelDataIniRelatorio, painelDataFimRelatorio;
    JTextField codigoTF, CPFlistaImovelTF, nomeFatPeriodoCorretorTF, creciFatPeriodoCorretorTF, nomeVisitasJF;
    JButton selecionardataEventos, consultarEventos, selecionarVisitas, consultarVisitas, listarImoveis, selecionardataFatPeriodo, consultarFatPeriodo, selecionardataFatPeriodoCorretor,
            consultarFatPeriodoCorretor, selecionarDataRelatorio, consultarRelatorio;
    Calendar dataIni, dataFim, dataFatPeriodoIni, dataIniVisitas, dataFimVisitas, dataFatPeriodoFim, dataEventoIni, dataEventoFim, dataIniFatPeriodo, dataFatPeriodoIniCorretor, dataFatPeriodoFimCorretor,
            dataIniRelatorio, dataFimRelatorio;

    //
    Calendario CalendarioIni, CalendarioFatPeriodoIni, CalendarioFatPeriodoIniCorretor, CalendarioIniVisitas, CalendarioIniRelatorio;
    Calendario CalendarioFim, CalendarioFatPeriodoFim, CalendarioFatPeriodoFimCorretor, CalendarioFimVisitas, CalendarioFimRelatorio;

    public LimitePrincipal(ControlePrincipal objControladorPrincipal) {

        super("Imobiliária ItaHouse");
        super.addWindowListener(this);
        this.objControladorPrincipal = objControladorPrincipal;
        controleVendedor = objControladorPrincipal.getInstanciaControleVendedor();
        controleCorretor = objControladorPrincipal.getInstanciaControleCorretor();
        controleComprador = objControladorPrincipal.getInstanciaControleComprador();
        controleImovel = objControladorPrincipal.getInstanciaControleImovel();

        limiteFaturamento = new LimiteFaturamento(objControladorPrincipal);
        JPanel cards = new JPanel(new CardLayout());
        this.getContentPane().add(cards, BorderLayout.CENTER);

        JPanel inicial = new JPanel(new BorderLayout());
        cards.add(inicial, "inicial");

        //ControleVendedor controleVendedor = new ControleVendedor();
        //painel para Registrar Vendedor
        JPanel painelVendedor = controleVendedor.getPainelVendedor();
        painelVendedor.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(painelVendedor, "RegistrarVendedor");
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        //painel para Registrar Corretor
        JPanel painelCorretor = controleCorretor.getPainelCorretor();
        painelCorretor.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(painelCorretor, "RegistrarCorretor");

        //painel para Registrar Comprador
        JPanel painelComprador = controleComprador.getPainelComprador();
        painelComprador.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(painelComprador, "RegistrarComprador");

        //painel para Registrar Imovel
        JPanel painelImovel = controleImovel.getPainelImovel();
        painelImovel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(painelImovel, "RegistrarImovel");

        //Painel para  Visitas 
        JPanel painelVisitasCorretor = new JPanel();

        menuVisitasJL = new JLabel("Visitas");
        nomeVisitasJF = new JTextField(30);
        menuVisitasJT = new JTextArea();

        //
        dataIniVisitas = Calendar.getInstance();
        dataFimVisitas = Calendar.getInstance();

        //
        //
        CalendarioIniVisitas = new Calendario();
        CalendarioFimVisitas = new Calendario();

        //
        painelDataInicialVisitas = new JPanel();
        painelDataFinalVisitas = new JPanel();
        painelDataInicialVisitas.add(new JLabel("Data Inicial"));
        painelDataInicialVisitas.add(CalendarioIniVisitas);
        painelDataFinalVisitas.add(new JLabel("Data Final"));
        painelDataFinalVisitas.add(CalendarioFimVisitas);

        //MODIFICAR O TAMANHO
        menuVisitasJT.setSize(1280, 720);
        selecionarVisitas = new JButton("Selecionar");
        consultarVisitas = new JButton("Consultar");

        painelVisitasCorretor.add(painelDataInicialVisitas);
        painelVisitasCorretor.add(painelDataFinalVisitas);
        painelVisitasCorretor.add(selecionarVisitas);
        painelVisitasCorretor.add(consultarVisitas);
        painelVisitasCorretor.add(nomeVisitasJF);
        painelVisitasCorretor.add(menuVisitasJL);
        painelVisitasCorretor.add(menuVisitasJT);

        painelVisitasCorretor.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(painelVisitasCorretor, "VisitasCorretor");

        // Barra de Menu
        //Menu para opção imóveis
        menuImoveis = new JMenu("Imóveis");
        menuRegistrarImoveis = new JMenuItem("Registrar");
        menuEventos = new JMenuItem("Eventos");
        menuImoveis.add(menuRegistrarImoveis);
        menuImoveis.add(menuEventos);
        menu.add(menuImoveis);

        //Menu para opção  Corretores
        menuCorretores = new JMenu("Corretores");
        menuRegistrarCorretores = new JMenuItem("Registrar");
        menuVisitas = new JMenuItem("Visitas");
        menuCorretores.add(menuRegistrarCorretores);
        menuCorretores.add(menuVisitas);
        menu.add(menuCorretores);

        //Menu para opção Vendedores
        menuVendedores = new JMenu("Vendedores");
        menuRegistrarVendedores = new JMenuItem("Registrar");
        menuListarImoveis = new JMenuItem("Listar Imóveis");
        menuVendedores.add(menuRegistrarVendedores);
        menuVendedores.add(menuListarImoveis);
        menu.add(menuVendedores);
        //Menu para opção Compradores
        menuCompradores = new JMenu("Compradores");
        menuRegistrarComprador = new JMenuItem("Registrar");
        menuCompradores.add(menuRegistrarComprador);
        menu.add(menuCompradores);

        //Menu para opção Faturamento
        menuFaturamento = new JMenu("Faturamento");
        menuFaturamentoporPeriodo = new JMenuItem("Faturamento por período");
        menuFaturamentoCorretor = new JMenuItem("Faturamento de corretor por período");
        menuFaturamento.add(menuFaturamentoporPeriodo);
        menuFaturamento.add(menuFaturamentoCorretor);
        menu.add(menuFaturamento);
        //Menu para opção Relatório      
        menuRelatorio = new JMenu("Relatório");
        menuRelatorioVendas = new JMenuItem("Vendas por período");
        menuRelatorio.add(menuRelatorioVendas);
        menu.add(menuRelatorio);

        // itens para painel Eventos
        painelEventos = new JPanel();
        EventosJT = new JTextArea();
        selecionardataEventos = new JButton("Selecionar");
        consultarEventos = new JButton("Consultar");
        codigoJL = new JLabel("Código");
        JLabel dataInicialJL = new JLabel("Data inicial");
        JLabel dataFinalJL = new JLabel("Data final");

        //
        codigoTF = new JTextField(10);
        painelCodigo = new JPanel();
        painelCodigo.add(codigoJL);
        painelCodigo.add(codigoTF);

        //
        dataEventoIni = Calendar.getInstance();
        dataEventoFim = Calendar.getInstance();

        //
        //
        CalendarioIni = new Calendario();
        CalendarioFim = new Calendario();

        //
        painelDataInicial = new JPanel();
        painelDataFinal = new JPanel();
        painelDataInicial.add(dataInicialJL);
        painelDataInicial.add(CalendarioIni);
        painelDataFinal.add(dataFinalJL);
        painelDataFinal.add(CalendarioFim);

        //
        painelEventos.add(painelCodigo);
        painelEventos.add(painelDataInicial);
        painelEventos.add(painelDataFinal);
        painelEventos.add(selecionardataEventos);
        painelEventos.add(consultarEventos);
        painelEventos.add(EventosJT);

        // painel para Eventos
        painelEventos.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(painelEventos, "Eventos");

        //itens painel listar imóveis
        painellistaImoveis = new JPanel();

        listarImoveis = new JButton("Listar Imóveis");
        CPFlistaImovelJL = new JLabel("CPF");

        //
        CPFlistaImovelTF = new JTextField(15);
        painelCPFlistaImovel = new JPanel();
        listaImovelJT = new JTextArea();
        painelCPFlistaImovel.add(CPFlistaImovelJL);
        painelCPFlistaImovel.add(CPFlistaImovelTF);
        painellistaImoveis.add(painelCPFlistaImovel);
        painellistaImoveis.add(listarImoveis);
        JPanel painellistaImoveisInformacoes = new JPanel();
        painellistaImoveisInformacoes.add(new JLabel("Informações:"));
        painellistaImoveisInformacoes.add(listaImovelJT);
        painellistaImoveis.add(painellistaImoveisInformacoes);

        //painel lista imóveis
        painellistaImoveis.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(painellistaImoveis, "ListaImovel");

        this.setSize(1280, 720);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //itens para painel faturamento por período
        painelFatPeriodo = new JPanel();
        FatPeriodoJT = new JTextArea();

        selecionardataFatPeriodo = new JButton("Selecionar");
        consultarFatPeriodo = new JButton("Consultar");

        JLabel dataInicialFatPeriodoJL = new JLabel("Data inicial");
        JLabel dataFinalFatPeriodoJL = new JLabel("Data final");

        //
        //
        dataFatPeriodoIni = Calendar.getInstance();
        dataFatPeriodoFim = Calendar.getInstance();

        //
        //
        CalendarioFatPeriodoIni = new Calendario();
        CalendarioFatPeriodoFim = new Calendario();

        //
        painelDataInicialFatPeriodo = new JPanel();
        painelDataFinalFatPeriodo = new JPanel();
        painelDataInicialFatPeriodo.add(dataInicialFatPeriodoJL);
        painelDataInicialFatPeriodo.add(CalendarioFatPeriodoIni);
        painelDataFinalFatPeriodo.add(dataFinalFatPeriodoJL);
        painelDataFinalFatPeriodo.add(CalendarioFatPeriodoFim);

        //
        painelFatPeriodo.add(painelDataInicialFatPeriodo);
        painelFatPeriodo.add(painelDataFinalFatPeriodo);
        painelFatPeriodo.add(selecionardataFatPeriodo);
        painelFatPeriodo.add(consultarFatPeriodo);
        painelFatPeriodo.add(FatPeriodoJT);

        //painel faturamento por período
        painelFatPeriodo.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(painelFatPeriodo, "FatPeriodo");

        //itens para painel faturamento do corretor  por período
        painelFatPeriodoCorretor = new JPanel();
        selecionardataFatPeriodoCorretor = new JButton("Selecionar");
        consultarFatPeriodoCorretor = new JButton("Consultar");
        nomeFatPeriodoCorretorJL = new JLabel("Nome");

        creciFatPeriodoCorretorJL = new JLabel("Creci");

        //
        nomeFatPeriodoCorretorTF = new JTextField(30);
        creciFatPeriodoCorretorTF = new JTextField(10);

        painelnomeFatPeriodoCorretor = new JPanel();
        painelcreciFatPeriodoCorretor = new JPanel();
        //listaImovelJT = new JTextArea();
        painelnomeFatPeriodoCorretor.add(nomeFatPeriodoCorretorJL);
        painelnomeFatPeriodoCorretor.add(nomeFatPeriodoCorretorTF);

        painelcreciFatPeriodoCorretor.add(creciFatPeriodoCorretorJL);
        painelcreciFatPeriodoCorretor.add(creciFatPeriodoCorretorTF);
        painellistaFatPeriodoCorretorInformacoes = new JPanel();
        painellistaFatPeriodoCorretorInformacoes.add(new JLabel("Informações:"));
        FatPeriodoCorretorJT = new JTextArea();
        painellistaFatPeriodoCorretorInformacoes.add(FatPeriodoCorretorJT);

        dataFatPeriodoIniCorretor = Calendar.getInstance();
        dataFatPeriodoFimCorretor = Calendar.getInstance();

        //
        //
        CalendarioFatPeriodoIniCorretor = new Calendario();
        CalendarioFatPeriodoFimCorretor = new Calendario();

        //
        painelDataInicialFatPeriodoCorretor = new JPanel();
        painelDataFinalFatPeriodoCorretor = new JPanel();

        painelDataInicialFatPeriodoCorretor.add(new JLabel("Data Inicial"));
        painelDataInicialFatPeriodoCorretor.add(CalendarioFatPeriodoIniCorretor);

        painelDataFinalFatPeriodoCorretor.add(new JLabel("Data Final"));
        painelDataFinalFatPeriodoCorretor.add(CalendarioFatPeriodoFimCorretor);

        painelFatPeriodoCorretor.add(painelnomeFatPeriodoCorretor);
        painelFatPeriodoCorretor.add(painelcreciFatPeriodoCorretor);
        painelFatPeriodoCorretor.add(painelDataFinalFatPeriodoCorretor);
        painelFatPeriodoCorretor.add(selecionardataFatPeriodoCorretor);
        painelFatPeriodoCorretor.add(consultarFatPeriodoCorretor);
        painelFatPeriodoCorretor.add(painellistaFatPeriodoCorretorInformacoes);

        // painel faturamento do corretor  por período
        painelFatPeriodoCorretor.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(painelFatPeriodoCorretor, "FatPeriodoCorretor");

        // painel para o relatorio de vendas
        // item 5
        painelRelatorio = new JPanel();
        painelDataIniRelatorio = new JPanel();
        painelDataFimRelatorio = new JPanel();

        // criacao do JButton para selecionar as datas do item 5
        selecionarDataRelatorio = new JButton("Selecionar");

        // JLabel para item 5
        dataIniRelatorioJL = new JLabel("Data inicial");
        dataFimRelatorioJL = new JLabel("Data final");

        // calendario para item 5
        CalendarioIniRelatorio = new Calendario();
        CalendarioFimRelatorio = new Calendario();

        // JTextArea para item 5
        RelatorioJT = new JTextArea();
        consultarRelatorio = new JButton("Consultar");
        // add os componentes no painel data inicial e no painel data final
        painelDataIniRelatorio.add(dataIniRelatorioJL);
        painelDataIniRelatorio.add(CalendarioIniRelatorio);
        painelDataFimRelatorio.add(dataFimRelatorioJL);
        painelDataFimRelatorio.add(CalendarioFimRelatorio);
        painelDataFimRelatorio.add(selecionarDataRelatorio);

        // add os paineis  no painel relatorio
        painelRelatorio.add(painelDataIniRelatorio);
        painelRelatorio.add(painelDataFimRelatorio);
        painelRelatorio.add(consultarRelatorio);
        painelRelatorio.add(RelatorioJT);

        //
        painelRelatorio.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(painelRelatorio, "Relatorio");

        //Listener para Registrar Imoveis
        menuRegistrarImoveis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "RegistrarImovel");
            }

        });
        //Listener para Eventos
        menuEventos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "Eventos");
            }

        });
        //Listener para Registrar Corretores
        menuRegistrarCorretores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "RegistrarCorretor");
            }

        });
        //Listener para Visitas
        menuVisitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                menuVisitasJT.setText(objControladorPrincipal.getInstanciaControleCorretor().visitasCorretor());
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "VisitasCorretor");
            }

        });
        //Listener para Registrar Vendedores
        menuRegistrarVendedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "RegistrarVendedor");
            }

        });
        //Listener para Listar Imoveis
        menuListarImoveis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "ListaImovel");
            }

        });
        //Listener para Registrar Comprador
        menuRegistrarComprador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "RegistrarComprador");
            }

        });

        //Listener para Faturamento por Periodo
        menuFaturamentoporPeriodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "FatPeriodo");
            }

        });
        //Listener para Faturamento Corretor
        menuFaturamentoCorretor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "FatPeriodoCorretor");
            }

        });
        //Listener para Relatorio Vendas
        menuRelatorioVendas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "Relatorio");
            }

        });
        //Listener para  botão selecionar datas de evento
        selecionardataEventos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//pegar data e tals... adicionar booleano para verificar se botao foi pressionado

                dataEventoIni = CalendarioIni.getDatas();
                dataEventoFim = CalendarioFim.getDatas();

            }

        });
        //Listener para  botão Consultar Eventos 
        consultarEventos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//verificar por data chamar controle para isso
                String Codigo = codigoTF.getText();
                if (!Codigo.isEmpty()) {
                    EventosJT.setText(controleImovel.eventosImovel(dataEventoIni, dataEventoFim, Integer.parseInt(Codigo)));
                } else {
                    JOptionPane.showMessageDialog(null, "Código não preenchido");
                }

            }

        });
        listarImoveis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//verificar por data chamar controle para isso
                String CPF = CPFlistaImovelTF.getText();
                if (!CPF.isEmpty()) {
                    listaImovelJT.setText(controleImovel.imovelPorVendedor(CPF));
                } else {
                    JOptionPane.showMessageDialog(null, "CPF não preenchido");
                }
            }

        });
        selecionardataFatPeriodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//verificar por data chamar controle para isso
                dataEventoIni = CalendarioFatPeriodoIni.getDatas();
                dataEventoFim = CalendarioFatPeriodoFim.getDatas();
            }

        });
        consultarFatPeriodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//verificar por data chamar controle para isso
                double fatImobiliaria = limiteFaturamento.retornaFatImobiliaria(dataFatPeriodoIni, dataFatPeriodoFim);
                double fatCorretores = limiteFaturamento.retornaFatCorretores(dataFatPeriodoIni, dataFatPeriodoFim);

                double fatTotal = limiteFaturamento.retornaFatTotal(dataFatPeriodoIni, dataFatPeriodoFim);
                FatPeriodoJT.setText("faturamento Imobiliária:" + fatImobiliaria + "\n" + "faturamento Corretores" + fatCorretores + "\n" + "faturamento Total" + fatTotal + "\n");
            }

        });
        selecionardataFatPeriodoCorretor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//verificar por data chamar controle para isso
                dataEventoIni = CalendarioFatPeriodoIniCorretor.getDatas();
                dataEventoFim = CalendarioFatPeriodoFimCorretor.getDatas();
            }

        });
        consultarFatPeriodoCorretor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//verificar por data chamar controle para isso
                String nome = nomeFatPeriodoCorretorTF.getText();
                String creci = creciFatPeriodoCorretorTF.getText();

                double faturamento = limiteFaturamento.retornaFatCorretor(nome, creci, dataFatPeriodoIni, dataFatPeriodoFim);
                FatPeriodoCorretorJT.setText("faturamento" + faturamento);
            }

        });
        selecionarDataRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//verificar por data chamar controle para isso
                dataIniRelatorio = CalendarioIniRelatorio.getDatas();
                dataFimRelatorio = CalendarioFimRelatorio.getDatas();
            }

        });
        consultarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//verificar por data chamar controle para isso
                String corretor = nomeVisitasJF.getText();
                
                    RelatorioJT.setText(controleImovel.relatorioVendas(dataIniRelatorio, dataFimRelatorio));

            
            }

        });
        selecionarVisitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//verificar por data chamar controle para isso
                dataIniVisitas = CalendarioIniRelatorio.getDatas();
                dataFimVisitas = CalendarioFimRelatorio.getDatas();
            }

        });

        consultarVisitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//verificar por data chamar controle para isso
                String corretor = nomeVisitasJF.getText();
                if (!corretor.isEmpty()) {
                    menuVisitasJT.setText(controleImovel.visitasCorretor(corretor, dataIniVisitas, dataFimVisitas));

                } else {

                    JOptionPane.showMessageDialog(null, "Nome do corretor não informado");
                }
            }

        });

        // faltou o consultar relatorio
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try {
            controleVendedor.recuperaDados();
            controleImovel.recuperaDados();
            controleComprador.recuperaDados();
            controleCorretor.recuperaDados();

        } catch (Exception ex) {
            Logger.getLogger(LimitePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            controleVendedor.gravaDados();
            controleImovel.gravaDados();
            controleComprador.gravaDados();
            controleCorretor.gravaDados();
        } catch (Exception ex) {
            Logger.getLogger(LimitePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void windowClosed(WindowEvent e) {

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
