package comunicacao;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Receiver {
    InputStream inputStream;
    DataInputStream dataInputStream;

    public Receiver(Socket socket) {
        try {
            this.inputStream = socket.getInputStream();
            this.dataInputStream = new DataInputStream(inputStream);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void service() {
        while(true) {
            try {
                String msg = this.dataInputStream.readUTF();
                printMessage(msg);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void printMessage(String msg) {
        System.out.print(msg + "\n");
    }

    private Runnable thread = new Runnable() {
        public void run() {
           service();
        }
    };

    public Runnable getThread() {
        return this.thread;
    } 
    
}
