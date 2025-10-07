package com.example.carpoolconnect.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.carpoolconnect.R;
import com.example.carpoolconnect.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText nameEt, phoneEt, emailEt, passwordEt;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        nameEt = findViewById(R.id.etName);
        phoneEt = findViewById(R.id.etPhone);
        emailEt = findViewById(R.id.etEmail);
        passwordEt = findViewById(R.id.etPassword);
        Button registerBtn = findViewById(R.id.btnRegister);
        View goLogin = findViewById(R.id.tvGoLogin);
        progress = findViewById(R.id.progress);

        registerBtn.setOnClickListener(v -> doRegister());
        goLogin.setOnClickListener(v -> finish());
    }

    private void doRegister() {
        String name = nameEt.getText().toString().trim();
        String phone = phoneEt.getText().toString().trim();
        String email = emailEt.getText().toString().trim();
        String password = passwordEt.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Fill all required fields", Toast.LENGTH_SHORT).show();
            return;
        }
        progress.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() && auth.getCurrentUser() != null) {
                            String uid = auth.getCurrentUser().getUid();
                            User user = new User(uid, name, email, phone, null);
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(uid)
                                    .setValue(user)
                                    .addOnCompleteListener(setTask -> {
                                        progress.setVisibility(View.GONE);
                                        if (setTask.isSuccessful()) {
                                            startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                                            finish();
                                        } else {
                                            Toast.makeText(RegisterActivity.this, String.valueOf(setTask.getException()), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        } else {
                            progress.setVisibility(View.GONE);
                            Toast.makeText(RegisterActivity.this, String.valueOf(task.getException()), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}




