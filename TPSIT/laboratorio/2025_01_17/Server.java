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
            
        }
    }

    private void elaborazioneDati(BufferedReader in, PrintWriter out) throws IOException {
        String input = in.readLine();
        System.out.println("Ricevuto: " + input);

        String[] datiCalcolo = input.split(" ");
        
        if (datiCalcolo.length != 3 )
        {
            out.println("Input non valido, usa la sintassi 'numero + numero'. \nFai attenzione a mettere uno spazio e non di più tra l'operatore e i numeri.");
            return;
        }
            double num_1 = Double.valueOf(datiCalcolo[0]);
            String operatore = datiCalcolo[1];
            double num_2 = Double.valueOf(datiCalcolo[2]);
        try{
            String risultati = effettuaCalcolo(num_1 ,num_2, operatore);
            System.out.println("Inviato: " + risultati);
            out.println(risultati); 
        } catch (Exception e){
            System.out.println("Errore: " + e);
        }

    }

   private String effettuaCalcolo (double num1, double num2, String operatore) {
    switch (operatore) {
        case "+":
            return Double.toString(num1 + num2);
        case "-":
            return Double.toString(num1 - num2);
        case "*":
            return Double.toString(num1 * num2);
        case "/":
            if (num2 != 0) {
                return Double.toString(num1 / num2);
            } else {
                return "Divisione per zero non consentita.";
            }
        default:
            return "Operatore non valido: " + operatore;
    }
   }

}
