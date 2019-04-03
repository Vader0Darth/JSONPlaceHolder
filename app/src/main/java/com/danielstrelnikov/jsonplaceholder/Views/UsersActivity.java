package com.danielstrelnikov.jsonplaceholder.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danielstrelnikov.jsonplaceholder.Presenter.UsersPresenter;
import com.danielstrelnikov.jsonplaceholder.R;

public class UsersActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    UsersPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        linearLayout = findViewById(R.id.linearLayout);


        presenter = new UsersPresenter(this);
    }

    public void setLoader(){
        TextView t = new TextView(this);
        t.setText("Downloading...");
        linearLayout.addView(t);
    }
    public void removeLoader(){
        linearLayout.removeAllViews();
    }
    public void showUsers(String[] names){
        for (String name:
             names) {
            Button b = new Button(this);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button clicked = (Button)v;
                    userBtnClicked(clicked.getText().toString());
                }
            });
            b.setText(name);
            linearLayout.addView(b);
        }
    }
    private void userBtnClicked(String name){
        presenter.userBtnClicked(name);
    }
    public void gotoActivityUser(String name){
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
