package Limite;

import Controle.*;
import Model.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class LimiteImovel extends JPanel implements ActionListener {

    ImageIcon image;

    JFileChooser fc = new JFileChooser();

    //
    private ControleImovel objControladorImovel;
    ControlePrincipal controlePrincipal;
    JLabel codigoJL, tipoJL, descricaoJL, arquivoFotoJL, precoJL, comissaoJL,
            dataInclusaoJL, vendedorJL;
    JTextField codigoTF, tipoTF, descricaoTF, arquivoFotoTF, precoTF, comissaoTF,
            dataInclusaoTF, vendedorTF;
    JButton cadastrar, selecionar, arqFoto;
    JPanel painelImovel, painelCodigo, painelTipo, painelDescricao, painelArquivoFoto, painelPreco, painelComissao, painelDataInclusao, painelVendedor;
    Calendario painelCalendario;
    Calendar data;

    public LimiteImovel(ControleImovel objControladorImovel, ControlePrincipal controlePrincipal) {
        this.objControladorImovel = objControladorImovel;
        this.controlePrincipal = controlePrincipal;
         image=new ImageIcon();
         arquivoFotoJL=new JLabel();
        //
        codigoJL = new JLabel("Código");
        tipoJL = new JLabel("Tipo");
        descricaoJL = new JLabel("Descrição");
        precoJL = new JLabel("Preço");
        comissaoJL = new JLabel("Comissão (1% a 5%)");
        dataInclusaoJL = new JLabel("Data de Inclusão");
        vendedorJL = new JLabel("Vendedor");

        //
        codigoTF = new JTextField(10);
        tipoTF = new JTextField(20);
        descricaoTF = new JTextField(50);
        arquivoFotoTF = new JTextField(50);
        precoTF = new JTextField(20);
        comissaoTF = new JTextField(1);
        dataInclusaoTF = new JTextField(10);
        vendedorTF = new JTextField(50);

        //
        arqFoto = new JButton("Foto");
        arqFoto.addActionListener(this);

        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(this);

        painelImovel = new JPanel();
        painelImovel.setLayout(new BoxLayout(painelImovel, BoxLayout.Y_AXIS));

        selecionar = new JButton("Selecionar");
        painelCodigo = new JPanel();
        painelCodigo.setLayout(new FlowLayout());
        painelCodigo.setAlignmentX(0.5f);
        painelTipo = new JPanel();
        painelTipo.setLayout(new FlowLayout());
        painelTipo.setAlignmentX(0.5f);
        painelDescricao = new JPanel();
        painelDescricao.setLayout(new FlowLayout());
        painelDescricao.setAlignmentX(0.5f);
        painelArquivoFoto = new JPanel();
        painelArquivoFoto.setLayout(new FlowLayout());
        painelArquivoFoto.setAlignmentX(0.5f);
        painelPreco = new JPanel();
        painelPreco.setLayout(new FlowLayout());
        painelPreco.setAlignmentX(0.5f);
        painelComissao = new JPanel();
        painelComissao.setLayout(new FlowLayout());
        painelComissao.setAlignmentX(0.5f);
        painelDataInclusao = new JPanel();
        painelDataInclusao.setLayout(new FlowLayout());
        painelDataInclusao.setAlignmentX(0.5f);
        painelVendedor = new JPanel();
        painelVendedor.setLayout(new FlowLayout());
        painelVendedor.setAlignmentX(0.5f);
        painelCalendario = new Calendario();

        painelCodigo.add(codigoJL);
        painelCodigo.add(codigoTF);
        painelTipo.add(tipoJL);
        painelTipo.add(tipoTF);
        painelDescricao.add(descricaoJL);
        painelDescricao.add(descricaoTF);
        painelArquivoFoto.add(arquivoFotoJL);
        painelArquivoFoto.add(arqFoto);
        painelPreco.add(precoJL);
        painelPreco.add(precoTF);
        painelComissao.add(comissaoJL);
        painelComissao.add(comissaoTF);
        painelDataInclusao.add(dataInclusaoJL);
        painelDataInclusao.add(painelCalendario);
        painelDataInclusao.add(selecionar);

        //painelDataInclusao.add(dataInclusaoJL);
        //painelDataInclusao.add(dataInclusaoTF);
        painelVendedor.add(vendedorJL);
        painelVendedor.add(vendedorTF);

        //
        painelImovel.add(painelCodigo);
        painelImovel.add(Box.createVerticalGlue());
        painelImovel.add(painelTipo);
        painelImovel.add(Box.createVerticalGlue());
        painelImovel.add(painelDescricao);
        painelImovel.add(Box.createVerticalGlue());
        painelImovel.add(painelArquivoFoto);
        painelImovel.add(Box.createVerticalGlue());
        painelImovel.add(painelPreco);
        painelImovel.add(Box.createVerticalGlue());
        painelImovel.add(painelComissao);
        painelImovel.add(Box.createVerticalGlue());
        painelImovel.add(painelDataInclusao);
        painelImovel.add(Box.createVerticalGlue());
        painelImovel.add(painelVendedor);
        painelImovel.add(Box.createVerticalGlue());

        painelImovel.add(cadastrar);

        // super.setTitle("Cadastrar Imovel");
        super.add(painelImovel);
        super.setSize(1280, 720);
        //super.setAlwaysOnTop(true);
        //super.setResizable(false);
        //super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        super.setVisible(true);

        arqFoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Handle Sopen button action.
                if (e.getSource() == arqFoto) {
                    int returnValue = fc.showOpenDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fc.getSelectedFile();
                        arquivoFotoTF.setText(selectedFile.getAbsolutePath());
                        image = new ImageIcon(getClass().getResource(arquivoFotoTF.getText()));
                        image.setImage(image.getImage());
                        arquivoFotoJL = new JLabel(image);
                        System.out.println(arquivoFotoTF.getText());
                    }
                }
            }
        });

        //Listener para o botão selecionar
        selecionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data = Calendar.getInstance();
                data = painelCalendario.getDatas();
            }

        });
    }

    Vendedor BuscaVendedorImovel(String nomeVendedor) {

        ArrayList<Vendedor> listaVendedor = controlePrincipal.getInstanciaControleVendedor().getListaVendedor();
        for (Vendedor v : listaVendedor) {
            if (v.getNome().equals(nomeVendedor)) {

                return v;//se achar o vendedor retorne 
            }

        }
        return null;// senao achar retorne nada
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // criacao de um botao auxiliar 
        JButton botaoAux = (JButton) e.getSource();

        // criacao de uma string para verificar se foram informados dados
        String identificarCodigo = "";
        String identificarTipo = "";
        String identificarDescricao = "";
        String identificarArquivoFoto = "";
        String identificarPreco = "";
        String identificarComissao = "";
        String identificarDataInclusao = "";
        String identificarVendedor = "";

        if (botaoAux.equals(cadastrar)) {
            identificarCodigo = codigoTF.getText();
            identificarTipo = tipoTF.getText();
            identificarDescricao = descricaoTF.getText();
            identificarArquivoFoto = arquivoFotoTF.getText();
            identificarPreco = precoTF.getText();
            identificarComissao = comissaoTF.getText();

            identificarVendedor = vendedorTF.getText();
            //talvez vai varrer vendedor

            // if para ver se todos os campos foram preenchidos
            if (identificarCodigo.isEmpty() || identificarTipo.isEmpty()
                    || identificarDescricao.isEmpty() || identificarArquivoFoto.isEmpty()
                    || identificarPreco.isEmpty() || identificarComissao.isEmpty()
                    || identificarVendedor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não foram informados todos os campos");
            } else {
                // criacao de variaveis para converter de string para o tipo especifico
                int codigo = Integer.parseInt(identificarCodigo);
                double preco = Double.parseDouble(identificarPreco);
                double comissao = Double.parseDouble(identificarComissao);

                //
                Vendedor vendedor = BuscaVendedorImovel(identificarVendedor);
                if (vendedor != null) {

                    //contém vendedor cadastrado
                    // ver como faz conversao de String para Calendar
                    //Calendar data = Calendar.parseCalendar(identificarDataInclusao);
                    objControladorImovel.cadastraImovel(codigo, identificarTipo, identificarDescricao, identificarArquivoFoto, preco, comissao, data, vendedor);
                    JOptionPane.showMessageDialog(this, "Imovel cadastrado");
                } else {

                    JOptionPane.showMessageDialog(this, "Vendedor não possui cadastrado, efetue o cadastro para prosseguir.");

                }

            }
        }
    }
}