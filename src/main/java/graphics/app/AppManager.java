package graphics.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AppManager {
    public static void launchLogin(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(Constants.LOGIN_FXML_PATH));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add(Objects.requireNonNull(Launcher.class.getResource
                (Constants.LIGHT_MODE_CSS_PATH)).toString());
        stage.setTitle(Constants.APP_TITLE);
        stage.getIcons().add(new Image(Objects.requireNonNull(Launcher.class.getResource
                (Constants.ICON_PATH)).toString()));
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        stage.requestFocus();

        ((LoginFXML)fxmlLoader.getController()).initialize(scene.getRoot());
    }

    public static void alert(Alert.AlertType alertType, String header, String msg, String title){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
