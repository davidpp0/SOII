package reservas;



public class ReservasServer {

    public static void main(String args[]) {
        int regPort= 1099; // default RMIRegistry port

	if (args.length !=1) { // obrigar 'a presenca de um argumento
	    System.out.println("Usage: java so2.rmi.ReservasServer registryPort");
	    System.exit(1);
	}
	

	try {
	    // ATENCAO: este porto e' relativo ao binder e nao ao servidor RMI
	    regPort=Integer.parseInt(args[0]);


	    // criar um Objeto Remoto
	   Reservas obj= new ReservasImpl();


	    // registar este objeto no servico de nomes
            
            /**
             * Se quiser substituir o processo rmiregisty...
             * pode ativar o servidor de nomes neste mesmo processo (antes do bind)
             */
            java.rmi.registry.LocateRegistry.createRegistry(regPort);            
            
            
	    // usar o Registry local (em execução na mesma máquina)
            // e no porto regPort
	    java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(regPort);

         

	    // ... e bind
	    registry.rebind("reservas", obj);  // NOME DO SERVICO

	
	    System.out.println("Bound RMI object in registry");

            System.out.println("servidor pronto");
	} 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
    
}
