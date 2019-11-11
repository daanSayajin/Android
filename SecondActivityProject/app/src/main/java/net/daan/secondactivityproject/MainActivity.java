package net.daan.secondactivityproject;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private AppCompatEditText editTextEmail;
    private AppCompatEditText editTextPassword;
    private AppCompatButton buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Login");

        toolbar = findViewById(R.id.toolbar);
        textInputLayoutEmail = findViewById(R.id.text_input_layout_email);
        textInputLayoutPassword = findViewById(R.id.text_input_layout_password);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);
        buttonLogin = findViewById(R.id.button_login);

        setSupportActionBar(toolbar);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    textInputLayoutEmail.setError("E-mail é obrigatório!");
                    textInputLayoutEmail.setErrorEnabled(true);
                } else
                    textInputLayoutEmail.setErrorEnabled(false);

                if (password.isEmpty()) {
                    textInputLayoutPassword.setError("Senha é obrigatória!");
                    textInputLayoutPassword.setErrorEnabled(true);
                } else
                    textInputLayoutPassword.setErrorEnabled(false);

                if (!email.isEmpty() && !password.isEmpty()) {
                    Intent showCategoriesActivity = new Intent(MainActivity.this, CategoriesActivity.class);
                    startActivity(showCategoriesActivity);
                }
            }
        });
    }
}
