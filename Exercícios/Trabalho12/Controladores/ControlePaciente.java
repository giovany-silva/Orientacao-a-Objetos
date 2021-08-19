package Controladores;

import Entidades.*;
import Limites.*;
import java.util.ArrayList;

public class ControlePaciente {
    // ArrayList do tipo Paciente para armazenar pacientes
    private ArrayList<Paciente> objPacientes;

    // construtor do ControlePaciente
    public ControlePaciente() {
        objPacientes = new ArrayList<>();
        new LimitePaciente(this);
    }
    // funcao para adicionar um paciente do tipo particular, parametros precisam ser passados na mesma
    // ordem do construtor Particular
    public void adicionaParticular(String pNome, String pEndereco, String pCpf) {
        // cria um novo paciente Particular e add no ArrayList de pacientes
        objPacientes.add(new Particular(pNome, pEndereco, pCpf));
    }
    // funcao para adicionar um paciente do tipo convenio, parametros precisam ser passados na mesma
    // ordem do construtor Convenio
    public void adicionaConvenio(String pNome, String pEndereco, String pNomeConvenio, String pNroCartao) {
        // cria um novo paciente Convenio e add no ArrayList de pacientes
        objPacientes.add(new Convenio(pNome, pEndereco, pNomeConvenio, pNroCartao));
    }

    // funcao para buscar paciente, precisa passar um dado como parametro, que sera um cpf ou nroCartao
    public Paciente buscaPaciente(String pDado) {
        // criacao de uma variavel "pac" do tipo Paciente
        Paciente pac = null;
        // for para varrer o ArrayList de pacientes
        for (Paciente p : objPacientes) {
            // if para ver se o paciente eh do tipo Convenio
            if (p instanceof Convenio) {
                // criacao de uma variavel "conv" para este paciente e joga os dados de p nela
                // esta variavel "conv" sera usada para comparar o nroCartao desse paciente especifico, no if abaixo
                Convenio conv = (Convenio) p;
                
                // if para verificar se o nroCartao do Convenio eh igual ao do Dado passado como parametro
                if (conv.getNroCartao().equals(pDado)) {
                    // se o nroCartao for igual passa o paciente p para a variavel pac
                    pac = p;
                    break;
                }
            } 
            // se nao for Convenio eh Particular
            else {
                // criacao de uma variavel "part" para este paciente e joga os dados de p nela
                // esta variavel "part" sera usada para comparar o cpf desse paciente especifico, no if abaixo
                Particular part = (Particular) p;

                // if para verificar se o cpf do Particular eh igual ao do Dado passado como parametro
                if (part.getCpf().equals(pDado)) {
                    // se o cpf for igual passa o paciente p para a variavel pac
                    pac = p;
                    break;
                }
            }
        }
        // retorna a variavel pac com o paciente
        return pac;
    }

    // funcao para cadastrar uma sessao
    public void cadastraSessao(Paciente pac, int pDia, int pMes, String pTipo) throws Exception {
        // for para verrer o ArrayList de pacientes
        for (Paciente p : objPacientes) {
            // if para confirmar se algum paciente da lista eh igual ao paciente passado como parametro
            if (p.equals(pac)) {
                // ArrayList aux usado para pegar as sessoes do paciente p
                ArrayList aux = p.getSessoes();
                
                // cria e add uma nova sessao no ArrayList (aux) que contem as sessoes do paciente especifico
                // precisa passar os parametros da sessao na mesma ordem que estao no construtor da Sessao
                aux.add(new Sessao(pDia, pMes, pTipo));
            }
        }
    }
    // funcao para chamar o limite que faz a interface de adicionar sessao
    public void interfaceAddSessao() {
        new LimiteAdicaoSessao(this);
    }
    // funcao para chamar o limite que faz a interface de cadastrar convenio
    public void interfaceCadastroConvenio() {
        new LimiteCadastroConvenio(this);
    }
    // funcao para chamar o limite que faz a interface de cadastrar Particular
    public void interfaceCadastroParticular() {
        new LimiteCadastroParticular(this);
    }
    // funcao para chamar o limite que faz a interface de exibicao de ficha
    public void interfaceExibicaoFicha() {
        new LimiteImpressaoFicha(this);
    }
    // funcao para chamar o limite que faz a interface de exibicao de faturamento
    public void interfaceExibicaoFaturamento() {
        new LimiteFaturamento(this);
    }
    // funcao para retornar o ArrayList com os pacientes
    public ArrayList<Paciente> getObjPacientes(){
        return objPacientes;
    }

}
