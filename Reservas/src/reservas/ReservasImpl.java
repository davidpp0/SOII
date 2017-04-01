package reservas;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class ReservasImpl extends UnicastRemoteObject implements Reservas, java.io.Serializable {

    Vector<String> listaReservas = new Vector();
    
    public ReservasImpl() throws java.rmi.RemoteException {
        super();
    }

     @Override
    public int getNumReservas(Vector<String> s) throws RemoteException {
         String[] lista = (String[]) s.toArray();
         return lista.length;
             
    }

    @Override
    public String[] getReservas(Vector<String> s) throws RemoteException {
        String[] lista = (String[]) s.toArray();
        return lista;
    }

    @Override
    public void addReserva(String s) throws RemoteException {
        listaReservas.add(s);
    }

}
