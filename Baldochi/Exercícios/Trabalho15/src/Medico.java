public class Medico extends Funcionario {
    private String especialidade;

    public Medico(int nroFuncional, String nome, String especialidade) {
        super(nroFuncional, nome);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    
}
