
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class LimiteVendedor {

    private ControleVendedor objCtrVendedor;

    public LimiteVendedor(ControleVendedor objControleVendedor) {
        this.objCtrVendedor = objControleVendedor;
        menu();
    }

    private void menu() {
        int escolha;
        do {
            do {
                String escolhaAux = JOptionPane.showInputDialog(
                        "Escolha uma opção:\n"
                        + "[1] Adicionar Vendedor\n"
                        + "[2] Inserir Venda\n"
                        + "[3] Imprimir folha de pagamento\n"
                        + "[4] Sair");
                escolha = Integer.parseInt(escolhaAux);
            } while ((escolha < 1) || (escolha > 4));
            if (escolha != 4) {
                menuEscolha(escolha);
            } else {
                System.exit(0);
            }
        } while (true);
    }

    private void menuEscolha(int escolha) {
        switch (escolha) {
            case 1:
                cadastraVendedor();
                break;
            case 2:
                cadastraVendas();
                break;
            case 3:
                impFolha();
                break;
        }
    }

    private void cadastraVendedor() {
        String retorno = JOptionPane.showInputDialog(
                "Escolha o tipo de vendedor:\n"
                + "[1] Comissionado\n"
                + "[2] Contratado");
        int codigo = Integer.parseInt(retorno);
        do {
            switch (codigo) {
                case 1:
                    cadastraComissionado();
                    break;
                case 2:
                    cadastraContratado();
                    break;
            }
        } while (codigo < 1 || codigo > 2);
    }

    private void cadastraComissionado() {
        String nome = JOptionPane.showInputDialog("Insira o nome");
        String cpf = JOptionPane.showInputDialog("Insira o número do CPF");
        String cod = JOptionPane.showInputDialog("Insisa o código");
        int codigo = Integer.parseInt(cod);


        String comis = JOptionPane.showInputDialog("Insira a comissão");
        float comissao = Float.parseFloat(comis);
        objCtrVendedor.insereComissionado(codigo, nome, cpf, comissao);
    }

    private void cadastraContratado() {
        String cod = JOptionPane.showInputDialog("Insira o código");
        int codigo = Integer.parseInt(cod);
        String nome = JOptionPane.showInputDialog("Insira o nome");
        String sal = JOptionPane.showInputDialog("Insira o salário fixo");
        double salarioFixo = Float.parseFloat(sal);
        String nroCartTrabalho = JOptionPane.showInputDialog("Insira o número da carteira de trabalho");
        objCtrVendedor.insereContratado(codigo, nome, salarioFixo, nroCartTrabalho);
    }

    private void cadastraVendas() {
        String Cod = JOptionPane.showInputDialog("Insira o código do vendedor");
        int codigo = Integer.parseInt(Cod);
        String cod = JOptionPane.showInputDialog("Insira o código do imóvel");
        int codImovel = Integer.parseInt(cod);
        String Mes = JOptionPane.showInputDialog("Insira o mês");
        int mes = Integer.parseInt(Mes);
        String Ano = JOptionPane.showInputDialog("Insira o ano");
        int ano = Integer.parseInt(Ano);
        String val = JOptionPane.showInputDialog("Insira o valor");
        double valor = Float.parseFloat(val);
        objCtrVendedor.insereVenda(codigo, codImovel, mes, ano, valor);
    }

    private void impFolha() {
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Insira o mês"));
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Insira o ano"));
        JTextArea rendaVendedores = objCtrVendedor.imprimeFolha(mes, ano);
        JOptionPane.showMessageDialog(null, rendaVendedores, "Renda dos Vendedores", 1);
    }
}
