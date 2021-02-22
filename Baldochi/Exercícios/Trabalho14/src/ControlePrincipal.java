
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlePrincipal {
    // obj do tipo do LimitePrincipal
    private LimitePrincipal limPrin;
    // ArrayList das vendas, clientes e produtos
    private ArrayList<Venda> listaVendas = new ArrayList<Venda>();
    private ArrayList<Cliente> listaClient = new ArrayList<Cliente>();
    private ArrayList<Produto> listaProduto = new ArrayList<Produto>();
    
    // construtor da ControlePrincipal
    public ControlePrincipal(){
        limPrin = new LimitePrincipal(this);
        // chama a funcao recebeDados
        recebeDados();
    }// ---------------- CONSTRUTOR TERMINA AQUI ----------------
    
    // funcao para instanciar os clientes e produtos
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
    // funcao para verificar se o produto existe, precisa passar um codigo como parametro
    public boolean existeElemento(int codigo){
        // for para varrer a lista de produtos
        for(Produto p: listaProduto){
            // se o codigo passado como parametro existir no ArrayList de produtos
            // significa que o produto existe
            if(p.getCodigo()==codigo)
                // caso o produto exista retorna true
                return true;
        }
        // se o produto nao existir retorna false
        return false;
    }
    // funcao para retornar um produto, precisa passar o codigo como parametro
    public Produto retornaProduto(int codigo){
        // for para varrer a lista de produtos
        for(Produto p: listaProduto){
            // if para ir comparando o codigo passado com os codigos da lista de produtos
            if(p.getCodigo()==codigo)
                // se o codigo existir retorna o produto
                return p;
        }
        // se o codigo nao existir nao retorna nada
        return null;
    }
    // funcao para retornar um cliente, precisa passar o cpf como parametro
    public Cliente retornaCliente(String cpf){
        // for para varrer a lista de clientes
        for(Cliente p: listaClient){
            // if para ir comparando o cpf passado com os cpf's da lista de clientes
            if(p.getCpf().equals(cpf))
                // se o cpf existir retorna o cliente
                return p;
        }
        // se o cpf nao existir nao retorna nada
        return null;
    }
    // funcao para buscar a idade do cliente atraves do cpf passado como parametro
    public int retornaIdadePorCpf(String cpf){
        // for para varrer a lista de clientes
        for(Cliente c: listaClient){
            // if para ir comparando o cpf passado com os cpf's da lista de clientes
            if(c.getCpf().equals(cpf)){
                // ao encontrar o cliente retorna a idade dele
                return c.getIdade();
            }
        }
        // se nao encontrar o cliente retorna -1
        return -1;
    }
    // funcao para cadastrar venda
    public void cadastraVenda(Produto p, Cliente c, int quant, boolean existe){
        // cria um nova venda
        Venda novo = new Venda(p,c,quant);
        // passa que o cliente existe
        novo.setExisteCliente(existe);
        // adiciona a venda na lista de vendas e retorna uma msg
        listaVendas.add(novo);
        JOptionPane.showMessageDialog(null, "Venda realizada");
    }
    // funcao para retornar a lista de vendas
    public ArrayList<Venda> getListaVendas() {
        return listaVendas;
    }
    // set para a lista de vendas
    // para jogar os dados de uma lista de vendas passada como parametro
    // para a lista de vendas dessa classe Controle
    public void setListaVendas(ArrayList<Venda> listaVendas) {
        this.listaVendas = listaVendas;
    }
    // funcao para retornar a lista de clientes
    public ArrayList<Cliente> getListaClient() {
        return listaClient;
    }
    // set para a lista de clientes
    // para jogar os dados de uma lista de clientes passada como parametro
    // para a lista de clientes dessa classe Controle
    public void setListaClient(ArrayList<Cliente> listaClient) {
        this.listaClient = listaClient;
    }
    // funcao para retornar a lista de produtos
    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }
    // set para a lista de produtos
    // para jogar os dados de uma lista de produtos passada como parametro
    // para a lista de produtos dessa classe Controle
    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
    
    public static void main(String s[]){
        new ControlePrincipal();
    }
}
