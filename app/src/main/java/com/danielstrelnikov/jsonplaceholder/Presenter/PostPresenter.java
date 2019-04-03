package com.danielstrelnikov.jsonplaceholder.Presenter;

import android.util.Log;

import com.danielstrelnikov.jsonplaceholder.Model.Model;
import com.danielstrelnikov.jsonplaceholder.Model.Post.Comments;
import com.danielstrelnikov.jsonplaceholder.Model.Post.Post;
import com.danielstrelnikov.jsonplaceholder.Views.PostActivity;

import java.util.ArrayList;
import java.util.List;

public class PostPresenter {

    PostActivity activity;
    String postName;

    public PostPresenter(PostActivity activity, String postName){
        this.activity = activity;
        this.postName = postName;

        setPost(findPost());
    }

    private Post findPost(){
        for (Post post:
                Model.getPosts()) {
            if(post.getTitle().equals(postName))
                return post;
        }
        return null;
    }

    private void setPost(Post post){
        activity.setName(post.getTitle());
        activity.setBody(post.getBody());
        activity.setCommnets(getComments(post));
    }

    private List<String> getComments(Post post){
        List<String> comments = new ArrayList<>();
        for (Comments p:
             Model.getComments()) {
            if(p.getPostId().equals(post.getId()))
                comments.add(p.getBody());
        }
        return comments;
    }

}
