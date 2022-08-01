package Builder;

import Database.Loader;
import Objects.*;
import java.time.LocalDateTime;

public class PostBuilder {
    public static Post getPostFromDatabase(int postID) {
        return getPostFromDatabaseDetailsOnly(postID); //This is the default
    }

    public static Post getPostFromDatabase(int postID, User poster) {
        return getPostFromDatabaseDetailsOnly(postID, poster); //This is the default
    }

    public static Post getPostFromDatabaseWithComments(int postID) {
        Post post = getPostFromDatabase(postID);
        int[] commentIDs = Database.Loader.getPostComments(postID);
        for (int commentID: commentIDs) post.getComments().add(CommentBuilder.getCommentFromDatabase(commentID, post));
        return post;
    }

    public static Post getPostFromDatabaseWithComments(int postID, User poster) {
        Post post = getPostFromDatabase(postID, poster);
        int[] commentIDs = Database.Loader.getPostComments(postID);
        for (int commentID: commentIDs) post.getComments().add(CommentBuilder.getCommentFromDatabase(commentID, post));
        return post;
    }


    public static Post getPostFromDatabaseDetailsOnly(int postID) {
        Post post;
        String[] details = Loader.getPostDetails(postID);

        if (details[3].equals(UserType.BUSINESS.toString())) post = new BusinessPost();
        else post = new Post();

        post.setPoster(UserBuilder.getUserFromDatabase(details[0]));
        post.setPostID(new SaveHandle(postID));
        post.setDescription(details[1]);
        post.setDatePosted(LocalDateTime.parse(details[2]));

        return post;
    }

    public static Post getPostFromDatabaseDetailsOnly(int postID, User poster) {
        Post post;
        String[] details = Loader.getPostDetails(postID);

        if (details[3].equals(UserType.BUSINESS.toString())) post = new BusinessPost();
        else post = new Post();

        post.setPostID(new SaveHandle(postID));
        post.setPoster(poster);
        post.setDescription(details[1]);
        post.setDatePosted(LocalDateTime.parse(details[2]));

        return post;
    }
}