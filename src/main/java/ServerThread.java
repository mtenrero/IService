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
            int i = ois.readInt();
            String today = (String) ois.readObject();
            Date date = (Date) ois.readObject();
            ois.close();
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
