public abstract class Professor {
    private String nome;
    public Professor(String pNome) {
        nome = pNome;
    }
    public String getNome(){
        return nome;
    }
    public abstract double getSalario();
}
