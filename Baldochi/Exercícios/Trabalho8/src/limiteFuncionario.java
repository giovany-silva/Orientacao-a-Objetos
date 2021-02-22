import javax.swing.JOptionPane;

public class limiteFuncionario {
    private controleFuncionario objCfuncionario;

    public limiteFuncionario(controleFuncionario objControleFuncionario) {
        this.objCfuncionario = objControleFuncionario;
        menu();
    }

    private void menu() {
        int escolha;
        do {
            do {
                String escolhaAux = JOptionPane.showInputDialog(
                        "Escolha uma opção:\n"
                        + "[1] Adicionar Funcionario\n"
                        + "[2] Inserir ponto\n"
                        + "[3] Lançar falta\n"
                        + "[4] Lançar atraso\n"
                        + "[5] Imprimir folha de pagamento\n"
                        + "[6] Sair");
                escolha = Integer.parseInt(escolhaAux);
            } while ((escolha < 1) || (escolha > 6));
            if (escolha != 6) {
                menuEscolha(escolha);
            } else {
                System.exit(0);
            }
        } while (true);
    }

    private void menuEscolha(int escolha) {
        switch (escolha) {
            case 1:
                cadastraFuncionario();
                break;
            case 2:
                cadastraPonto();
                break;
            case 3:
                lancaFalta();
                break;
            case 4:
                lancaAtraso();
                break;
            case 5:
                impFolha();
                break;
        }
    }

    private void cadastraFuncionario() {
        String retorno = JOptionPane.showInputDialog(
                "Escolha o tipo de funcionário:\n"
                + "[1] Professor\n"
                + "[2] Técnico Administrativo");
        int codigo = Integer.parseInt(retorno);
        do {
            switch (codigo) {
                case 1:
                    cadastraProf();
                    break;
                case 2:
                    cadastraTec();
                    break;
            }
        } while (codigo < 1 || codigo > 2);
    }

    private void cadastraProf() {
        String retorno = JOptionPane.showInputDialog(
                "Informe o código");
        int codigo = Integer.parseInt(retorno);
        String nome = JOptionPane.showInputDialog(
                "Informe o nome");
        String titulacao = JOptionPane.showInputDialog(
                "Informe a titulacao");
        String salarioHora = JOptionPane.showInputDialog(
                "Informe o valor Hora/Aula");
        double salario = Float.parseFloat(salarioHora);
        String horasAula = JOptionPane.showInputDialog(
                "Informe o numero de aulas ministradas");
        int horas = Integer.parseInt(horasAula);
        objCfuncionario.insereProfessor(codigo, nome, titulacao, salario, horas);
    }

    private void cadastraTec() {
        String retorno = JOptionPane.showInputDialog(
                "Informe o código");
        int codigo = Integer.parseInt(retorno);
        String nome = JOptionPane.showInputDialog(
                "Informe o nome");
        String funcao = JOptionPane.showInputDialog(
                "Informe a função");
        String salarioHora = JOptionPane.showInputDialog(
                "Informe o salario");
        double salario = Float.parseFloat(salarioHora);
        objCfuncionario.insereTecAdm(codigo, nome, funcao, salario);
    }

    private void cadastraPonto() {
        String cod = JOptionPane.showInputDialog(
                "Informe o código do funcionario");
        int codigo = Integer.parseInt(cod);
        String Mes = JOptionPane.showInputDialog(
                "Informe o mês");
        int mes = Integer.parseInt(Mes);
        String horasAula = JOptionPane.showInputDialog(
                "Informe o ano");
        int ano = Integer.parseInt(horasAula);
        objCfuncionario.inserePonto(codigo, mes, ano);
    }
    
    private void lancaFalta(){
        String cod = JOptionPane.showInputDialog(
                "Informe o código do funcionario");
        int codigo = Integer.parseInt(cod);
        String Mes = JOptionPane.showInputDialog(
                "Informe o mês");
        int mes = Integer.parseInt(Mes);
        String horasAula = JOptionPane.showInputDialog(
                "Informe o ano");
        int ano = Integer.parseInt(horasAula);
        String faltas = JOptionPane.showInputDialog(
                "Informe o numero de faltas");
        int numFaltas = Integer.parseInt(faltas);
        objCfuncionario.lancaFalta(codigo, mes, ano, numFaltas);
    }
    
    private void lancaAtraso(){
        String cod = JOptionPane.showInputDialog(
                "Informe o código do funcionario");
        int codigo = Integer.parseInt(cod);
        String Mes = JOptionPane.showInputDialog(
                "Informe o mês");
        int mes = Integer.parseInt(Mes);
        String horasAula = JOptionPane.showInputDialog(
                "Informe o ano");
        int ano = Integer.parseInt(horasAula);
        String faltas = JOptionPane.showInputDialog(
                "Informe o numero de atrasos");
        int numFaltas = Integer.parseInt(faltas);
        objCfuncionario.lancaAtraso(codigo, mes, ano, numFaltas);
    }

    private void impFolha() {
        String Mes = JOptionPane.showInputDialog(
                "Informe o mês");
        int mes = Integer.parseInt(Mes);
        String horasAula = JOptionPane.showInputDialog(
                "Informe o ano");
        int ano = Integer.parseInt(horasAula);
        objCfuncionario.buscaFolha(mes, ano);
    }

}