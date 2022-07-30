package graphics.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AppManager {
    static Stage loginStage, mainStage;

    public static void launchLogin(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(Constants.LOGIN_FXML_PATH));
        Scene scene = new Scene(fxmlLoader.load(), Constants.PREF_WIDTH, Constants.PREF_HEIGHT);
        scene.getStylesheets().add(Objects.requireNonNull(Launcher.class.getResource
                (Constants.LIGHT_MODE_CSS_PATH)).toString());
        stage.setTitle(Constants.APP_TITLE);
        stage.getIcons().add(new Image(Objects.requireNonNull(Launcher.class.getResource
                (Constants.ICON_PATH)).toString()));
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.requestFocus();
        stage.show();
        loginStage = stage;

        ((LoginFXML)fxmlLoader.getController()).initialize(scene.getRoot());
    }

    public static void launchMain() throws IOException {
        loginStage.close(); //closing login stage

        mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(Constants.MAIN_FXML_PATH));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add(Objects.requireNonNull(Launcher.class.getResource
                (Constants.LIGHT_MODE_CSS_PATH)).toString());
        mainStage.setTitle(Constants.APP_TITLE);
        mainStage.getIcons().add(new Image(Objects.requireNonNull(Launcher.class.getResource
                (Constants.ICON_PATH)).toString()));
        mainStage.setScene(scene);
    }











    public static void alert(Alert.AlertType alertType, String header, String msg, String title){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
