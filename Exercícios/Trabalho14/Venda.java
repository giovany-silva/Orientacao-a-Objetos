
import java.util.Date;

public class Venda {
    // obj do tipo Produto
    private Produto produto = null;
    // obj do tipo Cliente
    private Cliente cliente = null;
    // atributos da venda
    private int quantidade = 0;
    private Date d;
    // variavel para verificar se existe cliente
    private boolean existeCliente = false;
    
    // construtor da Venda
    public Venda(Produto p, Cliente c, int quant){
        d = new Date();
        produto = p;
        cliente = c;
        quantidade = quant;
    }
    // get da data da Venda
    public Date getD() {
        return d;
    }
    // set da data da Venda
    public void setA(Date d) {
        this.d = d;
    }
    // get da quantidade da Venda
    public int getQuantidade() {
        return quantidade;
    }
    // set da quantidade da Venda
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    // get para retornar se existe cliente
    public boolean isExisteCliente() {
        return existeCliente;
    }
    // set do existeCliente
    public void setExisteCliente(boolean existeCliente) {
        this.existeCliente = existeCliente;
    }
    // get do produto da Venda
    public Produto getProduto() {
        return produto;
    }
    // set da produto da Venda
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    // get do cliente da Venda
    public Cliente getCliente() {
        return cliente;
    }
    // set do cliente da Venda
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    
}
