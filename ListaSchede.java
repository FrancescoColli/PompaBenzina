package application;

import java.util.ArrayList;
import java.sql.*;

public class ListaSchede {
	ArrayList<Schede> listaS;

	private String username = "root";
	private String password = "Fra6178623**";
	private static Connection database;

	public ListaSchede() {
		this.listaS = new ArrayList<>();
		if (!connetti("world", username, password)) {
			System.exit(1);
		}
	}

	public boolean getAccesso(String pin) {
		boolean ok = false;
		for (Schede s : listaS) {
			if (s.getPin().equalsIgnoreCase(pin)) {
				ok = true;
			}
		}
		return ok;
	}

	public double mettiBenzina(String pin, double importo) {
		double credito = -1;
		for (Schede c1 : listaS) {
			if (c1.getPin().equals(pin)) {
				if (c1.getCredito() >= importo) {
					c1.setCredito(c1.getCredito() - importo);
					credito = c1.getCredito();
				}
			}
		}
		return credito;
	}

	public double versa(String pin, double importo) {
		double credito = -1;
		for (Schede c1 : listaS) {
			if (c1.getPin().equals(pin)) {
				c1.setCredito(c1.getCredito() + importo);
				credito = c1.getCredito();

			}
		}
		return credito;
	}

	private static boolean connetti(String nomeDB, String nomeUtente, String pwdUtente) {

		boolean connesso = false;
		try {
			// Carico il driver JDBC per la connessione con il database MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");// driver vecchio "com.mysql.jdbc.Driver"
			database = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomeDB + "?user=" + nomeUtente
					+ "&password=" + pwdUtente + "&useLegacyDatetimeCode=false&serverTimezone=UTC");
			connesso = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connesso;
	}

	private void disconnetti() {
		try {
			database.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		disconnetti();
	}
}