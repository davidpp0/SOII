package reservas;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicosImpl extends UnicastRemoteObject implements Servicos, java.io.Serializable {
      
   BDConnector pc = new BDConnector();

 
 

    public ServicosImpl() throws java.rmi.RemoteException {}

    
  
   
    public ArrayList<String> listar_espacos() throws RemoteException {
    ArrayList<String> info = null;  
 
    //estabelecer conexao com bd
       try {
           pc.connect();
       } catch (Exception ex) {
           Logger.getLogger(ServicosImpl.class.getName()).log(Level.SEVERE, null, ex);
       }
      
        try {
            
            //query para selecionar tabela dos campos
             ResultSet rs = pc.getStatement().executeQuery("SELECT * from campos");
            //escreve lista dos espaços e respetivos custos
             while (rs.next()) {
                String nome = rs.getString("nomeEspaco");
                String custo=Integer.toString(rs.getInt("custo"));
                info.add("Espaço: "+nome+" Custo: "+custo);
             }
        
               
          
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems retrieving data from db...");
        }
        
         //fecha ligaçao com a bd
               pc.disconnect();
  
         return info;
    }

   
    public boolean disponibilidade(String nomeEspaco, Timestamp data) throws RemoteException {
        return false;
        
    }

    
    public void reserva(String nomeEspaco, Timestamp dataInicio, Timestamp dataFim, int telefone, double custoEstimado, int numUtilizadores) throws RemoteException {
        
    }

    
    public void listar_reservas(String nomeEspaco) throws RemoteException {
        
    }
    
   
   
  
  
}
