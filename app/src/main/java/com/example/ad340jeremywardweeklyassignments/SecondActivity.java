package com.example.ad340jeremywardweeklyassignments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
    Button button;
    String name, email, username, occupation, desc;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString(Constants.NAME_KEY);
            email = extras.getString(Constants.EMAIL_KEY);
            username = extras.getString(Constants.USERNAME_KEY);
            occupation = extras.getString(Constants.OCCUPATION_KEY);
            desc = extras.getString(Constants.DESCRIPTION_KEY);
        }

        setContentView(R.layout.activity_second);
        TextView textView =  findViewById(R.id.nameView);
        textView.setText(name);
        TextView emailView = findViewById(R.id.emailView);
        emailView.setText(email);
        TextView userName = findViewById(R.id.usernameView);
        userName.setText(username);
        TextView occupationView = findViewById(R.id.occupationView);
        occupationView.setText(occupation);

        button = (Button)findViewById(R.id.goToAnotherActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SecondActivity.this, MainActivity.class);
                SecondActivity.this.startActivity(myIntent);
            }
        });
    }
}
