package portscanner.dtchin2.com;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScannerGui app = new ScannerGui();
		app.start(primaryStage);
	}

}
