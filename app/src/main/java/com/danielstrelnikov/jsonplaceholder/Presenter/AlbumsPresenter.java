package com.danielstrelnikov.jsonplaceholder.Presenter;

import com.danielstrelnikov.jsonplaceholder.Model.Album.Album;
import com.danielstrelnikov.jsonplaceholder.Model.Album.Photos;
import com.danielstrelnikov.jsonplaceholder.Model.Model;
import com.danielstrelnikov.jsonplaceholder.Views.AlbumsActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsPresenter {

    AlbumsActivity albumsActivity;

    public AlbumsPresenter(AlbumsActivity activity){
        albumsActivity = activity;
        activity.setLoader();
        getAlbums();
    }
    public void albumClicked(String name){
        albumsActivity.gotoPostActivity(name);
    }
    private void getAlbums(){
        if(Model.getPhotos() == null)
            Model.getInstance()
                    .getJSONPlaceHolderApi()
                    .getAllPhotos()
                    .enqueue(new Callback<ArrayList<Photos>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Photos>> call, Response<ArrayList<Photos>> response) {
                            Model.setPhotos(response.body());
                        }

                        @Override
                        public void onFailure(Call<ArrayList<Photos>> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
        if(Model.getAlbums() == null)
            Model.getInstance()
            .getJSONPlaceHolderApi()
            .getAllAlbums()
            .enqueue(new Callback<ArrayList<Album>>() {
                @Override
                public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                    Model.setAlbums(response.body());
                    albumsActivity.removeLoader();
                    setAlbums(getAlbumsName());
                }

                @Override
                public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

                }
            });
        else {
            albumsActivity.removeLoader();
            setAlbums(getAlbumsName());
        }
    }
    private String[] getAlbumsName() {
        String[] names = new String[Model.getAlbums().size()];
        for (int i = 0; i < names.length; i++)
            names[i] = Model.getAlbums().get(i).getTitle();
        return names;
    }
    private void setAlbums(String[] names){
        albumsActivity.setAlbumsNames(names);
    }


}
