package graphics.app;

import animatefx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
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
    @FXML
    Label description;

    public void initialize(Parent root) {
        AnimationFX rootAnim = new SlideInUp(root);
        rootAnim.setOnFinished(e-> usernameField.setVisible(true));
        rootAnim.play();
        usernameField.setVisible(false);
        passwordField.setVisible(false);
        loginButton.setVisible(false);
        forgotMyPassword.setVisible(false);
        description.setVisible(false);
        AnimationFX animationFX = new SlideInLeft(usernameField);
        animationFX.setDelay(Duration.seconds(1));
        animationFX.play();
        animationFX.setOnFinished(e-> passwordField.setVisible(true));
        AnimationFX animationFX1 = new SlideInLeft(passwordField);
        animationFX1.setDelay(Duration.seconds(2));
        animationFX1.play();
        animationFX1.setOnFinished(e-> loginButton.setVisible(true));
        AnimationFX animationFX2 = new SlideInLeft(loginButton);
        animationFX2.setDelay(Duration.seconds(3));
        animationFX2.play();
        animationFX2.setOnFinished(e-> {forgotMyPassword.setVisible(true); description.setVisible(true);});
        AnimationFX animationFX3 = new FadeIn(forgotMyPassword);
        animationFX3.setDelay(Duration.seconds(4));
        animationFX3.play();
        AnimationFX animationFX4 = new FadeIn(description);
        animationFX4.setDelay(Duration.seconds(4));
        animationFX4.play();
    }
}
