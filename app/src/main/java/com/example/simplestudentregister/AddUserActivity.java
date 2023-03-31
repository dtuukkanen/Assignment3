package com.example.simplestudentregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddUserActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        context = AddUserActivity.this;
    }

    public void addUser(View view) {
        String firstName = ((EditText)findViewById(R.id.textFirstName)).getText().toString();
        String lastName = ((EditText)findViewById(R.id.textLastName)).getText().toString();
        String email = ((EditText)findViewById(R.id.textEmail)).getText().toString();
        String degreeProgram = null;
        RadioGroup rgDegreeProgram = findViewById(R.id.rgDegreeProgram);

        switch (rgDegreeProgram.getCheckedRadioButtonId()) {
            case R.id.rbTietotekniikka:
                degreeProgram = "Tietotekniikka";
                break;
            case R.id.rbTuotantotalous:
                degreeProgram = "Tuotantotalous";
                break;
            case R.id.rbLaskennallinenTekniikka:
                degreeProgram = "Laskennallinen tekniikka";
                break;
            case R.id.rbSahkotekniikka:
                degreeProgram = "Sähkötekniikka";
                break;
        }
        UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram));
        UserStorage.getInstance().saveUsers(context);
    }
}