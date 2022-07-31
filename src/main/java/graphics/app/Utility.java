package graphics.app;

import javafx.concurrent.Task;

public class Utility {
    public static final String
    APP_TITLE = "Instakilogram",
    LOGIN_FXML_PATH = "Login.fxml",
    FORGOT_FXML_PATH = "Forgot Password.fxml",
    CREATE_FXML_PATH = "Create Account.fxml",
    MAIN_FXML_PATH = "Main.fxml",
    LIGHT_MODE_CSS_PATH = "Light.css",
    DARK_MODE_CSS_PATH = "Dark.css",
    ICON_PATH = "instakilogram.png";

    public static final int PREF_WIDTH = 900, PREF_HEIGHT = 600;

    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<>() {
            @Override protected Void call() {
                try {Thread.sleep(millis);} catch (InterruptedException ignored) {}
                return null;}};
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }
}
