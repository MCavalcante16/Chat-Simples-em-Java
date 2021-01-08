package servidor;
public class Configuracao {

	int porta;

	public Configuracao() {
		this.porta = 3333;
	}
	
	public Configuracao(int porta){
		this.porta = porta;
	}
	
	public int getPorta(){
		return this.porta;
	}
}
