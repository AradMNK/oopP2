package graphics.app;

import Login.Loginner;
import animatefx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.io.IOException;

public class LoginFXML {
    @FXML
    Hyperlink forgotMyPassword;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Button loginButton, createButton;
    @FXML
    Label description;

    public void initialize(Parent root) {
        AnimationFX rootAnim = new SlideInUp(root);
        rootAnim.setOnFinished(e-> usernameField.setVisible(true));
        rootAnim.play();
        usernameField.setVisible(false);
        passwordField.setVisible(false);
        loginButton.setVisible(false);
        createButton.setVisible(false);
        forgotMyPassword.setVisible(false);
        description.setVisible(false);
        AnimationFX usernameFX = new SlideInLeft(usernameField);
        usernameFX.setDelay(Duration.seconds(1));
        usernameFX.play();
        usernameFX.setOnFinished(e-> passwordField.setVisible(true));
        AnimationFX passwordFX = new SlideInLeft(passwordField);
        passwordFX.setDelay(Duration.seconds(2));
        passwordFX.play();
        passwordFX.setOnFinished(e-> {loginButton.setVisible(true); createButton.setVisible(true);});
        AnimationFX loginFX = new SlideInLeft(loginButton);
        loginFX.setDelay(Duration.seconds(3));
        loginFX.play();
        loginFX.setOnFinished(e-> {forgotMyPassword.setVisible(true); description.setVisible(true);});
        AnimationFX createFX = new SlideInLeft(createButton);
        createFX.setDelay(Duration.seconds(3));
        createFX.play();
        AnimationFX forgotFX = new FadeIn(forgotMyPassword);
        forgotFX.setDelay(Duration.seconds(4));
        forgotFX.play();
        AnimationFX descriptionFX = new SlideInRight(description);
        descriptionFX.setDelay(Duration.seconds(4));
        descriptionFX.play();
    }

    @FXML
    public void login(){
        String username = usernameField.getText(), password = passwordField.getText();
        if (username.equals("") || password.equals("")){
            AppManager.alert(Alert.AlertType.ERROR, "Some fields have been left out!",
                    "Please fill them up and try again.", "Some fields are empty...");
            return;
        }

        if (username.contains(",")){
            AppManager.alert(Alert.AlertType.ERROR, "Illegal character \",\"!",
                    "You cannot have commas in your username.", "Your username had a \",\"...");
            return;
        }

        try {Loginner.attemptLoginGraphical(username, password);} catch (IOException e) {e.printStackTrace();}
    }
    @FXML
    public void create(){

    }
    @FXML
    public void forgot(){

    }
}
