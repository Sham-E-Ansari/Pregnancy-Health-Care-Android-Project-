package com.example.joker.pregnancyhealthcare;

/**
 * Created by Joker on 30-Jan-18.
 */

public class Question {
    String postTopic, post,postUser;
    int _id;

    public Question() {
    }

    public Question( int _id,String postTopic, String post, String postUser) {
        this.postTopic = postTopic;
        this.post = post;
        this.postUser = postUser;
        this._id = _id;
    }

    public String getPostTopic() {
        return postTopic;
    }

    public void setPostTopic(String postTopic) {
        this.postTopic = postTopic;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostUser() {
        return postUser;
    }

    public void setPostUser(String postUser) {
        this.postUser = postUser;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
