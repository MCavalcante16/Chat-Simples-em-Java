package comunicacao;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {
    String nome;
    OutputStream outputStream;
	DataOutputStream dataOutputStream;
    Scanner scanner;

    public Sender(String nome, Socket socket) {
        try {
            this.nome = nome;
            this.outputStream = socket.getOutputStream();
            this.dataOutputStream = new DataOutputStream(outputStream);
            this.scanner = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void service() {
        while(true) {
            try {
                String msg = scanner.nextLine();
                this.dataOutputStream.writeUTF(this.nome + ": " +  msg);
                this.dataOutputStream.flush();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
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
