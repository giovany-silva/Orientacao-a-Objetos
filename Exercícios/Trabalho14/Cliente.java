
public class Cliente {
    // atributos do cliente
    private String nome;
    private String CPF;
    private int idade;

    // construtor do cliente
    public Cliente(String cpf, String nome, int idade) {
        this.CPF = cpf;
        this.nome = nome;
        this.idade = idade;
    }
    // get do cpf do cliente
    public String getCpf() {
        return CPF;
    }
    // set do cpf do cliente
    public void setCpf(String cpf) {
        this.CPF = cpf;
    }
    // get do nome do cliente
    public String getNome() {
        return nome;
    }
    // set do nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }
    // get da idade do cliente
    public int getIdade() {
        return idade;
    }
    // set da idade do cliente
    public void setIdade(int idade) {
        this.idade = idade;
    }

}
