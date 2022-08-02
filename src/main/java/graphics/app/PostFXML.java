package graphics.app;

import Login.Loginner;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import Objects.Post;
import Objects.User;
import javafx.scene.text.Text;

import java.time.LocalDateTime;
import java.util.Objects;

public class PostFXML {
    @FXML Circle picture;
    @FXML Text name, username, bio, postContent, subtitle, date;
    @FXML ScrollPane postPane, bioPane;

    private void initContents(String name, String username, String bio, String post, String subtitle, LocalDateTime time){
        postContent.setWrappingWidth(postPane.getWidth());
        this.bio.setWrappingWidth(bioPane.getWidth());

        this.name.setText(name);
        this.username.setText(username);
        this.bio.setText(bio);
        this.postContent.setText(post);
        this.subtitle.setText(subtitle);
        this.date.setText(time.toString());
    }

    public void initialize(Post post){
        if (post.getPoster().getPfp().getHandle().equals(""))
            picture.setFill(new ImagePattern(new Image(Objects.requireNonNull
                    (Launcher.class.getResource(Utility.UNKNOWN_USER_PICTURE)).toString())));
        else picture.setFill(new ImagePattern(new Image(post.getPoster().getPfp().getHandle())));

        User poster = post.getPoster();
        initContents(poster.getName(), poster.getUsername(), poster.getBio(),
                post.getDescription(), poster.getSubtitle(), post.getDatePosted());
    }

    public void initializeSample(){
        if (Loginner.loginnedUser.getPfp().getHandle().equals(""))
            picture.setFill(new ImagePattern(new Image(Objects.requireNonNull
                    (Launcher.class.getResource(Utility.UNKNOWN_USER_PICTURE)).toString())));
        else picture.setFill(new ImagePattern(new Image(Loginner.loginnedUser.getPfp().getHandle())));

        User poster = Loginner.loginnedUser;
        initContents(poster.getName(), poster.getUsername(), poster.getBio(),
                postContent.getText(), poster.getSubtitle(), LocalDateTime.now());
    }
}
