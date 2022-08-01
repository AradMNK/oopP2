package graphics.app;

import Login.Loginner;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import Objects.Post;

import java.util.Objects;

public class PostFXML {
    @FXML Circle picture;

    public void initialize(Post post){
        if (post.getPoster().getPfp().getHandle().equals(""))
            picture.setFill(new ImagePattern(new Image(Objects.requireNonNull
                    (Launcher.class.getResource(Utility.UNKNOWN_USER_PICTURE)).toString())));
        else picture.setFill(new ImagePattern(new Image(post.getPoster().getPfp().getHandle())));

    }

    public void initializeSample(){
        if (Loginner.loginnedUser.getPfp().getHandle().equals(""))
            picture.setFill(new ImagePattern(new Image(Objects.requireNonNull
                    (Launcher.class.getResource(Utility.UNKNOWN_USER_PICTURE)).toString())));
        else picture.setFill(new ImagePattern(new Image(Loginner.loginnedUser.getPfp().getHandle())));

    }
}
