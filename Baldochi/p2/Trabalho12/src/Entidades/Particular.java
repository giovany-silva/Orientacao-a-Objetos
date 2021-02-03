package Entidades;

public class Particular extends Paciente {

    private String cpf;

    public Particular(String pNome, String pEndereco, String pCpf) {
        super(pNome, pEndereco);
        cpf = pCpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public double calculaFaturamento(int pMes) {
        double faturamento = 0;

        for (Sessao s : super.getSessoes()) {
            if (s.getMes() == pMes) {
                if (s.getTipo().equals(Sessao.ORTOPEDICA)) {
                    faturamento += 50;
                } else if (s.getTipo().equals(Sessao.PILATES)) {
                    faturamento += 70;
                } else {
                    faturamento += 60;
                }
            }
        }

        return faturamento;
    }
}
