public class Tecnico extends Funcionario{
    private String funcao;

    public Tecnico(int nroFuncional, String nome, String funcao) {
        super(nroFuncional, nome);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }
    
}
