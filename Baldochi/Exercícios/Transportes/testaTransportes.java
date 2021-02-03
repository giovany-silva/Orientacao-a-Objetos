import java.util.*;
public class testaTransportes
{
    
    public static void main()
    {
        ArrayList<Motorizado>A1=new ArrayList<Motorizado>();
        ArrayList<Conduzivel>A2=new ArrayList<Conduzivel>();
        Aviao a=new Aviao();


        A1.add(a);
        
        
        Carro c=new Carro();

        A1.add(c);
        
        
        for(Motorizado m: A1)m.ligarMotor();
        
        Bicicleta b=new Bicicleta();
        
        A2.add(c);// carro tbm eh Conduzivel
        A2.add(a);//aviao tbm eh
         for(Conduzivel con: A2)con.curvar(10.0f);
        
    }
    
    
    
}