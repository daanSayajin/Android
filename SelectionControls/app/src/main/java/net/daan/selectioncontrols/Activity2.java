package net.daan.selectioncontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import java.nio.channels.InterruptedByTimeoutException;

public class Activity2 extends AppCompatActivity {

    private AppCompatButton activity3;
    private AppCompatButton galeria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        setTitle(getTitle() + " - Activity 2");

        activity3 = findViewById(R.id.button_activity3);
        galeria = findViewById(R.id.button_galeria);

        activity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showActivity3 = new Intent(Activity2.this, Activity3.class);
                startActivity(showActivity3);
            }
        });

        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent foto = new Intent();
                foto.setType("image/*");
                foto.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(foto, 0);
            }
        });
    }
}
