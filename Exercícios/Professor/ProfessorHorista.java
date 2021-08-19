public class ProfessorHorista extends Professor {
    private double valorHoraAula;
    private int nroHorasTrab;    
    public ProfessorHorista(String pNome, double pValorHoraAula,              
                                          int pNroHorasTrab){
        super(pNome);
        valorHoraAula = pValorHoraAula;
        nroHorasTrab = pNroHorasTrab;
    }    
    public double getSalario(){
        return (double)valorHoraAula * nroHorasTrab;
    }
}
