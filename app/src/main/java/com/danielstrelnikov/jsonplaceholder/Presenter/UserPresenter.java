package com.danielstrelnikov.jsonplaceholder.Presenter;

import android.content.Intent;

import com.danielstrelnikov.jsonplaceholder.Model.Model;
import com.danielstrelnikov.jsonplaceholder.Model.User.User;
import com.danielstrelnikov.jsonplaceholder.Views.UserActivity;

public class UserPresenter {

    private UserActivity activity;
    private User user = null;

    public UserPresenter(UserActivity activity, String name){
        this.activity = activity;
        user = findUser(name);
        setUser();
    }

    private User findUser(String name){
        for (User user:
                Model.getUsers()) {
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }
    private void setUser(){
        activity.setName(user.getName());
        activity.setCity(user.getAddress().getCity());
        activity.setEmail(user.getEmail());
        activity.setPhone(user.getPhone());
        activity.setZipCode(user.getAddress().getZipcode());
    }
    public void nextBtnClicked(){
        int id = user.getId();
        if(id == Model.getUsers().size())
            return;
        for (User user:
             Model.getUsers()) {
            if(user.getId() - 1 == id)
                this.user = user;
        }
        setUser();
    }
    public void prewBtnClicked(){
        int id = user.getId();
        if(id == 0)
            return;
        for (User user:
                Model.getUsers()) {
            if(user.getId() + 1 == id)
                this.user = user;
        }
        setUser();
    }


}
