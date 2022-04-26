package com.example.ad340jeremywardweeklyassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameField = (EditText) findViewById(R.id.name);
    private EditText emailAddressField;
    private EditText usernameField;
    private EditText descriptionField;
    private EditText occupationField;
    private TextView dobTextView;
    private int dobYear = 0;
    private int dobMonth = 0;
    private int dobDay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToNextActivity(View view) {
        Intent intent = new Intent();
        intent.putExtra(String.valueOf(nameField), "New Name");
        startActivity(intent);
    }
}