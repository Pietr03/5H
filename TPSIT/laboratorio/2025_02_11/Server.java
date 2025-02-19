import java.io.*;
import java.net.*;
import java.util.*;

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
        }
    }

    // Metodo che restituisce un intero casuale compreso tra 0 (incluso) e lastIndex (escluso)
    private int randomInt(int lastIndex) {
        Random rand = new Random();
        int number = rand.nextInt(lastIndex);
        return number;
    }


    private String mischiaCaratteri(String stringaInput) {

        String[] arrStringa = stringaInput.split("\\s+");
        
        Vector<String> vettoreCaratteri = new Vector<>();
        
        for (String parola : arrStringa) {
            vettoreCaratteri.add(parola);
        }

        String nuovaStringa = "";
        // Finché rimangono parole nel vettore, le estraiamo in ordine casuale
        while (vettoreCaratteri.size() > 0) {
            int posizione = randomInt(vettoreCaratteri.size());
            nuovaStringa += vettoreCaratteri.get(posizione) + " ";
            vettoreCaratteri.remove(posizione);
        }
        return nuovaStringa.trim();
    }

    private void accettaClient(ServerSocket serverSocket) {
        try {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            System.out.println("Connessione accettata da " + clientSocket.getInetAddress());
            elaborazioneDati(in, out);

        } catch (IOException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }

    private void elaborazioneDati(BufferedReader in, PrintWriter out) throws IOException {
        String input = in.readLine();
        System.out.println("Ricevuto: " + input);

        String paroleRandom = mischiaCaratteri(input);
        System.out.println("Parole in ordine casuale: " + paroleRandom);
        
        String output = "Lunghezza stringa: " + input.split("\\s+").length + ". Parole in ordine casuale: "+  paroleRandom;
        out.println(output);
        System.out.println("Inviato: " + output);
    }
}
