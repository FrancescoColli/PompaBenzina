package application;

public class Schede {

private	String pin;
private	double credito;
	
	public Schede(String pin, double credito) {
		
		this.pin = pin;
		this.credito = credito;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	@Override
	public String toString() {
		return "Schede [pin=" + pin + ", credito= € " + credito  + "]";
	}
	
	
}
