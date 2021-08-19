// Define a classe de personagem CONTROLAVEL, subclasse de Personagem

public class Controlavel extends Personagem {

    private String jogadorID;

// Constructor
    public Controlavel(String nomePersonagem, String jogadorID) {
        super(nomePersonagem);
        this.jogadorID = jogadorID;
    }

    @Override
    public String getNomePersonagem() {
        return "Personagem Controlável " + super.getNomePersonagem();
    }

    @Override
    public String getID() {
        return " Nome do Jogador: " + jogadorID;
    }
}
