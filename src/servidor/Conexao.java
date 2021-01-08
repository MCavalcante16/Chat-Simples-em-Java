package servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class Conexao {
	
	Configuracao configuracao;

	public Conexao() {
		this.configuracao = new Configuracao();
	}
	
	public Conexao (Configuracao configuracao){
		this.configuracao = configuracao;
	}

	public Socket start(){
		try {
			// Instancia o ServerSocket ouvindo a porta desejada
			ServerSocket servidor = new ServerSocket(configuracao.getPorta());
			System.out.println("Servidor ouvindo a porta " + configuracao.getPorta());
			Socket cliente = servidor.accept();

			//Retorna feedback de conexão
			System.out.println("Conexão estabelecida!");
			System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());	
			
			return cliente;
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}
}
