package com.danielstrelnikov.jsonplaceholder.Model;

import com.danielstrelnikov.jsonplaceholder.Model.Album.Album;
import com.danielstrelnikov.jsonplaceholder.Model.Album.Photos;
import com.danielstrelnikov.jsonplaceholder.Model.Post.Comments;
import com.danielstrelnikov.jsonplaceholder.Model.Post.Post;
import com.danielstrelnikov.jsonplaceholder.Model.User.User;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {

    private static Model mInstance;
    private static String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static Retrofit mRetrofit;

    private static ArrayList<User> users;
    private static ArrayList<Post> posts;
    private static ArrayList<Album> albums;
    private static ArrayList<Comments> comments;
    private static ArrayList<Photos> photos;

    public static Model getInstance(){
        if(mInstance == null)
            mInstance = new Model();
        return mInstance;
    }
    private Model(){
        users = null;
        posts = null;
        albums = null;
        comments = null;
        photos = null;
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static JSONPlaceHolderApi getJSONPlaceHolderApi(){
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }

    public static void setUsers(ArrayList<User> users) {
        Model.users = users;
    }
    public static void setPosts(ArrayList<Post> posts) {
        Model.posts = posts;
    }
    public static void setAlbums(ArrayList<Album> albums) {
        Model.albums = albums;
    }
    public static void setComments(ArrayList<Comments> comments) {
        Model.comments = comments;
    }
    public static void setPhotos(ArrayList<Photos> photos) {
        Model.photos = photos;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
    public static ArrayList<Post> getPosts() {
        return posts;
    }
    public static ArrayList<Album> getAlbums() {
        return albums;
    }
    public static ArrayList<Comments> getComments() {
        return comments;
    }
    public static ArrayList<Photos> getPhotos() {
        return photos;
    }
}
