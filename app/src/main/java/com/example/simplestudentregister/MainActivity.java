package com.example.simplestudentregister;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToAddUser(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void switchToListUsers(View view) {
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
    }
}