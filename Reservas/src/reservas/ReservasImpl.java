package reservas;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class ReservasImpl extends UnicastRemoteObject implements Reservas, java.io.Serializable {

    int horaInicio;
    int horaFim;
    Date dia;
    Espaco espaco;
    
    public ReservasImpl() throws java.rmi.RemoteException {}
    
    public ReservasImpl(int horaInicio, int horaFim, Date dia, Espaco e) throws java.rmi.RemoteException {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.dia = dia;
        espaco = e;
    }

   
   /* public boolean espacoLivre(ReservasImpl[] listaReservas,String nomeEspaco, int hora) throws RemoteException {
       boolean result = true;
       
          for (ReservasImpl reserva:listaReservas){
               if(reserva.espaco.getNome().equals(nomeEspaco) && reserva.horaInicio == hora){
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

  
    public Espaco getEspaco() throws RemoteException {
        return espaco;
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

    
    public void setEspaco(Espaco e) throws RemoteException {
        espaco = e;
    }
  
}
