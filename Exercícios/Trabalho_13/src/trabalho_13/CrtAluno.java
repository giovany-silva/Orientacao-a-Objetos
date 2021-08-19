package trabalho_13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CrtAluno {

    // ArrayList responsavel em manter os dados dos alunos cadastrados
    ArrayList<Aluno> arrayAluno = new ArrayList<>();
    
    // construtor da CtrAluno
    public CrtAluno() throws Exception {
        // chama a funcao que le os arquivos que contem os alunos
        desserializaCorretor();
        
        // da um new LimiteAluno para a classe controle receber os dados digitados
        // nos paineis, que estao na Limite
        new LimiteAluno(this);
    }

    // funcao do tipo boolean para criar aluno, precisa receber os dados do aluno
    // item i: composicao de dados de um aluno
    public boolean CriaAluno(String nome, String nroMatricula, int dia, int mes, int ano) {
        // criacao de uma variavel "novo" do tipo aluno, e da um new para criar um novo aluno
        Aluno novo = new Aluno(nome, nroMatricula, dia, mes, ano);
        
        // pega a variavel "novo" e adiciona no ArrayList arrayAluno
        arrayAluno.add(novo);
        
        // caso as duas linhas de cima executarem corretamente, a funcao retorna true
        return true;
    }

    // funcao do tipo string para listar os alunos
    // item ii: composicao da lista de alunos utilizando o ArrayList
    public String Listagem(){
        // declaracao de uma variavel "re" do tipo String, para printar os alunos cadastrados
        String re = (" ");
        
        // if para o caso do ArrayList estar vazio
        if (arrayAluno.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não tem alunos cadastrados!");
        } 
        // caso o ArrayList nao esteja vazio
        else {
            // for para percorrer o ArrayList de alunos
            for (int i = 0; i < arrayAluno.size(); i++) {
                // ao encontrar o aluno, pega seus dados e coloca na string "re"
                re += ("\nNOME: " + arrayAluno.get(i).getNome() + "      MATRICULA:" + arrayAluno.get(i).getNroMatricula());
            }
        }
        // retorna a string "re"
        return re;
    }

    // Faz a leitura do arquivo que contem os corretores
    // Funcao para fazer a leitura do arquivo que contem os alunos
    // Seguir esse padrao, tomar cuidado com o nome e o tipo do ArrayList
    private void desserializaCorretor() throws Exception {
        File objFile = new File("alunos.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("alunos.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            arrayAluno = (ArrayList<Aluno>) objIS.readObject();
            objIS.close();
        }
    }

    // Salva os corretores no arquivo 
    // Funcao para salvar os alunos em um arquivo
    // Seguir esse padrao, tomar cuidado com o nome e o tipo do ArrayList
    private void serializaCorretor() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("alunos.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(arrayAluno);
        objOS.flush();
        objOS.close();
    }
    
    // Funcao que ao terminar, chama a funcao "serializaCorretor" que grava os alunos em um arquivo
    public void finalize() throws Exception {
        serializaCorretor();
    }

    public static void main(String[] args) throws Exception {
        // cria uma variavel do tipo CtrAluno e da um new CtrAluno
        CrtAluno ctrPrinc = new CrtAluno();
    }
}
