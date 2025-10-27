package ramadani.it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {  
        Socket socket = new Socket("localhost", 3000);
        System.out.println("Connesso.");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("hello world");
        String result = in.readLine();
        System.out.println("Ricevuto: " + result);

        socket.close();
    }
}