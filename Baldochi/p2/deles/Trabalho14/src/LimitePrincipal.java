import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class LimitePrincipal extends JFrame implements ActionListener{
    private ControlePrincipal ctrlPrin;
    private JPanel painel1,painel2,painel3, painelConsulta,painel;
    private JLabel l1,l2,l3, quantL, consultaL; 
    private JTextField t1,t2, quantT, consultaT;
    private JTextArea ja1, ja2, consultaResult;
    private JButton but1, but2, but3, but4, bquant, consultaBut;
    private Produto auxiliarProd = null;
    private Cliente auxiliarClien = null;
    private int quantidadeProdutos = 0;
    private boolean existeClien = false;
    
    public LimitePrincipal(ControlePrincipal con){
        ctrlPrin = con;
        criaJanela();
    }
    
    public void criaJanela(){
        painel = new JPanel();
        ja2 = new JTextArea();
        
        //painel consulta
        painelConsulta = new JPanel();
        consultaT = new JTextField(10);
        consultaBut = new JButton("Procurar");
        consultaL = new JLabel("CPF: ");
        consultaResult = new JTextArea();
        
        painelConsulta.add(consultaL);
        painelConsulta.add(consultaT);
        painelConsulta.add(consultaBut);
        painelConsulta.add(consultaResult);
        
        //JMenu
        JMenuBar menu = new JMenuBar();
        JMenu primMenu = new JMenu("Opções");
        JMenuItem cadMenu = new JMenuItem("Realizar Venda");
        JMenuItem conMenu = new JMenuItem("Consultar Vendas");
        primMenu.add(cadMenu);
        primMenu.add(conMenu);
        menu.add(primMenu);
        
        cadMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                painelConsulta.setVisible(false);
                painel.setVisible(true);
                painel2.setVisible(false);
                painel3.setVisible(false);
                
                l1.setVisible(true);
                t1.setVisible(true);
                but1.setVisible(true);
                ja1.setVisible(false);
                    
                t1.setText("");
                t2.setText("");
                quantT.setText(""); 
                
                t1.setEditable(true);
                but1.setEnabled(true);
                quantL.setVisible(false);
                quantT.setVisible(false);
                bquant.setVisible(false);
                
                painel1.setVisible(true);
            }
        });
        
        conMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                painel1.setVisible(false);
                painel2.setVisible(false);
                painel3.setVisible(false);
                painelConsulta.setVisible(true);
                consultaT.setText("");
                consultaResult.setVisible(false);
            }
        });
      
        
        consultaBut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                String cpf = consultaT.getText();
                Cliente c = ctrlPrin.retornaCliente(cpf);
                if(c!=null){
                    double total = 0;
                    String result = "Nome: " + c.getNome() + 
                            " | Idade: " + c.getIdade() + 
                            " | CPF: " + c.getCpf();
                    ArrayList<Venda> listaV = ctrlPrin.getListaVendas();
                    //System.out.println(listaV.size());
                    for(Venda v: listaV){
                        //System.out.println("");
                        //System.out.println(v.isExisteCliente());
                        if(v.isExisteCliente()){
                            String compare = "11111111111";
                            Cliente caux = v.getCliente();
                            //System.out.println(caux);
                            compare = caux.getCpf();
                            //System.out.println(compare+ " e " +cpf);
                            if(compare.equals(cpf)){
                                if(flag==false)
                                    result+="\n\nCOMPRAS(código>1000):\n";
                                flag = true;
                                double valor = v.getQuantidade()*v.getProduto().getPreco();
                                result += "\nCodigo: " + v.getProduto().getCodigo()+ 
                                "\nDescrição: "+ v.getProduto().getDescricao()+
                                "\nValor unitário: R$"+v.getProduto().getPreco()+
                                " | Quantidade: "+ v.getQuantidade()+
                                " | Total: R$"+valor+"\n";
                                total+=valor;
                            }
                        }
                    }
                    if(flag==false){
                        result+="\n\nnão há compras cadastradas nessa loja para esse cliente.\n";
                    }else{
                        result+="\nTOTAL GASTO NA LOJA: R$"+total+"\n";
                    }
                    consultaResult.setText(result);
                    consultaResult.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Cliente inexistente para o CPF especificado.");
                    consultaT.setText("");
                }
            }
        });
        
        painel1 = new JPanel(new GridLayout(10,2));
        l1 = new JLabel("Código: ");
        t1 = new JTextField(10);
        ja1 = new JTextArea();
        but1 = new JButton("Ok");
        
        quantL = new JLabel("Quantidade de venda: ");
        quantT = new JTextField(10);
        bquant = new JButton("Ok");
        
        painel2 = new JPanel(new GridLayout(10,2));
        l2 = new JLabel("Cpf: ");
        t2 = new JTextField(10);
        but2 = new JButton("Ok.");
        
        painel3 = new JPanel(new GridLayout(10,2));
        l3 = new JLabel("Confirmar compra?");
        
        but3 = new JButton("Confirmar");
        but4 = new JButton("Cancelar");
        
        painel1.add(l1);
        painel1.add(t1);
        painel1.add(but1);
        painel1.add(ja1);
        ja1.setVisible(false);
        painel1.add(quantL);
        painel1.add(quantT);
        painel1.add(bquant);
        
        painel2.add(l2);
        painel2.add(t2);
        painel2.add(but2);
        
        painel3.add(l3);
        
        painel3.add(but3);
        painel3.add(but4);
        painel3.add(ja2);
        
        but1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cod = t1.getText();
                int codigo = Integer.parseInt(cod);
                if(cod.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo vazio!");
                }else{
                    if(ctrlPrin.existeElemento(codigo)){
                        t1.setEditable(false);
                        but1.setEnabled(false);
                        quantL.setVisible(true);
                        quantT.setVisible(true);
                        bquant.setVisible(true);
                        ja1.setText("");
                        ja1.setVisible(true);
                        ja1.setEditable(false);
                        Produto p = ctrlPrin.retornaProduto(codigo);
                        auxiliarProd = p;
                        ja1.setText("Descrição: " + p.getDescricao());
                    }else{
                        JOptionPane.showMessageDialog(null, "Não existe nenhum produto com o código especificado.");
                    }
                }
            }
        });
        
        bquant.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String quant = quantT.getText();
                int codigo = auxiliarProd.getCodigo();
                if(quant.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo vazio de quantidade.");
                }else{
                    quantidadeProdutos = Integer.parseInt(quant);
                    //System.out.println(quantidadeProdutos);
                    painel1.setVisible(false);
                    if(codigo>1000){
                        //mostrar painel2
                        painel2.setVisible(true);
                        //retorna o cliente
                    }else if(codigo<=1000){
                        //mostrar painel3
                        String result = "";
                        double valor = auxiliarProd.getPreco()*quantidadeProdutos;
                        result = "Codigo: " + auxiliarProd.getCodigo()+ 
                                "\nDescrição: "+ auxiliarProd.getDescricao()+
                                "\nValor unitário: R$"+auxiliarProd.getPreco()+
                                "\nTotal: R$"+valor;
                        ja2.setText(result);
                        ja2.setVisible(true);
                        painel3.setVisible(true);
                        auxiliarClien = null;
                        existeClien = false;
                    }
                }
            }
        });
        
        but2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = t2.getText();
                int idade = ctrlPrin.retornaIdadePorCpf(cpf);
                if(idade == -1){
                    JOptionPane.showMessageDialog(null, "CPF inválido.");
                    auxiliarClien = null;
                    existeClien = false;
                }else{
                    auxiliarClien = null;
                    existeClien = false;
                    if(idade>=18){
                        auxiliarClien = ctrlPrin.retornaCliente(cpf);
                        existeClien = true;
                        String result = "";
                        double valor = auxiliarProd.getPreco()*quantidadeProdutos;
                        result = "Codigo: " + auxiliarProd.getCodigo()+ 
                                "\nDescrição: "+ auxiliarProd.getDescricao()+
                                "\nValor unitário: R$"+auxiliarProd.getPreco()+
                                "\nTotal: R$"+valor;
                        ja2.setText(result);
                        ja2.setVisible(true);
                        painel2.setVisible(false);
                        painel3.setVisible(true);
                    }else{
                        auxiliarClien = null;
                        existeClien = false;
                        painel2.setVisible(false);
                        painel1.setVisible(true);
                        JOptionPane.showMessageDialog(null, "MENOR DE IDADE! Proibido a venda do produto.");
                        t1.setEditable(true);
                        ja1.setVisible(false);
                        but1.setEnabled(true);
                        quantL.setVisible(false);
                        quantT.setVisible(false);
                        bquant.setVisible(false);
                        t1.setText("");
                        t2.setText("");
                        quantT.setText("");
                    }
                }
            }
        });
        
        but3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrlPrin.cadastraVenda(auxiliarProd, auxiliarClien, quantidadeProdutos, existeClien);

                painel3.setVisible(false);
                
                t1.setEditable(true);
                but1.setEnabled(true);
                quantL.setVisible(false);
                quantT.setVisible(false);
                bquant.setVisible(false);
                l1.setVisible(true);
                t1.setVisible(true);
                but1.setVisible(true);
                ja1.setVisible(false);
                    
                t1.setText("");
                t2.setText("");
                
                quantT.setText(""); 
                
                painel1.setVisible(true);
            }
        });
        
        but4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                painel3.setVisible(false);
                
                t1.setText("");
                t2.setText("");
                quantT.setText("");
                
                t1.setEditable(true);
                but1.setEnabled(true);
                quantL.setVisible(false);
                quantT.setVisible(false);
                bquant.setVisible(false);
                ja1.setVisible(false);
                
                painel1.setVisible(true);
            }
        });
        
        painel2.setVisible(false);
        painel3.setVisible(false);
        painel.add(painel1);
        painel.add(painel2);
        painel.add(painel3);
        
        painel.add(painelConsulta);
        painelConsulta.setVisible(false);
        
        super.setJMenuBar(menu);
        super.add(painel);
        
        super.setTitle("Lojinha de COM220");
        super.setSize(600,400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);

        quantL.setVisible(false);
        quantT.setVisible(false);
        bquant.setVisible(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
