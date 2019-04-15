package com.example.joker.pregnancyhealthcare;

/**
 * Created by Joker on 30-Jan-18.
 */

public class Comment {
    String comment,commentUser;
    int postId;
    int _id;

    public Comment() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Comment(int _id,int postId,String comment, String commentUser) {
        this.comment = comment;
        this.commentUser = commentUser;
        this.postId = postId;
        this._id = _id;
    }
}
