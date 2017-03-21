import Email.Send;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

/**
 * Created by was12 on 20/03/2017.
 */
public class ServerThread extends Thread {
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    public void run(){
        try{
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String email = (String) ois.readObject();
            String subject = (String) ois.readObject();
            String body = (String) ois.readObject();
            new Send().send(email,subject,body);
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
