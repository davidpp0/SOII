package reservas;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;
import java.util.ArrayList;
public class Client {
  
    /*
    public Object[] askIn() {
        Scanner reader = new Scanner(System.in);
        Object r[] = new Object[4];
        System.out.print("Insira a data inicial:");
        String d1 = reader.next();
        System.out.println("");
        System.out.print("Indique a h de inicio:");
        int h1 = reader.nextInt();
        System.out.println("");
        System.out.print("insira a data final");
        String d2 = reader.next();
        System.out.println("");
        System.out.print("Indique a h de final:");
        int h2 = reader.nextInt();
        System.out.println("");
    }
    */
    public static boolean menu() {
        Scanner reader = new Scanner(System.in);
        String s = "";
		while (!s.equalsIgnoreCase("exit")) {
            System.out.print("Insira o comando:");
            s = reader.next();
            System.out.println("");
            //Incluir um exit e verificacoes e ciclos para pedir o input de novo
            if (s.equalsIgnoreCase("listarEspacos")) {
                //escrever codigo para pedir ao sv para listar espacos

            } else if (s.equalsIgnoreCase("disponibilidade")) {
                System.out.print("Por favor indique qual o servico");
                s = reader.next();
                System.out.println("");
                if (s.equalsIgnoreCase("futsal")) {
                	try{
                            System.out.print("Insira a h:");
                            int h = reader.nextInt();
                	}catch(InputMismatchException e){};
                    System.out.println("");
                    System.out.print("insira o dia:");
                    String d = reader.next();
                    System.out.println("");
                    //Junta tudo e envia um array com pedido p futsal
                } else if (s.equalsIgnoreCase("padel")) {
                	try{
                    	System.out.print("Insira a h:");
                        int h = reader.nextInt();
                    }catch(InputMismatchException e){};
                    System.out.print("insira o dia");
                    String d = reader.next();
                    System.out.println("");
                    // pedido p padel
                } else if (s.equalsIgnoreCase("tenis")) {
                	try{
                    	System.out.print("Insira a h:");
                        int h = reader.nextInt();
                    }catch(InputMismatchException e){};
                    System.out.println("");
                    System.out.print("insira o dia");
                    String d = reader.next();
                    System.out.println("");
                    // pedido p tenis
                } else {
                    System.out.println("Comando invalido");
                }
                ///CONFIRMAR VALORES COM INTEIROS E ETC NOS PEDIDOS DE INPUT
            } else if (s.equalsIgnoreCase("adicionarReserva")) {
                System.out.print("indique o servico:");
                s = reader.next();
                System.out.println("");
                if (s.equalsIgnoreCase("futsal")) {
                    System.out.print("Insira a data de inicio:");
                    String d1 = reader.next();
                    System.out.println("");
                    System.out.print("Indique a h de inicio:");
                    try{
                    	int h1 = reader.nextInt();
                    }catch(InputMismatchException e){}
                    System.out.println("");
                    System.out.print("Insira a data final:");
                    String d2 = reader.next();
                    System.out.println("");
                    System.out.print("indique a h de final:");
                    try{
                    	int h2 = reader.nextInt();
                    }catch(InputMismatchException e){}
                    System.out.println("");

                } else if (s.equalsIgnoreCase("padel")) {
                    System.out.print("Insira a data inicial:");
                    String d1 = reader.next();
                    System.out.println("");
                    System.out.print("Indique a h de inicio:");
                    try{
                    	int h1 = reader.nextInt();
                    }catch(InputMismatchException e){}
                    System.out.println("");
                    System.out.print("Insira a data final:");
                    String d2 = reader.next();
                    System.out.println("");
                    System.out.print("Indique a h de final:");
                    try{
                    	int h2 = reader.nextInt();
                    }catch(InputMismatchException e){}
                    System.out.println("");
                } else if (s.equalsIgnoreCase("tenis")) {
                    System.out.print("Insira a data inicial:");
                    String d1 = reader.next();
                    System.out.println("");
                    System.out.print("Indique a h de inicio:");
                    try{
                    	int h1 = reader.nextInt();
                    }catch(InputMismatchException e){}
                    System.out.println("");
                    System.out.print("insira a data final");
                    String d2 = reader.next();
                    System.out.println("");
                    System.out.print("Indique a h de final:");
                    try{
                    	int h2 = reader.nextInt();
                    }catch(InputMismatchException e){}
                    System.out.println("");
                } else {
                    System.out.println("Comando nao reconhecido");
                }
            } else if (s.equalsIgnoreCase("listarReservas")) {
                System.out.println("Insira o campo da reserva:");
                s = reader.next();
                System.out.println("");
                //codigo para receber e imprimir reserva
            } else {
                System.out.println("Comando invalido");
            }
        }
        return false;
    }

    public static void main(String args[]) {
        // invocacao de metodos remotos
        @SuppressWarnings("unused")
       // boolean l = Client.menu();
        String regHost = "localhost";
        String regPort = "9000";  // porto do binder
        
        
        
       /* if (args.length != 2) { // requer 3 argumentos
            System.out.println("Usage: java so2.rmi.Client registryHost registryPort");
            System.exit(1);
        }
        regHost = args[0];
        regPort = args[1];*/
     
        
        try {
            // objeto que fica associado ao proxy para objeto remoto
                //Registry registry = LocateRegistry.getRegistry(regHost);
                Servicos stub = (Servicos)  java.rmi.Naming.lookup("rmi://" + regHost + ":" + regPort + "/servicos");
        
               /* stub.setHoraInicio(5);
                int response = stub.getHoraInicio();
                stub.setHoraFim(10);
                int result = stub.getHoraFim();
                System.out.println("response:"+ response);
                System.out.println("response"+result);*/
            
           //teste da funçao listar_espaços
           ArrayList<String> list = stub.listar_espacos();
               
            for (String list1 : list) {
                System.out.println(list1);
            }
           
            System.out.println();
           
            //teste da funçao listar_reservas
           ArrayList<String> reservas = stub.listar_reservas("futsal");
            for (String reservas1 : reservas) {
                System.out.println(reservas1);
            }  
            
            System.out.println();
           
            //teste funçao disponibilidade
            boolean disp = stub.disponibilidade("futsal", "2016-1-2 8:50:00");
            System.out.println(disp);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
