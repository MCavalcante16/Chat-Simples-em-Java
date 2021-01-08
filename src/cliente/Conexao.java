package cliente;

import java.net.Socket;

public class Conexao {
	Configuracao configuracao;
	
	public Conexao (Configuracao configuracao){
		this.configuracao = configuracao;
	}

	public Socket start(){
		try {
			Socket socket = new Socket(this.configuracao.getHost(), this.configuracao.getPorta());
			System.out.println("Conexão estabelecida!");
			return socket;
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
			System.out.println("Conexão Falhou!");
			return null;
		}
	}
}
