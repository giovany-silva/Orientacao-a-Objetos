package Limite;

import Controle.ControlePrincipal;
import Model.Imovel;
import Model.Util;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LimiteFaturamento extends JPanel implements ActionListener{
    
    //
    private ControlePrincipal objControlador;
    private JPanel painelFatPrincipal, painelFatTotal, painelFatImob, painelFatCorretores, painelDataInicial, painelDataFinal;
    private JLabel FatTotalJL, FatImobJL, FatCorretoresJL, DataInicialJL, DataFinalJL;
    private JTextField dataInicialTF, dataFinalTF;
    private JButton calcular;
    private JTextArea imobiliariaJA, corretoresJA, totalJA;
    
    public LimiteFaturamento(ControlePrincipal pControle){
        objControlador = pControle;
        
        // criacao do painel Faturamento principal
        painelFatPrincipal = new JPanel();
        painelFatPrincipal.setLayout(new BoxLayout(painelFatPrincipal, BoxLayout.Y_AXIS));
        
        // criacao dos paineis 
        painelFatTotal = new JPanel();
        painelFatTotal.setLayout(new FlowLayout());
        painelFatTotal.setAlignmentX(0.5f);
        painelFatImob = new JPanel();
        painelFatImob.setLayout(new FlowLayout());
        painelFatImob.setAlignmentX(0.5f);
        painelFatCorretores = new JPanel();
        painelFatCorretores.setLayout(new FlowLayout());
        painelFatCorretores.setAlignmentX(0.5f);
        painelDataInicial = new JPanel();
        painelDataInicial.setLayout(new FlowLayout());
        painelDataInicial.setAlignmentX(0.5f);
        painelDataFinal = new JPanel();
        painelDataFinal.setLayout(new FlowLayout());
        painelDataFinal.setAlignmentX(0.5f);
        
        
        //
        FatTotalJL = new JLabel("Faturamento Total");
        FatCorretoresJL = new JLabel("Valor Corretores");
        FatImobJL = new JLabel("Valor Imobiliária");
        DataInicialJL = new JLabel("Data Inicial");
        DataFinalJL = new JLabel("Data Final");
        
        //
        dataInicialTF = new JTextField(10);
        dataFinalTF = new JTextField(10);
        
        //
        calcular = new JButton("Calcular Faturamento");
        calcular.addActionListener(this);
        
        //
        imobiliariaJA = new JTextArea();
        corretoresJA = new JTextArea();
        totalJA = new JTextArea();
        
        //
        painelFatTotal.add(FatTotalJL);
        painelFatTotal.add(totalJA);
        painelFatImob.add(FatImobJL);
        painelFatTotal.add(imobiliariaJA);
        painelFatCorretores.add(FatCorretoresJL);
        painelFatCorretores.add(corretoresJA);
        painelDataInicial.add(DataInicialJL);
        painelDataInicial.add(dataInicialTF);
        painelDataFinal.add(DataFinalJL);
        painelDataFinal.add(dataFinalTF);
        
        //
        painelFatPrincipal.add(painelDataInicial);
        painelFatPrincipal.add(Box.createVerticalGlue());
        painelFatPrincipal.add(painelDataFinal);
        painelFatPrincipal.add(Box.createVerticalGlue());
        painelFatPrincipal.add(calcular);
        painelFatPrincipal.add(painelFatCorretores);
        painelFatPrincipal.add(Box.createVerticalGlue());
        painelFatPrincipal.add(painelFatImob);
        painelFatPrincipal.add(Box.createVerticalGlue());
        painelFatPrincipal.add(painelFatTotal);
        painelFatPrincipal.add(Box.createVerticalGlue());
        
        //
        //totalJA.setVisible(false);
        totalJA.setSize(150, 150);
        //imobiliariaJA.setVisible(false);
        imobiliariaJA.setSize(150, 150);
        //corretoresJA.setVisible(false);        
        corretoresJA.setSize(150, 150);
        
        // super.setTitle("Cadastrar Imovel");
        super.add(painelFatPrincipal);
        super.setSize(1280, 720);
        //super.setAlwaysOnTop(true);
        //super.setResizable(false);
        //super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
          // criacao de um botao auxiliar 
        JButton botaoAux = (JButton) e.getSource();

        // criacao de uma string para verificar se foram informados dados
        String identificarDataInicial = "";
        String identificarDataFinal = "";
        
        //
        if (botaoAux.equals(calcular)) {
            identificarDataInicial = dataInicialTF.getText();
            identificarDataFinal = dataFinalTF.getText();
            
            if(identificarDataInicial.isEmpty() || identificarDataFinal.isEmpty()){
            
                JOptionPane.showMessageDialog(this, "Você não informou as datas");
            } else {
                double fatImobiliaria=0, fatCorretores=0, fatTotal = 0;
            
                //
                       
                String strImobiliaria = "Faturamento imobiliaria: " +fatImobiliaria +"\n";
                String strCorretores = "Faturamento corretores: " +fatCorretores +"\n";
                String strTotal = "Faturamento total: " +fatTotal +"\n";
                
                //
                imobiliariaJA.setText(strImobiliaria);
                imobiliariaJA.setEditable(false);
                imobiliariaJA.setVisible(true);
                corretoresJA.setText(strCorretores);
                corretoresJA.setEditable(false);
                corretoresJA.setVisible(true);
                totalJA.setText(strTotal);
                totalJA.setEditable(false);
                totalJA.setVisible(true);
                
            }
        }    
    }
    //
    public double retornaFatTotal(Calendar dataIni,Calendar dataFim)
    {
    double FatTotal=objControlador.getInstanciaControleCorretor().calculaFatTotal(dataIni,dataFim);
    
    return FatTotal;
    }
    public double retornaFatImobiliaria(Calendar dataIni,Calendar dataFim){
        // variavel para retornar o faturamento
        double FatImobiliaria = objControlador.getInstanciaControleCorretor().calculaFatTotalImobiliaria(dataIni,dataFim);
        return FatImobiliaria;
    }
    //
    public double retornaFatCorretores(Calendar dataIni,Calendar dataFim){
        // variavel para retornar o faturamento
        double FatCorretores = objControlador.getInstanciaControleCorretor().calculaFatCorretores(dataIni,dataFim);
        
        
        return FatCorretores;
    }
    public double  retornaFatCorretor(String nome, String creci,Calendar dataIni,Calendar dataFim)
    {
    
        return objControlador.getInstanciaControleCorretor().calculaFatCorretor(nome,creci,dataIni,dataFim);
    }
    
    
}