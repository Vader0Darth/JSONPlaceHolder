package com.danielstrelnikov.jsonplaceholder.Views;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danielstrelnikov.jsonplaceholder.Presenter.AlbumsPresenter;
import com.danielstrelnikov.jsonplaceholder.R;

public class AlbumsActivity extends AppCompatActivity {

    LinearLayout layout;
    AlbumsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        layout = findViewById(R.id.layout);


        presenter = new AlbumsPresenter(this);
    }
    public void setLoader(){
        TextView t = new TextView(this);
        t.setText("Downloading...");
        layout.addView(t);
    }
    public void removeLoader(){
        layout.removeAllViews();
    }
    public void setAlbumsNames(String[] names){
        boolean odd = false;
        for (String name:
                names) {
            TextView txt = new TextView(this);
            txt.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            txt.setTextSize(16);
            txt.setPadding(5,10,5,10);
            txt.setText(name);
            if(odd)
                txt.setBackgroundColor(Color.GRAY);
            odd = !odd;
            txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.albumClicked(((TextView) v).getText().toString());
                }
            });
            layout.addView(txt);
        }
    }
    public void gotoPostActivity(String name){
        Intent intent = new Intent(this,  AlbumActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
