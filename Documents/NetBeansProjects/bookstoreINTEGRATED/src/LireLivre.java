import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import   javafx.application.*;




public class LireLivre extends Application {

    
    public static void main(String[] args) {
        launch(args);
        }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Enjoy Your Book");
        Button btn = new Button();
        btn.setText("Enjoy Your Book");
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
        
        HostServices hs =  getHostServices();
        hs.showDocument("C:\\aaaa.pdf");
    }
}