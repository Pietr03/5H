import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    ServerSocket server = null;
    Socket client= null;
    String stringaRicevuta= null;
    String stringaModificata= null;
    BufferedReader inDalClient;
    DataOutputStream outAlClient;

    public Socket attendi()
    {
        try {
            server = new ServerSocket(6789);
            System.out.println("Server in ascolto sulla porta 6789");
            client = server.accept();
            server.close();

            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outAlClient = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            System.out.println("Errore: \n" + e.getMessage());
            System.exit(1);
        }
        return client;
    }

    public void comunica()
    {
        try {
            stringaRicevuta = inDalClient.readLine();
            System.out.println("Ricevuto: " + stringaRicevuta);

            stringaModificata = stringaRicevuta.toUpperCase();
            outAlClient.writeBytes(stringaModificata + "\n");
            System.out.println("Inviato: " + stringaModificata);
            client.close();
        } catch (Exception e) {
            System.out.println("Errore: \n" + e.getMessage());
            System.exit(2);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.attendi();
        server.comunica();
    }
}