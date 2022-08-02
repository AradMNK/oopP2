package graphics.app;

import Login.Loginner;
import animatefx.animation.Pulse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;

import java.io.IOException;

public class MyAccountFXML {
    @FXML Pane preview;
    @FXML TextField bioField, subtitleField, nameField;
    @FXML Button pictureButton, updatePreviewButton;
    @FXML Label nameLabel, bioLabel, subtitleLabel;

    private void updatePreview(){
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(Utility.POST_FXML_PATH));
        preview.getChildren().removeAll();
        try {preview.getChildren().add(fxmlLoader.load());} catch (IOException e) {AppManager.alert(Alert.AlertType.ERROR,
                "Exception occurred.", e.getClass().toString(), "Exception"); e.printStackTrace();}
        ((PostFXML)fxmlLoader.getController()).initializeSample();
    }

    public void initialize(){
        updatePreview();
        bioField.setText(Loginner.loginnedUser.getBio());
        subtitleField.setText(Loginner.loginnedUser.getSubtitle());
    }

    @FXML void changePicture(){
        String directory;
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.showDialog(AppManager.mainStage);
        directory = directoryChooser.getInitialDirectory().getAbsolutePath();
        Database.Changer.setUserPfp(Loginner.loginnedUser.getUsername(), directory);
        Loginner.loginnedUser.getPfp().setHandle(directory);
        updatePreview();
    }

    @FXML void hoverNameLabel(){new Pulse(nameLabel).play();}
    @FXML void hoverBioLabel(){new Pulse(bioField).play();}
    @FXML void hoverSubtitleLabel(){new Pulse(subtitleLabel).play();}
    @FXML void hoverNameField(){new Pulse(nameField).play();}
    @FXML void hoverBioField(){new Pulse(bioField).play();}
    @FXML void hoverSubtitleField(){new Pulse(subtitleField).play();}
    @FXML void hoverChangeButton(){new Pulse(pictureButton).play();}
    @FXML void hoverUpdateButton(){new Pulse(updatePreviewButton).play();}

    @FXML void update(){
        boolean name = Loginner.loginnedUser.getName().equals(nameField.getText()),
                bio = Loginner.loginnedUser.getBio().equals(bioField.getText()),
                subtitle = Loginner.loginnedUser.getSubtitle().equals(subtitleField.getText());

        if (name) Database.Changer.setUserName(Loginner.loginnedUser.getUsername(), nameField.getText());
        if (name) Database.Changer.setUserBio(Loginner.loginnedUser.getUsername(), bioField.getText());
        if (name) Database.Changer.setUserSubtitle(Loginner.loginnedUser.getUsername(), subtitleField.getText());

        if (!(name && bio && subtitle)) updatePreview();
    }
}
