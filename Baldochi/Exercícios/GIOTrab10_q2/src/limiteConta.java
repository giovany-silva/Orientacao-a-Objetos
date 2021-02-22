
import java.util.*;
import javax.swing.JOptionPane;

//tudo que estah com nextLine e println trocar por jOptionPane ,remover scanner
public class limiteConta {

    controleConta ctrConta;

    public limiteConta(controleConta objPcontroleConta) {
        ctrConta = objPcontroleConta;
        capturaDados();
    }

    public void capturaDados() {

        String escolhaInformada;
        int escolha;

        while (true) {
            
            
            escolhaInformada = JOptionPane.showInputDialog(null, "\n1-criar conta 2-deposito 3-saque 4 -trans 5- extrato 6- sair\n");
            escolha = Integer.parseInt(escolhaInformada);
            switch (escolha) {

                case 1: {
                    criaConta();
                    break;
                }

                case 2: {
                    fazDeposito();
                    break;
                }
                case 3: {
                    fazSaque();
                    break;
                }
                case 4: {
                    fazTransferencia();
                    break;
                }
                case 5: {
                    imprimeExtrato();
                    break;
                }
                case 6: {
                    sair();
                    break;
                }

            }

        }

    }

    public void criaConta() {
       

        int NroConta;

        String nomeCorrent;
        double limiteConta;
        
        

        String nroConta = JOptionPane.showInputDialog(null, "\nConta:\n");
        NroConta = Integer.parseInt(nroConta);
        
        nomeCorrent = JOptionPane.showInputDialog(null, "\nNome:\n");
        
        String LimiteConta = JOptionPane.showInputDialog(null, "\nLimite:\n");
        limiteConta = Double.parseDouble(LimiteConta);
        
        String senha = JOptionPane.showInputDialog(null, "\nSenha:\n");
        
        ctrConta.criaConta(NroConta, nomeCorrent, limiteConta, senha);
    }

    public void fazDeposito() {
        int NroConta;
        
        double Valor;
        Date Data = new Date();
        String NomeDep;
        String nroConta = JOptionPane.showInputDialog(null, "\nDigite o número da conta:\n");
        
        String valor = JOptionPane.showInputDialog(null, "\nDigite o valor:\n");
      
        
        NomeDep = JOptionPane.showInputDialog(null, "\nDigite o nome do depósito:\n");
        
        NroConta = Integer.parseInt(nroConta);
        Valor = Double.parseDouble(valor);;
        
        
        if (!ctrConta.realizaDeposito(NroConta, Valor, Data, NomeDep)) {

            JOptionPane.showMessageDialog(null, "\nNão foi possível realizar o depósito:\n");

        }//retorna um bool
    }

    public void fazSaque() {
        
        String nroConta = JOptionPane.showInputDialog(null, "\nDigite o número da conta:\n");

        Date Data = new Date();

        int NroConta = Integer.parseInt(nroConta);
        
        String valor = JOptionPane.showInputDialog(null, "\nDigite o valor:\n");

        double Valor = Double.parseDouble(valor);

        String Senha = JOptionPane.showInputDialog(null, "\nDigite a senha:\n");

        if (!ctrConta.realizaSaque(NroConta, Valor, Data, Senha)) {
            System.out.println("Nao foi possivel realizar saque!");

        }//retorna um bool  

    }

    public void fazTransferencia() {
        
        
        String nroContadeb = JOptionPane.showInputDialog(null, "\nDigite o número da conta debitada:\n");
        int NroContadeb = Integer.parseInt(nroContadeb);
        
        String nroContacred = JOptionPane.showInputDialog(null, "\nDigite o número da conta creditada:\n");
        int NroContacred = Integer.parseInt(nroContacred);
        
        String valor = JOptionPane.showInputDialog(null, "\nDigite o valor:\n");
        double Valor = Double.parseDouble(valor);
        
        Date Data = new Date();
        
        String Senha = JOptionPane.showInputDialog(null, "\nDigite a senha:\n");

        if (!ctrConta.realizaTransferencia(NroContadeb, NroContacred, Valor, Data, Senha)) {
            JOptionPane.showMessageDialog(null, "\nNão foi possível realizar a transferência:\n");
        }
    }

    public void imprimeExtrato() {
        
        String nroConta = JOptionPane.showInputDialog(null, "\nDigite o número da conta:\n");
        int NroConta = Integer.parseInt(nroConta);
        
        if (!ctrConta.imprimeExtrato(NroConta)) {
            JOptionPane.showMessageDialog(null, "\nNão foi possível imprimir o extrato:\n");

        }

    }

    public void sair() {
        JOptionPane.showMessageDialog(null, "\nSaindo do sistema:\n");
        try {
            Thread.sleep(5000);//coloquei soh para sair em 5s pfv nao coloquem isso
        } catch (InterruptedException ex) {
        }

        System.exit(0);
    }
}
