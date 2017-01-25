package view;

import controller.SokobanController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.MyModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private FXMLLoader fl=new FXMLLoader(getClass().getResource("MainWindow.fxml"));
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = fl.load();
			MainWindowController mwc=fl.getController();
			MyModel myModel=new MyModel();
			SokobanController sc=new SokobanController(myModel, mwc);
			myModel.addObserver(sc);
			mwc.addObserver(sc);
			//sc.getController().start();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
