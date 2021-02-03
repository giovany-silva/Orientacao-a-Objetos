// Define a super classe Personagem

public abstract class Personagem {

    private String nomePersonagem;

    // Construtor
    public Personagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public String getID() {
        System.out.println("ERRO: Tipo desconhecido! Nao podemos definir o ID!!!");
        return "";
    }
}
