/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reservas;

/**
 *
 * @author David Parreira
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class EspacoImpl extends UnicastRemoteObject implements Espaco, java.io.Serializable {
   
    String name;
    int cost;

   EspacoImpl(String name, int cost ){
    this.name = name;
    this.cost = cost;
    }

   public String getName(){}
   public void setName(String name){};
   public int getCost(){};
   public void setCost(){};
}
