package com.danielstrelnikov.jsonplaceholder.Presenter;

import com.danielstrelnikov.jsonplaceholder.Model.Album.Album;
import com.danielstrelnikov.jsonplaceholder.Model.Album.Photos;
import com.danielstrelnikov.jsonplaceholder.Model.Model;
import com.danielstrelnikov.jsonplaceholder.Views.AlbumActivity;

import java.util.ArrayList;

public class AlbumPresenter {

    AlbumActivity activity;

    public AlbumPresenter(AlbumActivity activity, String name){
        this.activity = activity;
        Album album = findAlbum(name);
        setAlbumToActivity(album, getPhotosForAlbuv(album));
    }

    private Album findAlbum(String name)
    {
        for (Album album:
                Model.getAlbums()) {
            if(album.getTitle().equals(name))
                return album;
        }
        return null;
    }
    private ArrayList<String> getPhotosForAlbuv(Album album){
        ArrayList<String> photos = new ArrayList<>();
        for (Photos photo:
             Model.getPhotos()) {
            if(album.getId().equals(photo.getAlbumId()))
                photos.add(photo.getThumbnailUrl());
        }
        return photos;
    }

    private void setAlbumToActivity(Album album, ArrayList<String> photos){
        activity.setName(album.getTitle());
        activity.setPhotos(photos);
    }

}
