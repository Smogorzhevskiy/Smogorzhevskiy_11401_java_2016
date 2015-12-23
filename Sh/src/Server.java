import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    final int PORT = 3456;
    ArrayList<Connection> connections;
    public Server() throws IOException {
        connections = new ArrayList<Connection>();
        go();
    }

    public void go() throws IOException {
        ServerSocket s1 = new ServerSocket(PORT);
        while (true) {
            Socket client = s1.accept();
            Socket client2 = s1.accept();
            connections.add(new Connection(this, client, client2));
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}
