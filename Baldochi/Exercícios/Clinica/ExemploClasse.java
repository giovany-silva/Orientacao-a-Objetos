public class ExemploClasse {

 public static void main(String[] args) {

   Paciente p1 = new Paciente("Joao Silva", "Av BPS, 1454", Util.MASCULINO, 34, 1001);
   Paciente p2 = new Paciente("Pedro Santos", "R. Nova, 876", Util.MASCULINO, 23, 1002);
   Paciente p3 = new Paciente("Rafael Souza", "R Mario Braz, 234", Util.MASCULINO, 29, 1003);
   Paciente p4 = new Paciente("Marina Carvalho", "Av BPS, 298", Util.FEMININO, 45, 1004);
   Paciente p5 = new Paciente("Silvia Cruz", "Av Pres Vargas, 345", Util.FEMININO, 22, 1005);

   Paciente[] listaPac1 = {p1, p2, p3};
   Paciente[] listaPac2 = {p4, p5};

   Medico m1 = new Medico("Mario Silveira", "R. Olavo Bilac, 367", Util.MASCULINO,
                43, Util.CARDIO, listaPac1);
   Medico m2 = new Medico("Suzana Cunha", "R. Francisco Masseli, 255", Util.FEMININO,
                47, Util.PEDIATRA, listaPac2);

   System.out.println(m1.getDescricao());
   System.out.println("Especialidade: " + m1.getEspecialidade());
   System.out.println("Pacientes");
   System.out.println(m1.listaPacientes());
        
   System.out.println("\n");
        
   System.out.println(m2.getDescricao());
   System.out.println("Especialidade: " + m2.getEspecialidade());
   System.out.println("Pacientes");
   System.out.println(m2.listaPacientes());        

    }
}
