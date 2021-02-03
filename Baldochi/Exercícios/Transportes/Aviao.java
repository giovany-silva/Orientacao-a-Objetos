public class Aviao extends TransporteAereo implements Motorizado,Conduzivel
{
   int numlitros,numMotores;
    
    public void ligarMotor()
    {
    boolean Parado=false;
    }
    public void abastecer(int numlitros)
    {
        this.numlitros=numlitros;
    }
    public void curvar(float angulo)
    {
        
     System.out.println("angulo de curvatura! :"+angulo+"\n");  
    }
    
}
