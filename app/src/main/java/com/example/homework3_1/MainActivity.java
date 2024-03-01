package com.example.homework3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_email, et_theme, et_message;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = findViewById(R.id.et_email);
        et_theme = findViewById(R.id.et_theme);
        et_message = findViewById(R.id.et_message);

        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_email.getText().toString().isEmpty() && !et_theme.getText().toString().isEmpty()
                        && !et_message.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{et_email.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, et_theme.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, et_message.getText().toString());
                    intent.setType("message/rfc822");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "There is no application that support this action", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}