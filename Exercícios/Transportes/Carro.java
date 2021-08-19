public class Carro extends TransporteTerrestre implements Motorizado,Conduzivel
{
  int numlitros;

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
   void embrear()
   {
       
       System.out.println("Embreando!\n");
   }
}