package com.example.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showLoginDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog, null);
        builder.setView(dialogView);

        EditText usernameIn= dialogView.findViewById(R.id.user);
        EditText passwordIn = dialogView.findViewById(R.id.password);
        Button loginButton = dialogView.findViewById(R.id.dialogLogin);
        Button cancelButton = dialogView.findViewById(R.id.dialogCancel);

        AlertDialog dialog = builder.create();
        dialog.show();

        loginButton.setOnClickListener(v -> {
            String user = usernameIn.getText().toString();
            String password = passwordIn.getText().toString();

            if (user.equals("admin") && password.equals("admin")) {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("username", user);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                usernameIn.setText("");
                passwordIn.setText("");
            }
        });

        cancelButton.setOnClickListener(v -> dialog.dismiss());
    }
}