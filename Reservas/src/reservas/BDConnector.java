
package reservas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class BDConnector {
   

    private String PG_HOST="localhost";
    private String PG_DB="postgres";
    private String USER="postgres";
    private String PWD="miguel";

    Connection con = null;
    Statement stmt = null;

    public BDConnector() {}

    public void connect() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://" + PG_HOST + ":5432/" + PG_DB,
                    USER, PWD);

            stmt = con.createStatement();
            

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems setting the connection");
        }
    }

    public void disconnect() {    // importante: fechar a ligacao 'a BD
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return stmt;
    }

}
