package reservas;



public interface Espaco extends java.rmi.Remote{
    
   public String getName() throws java.rmi.RemoteException;
   
   public void setName(String name) throws java.rmi.RemoteException;
   
   public int getCost() throws java.rmi.RemoteException;
   
   public void setCost() throws java.rmi.RemoteException;

}
