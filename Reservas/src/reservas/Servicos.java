package reservas;


import java.sql.Timestamp;
import java.util.ArrayList;

public interface Servicos extends java.rmi.Remote {

    public ArrayList<String> listar_espacos() throws java.rmi.RemoteException;
    
    public boolean disponibilidade(String nomeEspaco, String data) throws java.rmi.RemoteException;
    
    public double reserva(String nome,String nomeEspaco,
            String dataInicio, String dataFim, int telefone, int numUtilizadores) throws java.rmi.RemoteException;
    
    public ArrayList<String> listar_reservas(String nomeEspaco) throws java.rmi.RemoteException;
}
