package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginPage extends AppCompatActivity {
    @BindView(R.id.editTextTextPersonName)
    EditText personNameEditText;
    @BindView(R.id.editTextTextPassword)
    EditText passwordEditText;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ButterKnife.bind(this);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    @OnClick(R.id.loginBtn)
    public void onLogin() {
        firebaseAuth.createUserWithEmailAndPassword(personNameEditText.getText().toString(), passwordEditText.getText().toString())
                .addOnCompleteListener((task) -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Sucuess", Toast.LENGTH_LONG).show();

                        startActivity(new Intent(this, MainActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
    }
}