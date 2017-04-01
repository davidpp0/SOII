package reservas;

import java.util.Vector;

public interface Reservas extends java.rmi.Remote {

    public int getNumReservas(Vector<String> s) throws java.rmi.RemoteException;

    public String[] getReservas(Vector<String> s) throws java.rmi.RemoteException;
    
    public void addReserva(String s) throws java.rmi.RemoteException;

}