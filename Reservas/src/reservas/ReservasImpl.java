package reservas;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Vector;

public class ReservasImpl extends UnicastRemoteObject implements Reservas, java.io.Serializable {

    int horaInicio;
    int horaFim;
    Date dia;
    Espaço espaço;
    
    public ReservasImpl() throws java.rmi.RemoteException {}
    
    public ReservasImpl(int horaInicio, int horaFim, Date dia, Espaço e) throws java.rmi.RemoteException {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.dia = dia;
        espaço = e;
    }

   
   /* public boolean espaçoLivre(ReservasImpl[] listaReservas,String nomeEspaço, int hora) throws RemoteException {
       boolean result = true;
       
          for (ReservasImpl reserva:listaReservas){
               if(reserva.espaço.getNome().equals(nomeEspaço) && reserva.horaInicio == hora){
                   result = false;
                   break;
               }
           }
      
       return result;
    }

    
    public void getEspacos(Vector<Reservas> s) throws RemoteException {
        
    }

    
    public void addReserva(String nome, Date dia) throws RemoteException {
        
    }

    
    public Reservas[] getReservas(String nome) throws RemoteException {
        return null;
       
    }
*/

    @Override
    public int getHoraInicio() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHoraFim() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getDia() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Espaço getEspaço() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHoraInicio(int h) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHoraFim(int h) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDia(Date d) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEspaço(Espaço E) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
