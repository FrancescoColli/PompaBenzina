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

	
	
	public boolean getAccesso(String pin) throws SQLException {
		String query = "select * from listapinbenzina";
		Statement fra = database.createStatement();
		ResultSet rs = fra.executeQuery(query);
		while (rs.next()) {
			String pinrinominato = rs.getString("pin");
			double creditorinominato = rs.getDouble("credito");
// System.out.println(); sysout + ctrl + spazio
			System.out.println("Pin: " + pinrinominato + ", Credito: " + creditorinominato);
			listaS.add(new Schede(pinrinominato, creditorinominato));
			
		}
		boolean ok = false;
		for (Schede s : listaS) {
			if (s.getPin().equalsIgnoreCase(pin)) {
				ok = true;
			}
		}
		return ok;
	}

	public double mettiBenzina(String pin, double importo) throws SQLException {
		
		double credito = -1;
		for (Schede c1 : listaS) {
			if (c1.getPin().equals(pin)) {
				if (c1.getCredito() >= importo) {
					c1.setCredito(c1.getCredito() - importo);
					credito = c1.getCredito();
					String query = "update listapinbenzina set credito = "+ credito +" where pin = " + pin;
					PreparedStatement fra = database.prepareStatement(query);
					int row = fra.executeUpdate();
					if (row > 0) {
						System.out.println("Update success");
					} else {
						System.out.println("Update failed");
					}
				}
			}
		}
		return credito;
	}

	public double versa(String pin, double importo) throws SQLException {
		double credito = -1;
		for (Schede c1 : listaS) {
			if (c1.getPin().equals(pin)) {
				c1.setCredito(c1.getCredito() + importo);
				credito = c1.getCredito();
				String query = "update listapinbenzina set credito = "+ credito +" where pin = " + pin;
				PreparedStatement fra = database.prepareStatement(query);
				int row = fra.executeUpdate();
				if (row > 0) {
					System.out.println("Update success");
				}else {
					System.out.println("Update failed");
				}

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