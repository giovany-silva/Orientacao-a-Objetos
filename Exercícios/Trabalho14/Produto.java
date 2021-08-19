
public class Produto {
    // atributos do produto
    private int codigo;
    private String descricao;
    private double preco;

    // construtor do produto
    public Produto(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }
    // get do codigo do produto
    public int getCodigo() {
        return codigo;
    }
    // set do codigo do produto
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    // get da descricao do produto
    public String getDescricao() {
        return descricao;
    }
    // set da descricao do produto
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    // get do preco do produto
    public double getPreco() {
        return preco;
    }
    // set do preco do produto
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
