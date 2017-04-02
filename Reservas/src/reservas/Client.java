package reservas;


import java.util.Vector;

public class ReservasClient {

    public static void main(String args[]) {
	String regHost = "localhost";
	String regPort = "9000";  // porto do binder
	String nomeReserva= "";

	if (args.length !=3) { // requer 3 argumentos
	    System.out.println
		("Usage: java so2.rmi.PalavrasClient registryHost registryPort frase");
	    System.exit(1);
	}
	regHost= args[0];
	regPort= args[1];
	nomeReserva= args[2];


	try {
	    // objeto que fica associado ao proxy para objeto remoto
	    Reservas obj =
		(Reservas) java.rmi.Naming.lookup("rmi://" + regHost + ":" + 
						  regPort + "/reservas");
	    

	    // invocacao de metodos remotos
/*
	    for (int i=0; i<v.size();i++) {
		System.out.println(i+" "+ v.get(i) );
	    }
*/
	} 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}
