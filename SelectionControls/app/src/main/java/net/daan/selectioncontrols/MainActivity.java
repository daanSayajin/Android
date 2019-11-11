package net.daan.selectioncontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private SwitchCompat ativar_localizacao;
    private AppCompatCheckBox cobol;
    private AppCompatCheckBox vb;
    private AppCompatCheckBox java;
    private AppCompatCheckBox csharp;
    private AppCompatCheckBox php;
    private AppCompatButton button_testar;
    private ToggleButton toggle_teste;
    private AppCompatImageButton image_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ativar_localizacao = findViewById(R.id.switch_ativar_localizacao);

        cobol = findViewById(R.id.check_cobol);
        vb = findViewById(R.id.check_vb);
        java = findViewById(R.id.check_java);
        csharp = findViewById(R.id.check_csharp);
        php = findViewById(R.id.check_php);

        button_testar = findViewById(R.id.button_testar);

        toggle_teste = findViewById(R.id.toggle_teste);

        image_button = findViewById(R.id.image_button);

        /* - É possível ouvir os eventos do switch utilizando o "onClickListener". Ex:s

            ativar_localizacao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean estado = ativar_localizacao.isChecked();
                    Toast.makeText(MainActivity.this, "Mudou para: " + estado, Toast.LENGTH_SHORT).show();
                }
            });
        */

        ativar_localizacao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Mudou para: " + b, Toast.LENGTH_SHORT).show();

                if (b)
                    cobol.setEnabled(true);
                else {
                    cobol.setEnabled(false);
                    cobol.setChecked(false);
                }
            }
        });

        cobol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Alterou Cobol para: " + b, Toast.LENGTH_SHORT).show();
            }
        });

        vb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Alterou VB para: " + b, Toast.LENGTH_SHORT).show();
            }
        });

        java.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Alterou Java para: " + b, Toast.LENGTH_SHORT).show();
            }
        });

        csharp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Alterou C# para: " + b, Toast.LENGTH_SHORT).show();
            }
        });

        php.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Alterou PHP para: " + b, Toast.LENGTH_SHORT).show();
            }
        });

        button_testar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (php.isChecked())
                    Toast.makeText(MainActivity.this, "PHP está ativado!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "PHP está desativado!", Toast.LENGTH_SHORT).show();
            }
        });

        toggle_teste.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Alterou ON/OFF para: " + b, Toast.LENGTH_SHORT).show();
            }
        });

        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showActivity2 = new Intent(MainActivity.this, Activity2.class);
                startActivity(showActivity2);
            }
        });
    }
}
