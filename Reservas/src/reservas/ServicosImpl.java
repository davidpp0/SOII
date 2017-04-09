package reservas;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicosImpl extends UnicastRemoteObject implements Servicos, java.io.Serializable {
      
   BDConnector pc = new BDConnector();

 
 

    public ServicosImpl() throws java.rmi.RemoteException {}

    
  
   
    public ArrayList<String> listar_espacos() throws RemoteException {
    ArrayList<String> info = new ArrayList();  
 
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
             
               
         //fecha ligaçao com a bd
         pc.disconnect();
               
          
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems retrieving data from db...");
        }
        
         //fecha ligaçao com a bd
               pc.disconnect();
  
         return info;
    }

   
 
    public boolean disponibilidade(String nomeEspaco,String data) throws RemoteException {
        boolean result=false;
       //estabelecer conexao com bd
       try {
           pc.connect();
       } catch (Exception ex) {
           Logger.getLogger(ServicosImpl.class.getName()).log(Level.SEVERE, null, ex);
       }
      
        try {
           
            //query para selecionar tabela dos campos
             ResultSet rs = pc.getStatement().executeQuery("SELECT id FROM reservas WHERE nomeEspaco='"+nomeEspaco+"' and dataInicio<='"+data+"' and dataFim>'"+data+"'");
             if(!rs.next()){
                 result=true;
             }
           
             
                //fecha ligaçao com a bd
               pc.disconnect();
               
          
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems retrieving data from db...");
        }
       return result;
        
    }

    
    public void reserva(String nomeEspaco, Timestamp dataInicio, Timestamp dataFim, int telefone, double custoEstimado, int numUtilizadores) throws RemoteException {
        
    }

    
    public ArrayList<String> listar_reservas(String nomeEspaco) throws RemoteException {
        ArrayList<String> info = new ArrayList();  
 
    //estabelecer conexao com bd
       try {
           pc.connect();
       } catch (Exception ex) {
           Logger.getLogger(ServicosImpl.class.getName()).log(Level.SEVERE, null, ex);
       }
      
        try {
            
            //query para selecionar tabela dos campos
             ResultSet rs = pc.getStatement().executeQuery("SELECT dataInicio, dataFim FROM reservas WHERE nomeEspaco='"+nomeEspaco+"'");
            //escreve lista dos espaços e respetivos custos
             while (rs.next()) {
                String dataInicio  = rs.getTimestamp("dataInicio").toString();
                String dataFim  = rs.getTimestamp("dataFim").toString();
                info.add("Espaço reservado de: "+dataInicio+" a "+dataFim);
             }
             
                //fecha ligaçao com a bd
               pc.disconnect();
               
          
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems retrieving data from db...");
        }
        
    
         return info;
    }
    
   
   
  
  
}
