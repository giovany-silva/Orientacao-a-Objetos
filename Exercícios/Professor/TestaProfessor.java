import java.util.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class TestaProfessor {
    public static void main(String args[]){
        
        ArrayList<Professor> listaProf = new ArrayList<Professor>();
        
        
         String nome="";
        
        int option=0,horas_trabalhadas;
        
         float salario;
         
        double valor_por_hora;     
        
       while(true)
       {
           option=Integer.parseInt(JOptionPane.showInputDialog("Deseja Cadastrar um novo professor?: 1-yes 2-No"));
         
           if(option==2)break;
          else nome = JOptionPane.showInputDialog("Digite o Nome do Professor");
           option= Integer.parseInt(JOptionPane.showInputDialog("1-ProfesorDE 2-ProfessorHorista."));
         
           switch(option)
          {
             
              
              case 1:{
                  salario=Float.parseFloat(JOptionPane.showInputDialog("Digite o Salário do Professor"));
                  
                  salario*=1.11; // 11% a mais para DEs 
                  
                  listaProf.add(new ProfessorDE( nome, salario));
                  break;
                }
                case 2:{
                    
                    horas_trabalhadas=Integer.parseInt(JOptionPane.showInputDialog("Digite o número de horas trabalhadas"));
                    

                    valor_por_hora=Double.parseDouble(JOptionPane.showInputDialog("Digite o valor pago por hora")); 

                  listaProf.add(new ProfessorHorista(nome,valor_por_hora, horas_trabalhadas));
                  break;
                }
                
          }
           
              
     
       }
       imprime_lista_de_prof(listaProf);
       
    }    
  
    public static void imprime_lista_de_prof(ArrayList<Professor> listaProf)
    {
        String text="Nome:              Salario:\n";
     
        DecimalFormat decimal = new DecimalFormat("0.00");
        double Salario;
        
        for(Professor p: listaProf)
        {
            Salario=p.getSalario();
        
      if(Salario>=1903.99 && Salario<=2826.65)Salario*=0.925;
      
      else if(Salario>2826.65&&Salario<=3751.06)Salario*=0.85;
      
      else if(Salario>3751.06&&Salario<=4664.68)Salario*=0.775;
    
      else Salario*=0.725;
 
     text+=p.getNome()+"              "+decimal.format(Salario)+"\n";
        
        }
           JOptionPane.showMessageDialog(null, text);
    
    
    }


}