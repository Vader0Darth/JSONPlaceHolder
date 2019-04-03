package com.danielstrelnikov.jsonplaceholder.Presenter;

import com.danielstrelnikov.jsonplaceholder.Views.MainActivity;

public class MainPresenter {

    MainActivity activity;

    public MainPresenter(MainActivity activity)
    {
        this.activity = activity;
    }
    public void userBtnlClicked(){
        activity.gotoUserActivity();
    }
    public void albumBtnClicked(){
        activity.gotoAlbumActivity();
    }
    public void postBtnClicked(){
        activity.gotoPostActivity();
    }

}
