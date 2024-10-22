package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	ListaSchede lSchede = new ListaSchede();
	

	
	  @Override
	    public void start(Stage primaryStage) throws Exception{
		  
		  GridPane grid = new GridPane();
		  
		  login = new TextField();
		login.setPromptText("Inserire il tuo pin");  
		
		  loginbtn = new Button("Accedi");
		  loginbtn.setOnAction(e -> entra());
		  
		  
		  
	  }

		public void entra() {
			 
			String codice  = t1.getText();
	 
	 
			if (macchinetta.getAccesso(codice)) {
				t1.setVisible(false);
				BtnC.setVisible(true);
				BtnT.setVisible(true);
				BtnA.setVisible(true);
				message.setText("Login riuscito");		
			}
			else {
	 
				 Alert alert = new Alert(AlertType.INFORMATION);
			        alert.setTitle("Messaggio");
	 
			        // recuperto il testo del textField con il metodo getText() e lo assegno ad una variabile stringa
			        String text = codice;}}
	
		
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
