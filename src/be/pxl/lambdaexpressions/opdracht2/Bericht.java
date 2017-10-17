package be.pxl.lambdaexpressions.opdracht2;

public class Bericht {
	private String tekst;
	
	public Bericht(String tekst){
		this.tekst = tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	public String encrypt(Encryptie encrypt){
		return encrypt.apply(tekst);
	}
}
