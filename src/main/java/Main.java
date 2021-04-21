
import Models.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/logIn.fxml"));
        primaryStage.setTitle("ATM");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        if(Database.getInstance() != null)
            Database.getInstance().disconnect();
        try {
        } catch (Exception exception){
            exception.getSuppressed();
        }
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
