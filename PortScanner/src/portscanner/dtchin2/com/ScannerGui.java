package portscanner.dtchin2.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScannerGui extends Application {

	private PortScanner scan;
	private TextField portEntry;
	private TextArea portResults;
	private Button process;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = new VBox();
		
		Pane topPane = new FlowPane();
		Label heading = new Label("Port Scanner Range Application");
		topPane.getChildren().addAll(heading);
		
		Pane midPane = new HBox();
		portResults = new TextArea();
		portResults.setEditable(false);
		midPane.getChildren().addAll(portResults);
		
		Pane bottomPane = new FlowPane();
		portEntry = new TextField();
		portEntry.setPromptText("Enter Port Num");
		Tooltip tp = new Tooltip("Press to Loop Through Ports");
		process = new Button("Process");
		process.setTooltip(tp);
		process.setOnAction(new BeginSearch());
		bottomPane.getChildren().addAll(portEntry,process);
		
		mainPane.getChildren().addAll(topPane,midPane,bottomPane);
		primaryStage.setTitle("Port Scanning Time!");
		primaryStage.setScene(new Scene(mainPane,300,300));
		primaryStage.show();
	}
	
	private class BeginSearch implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if(event.getSource().equals(process)) {
				int entryNum = Integer.parseInt(portEntry.getText());
				scan = new PortScanner(entryNum);
				portResults.setText(scan.printResults());
			}
		}
	}
}
