import java.util.ArrayList;
import javax.swing.*;

// Uma classe de teste para a classe personagem e suas subclasses
public class TestaPersonagem {

    public static void main(String[] args) {

        /*
        // Instanciando e imprimindo o personagem 1, um personagem Controlavel
        Personagem personagem1 = new Controlavel("'Grul, o Bárbaro'", "Pedro");

        System.out.println("Nome: " + personagem1.getNomePersonagem());

        System.out.println(personagem1.getID());

        System.out.println();
        
        // Instanciando e imprimindo o personagem 2, um personagem nao Controlavel
        Personagem personagem2 = new NaoControlavel("'Adria'", "Vendedora de Pocoes");

        System.out.println("Nome: " + personagem2.getNomePersonagem());

        System.out.println(personagem2.getID());

        System.out.println();
        
        // Construir uma instancia de Personagem sem um tipo apresenta problemas
        Personagem personagemGenerico = new Personagem("Cort, o Arqueiro");

        System.out.println("Nome: " + personagemGenerico.getNomePersonagem());

        System.out.println(personagemGenerico.getID());
    */
        
    ArrayList<Personagem> cadPersonagem = new ArrayList<Personagem>();
    
    cadPersonagem.add(new Controlavel("Grul, o Bárbaro"," Pedro\n "));
    cadPersonagem.add(new NaoControlavel(" Adria "," Vendedora de Pocoes"));
    
    System.out.println("Nomes dos personagem:");
    
    String saidaStr = "Nomes dos Personagens\n";
    
    for(Personagem p : cadPersonagem){
    saidaStr += p.getNomePersonagem() + "\t" + p.getID();
    System.out.println("\n");
    }
    
    JTextArea saidaArea = new JTextArea();
    saidaArea.setText(saidaStr);
    JOptionPane.showMessageDialog(null, saidaArea, "Personagens", JOptionPane.INFORMATION_MESSAGE);
    }
}
    

