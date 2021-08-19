public class Bicicleta extends TransporteTerrestre implements Conduzivel
{
 
 
    
    
    public void curvar(float angulo)
    {
        
      System.out.println("angulo de curvatura! :"+angulo+"\n");
    }
   public void pedalar()
   {
       System.out.println("pedalando!\n");
       
   }
}