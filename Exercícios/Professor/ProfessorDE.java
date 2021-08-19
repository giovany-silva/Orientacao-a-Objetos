public class ProfessorDE extends Professor {
    private double salarioFixo;
    public ProfessorDE(String pNome, float pSalarioFixo) {
        super(pNome);
        salarioFixo = pSalarioFixo;
    }
    public double getSalario() {
        return salarioFixo;
    }
}
