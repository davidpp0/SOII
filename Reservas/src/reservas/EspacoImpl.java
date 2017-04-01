package reservas;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EspacoImpl extends UnicastRemoteObject implements Espaco, java.io.Serializable {
    String name;
    int cost;
    
public EspacoImpl (String name, int cost) throws RemoteException{
    name= name;
    cost= cost;
}
    @Override
    public String getName() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCost() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCost() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
