package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocket {

    private static final int PORT = 1777;

    public static void main(String[] args) throws IOException {

        String sendString = "Hello sockets!";

        Socket socket = new Socket(InetAddress.getLocalHost(), PORT);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println(sendString);

        while ((sendString = br.readLine()) != null) {
            System.out.println(sendString);
        }

        br.close();
        pw.close();
        socket.close();
    }
}
