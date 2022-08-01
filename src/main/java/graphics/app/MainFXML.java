package graphics.app;

import animatefx.animation.Pulse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainFXML {
    @FXML Pane rootDisplay;
    @FXML Button homeButton, myAccountButton, chatsButton, feedButton, exploreButton, blocklistButton, postButton, searchButton;
    @FXML TextField searchField;

    public void initialize(){
    }

    @FXML void search(){

    }
    @FXML void home(){

    }
    @FXML void myAccount(){
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(Utility.MY_ACCOUNT_FXML_PATH));
        try {setDisplayTo(fxmlLoader.load());} catch (IOException e) {AppManager.alert(Alert.AlertType.ERROR,
                "Exception occurred.", e.getClass().toString(), "Exception"); e.printStackTrace(); return;}
        ((MyAccountFXML)fxmlLoader.getController()).initialize();
    }
    @FXML void chats(){

    }
    @FXML void feed(){

    }
    @FXML void explore(){

    }
    @FXML void blocklist(){

    }
    @FXML void post(){

    }

    @FXML void hoverSearchButton(){new Pulse(searchButton).play();}
    @FXML void hoverSearchField(){new Pulse(searchField).play();}
    @FXML void hoverHome(){new Pulse(homeButton).play();}
    @FXML void hoverMyAccount(){new Pulse(myAccountButton).play();}
    @FXML void hoverChats(){new Pulse(chatsButton).play();}
    @FXML void hoverFeed(){new Pulse(feedButton).play();}
    @FXML void hoverExplore(){new Pulse(exploreButton).play();}
    @FXML void hoverBlocklist(){new Pulse(blocklistButton).play();}
    @FXML void hoverPost(){new Pulse(postButton).play();}

    private void setDisplayTo(Parent root){
        rootDisplay.getChildren().removeAll();
        rootDisplay.getChildren().add(root);
    }
}
