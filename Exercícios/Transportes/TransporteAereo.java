public abstract class TransporteAereo extends Transporte
{
    String nome="";
    int altitudeAtual=0,numeroPassageiros=0;
  
   public void subir(int metros)
   {
             altitudeAtual+=metros;
       
   }
     public void descer(int metros)
   {
      altitudeAtual-=metros; 
       
   }
   
    
}