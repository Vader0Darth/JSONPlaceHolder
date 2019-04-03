package com.danielstrelnikov.jsonplaceholder.Model;

import com.danielstrelnikov.jsonplaceholder.Model.Album.Album;
import com.danielstrelnikov.jsonplaceholder.Model.Album.Photos;
import com.danielstrelnikov.jsonplaceholder.Model.Post.Comments;
import com.danielstrelnikov.jsonplaceholder.Model.Post.Post;
import com.danielstrelnikov.jsonplaceholder.Model.User.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {
    @GET ("users")
    public Call<ArrayList<User>> getAllUsers();

    @GET ("albums")
    public Call<ArrayList<Album>> getAllAlbums();

    @GET("posts")
    public Call<ArrayList<Post>> getAllPost();

    @GET ("comments")
    public Call<ArrayList<Comments>> getAllComments();

    @GET ("photos")
    public Call<ArrayList<Photos>> getAllPhotos();
}
