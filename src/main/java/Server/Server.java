package Server;

import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by was12 on 20/03/2017.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.ssl.keyStore","za.store");
        System.setProperty("javax.net.ssl.keyStorePassword","vetManager");
        ServerSocket server=((SSLServerSocketFactory) SSLServerSocketFactory.getDefault()).createServerSocket(4444);
        while (true) {
            new ServerThread(server.accept()).start();
            System.out.print("ACTIVADO");
        }
    }
}
