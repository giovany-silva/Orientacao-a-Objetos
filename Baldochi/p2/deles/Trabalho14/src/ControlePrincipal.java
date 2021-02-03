
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GiovanySilva95
 */
public class ControlePrincipal {
    private LimitePrincipal limPrin;
    private ArrayList<Venda> listaVendas = new ArrayList<Venda>();
    private ArrayList<Cliente> listaClient = new ArrayList<Cliente>();
    private ArrayList<Produto> listaProduto = new ArrayList<Produto>();
    
    public ControlePrincipal(){
        limPrin = new LimitePrincipal(this);
        recebeDados();
    }
    
    public void recebeDados(){
        listaClient.add(new Cliente("11111111111", "Joao Souza", 33));
        listaClient.add(new Cliente("22222222222", "Pedro Aquino", 15));
        listaClient.add(new Cliente("33333333333", "Antonio Silva", 25));
        
        listaProduto.add(new Produto(901, "Guarana lata", 4.50));
        listaProduto.add(new Produto(902, "Agua mineral copo", 2.00));
        listaProduto.add(new Produto(903, "Sorvete Kibon", 5.30));
        listaProduto.add(new Produto(904, "Chocolate Alpino", 4.30));
        listaProduto.add(new Produto(905, "Barra cereal", 3.70));
        listaProduto.add(new Produto(1001, "Cerveja Skol lata", 5.50));
        listaProduto.add(new Produto(1002, "Marlboro Maço", 9.40));
        listaProduto.add(new Produto(1003, "Vodka Skyy", 53.40));
    }
    
    public boolean existeElemento(int codigo){
        for(Produto p: listaProduto){
            if(p.getCodigo()==codigo)
                return true;
        }
        return false;
    }
    
    public Produto retornaProduto(int codigo){
        for(Produto p: listaProduto){
            if(p.getCodigo()==codigo)
                return p;
        }
        return null;
    }
    
    public Cliente retornaCliente(String cpf){
        for(Cliente p: listaClient){
            if(p.getCpf().equals(cpf))
                return p;
        }
        return null;
    }
    
    public int retornaIdadePorCpf(String cpf){
        for(Cliente c: listaClient){
            if(c.getCpf().equals(cpf)){
                return c.getIdade();
            }
        }
        return -1;
    }
    
    public void cadastraVenda(Produto p, Cliente c, int quant, boolean existe){
        Venda novo = new Venda(p,c,quant);
        novo.setExisteCliente(existe);
        listaVendas.add(novo);
        JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso!");
    }

    public ArrayList<Venda> getListaVendas() {
        return listaVendas;
    }

    public void setListaVendas(ArrayList<Venda> listaVendas) {
        this.listaVendas = listaVendas;
    }

    public ArrayList<Cliente> getListaClient() {
        return listaClient;
    }

    public void setListaClient(ArrayList<Cliente> listaClient) {
        this.listaClient = listaClient;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
    
    public static void main(String s[]){
        new ControlePrincipal();
    }
}
