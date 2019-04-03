package com.danielstrelnikov.jsonplaceholder.Presenter;

import android.util.Log;

import com.danielstrelnikov.jsonplaceholder.Model.Model;
import com.danielstrelnikov.jsonplaceholder.Model.Post.Comments;
import com.danielstrelnikov.jsonplaceholder.Model.Post.Post;
import com.danielstrelnikov.jsonplaceholder.Views.PostsActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsPresenter {

    PostsActivity activity;

    public PostsPresenter(PostsActivity activity)
    {
        this.activity = activity;
        getPosts();
    }


    private void getPosts(){
        activity.setLoader();
        if(Model.getComments() == null)
            Model.getInstance()
                    .getJSONPlaceHolderApi()
                    .getAllComments()
                    .enqueue(new Callback<ArrayList<Comments>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                            Model.setComments(response.body());
                        }

                        @Override
                        public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
        if(Model.getPosts() == null){
            Model.getInstance()
                    .getJSONPlaceHolderApi()
                    .getAllPost()
                    .enqueue(new Callback<ArrayList<Post>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                            Model.setPosts(response.body());
                            getPosts();
                            return;
                        }

                        @Override
                        public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                            Log.d("TAG", "onFailure: ");
                            t.printStackTrace();
                        }
                    });
        }
        else{
            activity.removeLoader();
            activity.setPosts(getPostNames(Model.getPosts()));
        }
    }

    private String[] getPostNames(ArrayList<Post> posts){
        String[] names = new String[posts.size()];
        for (int i = 0; i < posts.size(); i++)
            names[i] = posts.get(i).getTitle();
        return names;
    }

    public void postClicked(String name){
        activity.gotoPostActivity(name);
    }

}
