
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class LimitePrincipal extends JFrame implements ActionListener{
    // obj do tipo ControlePrincipal para as classes "se comunicarem"
    private ControlePrincipal ctrlPrin;
    // declaracao dos paineis, labels, textFields, textAreas, botoes
    private JPanel p1,p2,p3, painelConsulta;
    private JLabel l1,l2,l3, quantL, consultaL; 
    private JTextField t1,t2, quantT, consultaT;
    private JTextArea ja1, ja2, consultaResult;
    private JButton b1, b2, b3, b4, bquant, consultaBut;
    // obj do tipo Produto
    private Produto auxiliarProd = null;
    // obj do tipo cliente
    private Cliente auxiliarClien = null;
    //
    private JPanel painel;
    // outras variaveis
    private int quantidadeProdutos = 0;
    private boolean existeClien = false;
    
    // construtor da LimitePrincipal passa um obj do tipo Controle como parametro
    public LimitePrincipal(ControlePrincipal con){
        ctrlPrin = con;
        // chama a funcao criaJanela
        criaJanela();
    }// --------------- CONSTRUTOR TERMINA AQUI -----------
    
    // funcao para criar os paineis, ActionListeners e os componentes
    public void criaJanela(){
        // painel "painel" eh o principal
        painel = new JPanel();
        ja2 = new JTextArea();
        
        //painel consulta
        painelConsulta = new JPanel();
        consultaT = new JTextField(10);
        consultaBut = new JButton("Buscar");
        consultaL = new JLabel("CPF: ");
        consultaResult = new JTextArea();
        
        // adiciona os componentes da consulta no painelConsulta
        painelConsulta.add(consultaL);
        painelConsulta.add(consultaT);
        painelConsulta.add(consultaBut);
        painelConsulta.add(consultaResult);
        
        //JMenu
        JMenuBar menu = new JMenuBar();
        JMenu primMenu = new JMenu("Opções");
        JMenuItem cadMenu = new JMenuItem("Realiza Venda");
        JMenuItem conMenu = new JMenuItem("Consulta Vendas");
        primMenu.add(cadMenu);
        primMenu.add(conMenu);
        menu.add(primMenu);
        
        // ActionListener para a opcao "Realiza Venda"
        cadMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                painelConsulta.setVisible(false);
                painel.setVisible(true);
                p2.setVisible(false);
                p3.setVisible(false);
                
                l1.setVisible(true);
                t1.setVisible(true);
                b1.setVisible(true);
                ja1.setVisible(false);
                    
                t1.setText("");
                t2.setText("");
                quantT.setText(""); 
                
                t1.setEditable(true);
                b1.setEnabled(true);
                quantL.setVisible(false);
                quantT.setVisible(false);
                bquant.setVisible(false);
                
                p1.setVisible(true);
            }
        });
        // ActionListener para a opcao "Consulta Vendas"
        conMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                p2.setVisible(false);
                p3.setVisible(false);
                painelConsulta.setVisible(true);
                consultaT.setText("");
                consultaResult.setVisible(false);
            }
        });
      
        // ActionListener para o botao "Buscar" do painelConsulta
        consultaBut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                
                // pega o cpf digitado e joga na string
                String cpf = consultaT.getText();
                
                // chama a funcao retornaCliente e passa o cpf como parametro para buscar o cliente
                Cliente c = ctrlPrin.retornaCliente(cpf);
                
                // se o c for diferente de null, significa que existe cliente
                if(c!=null){
                    double total = 0;
                    // pega os dados do cliente encontrado e joga na variavel
                    String result = "Nome: " + c.getNome() + 
                            " | Idade: " + c.getIdade() + 
                            " | CPF: " + c.getCpf();
                    
                    // pega a lista de Vendas do controle e joga no ArrayList "listaV"
                    ArrayList<Venda> listaV = ctrlPrin.getListaVendas();
                    //System.out.println(listaV.size());
                    
                    // for para percorrer a lista de Vendas
                    for(Venda v: listaV){
                        //System.out.println("");
                        //System.out.println(v.isExisteCliente());
                        
                        // se existir o cliente
                        if(v.isExisteCliente()){
                            String compare = "11111111111";
                            
                            // caux eh igual ao cliente da venda
                            Cliente caux = v.getCliente();
                            //System.out.println(caux);
                            
                            // "compare" vai pegar o cpf do cliente da venda
                            compare = caux.getCpf();
                            //System.out.println(compare+ " e " +cpf);
                            
                            // se o cpf do cliente da venda eh igual ao cpf digitado
                            if(compare.equals(cpf)){
                                if(flag==false)
                                    result+="\n\nCOMPRAS(código>1000):\n";
                                flag = true;
                                
                                // "valor" tem o valor total da venda
                                double valor = v.getQuantidade()*v.getProduto().getPreco();
                                
                                // variavel "result" armazena a descricao da venda
                                result += "\nCodigo: " + v.getProduto().getCodigo()+ 
                                "\nDescrição: "+ v.getProduto().getDescricao()+
                                "\nValor unitário: R$"+v.getProduto().getPreco()+
                                " | Quantidade: "+ v.getQuantidade()+
                                " | Total: R$"+valor+"\n";
                                
                                // soma o "valor" na variavel "total"
                                total+=valor;
                            }
                        }
                    }
                    if(flag==false){
                        result+="\n\nEssa pessoa não fez compras nessa loja.\n";
                    }else{
                        result+="\nPreço total: R$"+total+"\n";
                    }
                    // joga a string no textArea do painelConsulta
                    consultaResult.setText(result);
                    consultaResult.setVisible(true);
                }
                // se o cliente nao existir retorna msg e "zera" o campo que foi digitado o cpf
                else{
                    JOptionPane.showMessageDialog(null, "Não existe cliente com este CPF.");
                    consultaT.setText("");
                }
            }
        });
        
        // criacao dos componentes relacionados ao painel 1
        // o p1 deve ler o codigo do produto, retornar sua descricao
        // e ler a quantidade de venda
        p1 = new JPanel(new GridLayout(10,2));
        l1 = new JLabel("Informe o código: ");
        t1 = new JTextField(10);
        ja1 = new JTextArea();
        b1 = new JButton("Ok");
        
        quantL = new JLabel("Quantidade de venda: ");
        quantT = new JTextField(10);
        bquant = new JButton("Ok");
        
        // criacao dos componentes relacionados ao painel 2
        // o p2 deve ser exibido caso a compra seja de alcool ou cigarro
        // deve ler o cpf e verificar se ele eh maior de idade
        // se for maior de 18, aparece o nome e chama o p3
        // se nao for maior de 18 da uma msg e volta para o p1
        p2 = new JPanel(new GridLayout(10,2));
        l2 = new JLabel("CPF: ");
        t2 = new JTextField(10);
        b2 = new JButton("Ok");
        
        // criacao dos componentes relacionados ao painel 3
        // p3 deve mostrar um resumo da compra
        p3 = new JPanel(new GridLayout(10,2));
        l3 = new JLabel("Confirmar compra?");
        
        b3 = new JButton("Confirma");
        b4 = new JButton("Cancela");
        
        p1.add(l1);
        p1.add(t1);
        p1.add(b1);
        p1.add(ja1);
        ja1.setVisible(false);
        p1.add(quantL);
        p1.add(quantT);
        p1.add(bquant);
        
        p2.add(l2);
        p2.add(t2);
        p2.add(b2);
        
        p3.add(l3);
        
        p3.add(b3);
        p3.add(b4);
        p3.add(ja2);
        
        // ActionListener para o botao "ok" do p1
        // botao para buscar o produto atraves do codigo informado
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // variavel para receber o codigo do produto
                String cod = t1.getText();
                int codigo = Integer.parseInt(cod);
                
                // se nao foi digitado nada retornar msg
                if(cod.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nao foi informadado nenhum dado");
                }
                // se foi digitado o codigo
                else{
                    // chama a funcao existeElemento e passa o codigo como parametro
                    // para ver se o elemento existe
                    if(ctrlPrin.existeElemento(codigo)){
                        t1.setEditable(false);
                        b1.setEnabled(false);
                        // se o produto existir, habilita os campos para informar a quantidade
                        quantL.setVisible(true);
                        quantT.setVisible(true);
                        bquant.setVisible(true);
                        // habilita o textArea que vai conter as informacoes do produto
                        ja1.setText("");
                        ja1.setVisible(true);
                        ja1.setEditable(false);
                        
                        // chama a funcao retornaProduto e passa o codigo como parametro para retornar o produto
                        Produto p = ctrlPrin.retornaProduto(codigo);
                        
                        // o obj do tipo Produto recebe o produto buscado
                        auxiliarProd = p;
                        
                        // joga a descricao do produto no textArea
                        ja1.setText("Descrição: " + p.getDescricao());
                    }
                    // se o produto nao existir retorna msg
                    else{
                        JOptionPane.showMessageDialog(null, "Não existe produto com este código.");
                    }
                }
            }
        });
        
        // ActionListener do botao "ok" apos ser informado a quantidade do produto
        bquant.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // variavel para receber a quantidade informada
                String quant = quantT.getText();
                
                // variavel para receber o codigo do produto
                int codigo = auxiliarProd.getCodigo();
                
                // se nao for informado a quantidade retorna msg
                if(quant.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo de quantidade vazio.");
                }
                // se foi informado a quantidade
                else{
                    // variael para receber a quantidade de produtos
                    quantidadeProdutos = Integer.parseInt(quant);
                    //System.out.println(quantidadeProdutos);
                    
                    // desabilita o painel 1
                    p1.setVisible(false);
                    
                    // se o codigo for maior que 1000 significa que eh alcool ou cigarro
                    if(codigo>1000){
                        //mostrar p2
                        
                        // entao deve-se mostrar o p2
                        p2.setVisible(true);
                        //retorna o cliente
                    }
                    // se o codigo for menor que 1000
                    else if(codigo<=1000){
                        //mostrar p3
                        String result = "";
                        
                        // pegar o valor total
                        double valor = auxiliarProd.getPreco()*quantidadeProdutos;
                        
                        // jogar a descricao da venda na variavel
                        result = "Codigo: " + auxiliarProd.getCodigo()+ 
                                "\nDescrição: "+ auxiliarProd.getDescricao()+
                                "\nValor unitário: R$"+auxiliarProd.getPreco()+
                                "\nTotal: R$"+valor;
                        
                        // jogar a variavel com a descricao no textArea
                        ja2.setText(result);
                        ja2.setVisible(true);
                        
                        // mostrar o p3 que tem o resumo da compra
                        p3.setVisible(true);
                        
                        // "zera" as variaveis e objetos
                        auxiliarClien = null;
                        existeClien = false;
                    }
                }
            }
        });
        
        // ActionListener do botao "ok" do p2
        // botao apos digitar o cpf, caso queira realizar a compra de produtos para maiores de 18
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // variavel recebe o cpf
                String cpf = t2.getText();
                
                // chama a funcao retornaIdadePorCpf e passa o cpf como parametro
                // funcao retorna a idade do cliente
                int idade = ctrlPrin.retornaIdadePorCpf(cpf);
                
                // se a idade eh igual a -1 significa que o cpf eh invalido
                // retorna msg e "zera" as variaveis e objetos
                if(idade == -1){
                    JOptionPane.showMessageDialog(null, "CPF inválido.");
                    auxiliarClien = null;
                    existeClien = false;
                }
                // se o cpf for valido
                else{
                    auxiliarClien = null;
                    existeClien = false;
                    
                    // se a idade for maior que 18
                    if(idade>=18){
                        // chama a funcao retornaCliente e passa o cpf como parametro
                        auxiliarClien = ctrlPrin.retornaCliente(cpf);
                        existeClien = true;
                        String result = "";
                        
                        // pega o valor total
                        double valor = auxiliarProd.getPreco()*quantidadeProdutos;
                        
                        // jogar a descricao da venda na variavel
                        result = "Codigo: " + auxiliarProd.getCodigo()+ 
                                "\nDescrição: "+ auxiliarProd.getDescricao()+
                                "\nValor unitário: R$"+auxiliarProd.getPreco()+
                                "\nTotal: R$"+valor;
                        
                        // jogar a variavel com a descricao no textArea
                        ja2.setText(result);
                        ja2.setVisible(true);
                        // desabilita o p2
                        p2.setVisible(false);
                        // habilita o p3
                        p3.setVisible(true);
                    }
                    // se a idade for menor que 18
                    else{
                        auxiliarClien = null;
                        existeClien = false;
                        p2.setVisible(false);
                        
                        // volta para o p1 e retorna msg
                        p1.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Venda proibidade para menores de idade.");
                        t1.setEditable(true);
                        ja1.setVisible(false);
                        b1.setEnabled(true);
                        quantL.setVisible(false);
                        quantT.setVisible(false);
                        bquant.setVisible(false);
                        
                        // "zera" os campos 
                        t1.setText("");
                        t2.setText("");
                        quantT.setText("");
                    }
                }
            }
        });
        
        // ActionListener do botao "Confirma" do painel 3
        // quando apertado deve-se usar os dados da venda para criar um obj Venda,
        // add no ArrayList de vendas e salvar em arquivo
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // chama a funcao para cadastrar a venda
                ctrlPrin.cadastraVenda(auxiliarProd, auxiliarClien, quantidadeProdutos, existeClien);

                p3.setVisible(false);
                
                t1.setEditable(true);
                b1.setEnabled(true);
                quantL.setVisible(false);
                quantT.setVisible(false);
                bquant.setVisible(false);
                
                //"zera" os textfields e volta para o p1
                l1.setVisible(true);
                t1.setVisible(true);
                b1.setVisible(true);
                ja1.setVisible(false);
                    
                t1.setText("");
                t2.setText("");
                
                quantT.setText(""); 
                
                p1.setVisible(true);
            }
        });
        
        // ActionListener para o botao "Cancela" do p3
        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                p3.setVisible(false);
                
                //"zera" os textfields e volta para o p1 sem guardar os dados da venda
                t1.setText("");
                t2.setText("");
                quantT.setText("");
                
                t1.setEditable(true);
                b1.setEnabled(true);
                quantL.setVisible(false);
                quantT.setVisible(false);
                bquant.setVisible(false);
                ja1.setVisible(false);
                
                p1.setVisible(true);
            }
        });
        
        // inicialmente o p1 fica habilitado
        p2.setVisible(false);
        p3.setVisible(false);
        painel.add(p1);
        painel.add(p2);
        painel.add(p3);
        
        painel.add(painelConsulta);
        painelConsulta.setVisible(false);
        
        super.setJMenuBar(menu);
        super.add(painel);
        
        super.setTitle("Loja");
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
