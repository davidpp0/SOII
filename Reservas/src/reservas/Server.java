package reservas;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Vector;



public class Server implements Reservas{

    Vector<Reservas> listaReservas;
    
    int horaInicio;
    int horaFim;
    Date diaInicio;
    Date diaFim;
    Espaco espaco;
    
    public Server(){}

    @Override
    public int getHoraInicio() throws RemoteException {
        return horaInicio;
    }

    public int getHoraFim() throws RemoteException {
        return horaFim;
    }

    @Override
    public Date getDiaInicio() throws RemoteException {
        return diaInicio;
    }

    public Date getDiaFim() throws RemoteException {
        return diaInicio;
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
    public void setDiaInicio(Date d) throws RemoteException {
        diaInicio = d;
    }
    
    public void setDiaFim(Date d) throws RemoteException {
        diaInicio = d;
    }
    
    public void setEspaco(Espaco e) throws RemoteException {
        espaco = e;
    }
    
    public boolean availability(String espaco, int h, Date day)
    {
        //vai consultar a bd com os parametros e retorna alguma coisa
        return true;
    }
    
    public static void main(String args[]) {
        
        int regPort=9001; // default RMIRegistry port
	/*
	    System.exit(1);
	}
        */
	try {
	    // ATENCAO: este porto e' relativo ao binder e nao ao servidor RMI
	   // regPort=Integer.parseInt(args[0]);
            Server obj = new Server();
	    Reservas stub =  (Reservas) UnicastRemoteObject.exportObject(obj,regPort);
            Registry registry = LocateRegistry.createRegistry(regPort);
            registry = LocateRegistry.getRegistry(regPort);
            
            registry.rebind("reservas", stub);        
              // criar um Objeto Remoto
             System.err.println("Server ready");
	    // registar este objeto no servico de nomes
            /**
             * Se quiser substituir o processo rmiregisty...
             * pode ativar o servidor de nomes neste mesmo processo (antes do bind)
             */
                      
	    // usar o Registry local (em execução na mesma máquina)
            // e no porto regPort
	    // ... e bind
	    
	} 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
    
}
