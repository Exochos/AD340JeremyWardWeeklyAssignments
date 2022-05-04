package com.example.ad340jeremywardweeklyassignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button button;

    private EditText nameField;
    private EditText emailAddressField;
    private EditText usernameField;
    private EditText locationField;
    private EditText occupationField;
    private EditText descriptionField;
    private TextView dobTextView;
    private int dobYear = 0;
    private int dobMonth = 0;
    private int dobDay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameField);
        emailAddressField = findViewById(R.id.email);
        usernameField = findViewById(R.id.username);
        locationField = findViewById(R.id.location);
        occupationField = findViewById(R.id.occupation);
        descriptionField = findViewById(R.id.description);


        button = (Button)findViewById(R.id.goToAnotherActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String name = nameField.getText().toString();
                 String email = emailAddressField.getText().toString();
                 String userName = usernameField.getText().toString();
                 String  location = locationField.getText().toString();
                 String occupation = occupationField.getText().toString();
                 String desc = descriptionField.getText().toString();

                 if (name.equals("") || email.equals("") || userName.equals("") || occupation.equals("")
                     || desc.equals("")) {
                     Toast.makeText(getApplicationContext(), getString(R.string.bad_data),
                             Toast.LENGTH_LONG).show();
                 }
                 else {
                     Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                     intent.putExtra(Constants.NAME_KEY, name);
                     intent.putExtra(Constants.EMAIL_KEY, email);
                     intent.putExtra(Constants.USERNAME_KEY, userName);
                     intent.putExtra(Constants.LOCATION_KEY, location);
                     intent.putExtra(Constants.OCCUPATION_KEY, occupation);
                     intent.putExtra(Constants.DESCRIPTION_KEY, desc);
                     MainActivity.this.startActivity(intent);
                 }
            }
        });
    }
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // TODO
        }
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}