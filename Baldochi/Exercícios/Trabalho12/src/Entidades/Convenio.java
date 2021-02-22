package Entidades;

public class Convenio extends Paciente {

    // atributos do paciente do tipo convenio
    private String nomeConvenio;
    private String nroCartao;

    // construtor do convenio, os primeiros parametros precisam ser passados na ordem do cosntrutor do super
    public Convenio(String pNome, String pEndereco, String pNomeConvenio, String pNroCartao) {
        super(pNome, pEndereco);
        nomeConvenio = pNomeConvenio;
        nroCartao = pNroCartao;
    }
    // get do nome do convenio do paciente do tipo convenio
    public String getNomeConvenio() {
        return nomeConvenio;
    }
    // get do numero do convenio do paciente do tipo convenio
    public String getNroCartao() {
        return nroCartao;
    }
    // funcao para calcular o faturamento em realcao aos pacientes do tipo convenio, precisa receber um mes como parametro
    @Override
    public double calculaFaturamento(int pMes) {
        // variavel para armazenar o faturamento
        double faturamento = 0;
        
        // for para pegar na super (paciente) as sessoes feitas por todos pacientes do tipo convenio
        for (Sessao s : super.getSessoes()) {
            // if para conferir se o mes passado como parametro eh igual ao mes na qual foi cadastrada a sessao
            if (s.getMes() == pMes) {
                // compara o tipo das sessoes e joga 60 por cento do valor na variavel "faturamento"
                if (s.getTipo().equals(Sessao.ORTOPEDICA)) {
                    faturamento += 30;
                } else if (s.getTipo().equals(Sessao.PILATES)) {
                    faturamento += 42;
                } else {
                    faturamento += 36;
                }
            }
        }
        // retorna a variavel faturamento
        return faturamento;
    }

}
