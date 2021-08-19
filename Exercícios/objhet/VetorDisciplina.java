
import java.util.ArrayList;
import javax.swing.*;

public class VetorDisciplina {

    private ArrayList<Disciplina> listaDisc = new ArrayList<Disciplina>();

    public void adicionaDisc() {
        String strCodigo, nome, strCarga;
        int codigo, carga;
        strCodigo = JOptionPane.showInputDialog("Digite o Codigo da Disciplina");
        nome = JOptionPane.showInputDialog("Digite o Nome da Disciplina");
        strCarga = JOptionPane.showInputDialog("Digite a carga hor da Disciplina");
        codigo = Integer.parseInt(strCodigo);
        carga = Integer.parseInt(strCarga);
        listaDisc.add(new Disciplina(codigo, nome, carga));
    }

    public void listaDisc() {
        String saidaStr = "Código\tnome\tCarga Horária\n";
        for (Disciplina d : listaDisc) {
            saidaStr += d.getCodigo() + "\t" + d.getNome() + "\t"
                    + d.getCargaHoraria() + "\n";
        }
        JTextArea saidaArea = new JTextArea();
        saidaArea.setText(saidaStr);
        JOptionPane.showMessageDialog(null, saidaArea, "Disciplinas cadastradas",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void consultaDisc() {
        String strCodigo;
        int codigo;

        strCodigo = JOptionPane.showInputDialog("Digite o Codigo da Disciplina");
        codigo = Integer.parseInt(strCodigo);

        String saidaStr = "Código\tnome\tCarga Horária\n";

        for (Disciplina d : listaDisc) {
            if (codigo == d.getCodigo()) {
                saidaStr += d.getCodigo() + "\t" + d.getNome() + "\t"
                        + d.getCargaHoraria() + "\n";
            }
        }
        JTextArea saidaArea = new JTextArea();
        saidaArea.setText(saidaStr);
        JOptionPane.showMessageDialog(null, saidaArea, "Disciplina buscada",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public void removeDisc() {
        String strCodigo, nome, strCarga;
        int codigo, carga;

        strCodigo = JOptionPane.showInputDialog("Digite o Codigo da Disciplina");
        codigo = Integer.parseInt(strCodigo);

        nome = JOptionPane.showInputDialog("Digite o Nome da Disciplina");

        strCarga = JOptionPane.showInputDialog("Digite o Carga da Disciplina");
        carga = Integer.parseInt(strCarga);

        for (int i = 0; i < listaDisc.size(); i++) {
            if (codigo == listaDisc.get(i).getCodigo()) {
                listaDisc.remove(i);
            }
        }

    }

    private void mostraMenu() {
        int escolha;
        do {
            do {
                String escolhaInformada
                        = JOptionPane.showInputDialog(
                                "Escolha uma opção do menu:\n"
                                + "[1] Adiciona disciplina\n"
                                + "[2] Lista disciplinas\n"
                                + "[3] Consulta disciplina \n"
                                + "[4] Remove disciplina \n"
                                + "[5] Finaliza");
                escolha = Integer.parseInt(escolhaInformada);
            } while ((escolha < 1) || (escolha > 5));
            if (escolha == 5) {
                System.exit(0);
            } else {
                execEscolha(escolha);
            }
        } while (true);
    }

    private void execEscolha(int escolha) {
        switch (escolha) {
            case 1: {
                adicionaDisc();
                break;
            }
            case 2: {
                listaDisc();
                break;
            }
            case 3: {
                consultaDisc();
                break;
            }
            case 4: {
                removeDisc();
                break;
            }
        }
    }

    public static void main(String[] args) {
        VetorDisciplina vd = new VetorDisciplina();
        vd.mostraMenu();
    }
}
