package servidor;

import java.net.Socket;

import comunicacao.Comunicacao;

public class Servidor {

	Configuracao configuracao;
	Conexao conexao;
	Comunicacao comunicacao;

	public static void main(String[] args) {
		Servidor servidor = new Servidor(args[0]);
		servidor.on();
	}
	
	public Servidor(String porta){
		this.configuracao = new Configuracao(Integer.parseInt(porta));
		this.conexao = new Conexao(configuracao);
	}

	public void on(){
		Socket socket = conexao.start();
		comunicacao = new Comunicacao("Servidor", socket);
		comunicacao.start();
	}
}
