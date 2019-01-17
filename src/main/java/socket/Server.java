package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 1777;

    public static void main(String[] args) throws IOException {

        String str;

        ServerSocket server = new ServerSocket(PORT);

        Socket clientSocket = server.accept();

        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while ((str = br.readLine()) != null) {
            System.out.println("Message: " + str);
            pw.println(str);
        }

        pw.close();
        br.close();
        clientSocket.close();
    }
}
