import java.util.ArrayList;
import java.util.Calendar;

public class Cirurgia {

    private Paciente paciente;
    private String tipoCirurgia;
    private ArrayList<Funcionario> listaFun;
    private Calendar data;

    public Cirurgia(Paciente paciente, String tipoCirurgia, ArrayList<Funcionario> listaFun) {
        this.paciente = paciente;
        this.tipoCirurgia = tipoCirurgia;
        this.listaFun = listaFun;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getTipoCirurgia(){
        return tipoCirurgia;
    }
    
    public ArrayList<Funcionario> getListaFun() {
        return listaFun;
    }

    public void marcaData(Calendar data){
        this.data = data;
    }
    
}
