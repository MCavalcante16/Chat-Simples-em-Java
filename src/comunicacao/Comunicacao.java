package comunicacao;

import java.net.Socket;

public class Comunicacao {
    Receiver receiver;
    Sender sender;

    public Comunicacao(String nome, Socket socket) { 
        try {
            this.receiver = new Receiver(socket);
            this.sender = new Sender(nome, socket);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.err.println("\n\n" + "-----------CHAT----------");
    }
    
    public void start() {
        new Thread(this.receiver.getThread()).start();
        new Thread(this.sender.getThread()).start(); 
    }
}
