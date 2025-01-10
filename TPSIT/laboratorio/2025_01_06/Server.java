import java.io.*;
import java.net.*;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        Server server = new Server();
        server.attivaServer();
    }

    public void attivaServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server in ascolto sulla porta " + PORT);
            while (true) {
                accettaClient(serverSocket);
            }
        } catch (IOException e) {
            System.err.println("Errore: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void accettaClient(ServerSocket serverSocket) {
        try{
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            System.out.println("Connessione accettata da " + clientSocket.getInetAddress());
            elaborazioneDati(in, out);
            
        } catch (IOException e) {
            System.err.println("Errore: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private void elaborazioneDati(BufferedReader in, PrintWriter out) throws IOException {
        String input = in.readLine();
        System.out.println("Ricevuto: " + input);
        String output = input.toUpperCase();
        out.println(output);
        System.out.println("Inviato: " + output);
    }
}

