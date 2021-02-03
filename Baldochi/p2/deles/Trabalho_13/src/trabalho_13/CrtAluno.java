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

    ArrayList<Aluno> arrayAluno = new ArrayList<>();

    public CrtAluno() throws Exception {
        desserializaCorretor();
        new LimiteAluno(this);
    }

    public boolean CriaAluno(String nome, String nroMatricula, int dia, int mes, int ano) {
        Aluno novo = new Aluno(nome, nroMatricula, dia, mes, ano);
        arrayAluno.add(novo);
        return true;
    }

    public String Listagem(){
        String re = (" ");
        if (arrayAluno.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não tem alunos cadastrados!");
        } else {
            for (int i = 0; i < arrayAluno.size(); i++) {
                re += ("\nNOME: " + arrayAluno.get(i).getNome() + "      MATRICULA:" + arrayAluno.get(i).getNroMatricula());
            }
        }
        return re;
    }

    // Faz a leitura do arquivo que contem os corretores
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
    private void serializaCorretor() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("alunos.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(arrayAluno);
        objOS.flush();
        objOS.close();
    }

    public void finalize() throws Exception {
        serializaCorretor();
    }

    public static void main(String[] args) throws Exception {
        CrtAluno ctrPrinc = new CrtAluno();
    }
}
