package graphics.app;

import animatefx.animation.FadeIn;
import animatefx.animation.SlideInRight;
import animatefx.animation.SlideInUp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class LoginFXML {
    @FXML
    Hyperlink forgotMyPassword;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Button loginButton;

    public void initialize(Parent root) {
        SlideInUp rootAnim = new SlideInUp(root);
        rootAnim.setSpeed(0.4).play();
        FadeIn userAnimation = new FadeIn(usernameField);
        FadeIn passAnimation = new FadeIn(passwordField);
        FadeIn loginAnimation = new FadeIn(loginButton);
        FadeIn fadeIn = new FadeIn(forgotMyPassword);
        userAnimation.setDelay(Duration.seconds(2.5)).play();
        passAnimation.playOnFinished(userAnimation);
        loginAnimation.playOnFinished(passAnimation);
        fadeIn.playOnFinished(loginAnimation);
    }
}
