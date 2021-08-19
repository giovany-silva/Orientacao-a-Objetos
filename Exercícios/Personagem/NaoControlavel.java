// Define a classe de personagem NAO CONTROLAVEL, subclasse de Personagem

public class NaoControlavel extends Personagem {

    private String iaID;

// Constructor
    public NaoControlavel(String nomePersonagem, String iaID) {
        super(nomePersonagem);
        this.iaID = iaID;
    }

    @Override
    public String getNomePersonagem() {
        return "Personagem NÃO Controlável " + super.getNomePersonagem();
    }

    @Override
    public String getID() {
        return " Inteligencia Artifical do Tipo: " + iaID;
    }
}
