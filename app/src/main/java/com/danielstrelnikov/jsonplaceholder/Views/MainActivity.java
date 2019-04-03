package com.danielstrelnikov.jsonplaceholder.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.danielstrelnikov.jsonplaceholder.Presenter.MainPresenter;
import com.danielstrelnikov.jsonplaceholder.R;

public class MainActivity extends AppCompatActivity {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
    }

    public void gotoAlbumActivity(){
        Intent intent = new Intent(this, AlbumsActivity.class);
        startActivity(intent);
    }
    public void gotoPostActivity(){
        Intent intent = new Intent(this, PostsActivity.class);
        startActivity(intent);
    }
    public void gotoUserActivity(){
        Intent intent = new Intent(this, UsersActivity.class);
        startActivity(intent);
    }

    public void postBtnClicked(View view) {
        presenter.postBtnClicked();
    }

    public void albumBtnClicked(View view) {
        presenter.albumBtnClicked();
    }

    public void usersBtnClicked(View view) {
        presenter.userBtnlClicked();
    }
}
