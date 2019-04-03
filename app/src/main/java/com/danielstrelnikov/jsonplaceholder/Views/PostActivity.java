package com.danielstrelnikov.jsonplaceholder.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danielstrelnikov.jsonplaceholder.Presenter.PostPresenter;
import com.danielstrelnikov.jsonplaceholder.R;

import org.w3c.dom.Text;

import java.util.List;

public class PostActivity extends AppCompatActivity {

    TextView name;
    TextView body;
    LinearLayout comments;
    PostPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        name = findViewById(R.id.name);
        body = findViewById(R.id.body);
        comments = findViewById(R.id.comments);

        Intent intent = getIntent();
        String postName = intent.getStringExtra("name");

        presenter = new PostPresenter(this, postName);
    }

    public void setName(String name){
        this.name.setText(name);
    }
    public void setBody(String body){
        this.body.setText(body);
    }
    public void setCommnets(List<String> commnets){
        for (String comment:
             commnets) {
            TextView txt = new TextView(this);
            txt.setText(comment);
            txt.setPadding(0,0,0,25);
            this.comments.addView(txt);
        }
    }


}
