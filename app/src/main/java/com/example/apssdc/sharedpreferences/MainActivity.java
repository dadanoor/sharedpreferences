package com.example.apssdc.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username_et);
        password=findViewById(R.id.password_et);
    }

    public void loginsScreen(View view) {
        sharedPreferences=getSharedPreferences(RegisterActivity.preferences,MODE_PRIVATE);
        String name=username.getText().toString();
        String password1=password.getText().toString();
        if (name.equals(sharedPreferences.getString(RegisterActivity.NAME_KEY,"keerthi"))&&
        password1.equals(sharedPreferences.getString(RegisterActivity.PASSWORD_KEY,"ppp")))
        {
           Intent intent=new Intent(this,LoginScreen.class);
           startActivity(intent);
        }
    }

    public void registerScreen(View view) {
       if (sharedPreferences==null) {

            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
       }
        else {
            Toast.makeText(this,"you already registered",Toast.LENGTH_SHORT).show();
        }
    }

   // public void logout(View view) {
    //    sharedPreferences.Editor editor=sharedPreferences.edit();
     //   editor.clear();
   // }
}
