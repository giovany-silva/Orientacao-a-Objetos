package Entidades;

public class Convenio extends Paciente {

    private String nomeConvenio;
    private String nroCartao;

    public Convenio(String pNome, String pEndereco, String pNomeConvenio, String pNroCartao) {
        super(pNome, pEndereco);
        nomeConvenio = pNomeConvenio;
        nroCartao = pNroCartao;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public String getNroCartao() {
        return nroCartao;
    }

    @Override
    public double calculaFaturamento(int pMes) {
        double faturamento = 0;

        for (Sessao s : super.getSessoes()) {
            if (s.getMes() == pMes) {
                if (s.getTipo().equals(Sessao.ORTOPEDICA)) {
                    faturamento += 30;
                } else if (s.getTipo().equals(Sessao.PILATES)) {
                    faturamento += 42;
                } else {
                    faturamento += 36;
                }
            }
        }

        return faturamento;
    }

}
