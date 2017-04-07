package reservas;



import java.util.Date;


public interface Reservas extends java.rmi.Remote {

    public int getHoraInicio() throws java.rmi.RemoteException;

    public int getHoraFim() throws java.rmi.RemoteException;
    
    public Date getDiaInicio() throws java.rmi.RemoteException;
   
    public Date getDiaFim() throws java.rmi.RemoteException;
    
    public Espaco getEspaco() throws java.rmi.RemoteException;
    
    public void setHoraInicio(int h) throws java.rmi.RemoteException;

    public void setHoraFim(int h) throws java.rmi.RemoteException;
    
    public void setDiaInicio(Date d) throws java.rmi.RemoteException;
    
    public void setDiaFim(Date d) throws java.rmi.RemoteException;
    
    public void setEspaco(Espaco E) throws java.rmi.RemoteException;
    
    public boolean availability(String espaco, int h, Date day);

}