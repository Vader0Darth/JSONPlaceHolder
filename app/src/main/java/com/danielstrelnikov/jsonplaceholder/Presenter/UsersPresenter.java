package com.danielstrelnikov.jsonplaceholder.Presenter;

import android.util.Log;

import com.danielstrelnikov.jsonplaceholder.Model.Model;
import com.danielstrelnikov.jsonplaceholder.Model.User.User;
import com.danielstrelnikov.jsonplaceholder.Views.UsersActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersPresenter {

    UsersActivity usersActivity;

    public UsersPresenter(UsersActivity usersActivity){
        this.usersActivity = usersActivity;
        callUsers();
    }

    public void userBtnClicked(String name){
        gotoActivityUser(name);
    }
    private void gotoActivityUser(String name){
        usersActivity.gotoActivityUser(name);
    }


    private void callUsers(){
        attachWaiter();
        ArrayList<User> users = Model.getUsers();
        if(users == null) {
            Model.getInstance()
                    .getJSONPlaceHolderApi()
                    .getAllUsers()
                    .enqueue(new Callback<ArrayList<User>>() {
                        @Override
                        public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                            Model.setUsers(response.body());
                            callUsers();
                            return;
                        }

                        @Override
                        public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                            Log.d("TAG", "onFailure: Fail");
                            t.printStackTrace();
                        }
                    });
        }
        else {
            detachWaiter();
            showUsers(users);
        }
    }

    private void attachWaiter(){
        usersActivity.setLoader();
    }
    private void detachWaiter(){
        usersActivity.removeLoader();
    }

    private void showUsers(ArrayList<User> users){
        usersActivity.showUsers(getUserNames(users));
    }
    private String[] getUserNames(ArrayList<User> users){
        String[] names = new String[users.size()];
        for (int i = 0; i < users.size(); i++)
            names[i] = users.get(i).getName();
        return names;
    }



}
