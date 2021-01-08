package cliente;

import java.net.Socket;

import comunicacao.Comunicacao;

public class Cliente {

	Conexao conexao;
	Configuracao configuracao;
	Comunicacao comunicacao;

	public static void main(String[] args) {
		Cliente cliente = new Cliente(args[0], args[1]);
		cliente.on();
	}

	public Cliente(String host, String porta){
		this.configuracao = new Configuracao(host, Integer.parseInt(porta));
		this.conexao = new Conexao(configuracao);
	}

	public void on() {
		Socket socket = conexao.start();
		comunicacao = new Comunicacao("Cliente", socket);
	    comunicacao.start();
	}
}
