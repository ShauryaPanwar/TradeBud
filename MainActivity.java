package com.example.tradebud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button login;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.etusername);
        Password = (EditText) findViewById(R.id.etpassword);
        Info = (TextView)findViewById(R.id.tvinfo);
        login = (Button) findViewById(R.id.button);

        Info.setText("No of attempts remaining: 5");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(),Password.getText().toString());
            }
        });



    }

    private void validate(String userName,String userPassword)
    {
       if((userName.equals("Admin")) && (userPassword.equals("1234")) )
       {
           Intent intent = new Intent(MainActivity.this, SecondActivity.class);
           startActivity(intent);
       }
       else{
           counter--;
           Info.setText("No of attempts remaining: "+String.valueOf(counter));
           if(counter==0){
               login.setEnabled(false);
           }
       }
    }
}
