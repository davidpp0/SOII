package reservas;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client {
    
    public static void main(String args[]) throws RemoteException {
        // invocacao de metodos remotos

       // boolean l = Client.menu();
        String regHost = "localhost";
        String regPort = "9000";  // porto do binder
        try {        
            menu(regHost,regPort);
            /* if (args.length != 2) { // requer 3 argumentos
            System.out.println("Usage: java so2.rmi.Client registryHost registryPort");
            System.exit(1);
            }
            regHost = args[0];
            regPort = args[1];*/
            
            /*
            try {
            // objeto que fica associado ao proxy para objeto remoto
            Registry registry = LocateRegistry.getRegistry(regHost);
            Servicos stub = (Servicos)  java.rmi.Naming.lookup("rmi://" + regHost + ":" + regPort + "/servicos");
            
            /* stub.setHoraInicio(5);
            int response = stub.getHoraInicio();
            stub.setHoraFim(10);
            int result = stub.getHoraFim();
            System.out.println("response:"+ response);
            System.out.println("response"+result);*/
            
            //teste da funçao listar_espaços
            /* ArrayList<String> list = stub.listar_espacos();
            
            for (String list1 : list) {
            System.out.println(list1);
            }
           
            System.out.println();
            
            
            
            System.out.println();
           
            //teste funçao disponibilidade
            boolean disp = stub.disponibilidade("futsal", "2016-1-2 11:55:00");
            System.out.println(disp);
            
            //teste funçao reserva
            boolean reserva =stub.reserva("tonel","futsal","2016-1-2 13:50" ,"2016-1-2 14:00",266733145,2);
            if(reserva){
            System.out.println("Sucesso");
            }
            else {
            System.out.println("Impossivel marcar!");
            }
                    
            //teste da funçao listar_reservas
            ArrayList<String> reservas = stub.listar_reservas("tenis");
            for (String reservas1 : reservas) {
            System.out.println(reservas1);
            }  
            
            } catch (Exception ex) {
            ex.printStackTrace();
            }*/
        } catch (ParseException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public static void menu(String regHost,String regPort) throws ParseException, RemoteException {
        Scanner reader = new Scanner(System.in);
        String in1 = "";
        String in2 = "";
        String d = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date1;
        Date date2;
        Registry registry;
         Servicos stub = null;        
        try{
            registry = LocateRegistry.getRegistry(regHost);
    
            
        
        stub = (Servicos)  java.rmi.Naming.lookup("rmi://" + regHost + ":" + regPort + "/servicos");
        }catch(Exception e){
              e.printStackTrace();
        }
        
        System.out.println("Insira 0 para ajuda");
        System.out.print("Insira o comando:");
        in1 = reader.next();
        System.out.println("");
        while (!in1.equalsIgnoreCase("exit")) {
            //Incluir um exit e verificacoes e ciclos para pedir o input de novo
            switch (in1) {
                
                case "0":
                    System.out.println("1-Listar espacos");
                    System.out.println("2-Verificar disponibilidade de um espaço");
                    System.out.println("3-Fazer reserva");
                    System.out.println("4-Listar reservas de um espaço");
                    break;
                //listar espacos    
                case "1":
                   
                    ArrayList<String> list=stub.listar_espacos();
                    //listar custos e espaços  
                   if(list!=null)
                        for (String list1 : list) {
                            System.out.println(list1);
                        }
                    else 
                        System.out.println("Nao");
                   
                        
                    System.out.println();
                    break;
                // Verificar disponibilidade
                case "2":
                        boolean disp;
                        System.out.print("Indique o campo (futsal, padel ou tenis):");
                        in2 = reader.next();
                        System.out.println("");
                        
                    switch (in2) {
                        case "padel":
                            try{
                                System.out.print("Insira o data (formato: ano-mes-dia h:min):");
                                reader.nextLine();
                                d = reader.nextLine();
                                System.out.println("");
                                date1 = format.parse(d);
                            }catch(Exception e){
                                   System.err.println("Formato deve ser ano-mes-dia h:min");
                            }
                            disp = stub.disponibilidade("padel",d);
                            if(disp)
                                System.out.println("Campo disponivel");
                            else 
                                System.out.println("Campo indisponivel");
                            
                            
                            
                            System.out.println();
                            break;
                            
                        case "futsal":
                             try{
                                System.out.print("Insira o data (formato: ano-mes-dia h:min):");
                                reader.nextLine();
                                d = reader.nextLine();
                                System.out.println("");
                                date1 = format.parse(d);
                            }catch(Exception e){
                                   System.err.println("Formato deve ser ano-mes-dia h:min");
                            }
                            disp = stub.disponibilidade("futsal",d);
                            if(disp)
                                System.out.println("Campo disponivel");
                            else 
                                System.out.println("Campo indisponivel");
                            
                            System.out.println();
                            break;
                            
                        case "tenis":
                             try{
                                System.out.print("Insira o data (formato: ano-mes-dia h:min):");
                                reader.nextLine();
                                d = reader.nextLine();
                                System.out.println("");
                                date1 = format.parse(d);
                            }catch(Exception e){
                                   System.err.println("Formato deve ser ano-mes-dia h:min");
                            }
                            disp = stub.disponibilidade("tenis",d);
                            if(disp)
                                System.out.println("Campo disponivel");
                            else 
                                System.out.println("Campo indisponivel");
                            
                            System.out.println();
                            break;
                            
                            
                        default:
                            System.err.println("Campo inválido (inserir futsal,padel ou tenis)");
                            break;
                    }
                    break;
                
                // Add reserva    
                case "3":
                    in2 = "";
                    System.out.print("Indique o campo (futsal, padel ou tenis):");
                    in2 = reader.next();
                    System.out.println();
                    String d1="";
                    String d2="";
                    double reserva=0;
                    int telefone=0;
                    int numUtilizadores=0;
                    String nome;
                    switch (in2) {
                        case "futsal":
                                try{
                                    System.out.print("Insira a data inicio (ano-mes-dia h:min):");
                                    reader.nextLine();
                                    d1 = reader.nextLine();
                                    System.out.println();                          
                                    System.out.print("Insira a data fim (ano-mes-dia h:min):");
                                    d2 = reader.nextLine();
                                    System.out.println();                            
                                    date1 = format.parse(d1);
                                    date2 = format.parse(d2);
                                }catch(Exception e){
                                       System.err.println("Formato deve ser ano-mes-dia h:min");
                                }
                                    System.out.print("Insira o seu nome:");
                                    nome = reader.nextLine();
                                    System.out.println();                          
                                    System.out.print("Insira o seu numero de telefone:");
                                try{    
                                    telefone = reader.nextInt();
                                    System.out.println();
                                }catch(Exception e){
                                     System.err.println("Insira um numero!");
                                }
                                    System.out.print("Insira o numero de utilizadores:");
                                try{    
                                    numUtilizadores = reader.nextInt();
                                    System.out.println();
                                }catch(Exception e){
                                     System.err.println("Insira um numero!");
                                }
                                reserva =stub.reserva(nome, "futsal", d1, d2, telefone, numUtilizadores);
                                if(reserva!=0)
                                    System.out.println("Reserva efetuada com sucesso, o custo da sua reserva e: " + reserva + "€");
                                else
                                    System.out.println("Impossivel fazer reserva");
                                
                                System.out.println();
                                break;
                        case "padel":
                                try{
                                    System.out.print("Insira a data inicio (ano-mes-dia h:min):");
                                    reader.nextLine();
                                    d1 = reader.nextLine();
                                    System.out.println();                          
                                    System.out.print("Insira a data fim (ano-mes-dia h:min):");
                                    d2 = reader.nextLine();
                                    System.out.println();                            
                                    date1 = format.parse(d1);
                                    date2 = format.parse(d2);
                                }catch(Exception e){
                                       System.err.println("Formato deve ser ano-mes-dia h:min");
                                }
                                    System.out.print("Insira o seu nome:");
                                    nome = reader.nextLine();
                                    System.out.println();                          
                                    System.out.print("Insira o seu numero de telefone:");
                                try{    
                                    telefone = reader.nextInt();
                                    System.out.println();
                                }catch(Exception e){
                                     System.err.println("Insira um numero!");
                                }
                                    System.out.print("Insira o numero de utilizadores:");
                                try{    
                                    numUtilizadores = reader.nextInt();
                                    System.out.println();
                                }catch(Exception e){
                                     System.err.println("Insira um numero!");
                                }
                                reserva =stub.reserva(nome, "padel", d1, d2, telefone, numUtilizadores);
                                if(reserva!=0)
                                    System.out.println("Reserva efetuada com sucesso, o custo da sua reserva e: " + reserva + "€");
                                else
                                    System.out.println("Impossivel fazer reserva");
                                
                                
                                System.out.println();
                                break;
                        case "tenis":
                            try{
                                    System.out.print("Insira a data inicio (ano-mes-dia h:min):");
                                    reader.nextLine();
                                    d1 = reader.nextLine();
                                    System.out.println();                          
                                    System.out.print("Insira a data fim (ano-mes-dia h:min):");
                                    d2 = reader.nextLine();
                                    System.out.println();                            
                                    date1 = format.parse(d1);
                                    date2 = format.parse(d2);
                                }catch(Exception e){
                                       System.err.println("Formato deve ser ano-mes-dia h:min");
                                }
                                    System.out.print("Insira o seu nome:");
                                    nome = reader.nextLine();
                                    System.out.println();                          
                                    System.out.print("Insira o seu numero de telefone:");
                                try{    
                                    telefone = reader.nextInt();
                                    System.out.println();
                                }catch(Exception e){
                                     System.err.println("Insira um numero!");
                                }
                                    System.out.print("Insira o numero de utilizadores:");
                                try{    
                                    numUtilizadores = reader.nextInt();
                                    System.out.println();
                                }catch(Exception e){
                                     System.err.println("Insira um numero!");
                                }
                                reserva =stub.reserva(nome, "tenis", d1, d2, telefone, numUtilizadores);
                                if(reserva!=0)
                                    System.out.println("Reserva efetuada com sucesso, o custo da sua reserva e: " + reserva + "€");
                                else
                                    System.out.println("Impossivel fazer reserva");
                                
                                
                                System.out.println();
                                break;
                    }
                    break;
                    
                //listar reservas
                case "4":
                    String campo=""; 
                    try{
                        System.out.print("Insira o campo (futsal, padel ou tenis):");
                        campo = reader.next();
                        System.out.println("");
                    }catch(Exception e){
                        System.err.println("Deve inserir um campo valido (futsal, padel ou tenis)");
                    }
                    list = stub.listar_reservas(campo);
                    if(list!=null)
                        for (String list1 : list) {
                            System.out.println(list1);
                        }
                    else 
                        System.out.println("Espaço sem reservas!");
                    
                    break;
                default:
                    System.out.println("Comando invalido");
                    break;
            }
                    System.out.println("Insira 0 para ajuda");
                    System.out.print("Insira o comando:");
                    in1 = reader.next();
                    System.out.println(""); 
        }

    }
}
