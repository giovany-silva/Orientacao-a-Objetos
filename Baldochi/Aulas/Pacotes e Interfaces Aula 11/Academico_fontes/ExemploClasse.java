
public class ExemploClasse {

    public static void main(String par[]) {

        Aluno objAluno = new Aluno();  
        Disciplina objDiscip1, objDiscip2;
        Disciplina vetDisc[] = new Disciplina[2];
       // Disciplina vetDisc[] = {new Disciplina("Programacao OO", 64), 
         //                       new Disciplina("Estrutura de Dados", 64)};

        objDiscip1 = new Disciplina("Programacao OO", 64);
        objDiscip2 = new Disciplina("Estrutura de Dados", 64);
        vetDisc[0] = objDiscip1;
        vetDisc[1] = objDiscip1;
        
        objAluno.setNome("Joao de Souza");
        objAluno.setEndereco("R das  Bromelias 222");
        objAluno.setIdade(19);
        objAluno.setSexo(Util.MASCULINO);
        objAluno.setCurso(Util.SI);
        objAluno.setDisciplina(vetDisc);
       
     //Obtém o conteúdo dos atributos Nome, Endereço e Idade e imprime esse
        //conteúdo para a saída padrão utilizando System.out.println();
        System.out.println("Nome: " + objAluno.getNome());
        System.out.println("Endereço: " + objAluno.getEndereco());
        System.out.println("Idade: " + objAluno.getIdade());
        System.out.println("Sexo: " + objAluno.getSexo());
        System.out.println("Curso: " + objAluno.getCurso());
        System.out.println("Disciplinas matriculadas: \n" + objAluno.getDisciplinas());

        System.out.println(objAluno.getDescricao());        
        
    }
}
