package application;
 
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
 
public class PompaDiBenzina extends Application {
 
	TextField login;
	Button loginbtn;
 
	Button ricarica;
	Button benzina;
 
	Button dieci;
	Button venti;
	Button cinquanta;
 
	TextField versa;
	Button versabtn;
 
	Label message;
 
	ListaSchede lSchede = new ListaSchede();
 
	@Override
	    public void start(Stage primaryStage) throws Exception{
 
		  GridPane grid = new GridPane();
 
		  login = new TextField();
		  login.setPromptText("Inserire il tuo pin");  
 
		  loginbtn = new Button("Accedi");
		  loginbtn.setOnAction(e -> entra());
 
		  ricarica= new Button("Ricarica");
		  ricarica.setOnAction(e -> visibilita(1));
		  ricarica.setVisible(false);
 
		  benzina=new Button("Benzina");
		  benzina.setOnAction(e -> visibilita(2));
		  benzina.setVisible(false);
 
		  dieci=new Button(" 10€ ");
		  benzina.setOnAction(e -> benzina(1));
		  benzina.setVisible(false);
 
		  venti=new Button(" 20€ ");
		  benzina.setOnAction(e -> benzina(2));
		  benzina.setVisible(false);
 
		  cinquanta=new Button(" 50€ ");
		  benzina.setOnAction(e -> benzina(3));
		  benzina.setVisible(false);
 
		  versa= new TextField();
		  login.setPromptText("Inserire importo");  
 
		  versabtn=new Button("Versa");
		  benzina.setOnAction(e -> versa());
		  benzina.setVisible(false);
 
		  message = new Label();
 
	  }
 
	public void entra() {
 
		String codice = login.getText();
 
		if (lSchede.getAccesso(codice)) {
			login.setVisible(false);
			loginbtn.setVisible(false);
			ricarica.setVisible(true);
			benzina.setVisible(true);
			message.setText("Login riuscito");
		} else {
 
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Messaggio");
 
			String text = codice;
 
			alert.setContentText(text + " non ricosciuto");
			alert.showAndWait();
			login.setVisible(true);
			loginbtn.setVisible(true);
			ricarica.setVisible(false);
			benzina.setVisible(false);
 
			message.setText("Login fallito");
		}
 
	}
 
	public static void main(String[] args) {
		launch(args);
	}
}