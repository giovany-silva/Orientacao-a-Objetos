
public class Disciplina {
    private String nomeDis;
    private int cargaHoraria;

    public Disciplina(String pnomeDis, int pcargaHoraria) {
        nomeDis = pnomeDis;
        cargaHoraria = pcargaHoraria;
    }

    public String getDescricao() {
        return "  Disciplina: " + nomeDis + "  Carga Horária: " + cargaHoraria;
    }
}
