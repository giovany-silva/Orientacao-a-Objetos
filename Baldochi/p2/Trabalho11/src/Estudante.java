
public class Estudante {

    private int nroMatric;
    private String nome;

    public Estudante(int nroMatric, String nome) {
        this.nroMatric = nroMatric;
        this.nome = nome;
    }

    public int getNroMatric() {
        return nroMatric;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNroMatric(int nroMatric) {
        this.nroMatric = nroMatric;
    }
}
