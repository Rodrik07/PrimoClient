package ramadani.it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {  
        Socket socket = new Socket("localhost", 3000);
        System.out.println("Connesso al server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        //lettura dell'operazione da fare
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Scegli un'operazione:");
        System.out.println("1: Addizione");
        System.out.println("2: Sottrazione");
        System.out.println("3: Moltiplicazione");
        System.out.println("4: Divisione");
        int operazione = Integer.parseInt(userInput.readLine());
        
        //chiede all'utente di inserire i due numeri
        System.out.println("Inserisci il primo numero:");
        double num1 = Double.parseDouble(userInput.readLine());
        
        System.out.println("Inserisci il secondo numero:");
        double num2 = Double.parseDouble(userInput.readLine());
        
        //invia  dati al server
        out.println(operazione); 
        out.println(num1);        
        out.println(num2);        
        
        //riceve e stampa il risultato
        String result = in.readLine();
        System.out.println(result);
        
        socket.close();
    }
}
