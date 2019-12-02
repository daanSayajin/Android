package net.daan.testingapplication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout txtilUsername;
    private AppCompatEditText txtUsername;
    private AppCompatButton btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtilUsername = findViewById(R.id.txtil_username);
        txtUsername = findViewById(R.id.txt_username);
        btnSearch = findViewById(R.id.btn_search);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userActivity = new Intent(MainActivity.this, UserActivity.class);
                userActivity.putExtra("username", txtUsername.getText().toString());
                startActivity(userActivity);
            }
        });
    }
}
