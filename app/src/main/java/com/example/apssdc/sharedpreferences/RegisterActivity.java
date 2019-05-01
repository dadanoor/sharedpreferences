package com.example.apssdc.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    public static final String preferences="SRIT";
    public static final String NAME_KEY="namekey";
    public static final String PASSWORD_KEY="passwordkey";
    SharedPreferences sharedPreferences;
    EditText name_edt_register,pass_edt_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        sharedPreferences=getSharedPreferences(preferences, Context.MODE_PRIVATE);
        name_edt_register=findViewById(R.id.user_name);
        pass_edt_register=findViewById(R.id.user_password);

    }
    public void userRegister(View view){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if (name_edt_register.getText().toString().length()>0&&
                pass_edt_register.getText().toString().length()>0) {
            editor.putString(NAME_KEY, name_edt_register.getText().toString());
            editor.putString(PASSWORD_KEY, pass_edt_register.getText().toString());
            editor.apply();
            finish();
        }
        else {
            Toast.makeText(this,"please enter the valid username and password",Toast.LENGTH_SHORT).show();
        }
        }
}
