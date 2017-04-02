package reservas;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

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
        return horaInicio;
    }

    @Override
    public int getHoraFim() throws RemoteException {
        return horaFim;
    }

    @Override
    public Date getDia() throws RemoteException {
        return dia;
    }

    @Override
    public Espaço getEspaço() throws RemoteException {
        return espaço;
    }

    @Override
    public void setHoraInicio(int h) throws RemoteException {
        horaInicio = h;
    }

    @Override
    public void setHoraFim(int h) throws RemoteException {
        horaFim = h;
    }

    @Override
    public void setDia(Date d) throws RemoteException {
        dia = d;
    }

    @Override
    public void setEspaço(Espaço e) throws RemoteException {
        espaço = e;
    }
  
}
