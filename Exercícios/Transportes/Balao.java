public class Balao extends TransporteAereo 
{
   int numlitros;
   
   float pesoLargada,temperatura;
    
    public void largarPeso(float pesoLargada)
    {
        this.pesoLargada=pesoLargada;
        
    }

  public void aquecerAr(float temperatura)
  {
      this.temperatura=temperatura;
  }
    
}
