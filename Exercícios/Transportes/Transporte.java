import java.util.*;
public abstract class Transporte
{
    String nome;
    int velocidadeAtual,numeroPassageiros;
    boolean Parado=true;
   
    boolean estaParado()
    {
        return Parado;
        
    }
    
}