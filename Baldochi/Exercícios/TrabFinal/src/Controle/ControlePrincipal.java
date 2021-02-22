package Controle;

import Limite.LimitePrincipal;
import Limite.LimiteVendedor;
import Model.Corretor;
import Model.Imovel;
import Model.Proposta;
import Model.Util;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ControlePrincipal extends JFrame {

    ControleVendedor controleVendedor;
    ControleComprador controleComprador;
    ControleCorretor controleCorretor;
    ControleImovel controleImovel;
    //pega o arraylist de proposta da classe imovel
   
    //atentar ao JPanel retornado

    //= new JMenu("Turma");
    public ControlePrincipal() {

         controleComprador = new ControleComprador(this);
        controleCorretor = new ControleCorretor(this);
        controleImovel = new ControleImovel(this);
        controleVendedor = new ControleVendedor(this);
        
        new LimitePrincipal(this);

    }

    public ControleVendedor getInstanciaControleVendedor() {
        return controleVendedor;
    }

    public ControleComprador getInstanciaControleComprador() {
        return controleComprador;
    }

    public ControleCorretor getInstanciaControleCorretor() {
        return controleCorretor;
    }

    public ControleImovel getInstanciaControleImovel() {
        return controleImovel;
    }


 

    public static void main(String[] args) {

        new ControlePrincipal();

    }
}
