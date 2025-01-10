import java.io.*;
import java.net.*;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        Client client = new Client();
        client.comunica();
    }

    public void comunica() {
        try{
            Socket socket = connettiAlServer();

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


            System.out.print("Inserisci una stringa: ");
            String input = consoleInput.readLine();

            out.println(input);
            String response = in.readLine();
            System.out.println("Risposta dal server: " + response);

        } catch (IOException e) {
             System.err.println("Errore: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Socket connettiAlServer() throws IOException {
        System.out.println("Connessione al server " + HOST + " sulla porta " + PORT);
        return new Socket(HOST, PORT);
    }
}
