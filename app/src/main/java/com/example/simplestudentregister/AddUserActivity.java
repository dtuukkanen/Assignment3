package com.example.simplestudentregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

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
        ArrayList<String> degrees = new ArrayList<>();
        CheckBox cbKandidaatti = findViewById(R.id.cbKandidaatti);
        CheckBox cbDI = findViewById(R.id.cbDI);
        CheckBox cbTohtori = findViewById(R.id.cbTohtori);
        CheckBox cbUima = findViewById(R.id.cbUima);

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

        if (cbKandidaatti.isChecked()) {
            degrees.add("Kandidaatin tutkinto");
        }
        if (cbDI.isChecked()) {
            degrees.add("Diplomi-insinöörin tutkinto");
        }
        if (cbTohtori.isChecked()) {
            degrees.add("Tekniikan tohtorin tutkinto");
        }
        if (cbUima.isChecked()) {
            degrees.add("Uimamaisteri");
        }

        UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram, degrees));
        UserStorage.getInstance().sortUsers();
        UserStorage.getInstance().saveUsers(context);
    }
}