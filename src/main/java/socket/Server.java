package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int PORT = 1777;

    public static void main(String[] args) throws IOException {

        String str;

        ServerSocket server = new ServerSocket(PORT);

        Socket clientSocket = server.accept();

        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        Scanner in = new Scanner(System.in);

        while (true) {

            str = in.next();

            System.out.println("Message: " + str);
            pw.println(str);

            if (str.equals("exit")) {
                break;
            }
        }

//        while ((str = br.readLine()) != null) {
//            System.out.println("Message: " + str);
//            pw.println(str);
//        }

        pw.close();
        br.close();
        clientSocket.close();
    }
}


/*

public static void clientFunc(object obj) {

    Socket s = obj as Socket;
    byte[] bytes = new byte[1024];
    while (true) {
        try {
            string result = Encoding.UTF8.GetString(bytes, 0, s.Receive(bytes));
            if (result.Equals("GET"))
        {
        s.Send(Encoding.UTF8.GetBytes(T.ToString()));
    }
 */