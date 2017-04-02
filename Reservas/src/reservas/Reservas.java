package reservas;



import java.util.Date;


public interface Reservas extends java.rmi.Remote {

    public int getHoraInicio() throws java.rmi.RemoteException;

    public int getHoraFim() throws java.rmi.RemoteException;
    
    public Date getDia() throws java.rmi.RemoteException;
    
    public Espaço getEspaço() throws java.rmi.RemoteException;
    
    public void setHoraInicio(int h) throws java.rmi.RemoteException;

    public void setHoraFim(int h) throws java.rmi.RemoteException;
    
    public void setDia(Date d) throws java.rmi.RemoteException;
    
    public void setEspaço(Espaço E) throws java.rmi.RemoteException;

}