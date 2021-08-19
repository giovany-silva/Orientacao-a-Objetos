public class Paciente {

    private int nroSUS;
    private String nome;

    public Paciente(int nroSUS, String nome) {
        this.nome = nome;
        this.nroSUS = nroSUS;
    }

    public String getNome() {
        return nome;
    }

    public int getNroSUS() {
        return nroSUS;
    }
}
