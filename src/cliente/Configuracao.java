package cliente;

public class Configuracao {
	String host;
	int porta;
	
	public Configuracao(String host, int porta){
		this.host = host;
		this.porta = porta;
	}
	
	public String getHost() {
		return host;
	}

	public int getPorta() {
		return porta;
	}
}
