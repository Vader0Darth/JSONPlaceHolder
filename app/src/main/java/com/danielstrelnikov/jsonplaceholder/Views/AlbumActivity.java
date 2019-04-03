package com.danielstrelnikov.jsonplaceholder.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danielstrelnikov.jsonplaceholder.Presenter.AlbumPresenter;
import com.danielstrelnikov.jsonplaceholder.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    TextView name;
    LinearLayout photos;

    AlbumPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        name = findViewById(R.id.name);
        photos = findViewById(R.id.photos);

        Intent intent = getIntent();

        presenter = new AlbumPresenter(this, intent.getStringExtra("name"));
    }

    public void setPhotos(ArrayList<String> photos){
        for (String photo:
             photos) {
            ImageView img = new ImageView(this);
            img.setPadding(0,0,0,25);
            this.photos.addView(img);
            Picasso.get()
                    .load(photo)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(img);
        }
    }
    public void setName(String name){
        this.name.setText(name);
    }

}
