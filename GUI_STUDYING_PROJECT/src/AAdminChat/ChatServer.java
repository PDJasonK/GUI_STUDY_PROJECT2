package AAdminChat;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    public static final int PORT = 5000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        List<PrintWriter> listWriters = new ArrayList<PrintWriter>();

        try {
// 1. �꽌踰� �냼耳� �깮�꽦
            serverSocket = new ServerSocket();

// 2. 諛붿씤�뵫
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            serverSocket.bind( new InetSocketAddress(hostAddress, PORT) );
            consoleLog("�뿰寃� 湲곕떎由� - " + hostAddress + ":" + PORT);

// 3. �슂泥� ��湲�
            while(true) {
                Socket socket = serverSocket.accept();
                new ChatServerProcessThread(socket, listWriters).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if( serverSocket != null && !serverSocket.isClosed() ) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consoleLog(String log) {
        System.out.println("[server " + Thread.currentThread().getId() + "] " + log);
    }
}