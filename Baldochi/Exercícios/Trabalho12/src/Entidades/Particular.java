package Entidades;

public class Particular extends Paciente {

    // atributo do paciente particular
    private String cpf;

    // construtor do particular, os primeiros parametros passados na ordem que estao no construtor da super
    public Particular(String pNome, String pEndereco, String pCpf) {
        super(pNome, pEndereco);
        cpf = pCpf;
    }
    // get do cpf do particular
    public String getCpf() {
        return cpf;
    }

    // funcao para calcular faturamento em relacao aos pacientes particulares, precisa receber um mes como parametro
    @Override
    public double calculaFaturamento(int pMes) {
        // variavel para armazenar o valor do faturamento
        double faturamento = 0;

        // for para pegar na super (paciente) as sessoes feitas por todos os pacientes do tipo particular
        for (Sessao s : super.getSessoes()) {
            // if para conferir se o mes passado como parametro eh igual ao mes na qual foi cadastrada a sessao
            if (s.getMes() == pMes) {
                // se o mes estiver correto, compara os tipos de sessoes e add seu respectivo valor no faturamento
                if (s.getTipo().equals(Sessao.ORTOPEDICA)) {
                    faturamento += 50;
                } else if (s.getTipo().equals(Sessao.PILATES)) {
                    faturamento += 70;
                } else {
                    faturamento += 60;
                }
            }
        }
        // retorna o faturamento
        return faturamento;
    }
}
