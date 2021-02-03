package Controladores;

import Entidades.*;
import Limites.*;
import java.util.ArrayList;

public class ControlePaciente {

    private ArrayList<Paciente> objPacientes;

    public ControlePaciente() {
        objPacientes = new ArrayList<>();
        new LimitePaciente(this);
    }

    public void adicionaParticular(String pNome, String pEndereco, String pCpf) {
        objPacientes.add(new Particular(pNome, pEndereco, pCpf));
    }

    public void adicionaConvenio(String pNome, String pEndereco, String pNomeConvenio, String pNroCartao) {
        objPacientes.add(new Convenio(pNome, pEndereco, pNomeConvenio, pNroCartao));
    }

    public Paciente buscaPaciente(String pDado) {
        Paciente pac = null;
        for (Paciente p : objPacientes) {
            if (p instanceof Convenio) {
                Convenio conv = (Convenio) p;

                if (conv.getNroCartao().equals(pDado)) {
                    pac = p;
                    break;
                }
            } else {
                Particular part = (Particular) p;

                if (part.getCpf().equals(pDado)) {
                    pac = p;
                    break;
                }
            }
        }

        return pac;
    }

    public void cadastraSessao(Paciente pac, int pDia, int pMes, String pTipo) throws Exception {
        for (Paciente p : objPacientes) {
            if (p.equals(pac)) {
                ArrayList aux = p.getSessoes();
                aux.add(new Sessao(pDia, pMes, pTipo));
            }
        }
    }

    public void interfaceAddSessao() {
        new LimiteAdicaoSessao(this);
    }

    public void interfaceCadastroConvenio() {
        new LimiteCadastroConvenio(this);
    }

    public void interfaceCadastroParticular() {
        new LimiteCadastroParticular(this);
    }

    public void interfaceExibicaoFicha() {
        new LimiteImpressaoFicha(this);
    }

    public void interfaceExibicaoFaturamento() {
        new LimiteFaturamento(this);
    }

    public ArrayList<Paciente> getObjPacientes() {
        return objPacientes;
    }

}
