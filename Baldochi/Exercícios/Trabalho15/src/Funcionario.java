public abstract class Funcionario {
    private int nroFuncional;
    private String nome;
    

    public Funcionario(int nroFuncional, String nome) {
        this.nome = nome;
        this.nroFuncional = nroFuncional;
    }

    public String getNome() {
        return nome;
    }

    public int getNroFuncional() {
        return nroFuncional;
    }

}
