package com.danielstrelnikov.jsonplaceholder.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.danielstrelnikov.jsonplaceholder.Presenter.UserPresenter;
import com.danielstrelnikov.jsonplaceholder.R;

public class UserActivity extends AppCompatActivity {

    UserPresenter userPresenter;

    TextView name;
    TextView email;
    TextView phone;
    TextView zipcode;
    TextView city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        String uName = intent.getStringExtra("name");

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        zipcode = findViewById(R.id.zipcode);
        city = findViewById(R.id.city);


        userPresenter = new UserPresenter(this, uName);
    }


    public void setName(String name){
        this.name.setText(name);
    }
    public void setEmail(String email){
        this.email.setText(email);
    }
    public void setPhone(String phone){
        this.phone.setText(phone);
    }
    public void setZipCode(String zipcode){
        this.zipcode.setText(zipcode);
    }
    public void setCity(String city){
        this.city.setText(city);
    }

    public void prewBtnClicked(View view) {
        userPresenter.prewBtnClicked();
    }

    public void nextBtnClicked(View view) {
        userPresenter.nextBtnClicked();
    }
}
